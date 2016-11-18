package pl.service.science.localization.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


public class Country {


	public int countryId;
	

	public int countryTranslationId;
	

	public String country;
	
	public Country(int countryId, int tcountryTranslationId, String country){
		this.setCountryId(countryId);
		this.setCountryTranslationId(countryTranslationId);
		this.setCountry(country);
	}
	
	public Country(){
		
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getCountryTranslationId() {
		return countryTranslationId;
	}

	public void setCountryTranslationId(int countryTranslationId) {
		this.countryTranslationId = countryTranslationId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


}