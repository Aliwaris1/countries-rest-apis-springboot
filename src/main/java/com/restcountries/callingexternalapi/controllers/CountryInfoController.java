package com.restcountries.callingexternalapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restcountries.callingexternalapi.beans.CountryInfo;
import com.restcountries.callingexternalapi.services.CountryInfoService;

@RestController
@RequestMapping("/api/countryinfo")
public class CountryInfoController {

    private final CountryInfoService countryInfoService;

    @Autowired
    public CountryInfoController(CountryInfoService countryInfoService) {
        this.countryInfoService = countryInfoService;
    }

    @GetMapping//this mapping will get country information based on name
    public ResponseEntity<CountryInfo> getCountryInfoByName(@RequestParam String name) {
        CountryInfo countryInfo = countryInfoService.getCountryInfoByName(name);

        if (countryInfo != null) {
            System.out.println("CountryInfo retrieved: " + countryInfo);
            return new ResponseEntity<>(countryInfo, HttpStatus.OK);
        } else {
            System.out.println("Country not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
