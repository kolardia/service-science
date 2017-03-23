package pl.service.science.section.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.section.domain.Type;

/**
 * Interface for a database operations for a section type.
 * @author kolardia
 *
 */
@Service
public interface TypeService {

	/**
	 * Find entity by a section type id
	 * @param id
	 * @return the entity with the given id or null if none found
	 */
	public Type findById(Long id);

	/**
	 * Saves a given entity for a type object
	 * @param type
	 */
	public void save(Type type);
	
	public List<Type> findAll();
}
