package pl.service.science.localization.service;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.Country;
import pl.service.science.translation.domain.Translation;

@Service
public interface ServiceCountry {

	public Country findById(Long id);

	public Country findByCountry(Translation translation);

	public void save(Country country);

	public Translation insert(Translation translation);

	public void newText(Translation translation, String text, String code);

	public Country findOrSave(String countryName, String languageCode);

}
