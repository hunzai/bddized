package com.bddized.framework.abilities;

import com.bddized.framework.LogExtractor;
import com.bddized.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Verification {

    private WebDriver webDriver;
    private LogExtractor logExtractor;

    public Verification(WebDriver webDriver) {
        this.webDriver =  webDriver;
        this.logExtractor = new LogExtractor();
    }

    public void seesNoJsErrors() throws IOException {
        List<String> errorLogMessages = this.logExtractor.getJavascriptErrors(this.webDriver);
        Assert.assertTrue(errorLogMessages.toString(), errorLogMessages.size() == 0);
    }

    public void seesResponseCode(int expected) throws IOException {
        URL url = new URL(this.webDriver.getCurrentUrl());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int actual = con.getResponseCode();
        Assert.assertEquals(expected, actual);
    }
}
