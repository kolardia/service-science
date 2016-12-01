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
import pl.service.science.localization.domain.Region;
import pl.service.science.localization.service.ServiceCity;
import pl.service.science.localization.service.ServiceCountry;
import pl.service.science.localization.service.ServiceRegion;
import pl.service.science.translation.service.ServiceTranslation;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class LocationTest {

	@Autowired
	protected ServiceTranslation serviceTranslation;

	@Autowired
	protected ServiceCountry serviceCountry;

	@Autowired
	protected ServiceRegion serviceRegion;

	@Autowired
	protected ServiceCity serviceCity;

	@Test
	public void location() {

		Country country = new Country();
		country = serviceCountry.findOrSave("Polska", "PL");

		Region region = new Region();
		region = serviceRegion.findOrSave("Wielkopolska", "PL");
		region.setCountry(country);
		serviceRegion.save(region);

		City city = new City();
		city = serviceCity.findOrSave("Poznań", "PL");
		city.setCityRegion(region);
		serviceCity.save(city);

		Assert.assertEquals(serviceRegion.findById(region.getId()).getId(),
				serviceRegion.findByCountry(country).getId());

		Assert.assertEquals(serviceRegion.findById(region.getId()).getId(), serviceRegion.findByCity(city).getId());

		Assert.assertEquals(serviceRegion.findByRegion(serviceTranslation.findText("Wielkopolska", "PL")).getId(),
				serviceRegion.findByCity(city).getId());

	}
}
