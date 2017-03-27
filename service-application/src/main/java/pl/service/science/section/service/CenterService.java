package pl.service.science.section.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.section.domain.Section;
import pl.service.science.section.domain.Center;

/**
 * Interface for a database operations for the section related to the center
 * 
 * @author Monika Senderecka
 *
 */
@Service
public interface CenterService {

	/**
	 * Find entity by a section center id
	 * 
	 * @param id Identifier
	 * @return the entity with the given id
	 */
	public Center findById(Long id);

	/**
	 * All entities of transaction with section center
	 * 
	 * @return The list consisting of a entity
	 */
	public List<Center> findAll();

	/**
	 * Saves a given entity for a section center
	 * 
	 * @param center
	 */
	public void save(Center center);

	/**
	 * Find entity by a section
	 * 
	 * @param section
	 * @return the transaction of the section center
	 */
	public Center findBySubsection(Section section);

	/**
	 * Check out the section related to the Center
	 * 
	 * @param subsection
	 * @return find the section related to the center or save the transaction
	 */
	public Center checkSectionAssociatedWithCenter(Section center, Section subsection);

	/**
	 * List of entities from the section center
	 * 
	 * @param section
	 * @return The list consisting of a entity
	 */
	public List<Center> findBySectionCenter(Section section);

}
