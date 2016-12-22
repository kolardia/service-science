package pl.service.science.localization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.localization.dao.DaoCity;
import pl.service.science.localization.domain.City;
import pl.service.science.localization.service.ServiceCity;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.ServiceTranslation;

@Service
public class ServiceCityImpl implements ServiceCity {

	@Autowired
	protected DaoCity dao;

	@Autowired
	protected ServiceTranslation serviceTranslation;

	public City findById(Long id) {
		return dao.findById(id);
	}

	public void save(City city) {
		dao.save(city);
	}

	public void newText(Translation translation, String text, String languageCode) {
		serviceTranslation.newText(translation, text, languageCode);
	}

	public City findOrSave(String countryName, String languageCode) {

		Translation translation = new Translation();
		translation = serviceTranslation.findText(countryName, languageCode);

		if (translation != null) {

			return dao.findByCity(translation);

		} else {

			City city = new City();
			city.setCity(serviceTranslation.save(new Translation())); 
			
			dao.save(city);

			this.newText(city.getCity(), countryName, languageCode);
			
			return dao.findById(city.getId());

		}
	}
}
