package service.sience.service.location.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.localization.domain.Country;
import pl.service.science.localization.service.CountryService;
import pl.service.science.localization.service.RegionService;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationService;
import pl.service.science.translation.service.TranslationTextService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class CountryTest {

	@Autowired
	protected CountryService serviceCountry;

	@Autowired
	protected TranslationService serviceTranslation;

	/**
	 * Helper class for assert
	 */
	@Autowired
	protected LanguageService serviceLanguage;

	/**
	 * Helper class for assert
	 */
	@Autowired
	protected TranslationTextService serviceTextTranslation;

	@Autowired
	protected RegionService serviceRegion;

	@After
	public void cleanDatabase() {

		for (Country country : serviceCountry.findAll()) {

			serviceCountry.deleteWhithParts(country);
		}
	}

	@Test
	public void newCountry() {

		serviceCountry.fineOrSaveCountry("Polska", "PL");
		serviceCountry.fineOrSaveCountry("Niemcy", "PL");
		serviceCountry.fineOrSaveCountry("Japonia", "PL");
	}

	@Test
	public void maxCountry() {

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {

				Country country = new Country();
				Translation translation = new Translation();

				country = serviceCountry.fineOrSaveCountry(String.valueOf("kraj" + i), "PL");
				translation = serviceTranslation.findById(country.getCountry().getId());

				if (serviceTranslation.findTextTranslation(String.valueOf("country" + i), "EN") == null) {
					serviceTranslation.newTranslationForObject(translation, String.valueOf("country" + i), "EN");
				}

				if (serviceTranslation.findTextTranslation(String.valueOf("Land" + i), "DE") == null) {
					serviceTranslation.newTranslationForObject(translation, String.valueOf("Land" + i), "DE");
				}

				if (serviceTranslation.findTextTranslation(String.valueOf("国" + i), "JP") == null) {
					serviceTranslation.newTranslationForObject(translation, String.valueOf("国" + i), "JP");
				}
			}
			Assert.assertEquals(String.valueOf("country" + j), serviceTextTranslation
					.findByTextAndLanguage(String.valueOf("country" + j), serviceLanguage.adaptCode("EN")).getText());

		}
	}

}
