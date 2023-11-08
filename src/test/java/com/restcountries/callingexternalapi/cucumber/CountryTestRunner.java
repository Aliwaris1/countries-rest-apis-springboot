package com.restcountries.callingexternalapi.cucumber; // Adjust the package name as needed

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources", // Location of .feature files
    plugin = {"pretty", "html:target/cucumber-reports"}
    // Generate HTML reports
)

public class CountryTestRunner {

}


