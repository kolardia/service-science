package pl.service.science.localization.service;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.Location;
import pl.service.science.localization.domain.Region;

@Service
public interface LocationService {

	/**
	 * Find entity by a location type id
	 * @param id Identifier
	 * @return the entity with the given id
	 */
	public Location findById(Long id);

	/**
	 * Saves a given entity for a location object
	 * @param location
	 */
	public Location save(Location location);

	/**
	 * Check out the leading language (the issue of contractual) does objects exist and does objects are related; 
	 * Save country (if not exist) and region (if not exist). Create related (if not exist)
	 * @param LanguageCode
	 * @param nameRegion
	 * @param nameCountry
	 * @return the entity region associated with the country
	 */
	public Region countryAssociatedWithRegion(String LanguageCode, String nameRegion, String nameCountry);
	
	/**
	 * Clean and delete a given entity for a location object
	 * @param location
	 */
	public void cleanAndDelete(Location location);
	
}
