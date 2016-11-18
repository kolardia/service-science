package pl.service.science.localization.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


public class City {
	
	
	int countryId;
	

	int translationIdCountry;
	
	String country;
	
	public City(int countryId, int translationCountry, String country){
		this.setCountryId(countryId);
		this.setTranslationIdCountry(translationCountry);
		this.setCountry(country);
	}
	
	public City(){
		
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getTranslationIdCountry() {
		return translationIdCountry;
	}

	public void setTranslationIdCountry(int translationIdCountry) {
		this.translationIdCountry = translationIdCountry;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}	

}