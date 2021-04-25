package com.bddized;

import org.openqa.selenium.WebDriver;

public abstract class AbstractAbility {

    public WebDriver webDriver;

    public AbstractAbility(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
