package pl.service.science.authorization.service;

import org.springframework.stereotype.Service;

import pl.service.science.authorization.domain.Profile;
import pl.service.science.translation.domain.Translation;

/**
 * Interface for a database operations for authorization with a profile
 * @author Monika Senderecka
 *
 */
@Service
public interface ProfileService {

	/**
	 * Find entity by a profile id
	 * @param id Identifier
	 * @return the entity with the given id
	 */
	public Profile findById(Long id);
	
	/**
	 * Saves a given entity for a user profile object
	 * @param profile
	 */
	public void save(Profile profile);

	/**
	 * Find entity by a user profile
	 * @param translation
	 * @return the entity of a user profile with the given translation object
	 */
	public Profile findByPortfolio(Translation translation);

}
