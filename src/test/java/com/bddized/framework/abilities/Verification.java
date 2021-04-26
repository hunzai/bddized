package com.bddized.framework.abilities;

import com.bddized.framework.InterfaceResponseCode;
import com.bddized.framework.LogExtractor;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Verification implements InterfaceResponseCode {

    private RemoteWebDriver webDriver;
    private LogExtractor logExtractor;

    public Verification(RemoteWebDriver webDriver) {
        this.webDriver =  webDriver;
        this.logExtractor = new LogExtractor();
    }

    public void seesNoJsErrors() throws IOException {
        List<String> errorLogMessages = this.logExtractor.getJavascriptErrors(this.webDriver);
        Assert.assertTrue(errorLogMessages.toString(), errorLogMessages.size() == 0);
    }

    public void seesResponseCode(int expected) throws IOException {
        int actual = getResponseCode(this.webDriver.getCurrentUrl());
        Assert.assertEquals(expected, actual);
    }

    @Override
    public int getResponseCode(String pageUrl) throws IOException {
        URL url = new URL(this.webDriver.getCurrentUrl());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        return con.getResponseCode();
    }
}
