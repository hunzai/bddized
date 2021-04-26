package com.bddized;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverFactory {

    private static final Logger logger = Logger.getLogger(DriverFactory.class.getName());

    private final static String FIREFOX = "firefox";
    private final static String CHROME = "chrome";
    private final static String SAFARI = "safari";
    private final static String IE = "ie";
    private static RemoteWebDriver webDriver;

    public static RemoteWebDriver getDriver() throws Exception {

        String remoteDriverURL = System.getenv("SELENIUM_REMOTE_URL");
        URL url;
        if (remoteDriverURL == null || remoteDriverURL.isEmpty()) {
            throw new Exception("Env variable SELENIUM_REMOTE_URL not found");
        }else {
            url = new URL(remoteDriverURL);
        }

        String browserType = System.getenv("BROWSER");
        if (browserType == null || browserType.isEmpty()) {
            throw new Exception("Env variable BROWSER not found.");
        }

        logger.info("RemoteDriver URL: " + remoteDriverURL);
        logger.info("Browser: " + browserType);

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);

        switch (browserType) {
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
                webDriver = new RemoteWebDriver(url, firefoxOptions);
                break;

            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
                webDriver = new RemoteWebDriver(url, chromeOptions);
                break;

            default:
                logger.warning("Env BROWSER=" + browserType + " is invalid");
        }

        return webDriver;
    }
}
