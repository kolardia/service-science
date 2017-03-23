package pl.service.science.authorization.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.authorization.domain.User;

/**
 * Interface for generic database operations on a repository for a user type.
 * @author Monika Senderecka
 *
 */
@Service
public interface UserService {

	/**
	 * Checking if user exists in database
	 * @param email 
	 * @return the entity with the given email exists or a new user if none found
	 */
	public User CheckingUser(String email);

	/**
	 * CRUD Find entity by a user id
	 * @param id Identifier
	 * @return the entity with the given id
	 */
	public User findById(Long id);
	
	/**
	 * CRUD Find all entity
	 * @return A list of all users
	 */
	public List<User> findAll();
	
	/**
	 * CRUD Saves a given entity for a user object
	 * @param user Generated value for id
	 */
	public void save(User user);
	
}
