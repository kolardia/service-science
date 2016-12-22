package pl.service.science.localization.service;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.translation.domain.Translation;

@Service
public interface ServiceCountry {

	public Country findById(Long id);

	public Country findByCountry(Translation translation);

	public Country findByRegion(Region region);

	public void save(Country country);

	public void newText(Translation translation, String text, String code);

	public Country findOrSave(String countryName, String languageCode);

}
