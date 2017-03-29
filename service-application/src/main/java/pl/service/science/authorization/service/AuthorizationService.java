package pl.service.science.authorization.service;

import org.springframework.stereotype.Service;

import pl.service.science.authorization.domain.Authorization;
import pl.service.science.authorization.domain.Status;
import pl.service.science.authorization.domain.User;
import pl.service.science.section.domain.Section;

/**
 * Interface for generic database operations
 * @author Monika Senderecka
 *
 */
@Service
public interface AuthorizationService {

	/**
	 * Find entity by a authorization id
	 * @param id Identifier
	 * @return the entity with the given id
	 */
	public Authorization findById(Long id);

	/**
	 * Find entity by a user and a section and a status
	 * @param user
	 * @param section
	 * @param status a authorization status
	 * @return the entity 
	 */
	public Authorization findByUserAndSectionAndAuthorization(User user, Section section, Status status);

	/**
	 * Saves a given entity
	 * @param profile
	 */
	public void save(Authorization authorization);
}
