package com.bddized.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage  {

    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
       this.webDriver = webDriver;
    }

    public WebElement header(){
        return this.webDriver.findElement(By.cssSelector( "#w3c_mast > h1"));
    }

    public WebElement headerStandardsLink(){
        return this.webDriver.findElement(By.cssSelector("#w3c_nav > form > ul > li.first-item > a"));
    }

    public WebElement headerAboutW3CLink(){
       return this.webDriver.findElement(By.cssSelector("#w3c_nav > form > ul > li.last-item > a"));
    }

    public WebElement consentButton(){
        return this.webDriver.findElement(By.xpath("/html/body/div/div/div/div[3]/button[2]"));
    }
}
