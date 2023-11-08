package com.restcountries.callingexternalapi.beans;

// this class will return all the countries containing country name and code
public class CountryList {
	private String name;
	private String countryCode;


	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
    
    

}

