package com.restcountries.callingexternalapi.beans;

// This calls will return the country information based on the given name
public class CountryInfo {
	
    private String name;
    private String country_code;
    private String capital;
    private long population;
    private String flag_file_url;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCountryCode() {
        return country_code;
    }
    public void setCountryCode(String country_code) {
        this.country_code = country_code;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {
        this.population = population;
    }
    public String getFlagFileUrl() {
        return flag_file_url;
    }
    public void setFlagFileUrl(String flag_file_url) {
        this.flag_file_url = flag_file_url;
    }
}