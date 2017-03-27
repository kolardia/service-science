package pl.service.science.localization.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.City;
import pl.service.science.translation.domain.Translation;

/**
 * Interface for a database operations for a city type.
 * @author Monika Senderecka
 * 
 */

@Service
public interface CityService {


	/**
	 * Saves a new text entity in the language code for a translation object
	 * @param translation
	 * @param text a translation text
	 * @param languageCode translation in the given language code
	 */
	public void newText(Translation translation, String text, String languageCode);

	/**
	 * Saves a new city entity or a given city entity in the language code for a translation object
	 * @param cityName a name city for a text object
	 * @param languageCode a language code 
	 * @return the entity city with the given parameters for a translation object.
	 */
	public City findOrSaveCity(String cityName, String languageCode);
	
	/**
	 * Saves a new translation text for a given translation text entity in the language code.
	 * @param cityName a given translation
	 * @param languageCode a given language code
	 * @param newTranslationText a new translation text
	 * @param newLanguageCode a new language code
	 * @return the entity city with a additional translation text
	 */
	public City addCityTranslation(String cityName, String languageCode, String newTranslationText, String newLanguageCode);

	/**
	 * Find entity by a city type id
	 * @param id
	 * @return the entity with the given id
	 */
	public City findById(Long id);
	
	/**
	 * Saves a given entity for a city object
	 * @param city
	 */
	public void save(City city);
	
	public void deleteCityWhithParts(City city);
	
	public List<City>findAll();
	
}
