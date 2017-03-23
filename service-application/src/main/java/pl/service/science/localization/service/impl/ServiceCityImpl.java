package pl.service.science.localization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.localization.dao.CityDAO;
import pl.service.science.localization.domain.City;
import pl.service.science.localization.service.CityService;
import pl.service.science.translation.domain.TextTranslation;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.TranslationTextService;
import pl.service.science.translation.service.TranslationService;

@Service
public class ServiceCityImpl implements CityService {

	@Autowired
	protected CityDAO dao;

	@Autowired
	protected TranslationService serviceTranslation;

	@Autowired
	protected TranslationTextService serviceText;

	public City findById(Long id) {
		return dao.findById(id);
	}

	public void save(City city) {
		dao.save(city);
	}

	public void newText(Translation translation, String text, String languageCode) {
		serviceTranslation.newTextTranslationForObject(translation, text, languageCode);
	}

	public City findOrSaveCity(String cityName, String languageCode) {

		Translation translation = new Translation();
		translation = serviceTranslation.selectTextTranslation(cityName, languageCode);

		if (translation != null) {

			return dao.findByCity(translation);

		} else {

			City city = new City();
			city.setCity(serviceTranslation.save(new Translation()));

			dao.save(city);
			this.newText(city.getCity(), cityName, languageCode);

			return dao.findById(city.getId());

		}
	}

	public City addCityTranslation(String cityName, String languageCode, String newTranslationText,
			String newLanguageCode) {

		Translation translation = new Translation();
		translation = serviceTranslation.selectTextTranslation(cityName, languageCode);

		TextTranslation translationText = new TextTranslation();
		translationText = serviceText.findByText(newTranslationText);

		if (translation != null) {
			if (translationText == null) {
				this.newText(translation, newTranslationText, newLanguageCode);
			}
			return dao.findByCity(translation);

		} else {

			City city = new City();
			city.setCity(serviceTranslation.save(new Translation()));

			dao.save(city);
			this.newText(city.getCity(), cityName, languageCode);
			if (translationText == null) {
				this.newText(translation, newTranslationText, newLanguageCode);
			}
			return dao.findById(city.getId());
		}
	}
}
