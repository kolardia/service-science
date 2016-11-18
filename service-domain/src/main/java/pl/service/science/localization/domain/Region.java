package pl.service.science.localization.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


public class Region {
	
	
	public int regionId;
	
	
	public int countryId;
	
	
	public int translationIdRegion;
	
	
	public String region;
	
	public Region(int regionId, int countryId, int translationIdRegion, String region){
		this.setRegionId(regionId);
		this.setCountryId(countryId);
		this.setTranslationIdRegion(translationIdRegion);
		this.setRegion(region);
	}
	
	public Region(){
		
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getTranslationIdRegion() {
		return translationIdRegion;
	}

	public void setTranslationIdRegion(int translationIdRegion) {
		this.translationIdRegion = translationIdRegion;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
}