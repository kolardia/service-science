package pl.service.science.translation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.translation.dao.TranslationTextDAO;
import pl.service.science.translation.domain.Language;
import pl.service.science.translation.domain.TextTranslation;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.TranslationTextService;

@Service
public class ServiceTextTranslationImpl implements TranslationTextService {

	@Autowired
	protected TranslationTextDAO dao;

	public TextTranslation findById(Long id) {
		return dao.findById(id);
	}

	public TextTranslation checkingOrSetBlank(Translation translation, Language language) {
		
		if(dao.findByTranslationAndLanguage(translation, language)!=null){
			return dao.findByTranslationAndLanguage(translation, language);
		}else{
			TextTranslation text = new TextTranslation();
			text.setTranslation(translation);
			text.setLanguage(language);
		return text;
		}
	}

	public TextTranslation findByText(String text) {
		return dao.findByText(text);
	}

	public void save(TextTranslation text) {
		dao.save(text);
	}

	public List<TextTranslation> findByTranslation(Translation translation) {
		return dao.findByTranslation(translation);
	}

	public void delete(List<TextTranslation> text) {
		dao.delete(text);
	}

	public void delete(TextTranslation text) {
		dao.delete(text);
	}

	public TextTranslation findByTextAndLanguage(String text, Language language) {
		return dao.findByTextAndLanguage(text, language);
	}
	
	public List<TextTranslation> findByLanguage(Language language){
		return dao.findByLanguage(language);
	}
}
