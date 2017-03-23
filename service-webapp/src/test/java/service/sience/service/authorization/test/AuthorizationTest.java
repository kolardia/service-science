package service.sience.service.authorization.test;

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
import pl.service.science.authorization.domain.User;
import pl.service.science.authorization.service.ProfileService;
import pl.service.science.authorization.service.UserService;
import pl.service.science.section.domain.Section;
import pl.service.science.section.service.SectionService;
import pl.service.science.translation.domain.Language;
import pl.service.science.translation.domain.TextTranslation;
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
	protected ProfileService serviceProfile;

	@Autowired
	protected TranslationService serviceTranslation;

	@Autowired
	protected TranslationTextService serviceText;

	@Autowired
	protected LanguageService servicelanguage;

	@Autowired
	protected SectionService serviceSection;

	@Autowired
	protected UserService serviceUser;

	@Test
	public void newAuto() {

		Language language = new Language();
		language = servicelanguage.adaptCode("PL");

		TextTranslation text = new TextTranslation();

		Authorization auto = new Authorization();
		User user = new User();
		Section section = new Section();
		user = serviceUser.CheckingUser("m.senderecka@gmail.com");
		section = serviceSection.findById(new Long(403));
		auto.setSection(section);
		auto.setUser(user);
		auto.setEnabled(true);
		Profile profile = new Profile();
		if (auto.getProfileAuthorization() == null) {

			profile.setPortfolio(serviceTranslation.save(new Translation()));
			serviceProfile.save(profile);
			auto.setProfileAuthorization(profile);
		}
		dao.save(auto);

		text = serviceText.checkingOrSetBlank(profile.getPortfolio(), language);
		text.setText("dgs hhshc dhghf xd");
		serviceText.save(text);
	}

	@Test
	public void newStatus() {
	}
}