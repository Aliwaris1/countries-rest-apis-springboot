package com.restcountries.callingexternalapi.controllers;

import com.restcountries.callingexternalapi.beans.CountryList;
import com.restcountries.callingexternalapi.services.CountryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryListController {

    private final CountryListService countrylistService;

    @Autowired
    public CountryListController(CountryListService countryService) {
        this.countrylistService = countryService;
    }

    @GetMapping("/countries") // this mapping will get all the countries
    public ResponseEntity<List<CountryList>> getAllCountries() {

        List<CountryList> countries = countrylistService.getAllCountries();
        System.out.println("Country list retrieved: " + countrylistService);
        return new ResponseEntity<>(countries, HttpStatus.OK);

    }
}

