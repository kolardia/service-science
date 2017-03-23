package pl.service.science.localization.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.translation.domain.Translation;

@Service
public interface RegionService {

	/**
	 * @param translation
	 * @param text
	 * @param languageCode
	 */
	public void newText(Translation translation, String text, String languageCode);

	/**
	 * @param countryName
	 * @param languageCode
	 * @return
	 */
	public Region fineOrSaveRegion(String countryName, String languageCode);

	/**
	 * CRUD
	 * @param country
	 * 
	 * @return
	 */
	public List<Region> findByCountry(Country country);
	
	/**
	 * CRUD
	 * @param id
	 * @return
	 */
	public Region findById(Long id);

	/**
	 * CRUD
	 * @param translation
	 * @return
	 */
	public Region findByRegion(Translation translation);

	/**
	 * CRUD
	 * @param region
	 */
	public void save(Region region);


}
