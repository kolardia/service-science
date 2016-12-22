package pl.service.science.localization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.localization.dao.DaoCountry;
import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.localization.service.ServiceCountry;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.ServiceTranslation;

@Service
public class ServiceCountryImpl implements ServiceCountry {

	@Autowired
	protected DaoCountry dao;

	@Autowired
	protected ServiceTranslation serviceTranslation;

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
		serviceTranslation.newText(translation, text, code);
	}

	public Country findByCountry(Translation translation) {
		return dao.findByCountry(translation);
	}

	public Country findOrSave(String countryName, String languageCode) {

		Translation translation = new Translation();
		translation = serviceTranslation.findText(countryName, languageCode);

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
