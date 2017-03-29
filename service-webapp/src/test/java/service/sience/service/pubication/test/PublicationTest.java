package service.sience.service.pubication.test;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.authorization.domain.Authorization;
import pl.service.science.authorization.domain.Profile;
import pl.service.science.authorization.domain.Role;
import pl.service.science.authorization.domain.Status;
import pl.service.science.authorization.domain.User;
import pl.service.science.authorization.service.AuthorizationService;
import pl.service.science.authorization.service.ProfileService;
import pl.service.science.authorization.service.ServiceRole;
import pl.service.science.authorization.service.StatusService;
import pl.service.science.authorization.service.UserService;
import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.service.ServicePublication;
import pl.service.science.publication.service.ServiceState;
import pl.service.science.section.domain.Section;
import pl.service.science.section.service.SectionService;
import pl.service.science.section.service.TypeService;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationService;
import pl.service.science.translation.service.TranslationTextService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class PublicationTest {

	final static Logger logger = Logger.getLogger(PublicationTest.class);

	@Autowired
	protected ServicePublication service;
	
	@Autowired
	public TranslationService serviceTranslation;
	
	@Autowired
	ServiceState serviceState;


	@Test
	public void publication() {
		
		Locale locale = new Locale.Builder().setLanguage("pl").setRegion("PL").build();
		
		User userTemp = serviceUser.CheckingUser("m.margaretka@gmail.com");
		Section sectionTemp = serviceSection.checkingOrSetBlank("wmi@uam.com");
		Status statusTemp = serviceStatus.checkOrSaveStatusByLeadingLanguage("Redaktor", "PL");

		if (serviceAuthorization.findByUserAndSectionAndAuthorization(userTemp, sectionTemp, statusTemp) != null) {
			Authorization authorization = serviceAuthorization.findByUserAndSectionAndAuthorization(userTemp,
					sectionTemp, statusTemp);

			Publication publication = service.checkingOrSetBlank(null, authorization);
			publication.setEnabled(true);
			publication.setForFree(false);
			publication.setPrice(1700);
			publication.setNumberOfSeats(20);

			publication.setLeader(userTemp);
		//	State stateTemp = serviceState.checkOrSaveByLeadingLanguage("archiwa", "PL");
		//	publication.setState(stateTemp);
			publication.setType("KNF");

			service.save(publication);
			
			serviceTranslation.newOrUpdateForObject(publication.title, locale, "tytul 1");
			serviceTranslation.newOrUpdateForObject(publication.contents, locale, "tresc 1");
			serviceTranslation.newOrUpdateForObject(publication.eventProgram, locale, "program 1");
			serviceTranslation.newOrUpdateForObject(publication.methodology, locale, "metodologua 1");
			
			
			serviceTranslation.newOrUpdateForObject(publication.title, Locale.ENGLISH, "title 1");
			serviceTranslation.newOrUpdateForObject(publication.contents,  Locale.ENGLISH, "contents 1");
			serviceTranslation.newOrUpdateForObject(publication.eventProgram,  Locale.ENGLISH, "event program 1");
			serviceTranslation.newOrUpdateForObject(publication.methodology,  Locale.ENGLISH, "methodology 1");
		}

	}
	


	@Test
	public void simplePublication() {

		Publication contest = new Publication();

		contest.setAutorization(null);
		contest.setTitle(null);
		contest.setContents(null);

		service.save(contest);

		// service.deleteAllPublicationParts(contest);
	}

	@Autowired
	AuthorizationService serviceAuthorization;

	@Autowired
	protected SectionService serviceSection;

	@Autowired
	protected TypeService serviceType;

	@Autowired
	protected UserService serviceUser;

	@Autowired
	protected ServiceRole serviceRole;

	@Autowired
	public StatusService serviceStatus;

	@Autowired
	protected ProfileService serviceProfile;

	@Autowired
	protected TranslationTextService serviceText;

	@Autowired
	protected LanguageService servicelanguage;

	@Before
	public void authorization() {

		Authorization authorization = new Authorization();

		if (serviceUser.findByEmail("m.margaretka@gmail.com") != null
				|| serviceSection.findByEmail("wmi@uam.com") != null) {

			User userTemp = serviceUser.CheckingUser("m.margaretka@gmail.com");
			Section sectionTemp = serviceSection.checkingOrSetBlank("wmi@uam.com");
			Status statusTemp = serviceStatus.checkOrSaveStatusByLeadingLanguage("Redaktor", "PL");

			if (serviceAuthorization.findByUserAndSectionAndAuthorization(userTemp, sectionTemp, statusTemp) != null) {
				authorization = serviceAuthorization.findByUserAndSectionAndAuthorization(userTemp, sectionTemp,
						statusTemp);
			}

			Profile profileTemp = new Profile();

			authorization.setSection(sectionTemp);
			authorization.setUser(userTemp);
			authorization.setAuthorization(statusTemp);
			authorization.setEnabled(true);
			// Not required
			serviceProfile.save(profileTemp);
			authorization.setProfileAuthorization(profileTemp);
			serviceAuthorization.save(authorization);

			if (serviceRole.findByUserAndRola(userTemp, "REDAK") == null) {
				Role role = new Role();
				role.setRola("REDAK");
				role.setUser(userTemp);
				serviceRole.save(role);
			}

			if (profileTemp != null || profileTemp.getPortfolio() == null) {
				profileTemp.setPortfolio(serviceTranslation.save(new Translation()));
				serviceProfile.save(profileTemp);
			}

			if (profileTemp != null || profileTemp.getPortfolio() != null) {
				Locale locale = new Locale.Builder().setLanguage("pl").setRegion("PL").build();
				Translation portfolio = serviceTranslation.findById(profileTemp.getPortfolio().getId());
				if (serviceTranslation.CheckingTextTranslation(portfolio, locale) == null) {
					serviceTranslation.newTranslationForObject(portfolio, "Piekny kwiat", "pl");
				}

				if (serviceTranslation.CheckingTextTranslation(portfolio, Locale.ENGLISH) == null) {
					serviceTranslation.newTranslationForObject(portfolio, "A beautiful flower", "en");
				}
			}
		}
	}

}