package pl.service.science.translation.service;

import java.util.Locale;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.City;
import pl.service.science.translation.domain.Translation;

/**
 * Interface that specifies a set of operations for translations
 * @author Monika Senderecka
 *
 */
@Service
public interface TranslationService {

	/**
	 * Checking an existing string from a translated text in a given language
	 * @param translation
	 * @param locale
	 * @return A translated text
	 * 
	 */
	public String CheckingTextTranslation(Translation translation, Locale locale);
	/**
	 * Remove a translation entity along with related its entity of a translated texts
	 * @param translation
	 */
	public void removeTranslationWithTexts(Translation translation);

	/**
	 * Create a new entity for translation with a given parameters 
	 * @param translation
	 * @param text
	 * @param languageCode
	 * @return
	 */

	public Translation newTranslationForObject(Translation translation, String text, String languageCode);

	/**
	 * Update a entity for translation with a given parameters 
	 * @param translation
	 * @param text
	 * @param languageCode
	 * @return
	 */
	public Translation updateTranslationForObject(Translation translation, String text, String languageCode);

	/**
	 * Find entity by a translated text and a language
	 * @param text
	 * @param languageCode
	 * @return the entity with the given text and the given language code
	 */
	public Translation findTextTranslation(String text, String languageCode);
	
	/**
	 * Find entity by a translation id
	 * @param id Identifier
	 * @return the entity with the given id
	 */
	public Translation findById(Long id);

	/**
	 * Find entity by a city
	 * @param city
	 * @return the entity with the given city
	 */
	public Translation findByCity(City city);

	/**
	 * Saves a given entity for a translation object
	 * @param transaltion
	 * @return
	 */
	public Translation save(Translation transaltion);
	
	/**
	 * Delete a given entity for a translation object
	 * @param translation
	 */
	public void delete(Translation translation);


}
