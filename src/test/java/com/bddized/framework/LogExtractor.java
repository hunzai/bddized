package com.bddized.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Stream;

public class LogExtractor implements InterfaceLogExtractor {

    private List<String> getFirefoxErrorLogs(final WebDriver webDriver) throws IOException {

        String logFilePath = System.getProperty("webdriver.firefox.logfile");
        Path path = Paths.get(logFilePath);
        List<String> logMessages = new ArrayList<>();

        Stream<String> lines = Files.lines(path);
        lines.forEach(s -> {
            if (s.trim().startsWith("JavaScript error:")) {
                logMessages.add(s);
            }
        });
        lines.close();
        return logMessages;
    }

    private List<String> getChromeLogs(final WebDriver webDriver){
        List<String> errors = new ArrayList<>();
        webDriver.manage().logs().get(LogType.BROWSER).forEach(logEntry -> {
            if (logEntry.getLevel().equals(Level.SEVERE)) {
                errors.add(logEntry.getMessage());
            }
        });
        return errors;
    }

    @Override
    public List<String> getJavascriptErrors(final RemoteWebDriver webDriver) throws IOException {
        String browserName = (String) webDriver.getCapabilities().getCapability(CapabilityType.BROWSER_NAME);

        if (browserName.matches("chrome")){
            return getChromeLogs(webDriver);
        }else if (browserName.matches("firefox")){
            return getFirefoxErrorLogs(webDriver);
        }else {
            List<String> logMessages = new ArrayList<>();
            webDriver.manage().logs().get(LogType.BROWSER).forEach(logEntry -> {
                if (logEntry.getLevel().equals(Level.SEVERE)) {
                    logMessages.add(logEntry.getMessage());
                }
            });
            return logMessages;
        }
    }
}
