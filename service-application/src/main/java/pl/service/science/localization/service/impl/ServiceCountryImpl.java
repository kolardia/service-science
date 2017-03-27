package pl.service.science.localization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.localization.dao.CountryDAO;
import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.localization.service.CountryService;
import pl.service.science.localization.service.RegionService;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.TranslationService;
import pl.service.science.translation.service.TranslationTextService;

@Service
public class ServiceCountryImpl implements CountryService {

	@Autowired
	protected CountryDAO dao;

	@Autowired
	protected TranslationService serviceTranslation;

	@Autowired
	protected RegionService serviceRegion;

	@Autowired
	protected TranslationTextService serviceText;

	public Country findById(Long id) {
		return dao.findById(id);
	}

	public Country findByRegion(Region region) {
		return dao.findByRegion(region);
	}

	public void save(Country country) {
		dao.save(country);
	}

	public void newText(Translation translation, String text, String code) {
		serviceTranslation.newTranslationForObject(translation, text, code);
	}

	public Country findByCountry(Translation translation) {
		return dao.findByCountry(translation);
	}

	public List<Country> findAll() {
		return dao.findAll();
	}

	public void deleteWhithParts(Country country) {

		Translation translation = new Translation();
		translation = serviceTranslation.findById(country.getCountry().getId());

		if (country.getRegion() != null) {
			country.setRegion(null);
			dao.save(country);
		}

		dao.delete(country);
		serviceText.delete(serviceText.findByTranslation(translation));
		serviceTranslation.delete(translation);

	}

	public Country fineOrSaveCountry(String countryName, String languageCode) {

		Translation translation = new Translation();
		translation = serviceTranslation.findTextTranslation(countryName, languageCode);

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
