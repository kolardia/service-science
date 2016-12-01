package pl.service.science.translation.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.translation.dao.DaoTranslation;
import pl.service.science.translation.domain.Language;
import pl.service.science.translation.domain.TextTranslation;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.ServiceLanguage;
import pl.service.science.translation.service.ServiceTextTranslation;
import pl.service.science.translation.service.ServiceTranslation;

@Service
public class ServiceTranslationImpl implements ServiceTranslation {

	final static Logger logger = Logger.getLogger(ServiceTranslationImpl.class);

	@Autowired
	DaoTranslation dao;

	@Autowired
	ServiceLanguage serviceLanguage;

	@Autowired
	ServiceTextTranslation serviceTextTranslation;

	public Translation findById(Long id) {
		return dao.findById(id);
	}

	public List<Translation> findAll() {
		return dao.findAll();
	}

	public void save(Translation transaltion) {
		dao.save(transaltion);
	}

	public void delete(Translation translation) {
		dao.delete(translation);
	}

	public Translation newText(Translation translation, String text, String languageCode) {

		TextTranslation textTranslation = new TextTranslation();

		textTranslation.setLanguage(serviceLanguage.findByCode(languageCode));
		textTranslation.setTranslation(translation);
		textTranslation.setText(text);

		serviceTextTranslation.save(textTranslation);
		logger.info("save text translation object: " + textTranslation.toString());

		return translation;
	}

	public Translation updateText(Translation translation, String text, String languageCode) {

		TextTranslation textTranslation = new TextTranslation();
		Language language = new Language();

		language = serviceLanguage.findByCode(languageCode);
		textTranslation = serviceTextTranslation.findByTranslationAndLanguage(translation, language);
		textTranslation.setText(text);

		serviceTextTranslation.save(textTranslation);

		return translation;

	}

	public void deleteTranslationParts(Translation translation) {

		List<TextTranslation> text = serviceTextTranslation.findByTranslation(translation);

		serviceTextTranslation.delete(text);
		;
		this.delete(translation);

	}

	public Translation findText(String text, String languageCode) {

		TextTranslation textTranslation = new TextTranslation();
		Language language = new Language();

		language = serviceLanguage.findByCode(languageCode);
		textTranslation = serviceTextTranslation.findByTextAndLanguage(text, language);

		return dao.findByTextTranslation(textTranslation);

	}

}
