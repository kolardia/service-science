package service.sience.service.authorization.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.section.domain.Section;
import pl.service.science.section.domain.Type;
import pl.service.science.localization.domain.Location;
import pl.service.science.localization.service.CityService;
import pl.service.science.localization.service.LocationService;
import pl.service.science.section.domain.Center;
import pl.service.science.section.service.SectionService;
import pl.service.science.section.service.TypeService;
import pl.service.science.translation.service.TranslationService;
import pl.service.science.section.service.CenterService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class CenterSectionTest {

	@Autowired
	protected CenterService serviceCenter;

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
	
	@Before
	public void section(){
		
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
		
		Location locationOrder = new Location();
		locationOrder.setRegon(serviceLocation.countryAssociatedWithRegion("PL", "Wielkopolske", "Polska"));
		locationOrder.setCity(serviceCity.findOrSaveCity("Poznań", "PL"));
		locationOrder.setPostalAddress("Umultowska 89");
		locationOrder.setLatitude("52.466999");
		locationOrder.setLongitude("16.927879");
		serviceLocation.save(location);
		typeTemp = serviceType.checkOrSaveByLeadingLanguage("Instytut", "PL");
		Section sectionOrder = new Section();
		sectionOrder = serviceSection.checkingOrSetBlank("wb@uam.com");
		sectionOrder.setEmail("wb@uam.com");
		sectionOrder.setPhone("807-098-543");
		sectionOrder.setEnabled(true);
		sectionOrder.setType(serviceType.findById(typeTemp.getId()));
		sectionOrder.setLocation(serviceLocation.findById(locationOrder.getId()));
		serviceSection.save(section);
		
		Location locationCenter = new Location();
		locationCenter.setRegon(serviceLocation.countryAssociatedWithRegion("PL", "Wielkopolske", "Polska"));
		locationCenter.setCity(serviceCity.findOrSaveCity("Poznań", "PL"));
		locationCenter.setPostalAddress("Wieniawskiego 1");
		locationCenter.setLatitude("52.46690");
		locationCenter.setLongitude("16.92785");
		serviceLocation.save(locationCenter);
		typeTemp = serviceType.checkOrSaveByLeadingLanguage("Instytut", "PL");
		Section sectionCenter = new Section();
		sectionCenter = serviceSection.checkingOrSetBlank("uam@uam.com");
		sectionCenter.setEmail("uam@uam.com");
		sectionCenter.setPhone("618294000");
		sectionCenter.setEnabled(true);
		sectionCenter.setType(serviceType.findById(typeTemp.getId()));
		sectionCenter.setLocation(serviceLocation.findById(locationCenter.getId()));
		serviceSection.save(sectionCenter);
	}

	@Test
	public void setCenterTest() {

		Section centerTemp = serviceSection.checkingOrSetBlank("uam@uam.com");;
		Section subsectionTemp = serviceSection.checkingOrSetBlank("wmi@uam.com");
		Assert.assertNotNull(serviceSection.findById(centerTemp.getId()));
		Assert.assertNotNull(serviceSection.findById(subsectionTemp.getId()));
		
		Center center = serviceCenter.checkSectionAssociatedWithCenter(centerTemp, subsectionTemp);
		Assert.assertEquals(serviceCenter.checkSectionAssociatedWithCenter(centerTemp, subsectionTemp).getId(), center.getId());
		
		centerTemp = serviceSection.checkingOrSetBlank("uam@uam.com");;
		subsectionTemp = serviceSection.checkingOrSetBlank("wb@uam.com");
		Assert.assertNotNull(serviceSection.findById(centerTemp.getId()));
		Assert.assertNotNull(serviceSection.findById(subsectionTemp.getId()));
		
		center = serviceCenter.checkSectionAssociatedWithCenter(centerTemp, subsectionTemp);
	}

}
