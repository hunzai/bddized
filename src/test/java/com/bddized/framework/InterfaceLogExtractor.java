package com.bddized.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.util.List;

public interface InterfaceLogExtractor {
    List<String> getJavascriptErrors(final RemoteWebDriver webDriver) throws IOException;
}
