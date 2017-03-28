package service.sience.service.authorization.test;

import java.util.Locale;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.authorization.dao.AuthorizationDAO;
import pl.service.science.authorization.domain.Authorization;
import pl.service.science.authorization.domain.Profile;
import pl.service.science.authorization.domain.Role;
import pl.service.science.authorization.domain.Status;
import pl.service.science.authorization.domain.User;
import pl.service.science.authorization.service.ProfileService;
import pl.service.science.authorization.service.ServiceRole;
import pl.service.science.authorization.service.StatusService;
import pl.service.science.authorization.service.UserService;
import pl.service.science.section.domain.Section;
import pl.service.science.section.domain.Type;
import pl.service.science.section.service.SectionService;
import pl.service.science.section.service.TypeService;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationService;
import pl.service.science.translation.service.TranslationTextService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class AuthorizationTest {

	@Autowired
	AuthorizationDAO dao;

	@Autowired
	protected SectionService serviceSection;

	@Autowired
	protected TypeService serviceType;

	@Autowired
	protected UserService serviceUser;

	@Autowired
	protected ServiceRole serviceRole;

	@Autowired
	public TranslationService serviceTranslation;

	@Autowired
	public StatusService serviceStatus;

	@Autowired
	protected ProfileService serviceProfile;

	@Autowired
	protected TranslationTextService serviceText;

	@Autowired
	protected LanguageService servicelanguage;

	@Before
	public void Status() {

		Status statusTemp = new Status();
		statusTemp = serviceStatus.checkOrSaveStatusByLeadingLanguage("Uzytkownik", "PL");
		if (serviceTranslation.CheckingTextTranslation(statusTemp.getAuthorizationStatus(), Locale.ENGLISH) == null) {
			serviceTranslation.newTranslationForObject(statusTemp.getAuthorizationStatus(), "User", "en");
		}

		statusTemp = serviceStatus.checkOrSaveStatusByLeadingLanguage("Organizator", "PL");
		if (serviceTranslation.CheckingTextTranslation(statusTemp.getAuthorizationStatus(), Locale.ENGLISH) == null) {
			serviceTranslation.newTranslationForObject(statusTemp.getAuthorizationStatus(), "Organizer", "en");
		}

		statusTemp = serviceStatus.checkOrSaveStatusByLeadingLanguage("Redaktor", "PL");
		if (serviceTranslation.CheckingTextTranslation(statusTemp.getAuthorizationStatus(), Locale.ENGLISH) == null) {
			serviceTranslation.newTranslationForObject(statusTemp.getAuthorizationStatus(), "Editorial", "en");
		}

		statusTemp = serviceStatus.checkOrSaveStatusByLeadingLanguage("Partner", "PL");
		if (serviceTranslation.CheckingTextTranslation(statusTemp.getAuthorizationStatus(), Locale.ENGLISH) == null) {
			serviceTranslation.newTranslationForObject(statusTemp.getAuthorizationStatus(), "Partner", "en");
		}

		statusTemp = serviceStatus.checkOrSaveStatusByLeadingLanguage("Patron Medialny", "PL");
		if (serviceTranslation.CheckingTextTranslation(statusTemp.getAuthorizationStatus(), Locale.ENGLISH) == null) {
			serviceTranslation.newTranslationForObject(statusTemp.getAuthorizationStatus(), "Media patron", "en");
		}

		statusTemp = serviceStatus.checkOrSaveStatusByLeadingLanguage("Sponsor", "PL");
		if (serviceTranslation.CheckingTextTranslation(statusTemp.getAuthorizationStatus(), Locale.ENGLISH) == null) {
			serviceTranslation.newTranslationForObject(statusTemp.getAuthorizationStatus(), "Sponsor", "en");
		}

	}

	@Before
	public void section() {

		Type typeTemp = serviceType.checkOrSaveByLeadingLanguage("Instytut", "PL");
		Section section = new Section();
		section = serviceSection.checkingOrSetBlank("wmi@uam.com");
		section.setEmail("wmi@uam.com");
		section.setPhone("887-098-543");
		section.setEnabled(true);
		section.setType(serviceType.findById(typeTemp.getId()));
		serviceSection.save(section);

		User user = new User();
		user = serviceUser.CheckingUser("m.margaretka@gmail.com");
		user.setName("Alicja");
		user.setSurname("Margaretka");
		user.setEmail("m.margaretka@gmail.com");
		user.setEnabled(true);
		user.setPassword("password");

		serviceUser.save(user);

		if (serviceRole.findByUserAndRola(user, "ADMIN") == null) {
			Role role = new Role();
			role.setRola("ADMIN");
			role.setUser(user);
			serviceRole.save(role);
		}

	}

	@Test
	public void authorization() {

		Authorization authorization = new Authorization();

		if (serviceUser.findByEmail("m.margaretka@gmail.com") != null
				|| serviceSection.findByEmail("wmi@uam.com") != null) {
			
			User userTemp = serviceUser.CheckingUser("m.margaretka@gmail.com");
			Section sectionTemp = serviceSection.checkingOrSetBlank("wmi@uam.com");
			Status statusTemp = serviceStatus.checkOrSaveStatusByLeadingLanguage("Redaktor", "PL");
			
			if(dao.findByUserAndSectionAndAuthorization(userTemp, sectionTemp, statusTemp) != null){
				authorization = dao.findByUserAndSectionAndAuthorization(userTemp, sectionTemp, statusTemp);
			}

			Profile profileTemp = new Profile();
			
			authorization.setSection(sectionTemp);
			authorization.setUser(userTemp);
			authorization.setAuthorization(statusTemp);
			authorization.setEnabled(true);
			// Not required
			serviceProfile.save(profileTemp);
			authorization.setProfileAuthorization(profileTemp);
			dao.save(authorization);

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