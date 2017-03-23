package service.sience.service.location.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.localization.domain.City;
import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Location;
import pl.service.science.localization.domain.Region;
import pl.service.science.localization.service.CityService;
import pl.service.science.localization.service.CountryService;
import pl.service.science.localization.service.LocationService;
import pl.service.science.localization.service.RegionService;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationTextService;
import pl.service.science.translation.service.TranslationService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class LocationTest {

	@Autowired
	protected LanguageService serviceLanguage;

	@Autowired
	protected TranslationService serviceTranslation;

	@Autowired
	protected TranslationTextService serviceTextTranslation;

	@Autowired
	protected CountryService serviceCountry;

	@Autowired
	protected RegionService serviceRegion;

	@Autowired
	protected CityService serviceCity;

	@Autowired
	protected LocationService serviceLocation;

	@Test
	public void location() {

		Location location = new Location();
		location.setRegon(serviceLocation.findOrSaveRegionForCountry("PL", "Wielkopolske", "Polska"));
		location.setPostalAddress("os. Sobieskiego 78/5");
		serviceLocation.save(location);
	}

	@Test
	public void saveLocation() {

		for (int index = 0; index < 3; index++) {

			Country country = new Country();
			country = serviceCountry.fineOrSaveCountry("Polska", "PL");
			serviceCountry.save(country);

			Region region = new Region();
			region = serviceRegion.fineOrSaveRegion("Wielkopolskie", "PL");
			region.setCountry(country);
			serviceRegion.save(region);

			Assert.assertEquals(country.getId(), serviceCountry.findByRegion(region).getId());
		}
	}

	@Test
	public void maxCountry() {

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
			
				serviceCountry.fineOrSaveCountry(String.valueOf("kraj" + i), "PL");
				serviceCountry.fineOrSaveCountry(String.valueOf("country" + i), "EN");
				serviceCountry.fineOrSaveCountry(String.valueOf("Land" + i), "DE");
				serviceCountry.fineOrSaveCountry(String.valueOf("国" + i), "JP");
			
			}
			Assert.assertEquals(String.valueOf("country" + j), serviceTextTranslation
					.findByTextAndLanguage(String.valueOf("country" + j), serviceLanguage.adaptCode("EN")).getText());
		}
	}

	@Test
	public void maxRegion() {

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
			
				serviceRegion.fineOrSaveRegion(String.valueOf("wojewódźtwo" + i), "PL");
				serviceRegion.fineOrSaveRegion(String.valueOf("region" + i), "EN");
				serviceRegion.fineOrSaveRegion(String.valueOf("Gebiet" + i), "DE");
				serviceRegion.fineOrSaveRegion(String.valueOf("領域" + i), "JP");
				
			}
			Assert.assertEquals(String.valueOf("Gebiet" + j), serviceTextTranslation
					.findByTextAndLanguage(String.valueOf("Gebiet" + j), serviceLanguage.adaptCode("DE")).getText());

		}
	}

	@Test
	public void maxCity() {

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
		
				serviceCity.findOrSaveCity(String.valueOf("miasto" + i), "PL");
				serviceCity.findOrSaveCity(String.valueOf("city" + i), "EN");
				serviceCity.findOrSaveCity(String.valueOf("Großstadt" + i), "DE");
				serviceCity.findOrSaveCity(String.valueOf("シティ" + i), "JP");
 
			}
			Assert.assertEquals(String.valueOf("city" + j), serviceTextTranslation
					.findByTextAndLanguage(String.valueOf("city" + j), serviceLanguage.adaptCode("EN")).getText());
		}
	}

	@Test
	public void locationPartCountry() {

		Country country1 = new Country();
		country1 = serviceCountry.fineOrSaveCountry("Polska", "PL");
		serviceCountry.save(country1);

		Region region1 = new Region();
		region1 = serviceRegion.fineOrSaveRegion("Opolskie", "PL");
		region1.setCountry(country1);
		serviceRegion.save(region1);

		Assert.assertEquals(country1.getId(), serviceCountry.findByRegion(region1).getId());

		Region region2 = new Region();
		region2 = serviceRegion.fineOrSaveRegion("Wielkopolskie", "PL");
		region2.setCountry(country1);
		serviceRegion.save(region2);

		Assert.assertEquals(country1.getId(), serviceCountry.findByRegion(region2).getId());

		Region region3 = new Region();
		region3 = serviceRegion.fineOrSaveRegion("Mazowieckie", "PL");
		region3.setCountry(country1);
		serviceRegion.save(region3);

		Assert.assertEquals(country1.getId(), serviceCountry.findByRegion(region3).getId());

	}
}
