package com.bddized;

import com.bddized.framework.abilities.Navigation;
import com.bddized.framework.abilities.Search;
import com.bddized.framework.abilities.Verification;

public interface InterfaceGuestActor {
    String name();
    Search search();
    Navigation navigation();
    Verification verification();
}
