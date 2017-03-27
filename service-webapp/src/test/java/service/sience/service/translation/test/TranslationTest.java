package service.sience.service.translation.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.translation.dao.LanguageDAO;
import pl.service.science.translation.dao.TranslationDAO;
import pl.service.science.translation.dao.TranslationTextDAO;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationTextService;
import pl.service.science.translation.service.TranslationService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class TranslationTest {

	/**
	 * Testing service
	 */
	@Autowired
	protected TranslationService service;

	/**
	 * Testing service
	 */
	@Autowired
	protected TranslationTextService serviceText;

	/**
	 * Auxiliary class to be associated with the testing class.
	 */
	@Autowired
	protected LanguageService serviceLanguage;

	/**
	 * Helper class of DTO for cleaning database
	 */
	@Autowired
	 private LanguageDAO language;
	 
	/**
	 * Helper class of DTO for cleaning database
	 */
	@Autowired
	 private TranslationDAO translation;
	
	/**
	 * Helper class of DTO for cleaning database
	 */
	@Autowired
	 private TranslationTextDAO text;
	
	 @After public void cleanDatabase() {
			
			text.deleteAll();
			language.deleteAll();
			translation.deleteAll();
	   }
	 
	@Test
	public void oneLanguageOfTranslation() {

		Translation Translation = new Translation();
		service.save(Translation);

		Translation = service.newTranslationForObject(Translation, "polski tekst", "PL");
		assertNotNull(serviceText.findByText("polski tekst"));

		service.updateTranslationForObject(Translation, "poprawiony- polski tekst", "PL");
		assertNotNull(serviceText.findByText("poprawiony- polski tekst"));

		assertNull(serviceText.findByText("polski tekst"));
		assertNotNull(serviceText.findByText("poprawiony- polski tekst"));
	}

	@Test
	public void resumeTestTranslation() {

		Translation translation = new Translation();
		service.save(translation);

		translation = service.newTranslationForObject(translation, "english text", "EN");
		assertNotNull(serviceText.findByText("english text"));

		translation = service.newTranslationForObject(translation, "polski tekst", "PL");
		assertNotNull(serviceText.findByText("polski tekst"));

		service.updateTranslationForObject(translation, "poprawiony- polski tekst", "PL");
		assertNull(serviceText.findByText("polski tekst"));
		assertNotNull(serviceText.findByText("poprawiony- polski tekst"));

		service.updateTranslationForObject(translation, "corecttion- english text", "EN");
		assertNull(serviceText.findByText("english text"));
		assertNotNull(serviceText.findByText("corecttion- english text"));

		service.removeTranslationWithTexts(translation);
		assertNull(service.findById(translation.getId()));
		assertNull(serviceText.findByText("polski tekst"));
		assertNull(serviceText.findByText("poprawiony- polski tekst"));
		assertNull(serviceText.findByText("english text"));
		assertNull(serviceText.findByText("corecttion- english text"));
	}

}