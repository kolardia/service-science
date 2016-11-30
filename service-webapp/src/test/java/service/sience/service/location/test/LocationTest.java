package service.sience.service.location.test;

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
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.ServiceTextTranslation;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class LocationTest {

	@Autowired
	protected ServiceCountry serviceCountry;

	@Autowired
	protected ServiceTextTranslation serviceText;

	@Autowired
	protected ServiceRegion serviceRegion;

	@Autowired
	protected ServiceCity serviceCity;

	@Test
	public void location() {

		Country country = new Country();
		country.setCountry(serviceCountry.insert(new Translation()));

		serviceCountry.save(country);

		serviceCountry.newText(country.getCountry(), "Polska", "PL");

		Region region = new Region();
		region.setCountry(country);
		region.setRegion(serviceRegion.insert(new Translation()));

		serviceRegion.save(region);

		serviceCountry.newText(region.getRegion(), "Wielkopolska", "PL");

		City city = new City();
		city.setCity(serviceCity.insert(new Translation()));
		city.setCityRegion(region);

		serviceCity.save(city);
		serviceCity.newText(city.getCity(), "Poznan", "PL");

	}

}
