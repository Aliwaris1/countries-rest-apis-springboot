package com.restcountries.callingexternalapi.cucumber; // Adjust the package name as needed
import org.junit.jupiter.api.Test;
import io.cucumber.junit.Cucumber;

import io.cucumber.core.cli.Main;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources", // Location of your .feature files
    plugin = {"pretty", "html:target/cucumber-reports"}
    // Generate HTML reports
)

public class CountryTestRunner {
    // You don't need a contextLoads() method in this class, you can remove it.
}


