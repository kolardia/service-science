package pl.service.science.translation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.translation.dao.DaoTranslationText;
import pl.service.science.translation.domain.Language;
import pl.service.science.translation.domain.TextTranslation;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.ServiceTextTranslation;

@Service
public class ServiceTextTranslationImpl implements ServiceTextTranslation {

	@Autowired
	protected DaoTranslationText dao;

	public TextTranslation findById(Long id) {
		return dao.findById(id);
	}

	public TextTranslation findByTranslationAndLanguage(Translation translation, Language language) {
		return dao.findByTranslationAndLanguage(translation, language);
	}
	
	public TextTranslation findByText(String text){
		return dao.findByText(text);
	}

	public void save(TextTranslation text){
		dao.save(text);
	}
	
	public List<TextTranslation> findByTranslation(Translation translation){
		return dao.findByTranslation(translation);
	}
	
	public void delete(List <TextTranslation> text){
		dao.delete(text);
	}
	
	public void delete(TextTranslation text){
		dao.delete(text);
	}
}
