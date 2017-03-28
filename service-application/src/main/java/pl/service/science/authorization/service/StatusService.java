package pl.service.science.authorization.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.authorization.domain.Status;
import pl.service.science.translation.domain.Translation;

@Service
public interface StatusService {
	
	public Status checkOrSaveStatusByLeadingLanguage(String name, String LanguageCode);

	/**
	 * Find entity by a authorization status id
	 * @param id Identifier
	 * @return the entity with the given
	 */
	public Status findById(Long id);

	/**
	 * Saves a given entity for a status object
	 * @param type
	 */
	public void save(Status status);
	
	/**
	 * List of entities from a authorization status 
	 * @return The list consisting of a type entity
	 */
	public List<Status> findAll();
	
	/**
	 * Find entity by a translation
	 * @param translation
	 * @return the entity with the given translation
	 */
	public Status findByTranslation(Translation translation);

}
