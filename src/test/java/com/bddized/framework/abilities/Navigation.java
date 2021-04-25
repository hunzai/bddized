package com.bddized.framework.abilities;

import com.bddized.pages.HomePage;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Navigation {

    private WebDriver webDriver;
    private HomePage homePage;

    public Navigation(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.homePage = new HomePage(webDriver);
    }

    public void navigatesToPage(String url){
        this.webDriver.navigate().to(url);
    }

    public void navigatesToPricesPage(){
        homePage.headerStandardsLink().click();
    }

    public void navigatesToSupportPage(){
        homePage.headerAboutW3CLink().click();
    }

    public void closesBrowser() {
        this.webDriver.quit();
    }

}
