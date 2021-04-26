package com.bddized.framework;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

public interface InterfaceLogExtractor {
    List<String> getJavascriptErrors(final WebDriver webDriver) throws IOException;
}
