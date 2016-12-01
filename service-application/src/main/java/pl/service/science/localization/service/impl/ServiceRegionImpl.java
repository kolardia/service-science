package pl.service.science.localization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.localization.dao.DaoRegion;
import pl.service.science.localization.domain.City;
import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.localization.service.ServiceRegion;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.ServiceTranslation;

@Service
public class ServiceRegionImpl implements ServiceRegion {

	@Autowired
	protected DaoRegion dao;

	@Autowired
	protected ServiceTranslation serviceTranslation;

	public Region findById(Long id) {
		return dao.findById(id);
	}

	public void save(Region region) {
		dao.save(region);
	}

	public Translation insert(Translation translation) {
		serviceTranslation.save(translation);
		return translation;
	}

	public void newText(Translation translation, String text, String languageCode) {
		serviceTranslation.newText(translation, text, languageCode);
	}

	public Region findOrSave(String countryName, String languageCode) {

		Translation translation = new Translation();
		translation = serviceTranslation.findText(countryName, languageCode);

		if (translation == null) {
			Region region = new Region();

			region.setRegion(this.insert(new Translation()));

			dao.save(region);

			this.newText(region.getRegion(), countryName, languageCode);
			return region;

		} else {

			translation = serviceTranslation.findText(countryName, languageCode);

			return dao.findByRegion(translation);
		}
	}

	public Region findByCity(City city) {
		return dao.findByCity(city);
	}

	public Region findByCountry(Country country) {
		return dao.findByCountry(country);
	}
	
	public Region findByRegion(Translation translation){
		return dao.findByRegion(translation);
	}
}