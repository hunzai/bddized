package com.bddized.framework.actors;

import com.bddized.InterfaceGuestActor;
import com.bddized.framework.abilities.Navigation;
import com.bddized.framework.abilities.Search;
import com.bddized.framework.abilities.Verification;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Satoshi implements InterfaceGuestActor {

    private RemoteWebDriver webDriver;

    @Override
    public String name() {
        return "Satoshi Nakamoto";
    }

    public Navigation navigation() {
        return new Navigation(this.webDriver);
    }

    public Search search() {
        return new Search(this.webDriver);
    }

    public Verification verification() {
        return new Verification(this.webDriver);
    }
}
