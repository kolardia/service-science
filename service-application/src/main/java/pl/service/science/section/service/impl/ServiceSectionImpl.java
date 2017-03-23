package pl.service.science.section.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.section.dao.SectionDAO;
import pl.service.science.section.domain.Section;
import pl.service.science.section.service.SectionService;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.TranslationService;

@Service
public class ServiceSectionImpl implements SectionService {

	@Autowired
	SectionDAO dao;
	
	@Autowired
	TranslationService serviceTranslation;

	public Section findById(Long id) {
		return dao.findById(id);
	}

	public void save(Section section) {
		dao.save(section);
	}
	public Section ifExistfindByEmail(String email){
		 if(dao.findByEmail(email)== null){
			 Section section = new Section();
			 section.setEnabled(false);
			 section.setSection(serviceTranslation.save(new Translation()));
			 section.setDescription(serviceTranslation.save(new Translation()));
			 dao.save(section);
			 return findById(section.getId());
		 };
		
		return dao.findByEmail(email);
	};
}
