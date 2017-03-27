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

import pl.service.science.localization.domain.Region;
import pl.service.science.localization.service.RegionService;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationService;
import pl.service.science.translation.service.TranslationTextService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class RegionTest {
	
	@Autowired
	protected RegionService serviceRegion;

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
		 
		 for (Region region: serviceRegion.findAll()){
			 
			 serviceRegion.deleteRegionWhithParts(region);
		 }
		 
	   }
	
	@Test
	public void newRegion() {

		serviceRegion.fineOrSaveRegion("Wielkopolskie", "PL");
		serviceRegion.fineOrSaveRegion("Mazowieckie", "PL");
		serviceRegion.fineOrSaveRegion("Lubelskie", "PL");
	}

	@Test
	public void maxRegion() {

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {

				Region region = new Region();
				Translation translation = new Translation();

				region = serviceRegion.fineOrSaveRegion(String.valueOf("wojewódźtwo" + i), "PL");
				translation = serviceTranslation.findById(region.getRegion().getId());

				if (serviceTranslation.findTextTranslation(String.valueOf("Gebiet" + i), "DE") == null) {
					serviceTranslation.newTranslationForObject(translation, String.valueOf("Gebiet" + i), "DE");
				}

				if (serviceTranslation.findTextTranslation(String.valueOf("region" + i), "EN") == null) {
					serviceTranslation.newTranslationForObject(translation, String.valueOf("region" + i), "EN");
				}

				if (serviceTranslation.findTextTranslation(String.valueOf("領域" + i), "JP") == null) {
					serviceTranslation.newTranslationForObject(translation, String.valueOf("領域" + i), "JP");
				}
			}
			Assert.assertEquals(String.valueOf("Gebiet" + j), serviceTextTranslation
					.findByTextAndLanguage(String.valueOf("Gebiet" + j), serviceLanguage.adaptCode("DE")).getText());
		
		}
	}

}
