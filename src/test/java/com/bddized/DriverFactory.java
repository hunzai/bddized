package com.bddized;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverFactory {

    private static final Logger logger = Logger.getLogger(DriverFactory.class.getName());

    private final static String FIREFOX = "firefox";
    private final static String CHROME = "chrome";
    private final static String SAFARI = "safari";
    private final static String IE = "ie";
    private static WebDriver webDriver;

    public static WebDriver getDriver() throws Exception {

        String browserType = System.getProperty("browser");
        if (browserType == null || browserType.isEmpty()) {
            throw new Exception("browser not found. Please set gradle -Dbrowser=<chrome|firefox|safari>");
        }

        LoggingPreferences logPrefs = new LoggingPreferences();

        switch (browserType) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                logPrefs.enable(LogType.BROWSER, Level.ALL);

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

                webDriver = new FirefoxDriver(firefoxOptions);
                break;

            case CHROME:
                System.out.println("PROPS " + WebDriverManager.chromedriver().config().getProperties());
                WebDriverManager.chromedriver().setup();
                logPrefs.enable(LogType.BROWSER, Level.ALL);

                ChromeOptions cap = new ChromeOptions();
                cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

                webDriver = new ChromeDriver(cap);
                break;

            default:
                logger.warning("-Dbrowser is invalid or not provided " + browserType);
        }

        return webDriver;
    }
}
