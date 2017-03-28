package service.sience.service.authorization.test;

import java.util.Locale;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.localization.domain.Location;
import pl.service.science.localization.service.CityService;
import pl.service.science.localization.service.LocationService;
import pl.service.science.section.domain.Section;
import pl.service.science.section.domain.Type;
import pl.service.science.section.service.SectionService;
import pl.service.science.section.service.TypeService;
import pl.service.science.translation.service.TranslationService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class SectionTest {

	@Autowired
	protected SectionService serviceSection;

	@Autowired
	protected TranslationService serviceTranslation;

	@Autowired
	protected LocationService serviceLocation;

	@Autowired
	protected TypeService serviceType;

	@Autowired
	protected CityService serviceCity;

	@Test
	public void type() {
		
		Type typeTemp = new Type();
		typeTemp = serviceType.checkOrSaveByLeadingLanguage("Fundacja", "PL");
		if (serviceTranslation.CheckingTextTranslation(typeTemp.getType(), Locale.ENGLISH) == null) {
			serviceTranslation.newTranslationForObject(typeTemp.getType(), "Foundation", "en");
		}
		typeTemp = serviceType.checkOrSaveByLeadingLanguage("Instytut", "PL");
		if (serviceTranslation.CheckingTextTranslation(typeTemp.getType(), Locale.ENGLISH) == null) {
			serviceTranslation.newTranslationForObject(typeTemp.getType(), "Institute", "en");
		}
		typeTemp = serviceType.checkOrSaveByLeadingLanguage("Marka", "PL");
		if (serviceTranslation.CheckingTextTranslation(typeTemp.getType(), Locale.ENGLISH) == null) {
			serviceTranslation.newTranslationForObject(typeTemp.getType(), "Mark", "en");
		}
		typeTemp = serviceType.checkOrSaveByLeadingLanguage("Firma", "PL");
		if (serviceTranslation.CheckingTextTranslation(typeTemp.getType(), Locale.ENGLISH) == null) {
			serviceTranslation.newTranslationForObject(typeTemp.getType(), "Business", "en");
		}
	}

	@Test
	public void simpleSection() {

		Location location = new Location();
		location.setRegon(serviceLocation.countryAssociatedWithRegion("PL", "Wielkopolske", "Polska"));
		location.setCity(serviceCity.findOrSaveCity("Poznań", "PL"));
		location.setPostalAddress("Umultowska 87");
		location.setLatitude("52.466909");
		location.setLongitude("16.927859");
		serviceLocation.save(location);
		Type typeTemp = serviceType.checkOrSaveByLeadingLanguage("Instytut", "PL");
		Section section = new Section();
		section = serviceSection.checkingOrSetBlank("wmi@uam.com");
		section.setEmail("wmi@uam.com");
		section.setPhone("887-098-543");
		section.setEnabled(true);
		section.setType(serviceType.findById(typeTemp.getId()));
		section.setLocation(serviceLocation.findById(location.getId()));
		serviceSection.save(section);

		Assert.assertNotNull(serviceSection.findById(section.getId()));
		Assert.assertNotNull(serviceSection.findById(section.getId()).getType());
		Assert.assertNotNull(serviceSection.findById(section.getId()).getDescription());
		Assert.assertNotNull(serviceSection.findById(section.getId()).getLocation());
		Assert.assertEquals(serviceSection.findById(section.getId()).getEmail(), "wmi@uam.com");
		Assert.assertEquals(serviceSection.findById(section.getId()).getPhone(), "887-098-543");

		Assert.assertNotNull(serviceLocation.findById(location.getId()));
		Assert.assertNotNull(serviceLocation.findById(location.getId()).getCity());
		Assert.assertNotNull(serviceLocation.findById(location.getId()).getRegon());
		Assert.assertEquals(serviceLocation.findById(location.getId()).getLongitude(), "16.927859");
		Assert.assertEquals(serviceLocation.findById(location.getId()).getPostalAddress(), "Umultowska 87");

	
		   serviceSection.cleanAndDelete(section);
		 
		   Assert.assertNull(serviceLocation.findById(location.getId()));
		   Assert.assertNull(serviceSection.findById(section.getId()));
		 

	}

	@Test
	public void section() {

		Boolean noUpdateTemp = true;
		Section section = new Section();
		section = serviceSection.checkingOrSetBlank("wmi@uam.com");

		Location location = new Location();
		// In the case of an update
		if (section.getLocation() != null) {
			noUpdateTemp = false;
			location = serviceLocation.findById(section.getLocation().getId());
			location.setRegon(serviceLocation.countryAssociatedWithRegion("PL", "Wielkopolske", "Polska"));
			location.setCity(serviceCity.findOrSaveCity("Poznań", "PL"));
			location.setPostalAddress("Umultowska 87");
			location.setLatitude("52.466909");
			location.setLongitude("16.927859");
			serviceLocation.save(location);
		}

		section.setEmail("wmi@uam.com");
		section.setPhone("887-098-543");
		section.setEnabled(true);
		// Not required
		serviceLocation.save(location);
		section.setLocation(serviceLocation.findById(location.getId()));
		serviceSection.save(section);

		// Introduction of a new one
		if (section.getLocation() != null || noUpdateTemp) {
			location = serviceLocation.findById(section.getLocation().getId());
			location.setRegon(serviceLocation.countryAssociatedWithRegion("PL", "Wielkopolske", "Polska"));
			location.setCity(serviceCity.findOrSaveCity("Poznań", "PL"));
			location.setPostalAddress("Umultowska 87");
			location.setLatitude("52.466909");
			location.setLongitude("16.927859");
			serviceLocation.save(location);
		}

		if (serviceTranslation.CheckingTextTranslation(section.section, Locale.ENGLISH) == null) {
			serviceTranslation.newTranslationForObject(section.section, "Faculty of Mathematics and Computer Science",
					"EN");
		}
		serviceTranslation.updateTranslationForObject(section.section, "Faculty of Mathematics and Computer Science",
				"EN");

		Locale locale = new Locale.Builder().setLanguage("pl").setRegion("PL").build();
		if (serviceTranslation.CheckingTextTranslation(section.section, locale) == null) {
			serviceTranslation.newTranslationForObject(section.section, "Wydział Matematyki I Informatyki", "PL");
		}
		serviceTranslation.updateTranslationForObject(section.section, "Wydział Matematyki I Informatyki", "PL");

		Assert.assertNotNull(serviceSection.findById(section.getId()));
		Assert.assertNotNull(serviceSection.findById(section.getId()).getDescription());
		Assert.assertNotNull(serviceSection.findById(section.getId()).getLocation());
		Assert.assertEquals(serviceSection.findById(section.getId()).getEmail(), "wmi@uam.com");
		Assert.assertEquals(serviceSection.findById(section.getId()).getPhone(), "887-098-543");

		Assert.assertNotNull(serviceLocation.findById(location.getId()));
		Assert.assertNotNull(serviceLocation.findById(location.getId()).getCity());
		Assert.assertNotNull(serviceLocation.findById(location.getId()).getRegon());
		Assert.assertEquals(serviceLocation.findById(location.getId()).getLongitude(), "16.927859");
		Assert.assertEquals(serviceLocation.findById(location.getId()).getPostalAddress(), "Umultowska 87");

		serviceSection.cleanAndDelete(section);

		Assert.assertNull(serviceLocation.findById(location.getId()));
		Assert.assertNull(serviceSection.findById(section.getId()));

	}

}
