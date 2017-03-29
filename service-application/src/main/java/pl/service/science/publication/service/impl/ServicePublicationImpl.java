package pl.service.science.publication.service.impl;

import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.authorization.domain.Authorization;
import pl.service.science.publication.dao.PublicationDAO;
import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.service.ServicePublication;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.TranslationService;

@Service
public class ServicePublicationImpl implements ServicePublication {

	final static Logger logger = Logger.getLogger(ServicePublication.class);

	@Autowired
	protected PublicationDAO dao;

	@Autowired
	TranslationService serviceTranslation;

	/**
	 * public Section checkingOrSetBlank(String email) { if
	 * (dao.findByEmail(email) == null) { Section section = new Section();
	 * section.setEmail(email); section.setEnabled(false);
	 * section.setSection(serviceTranslation.save(new Translation()));
	 * section.setDescription(serviceTranslation.save(new Translation()));
	 * section.setLocation(null); dao.save(section); return
	 * findById(section.getId()); } return dao.findByEmail(email); };
	 */

	public Publication checkingOrSetBlank(Long id, Authorization authorization) {

		Publication publication = new Publication();
		
		if (dao.findById(id) == null) {
			publication.setEnabled(false);
			publication.setAutorization(authorization);
			publication.setTitle(serviceTranslation.save(new Translation()));
			publication.setPurposeOfEvent(serviceTranslation.save(new Translation()));
			publication.setCandidateProfile(serviceTranslation.save(new Translation()));
			publication.setInitialRequirements(serviceTranslation.save(new Translation()));
			publication.setContents(serviceTranslation.save(new Translation()));
			publication.setMethodology(serviceTranslation.save(new Translation()));
			publication.setEventProgram(serviceTranslation.save(new Translation()));

			dao.save(publication);
			publication = dao.findById(publication.getId());
		} else {
			publication =	dao.findById(id);
		}
		return publication;
	}

	public Publication findById(Long id) {
		return dao.findById(id);

	};

	public List<Publication> findAll() {
		return dao.findAll();
	};

	public Publication save(Publication contest) {
		return dao.save(contest);
	};

	public void delete(Long id) {
		dao.delete(id);
	};

	public void deleteAllPublicationParts(Publication poublication) {
		this.delete(poublication.getId());
		serviceTranslation.removeTranslationWithTexts(poublication.getTitle());
		serviceTranslation.removeTranslationWithTexts(poublication.getContents());
	}

	public void saveText(Translation translation, String text, String code) {

		serviceTranslation.newTranslationForObject(translation, text, code);
	}

	public Translation insert(Translation translation) {
		serviceTranslation.save(translation);

		return translation;
	}

	public List<Publication> searchLanguage(String language, List<Publication> listLanguage_en,
			List<Publication> listLanguage_pl) {
		/*
		 * https://docs.oracle.com/javase/tutorial/i18n/locale/create.html
		 * http://www.chemie.fu-berlin.de/diverse/doc/ISO_3166.html Region Codes
		 * Country A 2 A 3 Number POLAND PL POL 616
		 */
		/*
		 * http://www.loc.gov/standards/iso639-2/php/code_list.php Language Code
		 * ISO 639-2 Code ISO 639-1 Code English name of Language pol pl Polish
		 */
		Locale plLocale = new Locale.Builder().setLanguage("pl").setRegion("PL").build();
		Locale enLocale = new Locale.Builder().setLanguage("en").setRegion("US").build();

		String plLanguage = plLocale.getLanguage();
		String enLanguage = enLocale.getLanguage();

		if (language == plLanguage) {
			logger.info("***list_en: locale.ENGLISH ***");
			return listLanguage_pl;
		} else if (language == enLanguage) {
			logger.info("***list_pl: defaultLocale ***");
			return listLanguage_en;
		} else {
			List<Publication> list = null;
			logger.info("***A NEW EMPTY LIST: Translation not found: locale ***");
			return list;
		}
	}

}
