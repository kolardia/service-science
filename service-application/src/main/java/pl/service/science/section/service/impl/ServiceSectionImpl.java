package pl.service.science.section.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.Location;
import pl.service.science.localization.service.LocationService;
import pl.service.science.section.dao.SectionDAO;
import pl.service.science.section.domain.Section;
import pl.service.science.section.service.SectionService;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.TranslationService;
import pl.service.science.translation.service.TranslationTextService;

@Service
public class ServiceSectionImpl implements SectionService {

	@Autowired
	SectionDAO dao;

	@Autowired
	LocationService serviceLocation;

	@Autowired
	TranslationService serviceTranslation;

	@Autowired
	TranslationTextService serviceText;

	public Section findById(Long id) {
		return dao.findById(id);
	}

	public void save(Section section) {
		dao.save(section);
	}
	
	public Section findByEmail(String email){
		return dao.findByEmail(email);
	}

	public Section checkingOrSetBlank(String email) {
		if (dao.findByEmail(email) == null) {
			Section section = new Section();
			section.setEmail(email);
			section.setEnabled(false);
			section.setSection(serviceTranslation.save(new Translation()));
			section.setDescription(serviceTranslation.save(new Translation()));
			section.setLocation(null);
			dao.save(section);
			return findById(section.getId());
		}
		return dao.findByEmail(email);
	};

	public void cleanAndDelete(Section section) {

		section = dao.findById(section.getId());

		Long translationId = new Long(section.getSection().getId());
		Long translationDescriptionId = new Long(section.getDescription().getId());

		Location location = new Location();

		if (section.getLocation() != null) {
			location = serviceLocation.findById(section.getLocation().getId());
		}

		section.setType(null);
		section.setSection(null);
		section.setDescription(null);
		section.setLocation(null);
		dao.save(section);
		dao.delete(section);

		serviceLocation.cleanAndDelete(location);

		Translation translation = new Translation();

		translation = serviceTranslation.findById(translationId);
		serviceText.delete(serviceText.findByTranslation(translation));
		serviceTranslation.delete(translation);

		translation = serviceTranslation.findById(translationDescriptionId);
		serviceText.delete(serviceText.findByTranslation(translation));
		serviceTranslation.delete(translation);

	}
}
