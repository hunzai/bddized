package com.bddized.StepDefinitions;

import com.bddized.DriverFactory;
import com.bddized.InterfaceCustomerActor;
import com.bddized.framework.actors.Amjad;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.util.logging.Logger;

@RunWith(JUnit4.class)
public class Definitions {

    private Logger logger = Logger.getLogger("Definitions");
    private InterfaceCustomerActor actor;
    private static RemoteWebDriver webDriver;

    @Before
    public void setUp() throws Exception {
        logger.info("Setting up driver");
        webDriver = DriverFactory.getDriver();
        this.actor = new Amjad(webDriver);
    }

    @After
    public void tearDown(){
        this.actor.navigation().closesBrowser();
    }

    @Given("{string} sees {string} up and running")
    public void isUpAndRunning(String string, String url) throws IOException {
        int expectedStatus = 200;
        logger.info(actor + " is checking " + url + " for status " + expectedStatus);
        this.actor.navigation().navigatesToPage(url);
        this.actor.verification().seesResponseCode(expectedStatus);
    }

    @When("{string} goes to {string}")
    public void goesTo(String string, String pageUrl)  {
        this.actor.navigation().navigatesToPage(pageUrl);
    }

    @When("{string} navigates to prices")
    public void navigatesToPrices(String string) {
        this.actor.navigation().navigatesToPricesPage();
    }

    @When("{string} navigates to support")
    public void navigatesToSupport(String string) {
        this.actor.navigation().navigatesToSupportPage();
    }

    @And("{string} sees the {int}")
    public void seesResponseCode(String actorName, int responseCode ) throws IOException {
        this.actor.verification().seesResponseCode(responseCode);
    }

    @Given("{string} sees no javascript errors")
    public void seeNoJavascriptErrors(String name) throws IOException {
        logger.info(name + " is checking for js errors");
        this.actor.verification().seesNoJsErrors();
    }
}
