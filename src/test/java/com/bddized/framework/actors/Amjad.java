package com.bddized.framework.actors;

import com.bddized.AbstractAbility;
import com.bddized.InterfaceCustomerActor;
import com.bddized.framework.abilities.Navigation;
import com.bddized.framework.abilities.Search;
import com.bddized.framework.abilities.Verification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Amjad extends AbstractAbility implements InterfaceCustomerActor {

    private Navigation navigation;
    private Search search;
    private Verification verification;

    public Amjad(RemoteWebDriver webDriver) {
        super(webDriver);
        this.navigation = new Navigation(webDriver);
        this.search = new Search(webDriver);
        this.verification = new Verification(webDriver);
    }

    @Override
    public String name() {
        return "Amjad Saleem";
    }

    @Override
    public String email() {
        return "TheActorEmail@domain.com";
    }

    @Override
    public String password() {
        return "ItIsASecret.+HAsh0x0x129";
    }

    public Navigation navigation() {
        return navigation;
    }

    public Search search() {
        return search;
    }

    public Verification verification() {
        return verification;
    }

    @Override
    public String login(String name, String password) {
        return null;
    }
}
