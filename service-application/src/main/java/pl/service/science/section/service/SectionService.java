package pl.service.science.section.service;

import org.springframework.stereotype.Service;

import pl.service.science.section.domain.Section;

/**
 * Interface for generic database operations on a repository for a section type.
 * @author kolardia
 *
 */
@Service
public interface SectionService {

	/**
	 * Find entity by a section id.
	 * @param id
	 * @return the entity with the given id or null if none found
	 */
	public Section findById(Long id);

	/**
	 * Saves a given entity for a section object
	 * @param section
	 */
	public void save(Section section);
	
	/**
	 * Find entity by a section email. 
	 * @param email
	 * @return the entity with the given email exists or a new section template if none found
	 */
	public Section ifExistfindByEmail(String email);
}
