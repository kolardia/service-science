package pl.service.science.localization.service;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.City;
import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.translation.domain.Translation;

@Service
public interface ServiceRegion {

	public Region findById(Long id);
	
	public Region findByRegion(Translation translation);

	public void save(Region region);

	public Translation insert(Translation translation);

	public void newText(Translation translation, String text, String languageCode);

	public Region findOrSave(String countryName, String languageCode);

	public Region findByCity(City city);

	public Region findByCountry(Country country);

}