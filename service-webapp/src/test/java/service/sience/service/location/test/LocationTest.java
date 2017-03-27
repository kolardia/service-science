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

	@After
	public void cleanDatabase() {

		for (Country country : serviceCountry.findAll()) {

			serviceCountry.deleteWhithParts(country);
		}
		for (Region region : serviceRegion.findAll()) {

			serviceRegion.deleteRegionWhithParts(region);
		}
		for (City city : serviceCity.findAll()) {

			serviceCity.deleteCityWhithParts(city);
		}

	}

	@Test
	public void location() {

		Location location = new Location();
		location.setRegon(serviceLocation.countryAssociatedWithRegion("PL", "Wielkopolske", "Polska"));
		location.setCity(serviceCity.findOrSaveCity("Poznań", "PL"));
		location.setPostalAddress("Umultowska 87");
		location.setLatitude("52.466909");
		location.setLongitude("16.927859");
		serviceLocation.save(location);

		Assert.assertNotNull(serviceLocation.findById(location.getId()));
		Assert.assertNotNull(serviceLocation.findById(location.getId()).getRegon());
		Assert.assertNotNull(serviceLocation.findById(location.getId()).getCity());
		serviceLocation.cleanAndDelete(location);
	}

	@Test
	public void countryAssociatedWithRegion() {

		serviceLocation.countryAssociatedWithRegion("PL", "Opolskie", "Polska");

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
