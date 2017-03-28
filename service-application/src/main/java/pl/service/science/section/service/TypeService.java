package pl.service.science.section.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.section.domain.Type;
import pl.service.science.translation.domain.Translation;

/**
 * Interface for a database operations for a section type 
 * @author Monika Senderecka
 *
 */
@Service
public interface TypeService {
	
	public Type checkOrSaveByLeadingLanguage(String name, String LanguageCode);

	/**
	 * Find entity by a section type id
	 * @param id Identifier
	 * @return the entity with the given id or null if none found
	 */
	public Type findById(Long id);

	/**
	 * Saves a given entity for a type object
	 * @param type
	 */
	public void save(Type type);
	
	/**
	 * List of entities from section types
	 * @return The list consisting of a type entity
	 */
	public List<Type> findAll();
	
	/**
	 * Find entity by a translation
	 * @param translation
	 * @return the entity with the given translation
	 */
	public Type findByTranslation(Translation translation);
}
