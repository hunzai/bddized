package com.bddized;

import com.bddized.framework.abilities.Navigation;
import com.bddized.framework.abilities.Search;
import com.bddized.framework.abilities.Verification;

public interface InterfaceCustomerActor {
    String name();
    String email();
    String password();
    String login(String name, String password);

    Search search();
    Navigation navigation();
    Verification verification();
}
