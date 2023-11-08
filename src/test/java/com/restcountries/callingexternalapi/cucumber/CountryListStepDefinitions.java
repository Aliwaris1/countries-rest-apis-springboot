package com.restcountries.callingexternalapi.cucumber;
import com.restcountries.callingexternalapi.beans.CountryInfo;
import com.restcountries.callingexternalapi.beans.CountryList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CountryListStepDefinitions {

    private ResponseEntity<List<CountryList>> countryListResponse;
    private ResponseEntity<CountryInfo> countryInfoResponse;
    private ParameterizedTypeReference<List<CountryList>> responseType;



    @Given("the Country Service is running")
    public void theCountryServiceIsRunning() {

    }

    @When("I request the list of countries")
    public void iRequestTheListOfCountries() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/countries";

        ParameterizedTypeReference<List<CountryList>> responseType = new ParameterizedTypeReference<List<CountryList>>() {
        };

        ResponseEntity<List<CountryList>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, responseType);

        countryListResponse = responseEntity;
    }

    @Then("I should receive a list of all countries")
    public void iShouldReceiveAListOfAllCountries() {
        if (countryListResponse.getStatusCode() == HttpStatus.OK) {
            assertNotNull(countryListResponse.getBody());
        }
    }


    @When("I request the country name {string}")
    public void iRequestCountryName(String countryName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/countryinfo?name=" + countryName;
        countryInfoResponse = restTemplate.getForEntity(url, CountryInfo.class);
    }

    @Then("I should receive a country info successfully")
    public void iShouldReceiveACountryInfoSuccessfully() {
        assertNotNull(countryInfoResponse);
        assertEquals(HttpStatus.OK, countryInfoResponse.getStatusCode());
    }


}



