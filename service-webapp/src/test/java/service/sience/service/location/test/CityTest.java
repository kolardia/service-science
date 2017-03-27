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

import pl.service.science.localization.domain.City;
import pl.service.science.localization.service.CityService;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationService;
import pl.service.science.translation.service.TranslationTextService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class CityTest {

	@Autowired
	protected CityService serviceCity;

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
	
	 @After public void cleanDatabase() {
		 
		 for (City city: serviceCity.findAll()){
			 
			 serviceCity.deleteCityWhithParts(city);
		 }
		 
	   }
	
	@Test
	public void newCity() {

		serviceCity.findOrSaveCity("Poznań", "PL");
		serviceCity.findOrSaveCity("Warszawa", "PL");
		serviceCity.findOrSaveCity("Opole", "PL");
	}

	@Test
	public void maxCity() {

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {

				City city = new City();
				Translation translation = new Translation();

				city = serviceCity.findOrSaveCity(String.valueOf("miasto" + i), "PL");
				translation = serviceTranslation.findById(city.getCity().getId());

				if (serviceTranslation.findTextTranslation(String.valueOf("city" + i), "EN") == null) {
					serviceTranslation.newTranslationForObject(translation, String.valueOf("city" + i), "EN");
				}

				if (serviceTranslation.findTextTranslation(String.valueOf("Großstadt" + i), "DE") == null) {
					serviceTranslation.newTranslationForObject(translation, String.valueOf("Großstadt" + i), "DE");
				}

				if (serviceTranslation.findTextTranslation(String.valueOf("シティ" + i), "JP") == null) {
					serviceTranslation.newTranslationForObject(translation, String.valueOf("シティ" + i), "JP");
				}
			}
			Assert.assertEquals(String.valueOf("city" + j), serviceTextTranslation
					.findByTextAndLanguage(String.valueOf("city" + j), serviceLanguage.adaptCode("EN")).getText());
		
		}
	}

}
