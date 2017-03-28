package pl.service.science.section.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.section.dao.TypeDAO;
import pl.service.science.section.domain.Type;
import pl.service.science.section.service.TypeService;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.TranslationService;

@Service
public class ServiceTypeSectionImpl implements TypeService {

	@Autowired
	TypeDAO dao;

	@Autowired
	protected TranslationService serviceTranslation;

	public Type findById(Long id) {
		return dao.findById(id);
	}

	public Type checkOrSaveByLeadingLanguage(String name, String LanguageCode) {

		Translation translation = new Translation();

		if (serviceTranslation.findTextTranslation(name, LanguageCode) == null) {
			serviceTranslation.save(translation);
			translation = serviceTranslation.newTranslationForObject(translation, name, LanguageCode);

		} else {
			translation = serviceTranslation.findTextTranslation(name, LanguageCode);
		}

		if (this.findByTranslation(translation) == null) {
			Type type = new Type();
			type.setType(serviceTranslation.findById(translation.getId()));
			dao.save(type);
		}
		return this.findByTranslation(translation);

	}

	public void save(Type type) {
		dao.save(type);
	}

	public Type findByType(Translation type) {
		return dao.findByType(type);
	};

	public List<Type> findAll() {
		return dao.findAll();
	};

	public Type findByTranslation(Translation translation) {
		return dao.findByType(translation);
	}
}
