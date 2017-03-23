package service.sience.service.translation.test;

import org.junit.After;
import org.junit.Assert;
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
import pl.service.science.translation.domain.TextTranslation;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationService;
import pl.service.science.translation.service.TranslationTextService;

/**
 * @author kolardia
 * Testing LanguageService
 *
 */
@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class LanguageTest {

	/**
	 * Testing service
	 */
	@Autowired
	protected LanguageService serviceLanguage;

	/**
	 * Helper class of services for testing
	 */
	@Autowired
	protected TranslationTextService serviceTextTranslation;

	/**
	 * Helper class of services for testing
	 */
	@Autowired
	protected TranslationService serviceTranslation;

	/**
	 * Helper class of DTO for asserting and cleaning database
	 */
	@Autowired
	 private LanguageDAO language;
	 
	/**
	 * Helper class of DTO for asserting and cleaning database
	 */
	@Autowired
	 private TranslationDAO translation;
	
	/**
	 * Helper class of DTO for asserting and cleaning database
	 */
	@Autowired
	 private TranslationTextDAO text;
	
	 @After public void cleanDatabase() {
			
		text.deleteAll();
		language.deleteAll();
		translation.deleteAll();
        
  }
	
	@Test
	public void adaptCodeLanguage() {

		serviceLanguage.adaptCode("PL");
		serviceLanguage.adaptCode("EN");
		serviceLanguage.adaptCode("JP");
		serviceLanguage.adaptCode("DE");
		
		Assert.assertNotNull(language.findAll());
	}

	@Test
	public void removeLanguage() {

		for (int i = 0; i < 10; i++) {

			TextTranslation text = new TextTranslation();
			text.setLanguage(serviceLanguage.adaptCode("TEST"));
			text.setTranslation(serviceTranslation.save(new Translation()));
			text.setText("Test" + i);
			serviceTextTranslation.save(text);

			Assert.assertNotNull(serviceTextTranslation.findByTextAndLanguage(text.getText(), text.getLanguage()));

		}

		serviceLanguage.removeLanguageAlongWithTexts(serviceLanguage.adaptCode("TEST"));
		Assert.assertNull(language.findByCode("TEST"));
	}

}