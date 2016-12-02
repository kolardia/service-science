package pl.service.science.localization.service;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.City;
import pl.service.science.translation.domain.Translation;

@Service
public interface ServiceCity {

	public City findById(Long id);

	public void newText(Translation translation, String text, String languageCode);

	public void save(City city);

	public City findOrSave(String countryName, String languageCode);

}
