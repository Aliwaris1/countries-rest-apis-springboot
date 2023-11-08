package com.restcountries.callingexternalapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restcountries.callingexternalapi.beans.CountryInfo;

@Service
public class CountryInfoService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired //This is the dependency injection
    public CountryInfoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public CountryInfo getCountryInfoByName(String name) { //this function actually return country info based on the country name
        try {
            String url = "https://restcountries.com/v3.1/name/" + name;
            String jsonResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = objectMapper.readTree(jsonResponse);

            if (root.isArray() && root.size() > 0) {
                JsonNode firstCountry = root.get(0);
                if (firstCountry.has("name") && firstCountry.has("cca2")
                    && firstCountry.has("capital") && firstCountry.has("population")
                    && firstCountry.has("flags")) {
                    CountryInfo countryInfo = new CountryInfo();
                    countryInfo.setName(firstCountry.get("name").get("official").asText());
                    countryInfo.setCountryCode(firstCountry.get("cca2").asText());
                    countryInfo.setCapital(firstCountry.get("capital").get(0).asText());
                    countryInfo.setPopulation(firstCountry.get("population").asLong());
                    countryInfo.setFlagFileUrl(firstCountry.get("flags").get("svg").asText());
                    return countryInfo;
                }
            }
        } catch (Exception e) {              // this actually handle exceptions, log them, and return null or throw a custom exception.

            e.printStackTrace();
        }

        return null;
    }
}
