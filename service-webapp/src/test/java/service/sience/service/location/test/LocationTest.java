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
import pl.service.science.localization.service.ServiceCity;
import pl.service.science.localization.service.ServiceCountry;
import pl.service.science.localization.service.ServiceLocation;
import pl.service.science.localization.service.ServiceRegion;
import pl.service.science.translation.service.ServiceLanguage;
import pl.service.science.translation.service.ServiceTextTranslation;
import pl.service.science.translation.service.ServiceTranslation;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class LocationTest {

	@Autowired
	protected ServiceLanguage serviceLanguage;

	@Autowired
	protected ServiceTranslation serviceTranslation;

	@Autowired
	protected ServiceTextTranslation serviceTextTranslation;

	@Autowired
	protected ServiceCountry serviceCountry;

	@Autowired
	protected ServiceRegion serviceRegion;

	@Autowired
	protected ServiceCity serviceCity;

	@Autowired
	protected ServiceLocation serviceLocation;

	@Test
	public void location() {

		Location location = new Location();
		location.setCity(null);
		location.setRegon(serviceLocation.findOrSaveRegion("PL", "Wielkopolske", "Polska"));
		location.setPostalAddress("os. Sobieskiego 78/5");
		serviceLocation.save(location);
	}

	@Test
	public void saveLocation() {

		for (int index = 0; index < 3; index++) {

			Country country = new Country();
			country = serviceCountry.findOrSave("Polska", "PL");
			serviceCountry.save(country);

			Region region = new Region();
			region = serviceRegion.findOrSave("Wielkopolskie", "PL");
			region.setCountry(country);
			serviceRegion.save(region);

			Assert.assertEquals(country.getId(), serviceCountry.findByRegion(region).getId());
		}
	}

	@Test
	public void maxCountry() {

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				Country country = new Country();
				country = serviceCountry.findOrSave(String.valueOf("kraj" + i), "PL");
				country = serviceCountry.findOrSave(String.valueOf("country" + i), "EN");
				country = serviceCountry.findOrSave(String.valueOf("Land" + i), "DE");
				country = serviceCountry.findOrSave(String.valueOf("国" + i), "JP");
				serviceCountry.save(country);
			}
			Assert.assertEquals(String.valueOf("country" + j), serviceTextTranslation
					.findByTextAndLanguage(String.valueOf("country" + j), serviceLanguage.findByCode("EN")).getText());
		}
	}

	@Test
	public void maxRegion() {

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				Region region = new Region();
				region = serviceRegion.findOrSave(String.valueOf("wojewódźtwo" + i), "PL");
				region = serviceRegion.findOrSave(String.valueOf("region" + i), "EN");
				region = serviceRegion.findOrSave(String.valueOf("Gebiet" + i), "DE");
				region = serviceRegion.findOrSave(String.valueOf("領域" + i), "JP");
				serviceRegion.save(region);
			}
			Assert.assertEquals(String.valueOf("Gebiet" + j), serviceTextTranslation
					.findByTextAndLanguage(String.valueOf("Gebiet" + j), serviceLanguage.findByCode("DE")).getText());

		}
	}

	@Test
	public void maxCity() {

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				City city = new City();
				city = serviceCity.findOrSave(String.valueOf("miasto" + i), "PL");
				city = serviceCity.findOrSave(String.valueOf("city" + i), "EN");
				city = serviceCity.findOrSave(String.valueOf("Großstadt" + i), "DE");
				city = serviceCity.findOrSave(String.valueOf("シティ" + i), "JP");

				serviceCity.save(city);
			}
			Assert.assertEquals(String.valueOf("city" + j), serviceTextTranslation
					.findByTextAndLanguage(String.valueOf("city" + j), serviceLanguage.findByCode("EN")).getText());
		}
	}

	@Test
	public void locationPartCountry() {

		Country country1 = new Country();
		country1 = serviceCountry.findOrSave("Polska", "PL");
		serviceCountry.save(country1);

		Region region1 = new Region();
		region1 = serviceRegion.findOrSave("Opolskie", "PL");
		region1.setCountry(country1);
		serviceRegion.save(region1);

		Assert.assertEquals(country1.getId(), serviceCountry.findByRegion(region1).getId());

		Region region2 = new Region();
		region2 = serviceRegion.findOrSave("Wielkopolskie", "PL");
		region2.setCountry(country1);
		serviceRegion.save(region2);

		Assert.assertEquals(country1.getId(), serviceCountry.findByRegion(region2).getId());

		Region region3 = new Region();
		region3 = serviceRegion.findOrSave("Mazowieckie", "PL");
		region3.setCountry(country1);
		serviceRegion.save(region3);

		Assert.assertEquals(country1.getId(), serviceCountry.findByRegion(region3).getId());

	}
}
