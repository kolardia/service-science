package pl.service.science.translation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.translation.domain.Language;
import pl.service.science.translation.domain.TextTranslation;
import pl.service.science.translation.domain.Translation;

/**
 *  Interface for generic database operations on a repository for a TextTranslation type.
 * @author Monika Sendereca
 *
 */
@Service
public interface TranslationTextService {

	/**
	 * Checking an existing entity if not exist sets a blank entity with the given translation and the given language
	 * @param translation
	 * @param language
	 * @return the entity with the given text exists or a new blank if none found

	 */
	public TextTranslation checkingOrSetBlank(Translation translation, Language language);

	/**
	 * Saves a given entity for a object
	 * @param text
	 */
	public void save(TextTranslation text);

	/**
	 * Find entity by a translation
	 * @param translation
	 * @return The text entity
	 */
	public List<TextTranslation> findByTranslation(Translation translation);

	/**
	 * Deletes a given collection.
	 * @param text
	 */
	public void delete(List<TextTranslation> text);

	/**
	 * Deletes a given entity.
	 * @param text
	 */
	public void delete(TextTranslation text);

	/**
	 * Find entity by a translated text and a language
	 * @param text
	 * @param language
	 * @return The text entity
	 */
	public TextTranslation findByTextAndLanguage(String text, Language language);

	/**
	 * List of entities from translated texts
	 * @param language
	 * @return The list consisting of a text entity
	 */
	public List<TextTranslation> findByLanguage(Language language);
	
	/**
	 * Find entity by a text field
	 * @param text
	 * @return The text entity
	 */
	public TextTranslation findByText(String text);
	
	/**
	 * Find entity by a translated text by id
	 * @param id Identifier
	 * @return The text entity
	 */
	public TextTranslation findById(Long id);
}
