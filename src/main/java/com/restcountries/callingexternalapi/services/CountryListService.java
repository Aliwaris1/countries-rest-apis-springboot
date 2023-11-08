package com.restcountries.callingexternalapi.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restcountries.callingexternalapi.beans.CountryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryListService {
	

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CountryListService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }
    public List<CountryList> getAllCountries() { // this function will get all the countries name and country code
        List<CountryList> countries = new ArrayList<>();
        try {
            String url = "https://restcountries.com/v3.1/all/";
            String jsonResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = objectMapper.readTree(jsonResponse);

            if (root.isArray()) {
                for (JsonNode countryNode : root) {
                    if (countryNode.has("name") && countryNode.has("cca2")) {
                    	CountryList country = new CountryList();
                        country.setName(countryNode.get("name").get("official").asText());
                        country.setCountryCode(countryNode.get("cca2").asText());
                        countries.add(country);
                    }
                }
            }
        } catch (Exception e) {
            // Handle exceptions, log them, and return an empty list.
            e.printStackTrace();
        }

        return countries;
    }

}
