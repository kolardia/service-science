package pl.service.science.translation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.translation.dao.LanguageDAO;
import pl.service.science.translation.domain.Language;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationTextService;

@Service
public class ServiceLanguageImpl implements LanguageService {

	@Autowired
	protected LanguageDAO dao;

	@Autowired
	protected TranslationTextService serviceText;

	public Language findById(Long id) {
		
		return dao.findById(id);
	}
	
	public List<String> selectAllCode(){
		
		List<String> codes = new ArrayList<String>();
		 
			for (Language language :  dao.findAll()) {
				codes.add(language.getCode());
			}
		
		return codes;
	}

	public Language adaptCode(String code) {

		if (dao.findByCode(code.toLowerCase()) == null) {
			Language language = new Language();
			language.setCode(code.toLowerCase());
			dao.save(language);
		}

		return dao.findByCode(code.toLowerCase());
	}

	public void removeLanguageWithTexts(Language language) {

		serviceText.delete(serviceText.findByLanguage(language));
		dao.delete(language);
	}

}
