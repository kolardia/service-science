package pl.service.science.localization.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.translation.domain.Translation;

@Service
public interface CountryService {

	/**
	 * Find entity by a country type id
	 * @param id Identifier
	 * @return the entity with the given id
	 */
	public Country findById(Long id);
	

	/**
	 * Find entity by a translation id for a country
	 * @param translation
	 * @return
	 */
	public Country findByCountry(Translation translation);

	/**
	 * Find a country by a region
	 * @param region
	 * @return
	 */
	public Country findByRegion(Region region);

	public void save(Country country);

	public void newText(Translation translation, String text, String code);

	public Country fineOrSaveCountry(String countryName, String languageCode);
	
	public List <Country> findAll();
	
	public void deleteWhithParts(Country country);

}
