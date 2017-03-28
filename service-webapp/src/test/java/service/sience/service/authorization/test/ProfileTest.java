package service.sience.service.authorization.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import pl.service.science.authorization.domain.Profile;
import pl.service.science.authorization.service.ProfileService;
import pl.service.science.translation.domain.Language;
import pl.service.science.translation.domain.TextTranslation;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationTextService;
import pl.service.science.translation.service.TranslationService;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class ProfileTest {

	@Autowired
	protected ProfileService serviceProfile;

	@Autowired
	protected TranslationService serviceTranslation;

	@Autowired
	protected TranslationTextService serviceText;

	@Autowired
	protected LanguageService servicelanguage;

	@Test
	public void setProfile() throws Exception {

		Profile profile = new Profile();
		TextTranslation text = new TextTranslation();
		Language language = servicelanguage.adaptCode("pl");

		profile.setPortfolio(serviceTranslation.save(new Translation()));
		serviceProfile.save(profile);

		text = serviceText.checkingOrSetBlank(profile.getPortfolio(), language);
		text.setText(
				"s qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet");
		serviceText.save(text);
	}
}
