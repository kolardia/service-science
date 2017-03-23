package pl.service.science.translation.service;

import java.util.Locale;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.City;
import pl.service.science.translation.domain.Translation;

/**
 *
 * @author Monika Senderecka
 *
 */
@Service
public interface TranslationService {

	/**
	 * Setting text string by find translation and Language Locale 
	 * @param translation
	 * @param locale
	 * @return
	 * 
	 */
	public String CheckingTextTranslation(Translation translation, Locale locale);
	/**
	 * @param translation
	 */
	public void removeTranslationAlongWithAllTexts(Translation translation);

	/**
	 * @param translation
	 * @param text
	 * @param languageCode
	 * @return
	 */

	public Translation newTextTranslationForObject(Translation translation, String text, String languageCode);

	/**
	 * @param translation
	 * @param text
	 * @param languageCode
	 * @return
	 */
	public Translation updateTextTranslationForObject(Translation translation, String text, String languageCode);

	/**
	 * @param text
	 * @param languageCode
	 * @return the entity with the given text and the given language code
	 */
	public Translation selectTextTranslation(String text, String languageCode);
	
	/**
	 * CRUD Find entity by a translation id
	 * @param id Identifier
	 * @return the entity with the given id
	 */
	public Translation findById(Long id);

	/**
	 * CRUD Find entity by a city
	 * @param city
	 * @return the entity with the given city
	 */
	public Translation findByCity(City city);

	/**
	 * CRUD Saves a given entity for a user object
	 * @param transaltion
	 * @return
	 */
	public Translation save(Translation transaltion);


}
