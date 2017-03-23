package pl.service.science.translation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.translation.domain.Language;

/**
 * Interface that specifies a set of language operations
 * @author kolardia
 *
 */
@Service
public interface LanguageService {
	
	/**
	 * Code compliant with ISO 639-1 specifications 
	 * @param code A language code 
	 * The entity with the given language exists or a save language if none found
	 * Unification of the characters code
	 * @return a language entity
	 */
	public Language adaptCode(String code);
	
	/**
	 * Remove a language along with its translated texts
	 * @param language
	 */
	public void removeLanguageAlongWithTexts(Language language) ;
	
	/**
	 * Selected all codes for languages
	 * @return A list of all languages
	 */
	public List<String> selectAllCodes();
	
	/**
	 * CRUD Find entity by a Language id
	 * @param id Identifier
	 * @return the entity with the given id
	 */
	public Language findById(Long id);
	

}
