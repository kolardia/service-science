package pl.service.science.authorization.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.authorization.domain.Role;
import pl.service.science.authorization.domain.User;

@Service
public interface ServiceRole {
	
	/**
	 * Find entity by a role id
	 * @param id Identifier
	 * @return the entity with the given id
	 */
	public Role findById(Long id);
	
	/**
	 * Find entity transaction by a user object and its role
	 * @param id Identifier
	 * @return the entity
	 */
	public Role findByUserAndRola(User user, String role);

	/**
	 * Find all roles for the user object
	 * @param user
	 * @return the entity
	 */
	public List<Role> findByUser(User user);
	
	/**
	 * Saves a given entity for a role object
	 * @param user
	 */
	public void save(Role role);

}
