package service.sience.service.location.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

	/**
	 * Geographical coordinates
	 * 
	 * Poznań 52.399N 16.900E
	 * kalisz 51.770N 18.100E
	 * toruń 53.020N 18.609E
	 * 
	 * lat
	 * 	 *  Testing servic
	 */
	@Autowired
	protected LocationService serviceLocation;
	@Autowired
	protected RegionService serviceRegion;
	@Autowired
	protected CountryService serviceCountry;
	@Autowired
	protected CityService serviceCity;


	
	@Autowired
	protected LanguageService serviceLanguage;
	@Autowired
	protected TranslationService serviceTranslation;
	@Autowired
	protected TranslationTextService serviceTextTranslation;

	/**
	 * Helper class of DTO for cleaning database
	 */

	@Test
	public void location() {

		Location location = new Location();
		location.setRegon(serviceLocation.countryAssociatedWithRegion("PL", "Wielkopolske", "Polska"));
		location.setPostalAddress("os. Sobieskiego 78/5");
		serviceLocation.save(location);
	}

	@Test
	public void saveLocation() {

		for (int index = 0; index < 3; index++) {

	

			Region region = new Region();
			region = serviceRegion.fineOrSaveRegion("Wielkopolskie", "PL");
			serviceRegion.save(region);
			
			Country country = new Country();
			country = serviceCountry.fineOrSaveCountry("Polska", "PL");
			country.setRegion(region);
			serviceCountry.save(country);

			Assert.assertEquals(country.getId(), serviceCountry.findByRegion(region).getId());
		}
	}


	@Test
	public void locationPartCountry() {

		Region region1 = new Region();
		region1 = serviceRegion.fineOrSaveRegion("Opolskie", "PL");
		serviceRegion.save(region1);
		
		Country country1 = new Country();
		country1 = serviceCountry.fineOrSaveCountry("Polska", "PL");
		country1.setRegion(region1);
		serviceCountry.save(country1);

		Assert.assertEquals(country1.getId(), serviceCountry.findByRegion(region1).getId());

	}
}
