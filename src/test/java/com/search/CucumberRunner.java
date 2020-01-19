package com.search;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/features" },
        glue = { "src/test/java/com/search/stepDefinitions" },
        tags = { "@acceptance, @smoke" },
        plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber.json" },
        dryRun = true
)

public class CucumberRunner {
    //unused
}
