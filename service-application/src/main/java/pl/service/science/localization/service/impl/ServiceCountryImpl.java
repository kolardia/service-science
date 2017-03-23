package pl.service.science.localization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.localization.dao.CountryDAO;
import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.localization.service.CountryService;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.TranslationService;

@Service
public class ServiceCountryImpl implements CountryService {

	@Autowired
	protected CountryDAO dao;

	@Autowired
	protected TranslationService serviceTranslation;

	public Country findById(Long id) {
		return dao.findById(id);
	}

	public Country findByRegion(Region region){
		return dao.findByRegion(region);
	}
	
	public void save(Country country) {
		dao.save(country);
	}

	public void newText(Translation translation, String text, String code) {
		serviceTranslation.newTextTranslationForObject(translation, text, code);
	}

	public Country findByCountry(Translation translation) {
		return dao.findByCountry(translation);
	}

	public Country fineOrSaveCountry(String countryName, String languageCode) {

		Translation translation = new Translation();
		translation = serviceTranslation.selectTextTranslation(countryName, languageCode);

		if (translation != null) {

			return dao.findByCountry(translation);

		} else {
			Country country = new Country();
			country.setCountry(serviceTranslation.save(new Translation()));

			dao.save(country);

			this.newText(country.getCountry(), countryName, languageCode);
			
			return dao.findById(country.getId());

		}
	}
}
