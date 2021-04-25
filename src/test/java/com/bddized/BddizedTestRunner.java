package com.bddized;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.bddized",
        plugin = {"pretty",
                "html:target/cucumberReports/bddized/regression.html",
                "json:target/cucumberReports/bddized/regression.json"
        })
public class BddizedTestRunner {
}
