package pl.service.science.translation.service.impl;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.City;
import pl.service.science.translation.dao.TranslationDAO;
import pl.service.science.translation.domain.Language;
import pl.service.science.translation.domain.TextTranslation;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationTextService;
import pl.service.science.translation.service.TranslationService;

@Service
public class ServiceTranslationImpl implements TranslationService {

	final static Logger logger = Logger.getLogger(ServiceTranslationImpl.class);

	@Autowired
	TranslationDAO dao;

	@Autowired
	LanguageService serviceLanguage;

	@Autowired
	TranslationTextService serviceTextTranslation;

	public Translation findById(Long id) {
		return dao.findById(id);
	}
	
	public Translation findByCity(City city){
		return dao.findByCityTranslation(city);
	}

	public List<Translation> findAll() {
		return dao.findAll();
	}

	public Translation save(Translation transaltion) {
		return dao.save(transaltion);
	}

	public void delete(Translation translation) {
		dao.delete(translation);
	}

	public Translation newTranslationForObject(Translation translation, String text, String languageCode) {

		TextTranslation textTranslation = new TextTranslation();
		

		textTranslation.setLanguage(serviceLanguage.adaptCode(languageCode));
		textTranslation.setTranslation(translation);
		textTranslation.setText(text);

		serviceTextTranslation.save(textTranslation);
		logger.info("save text translation object: " + textTranslation.toString());

		return translation;
	}

	public Translation updateTranslationForObject(Translation translation, String text, String languageCode) {

		TextTranslation textTranslation = new TextTranslation();
		Language language = new Language();

		language = serviceLanguage.adaptCode(languageCode);
		textTranslation = serviceTextTranslation.checkingOrSetBlank(translation, language);
		textTranslation.setText(text);

		serviceTextTranslation.save(textTranslation);

		return translation;

	}

	public void removeTranslationWithTexts(Translation translation) {

		List<TextTranslation> text = serviceTextTranslation.findByTranslation(translation);

		serviceTextTranslation.delete(text);
		;
		this.delete(translation);

	}

	public Translation findTextTranslation(String text, String languageCode) {

		TextTranslation textTranslation = new TextTranslation();
		Language language = new Language();

		language = serviceLanguage.adaptCode(languageCode);
		textTranslation = serviceTextTranslation.findByTextAndLanguage(text, language);

		return dao.findByTextTranslation(textTranslation);

	}
	
	public String CheckingTextTranslation(Translation translation, Locale locale) {
		
		String langLocale = locale.getLanguage();

		Language language = serviceLanguage.adaptCode(langLocale);

		for (TextTranslation textTranslation : serviceTextTranslation.findByTranslation(translation)) {

			if (textTranslation.getLanguage().getId() == language.getId()) {

				return serviceTextTranslation.checkingOrSetBlank(translation, language).getText();
			}
		}
		return null;
	}

}
