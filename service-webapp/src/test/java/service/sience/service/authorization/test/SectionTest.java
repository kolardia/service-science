package service.sience.service.authorization.test;

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
import pl.service.science.section.service.SectionService;
import pl.service.science.section.service.TypeService;
import pl.service.science.translation.domain.Language;
import pl.service.science.translation.domain.TextTranslation;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationTextService;
import pl.service.science.translation.service.TranslationService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class SectionTest {

	@Autowired
	protected SectionService serviceSection;

	@Autowired
	protected LocationService serviceSectionLocation;

	@Autowired
	protected TypeService serviceSectionType;

	@Autowired
	protected TranslationService serviceTranslation;
	
	@Autowired
	protected TranslationTextService serviceText;
	
	@Autowired
	protected LanguageService servicelanguage;
	
	@Autowired
	protected LocationService serviceLocation;
	
	@Autowired
	protected CityService serviceCity;
	
	@Autowired
	protected TypeService servicetype;
	
	@Test
	public void nullSection() {
		
		TextTranslation text = new TextTranslation();
		Location location = new Location();
		
		Language language = new Language();
		language = servicelanguage.adaptCode("PL");
		
		Section section = new Section();
		section	= serviceSection.ifExistfindByEmail("x@gmail.pl");
		
		if(section != null){
	
			section.setEmail("x@gmail.pl");
			section.setEnabled(true);
			servicetype.findAll();
			section.setType(servicetype.findById(new Long(509)));
			
			if(section.getLocation() == null){
				serviceLocation.save(location);
				section.setLocation(location);
				}
			serviceSection.save(section);
		
				location.setId(section.getLocation().getId());
				location.setPostalAddress("xadres 4/7");
				location.setRegon(serviceLocation.findOrSaveRegionForCountry("PL", "Wielkopolske", "Polska"));
				location.setCity(serviceCity.findOrSaveCity("Poznan", "PL"));
				serviceCity.addCityTranslation("Poznan", "PL", "Posen", "EN");
				serviceLocation.save(location);
			
			text = serviceText.checkingOrSetBlank(section.getSection(), language);
			text.setText("ROSMANN");
			serviceText.save(text);
			
			text = serviceText.checkingOrSetBlank(section.getDescription(), language);
			text.setText("marka kosmetykow");
			serviceText.save(text);
		}	
			
		
		Assert.assertNotNull(serviceSection.findById(section.getId()));

	}
	@Test
	public void saveOrUpdateSection() {
		
		TextTranslation text = new TextTranslation();
		Location location = new Location();
		
		Language language = new Language();
		language = servicelanguage.adaptCode("PL");
		
		Section section = new Section();
		section	= serviceSection.ifExistfindByEmail("lego@gmail.pl");
		
		if(section != null){
	
			section.setEmail("lego@gmail.pl");
			section.setEnabled(true);
			servicetype.findAll();
			section.setType(servicetype.findById(new Long(509)));
			
			if(section.getLocation() == null){
				serviceLocation.save(location);
				section.setLocation(location);
				}
			serviceSection.save(section);
		
				location.setId(section.getLocation().getId());
				location.setPostalAddress("krakowska 4/7");
				location.setRegon(serviceLocation.findOrSaveRegionForCountry("PL", "Wielkopolske", "Polska"));
				location.setCity(serviceCity.findOrSaveCity("Poznan", "PL"));
				serviceCity.addCityTranslation("Poznan", "PL", "Posen", "EN");
				serviceLocation.save(location);
			
			text = serviceText.checkingOrSetBlank(section.getSection(), language);
			text.setText("LEGO");
			serviceText.save(text);
			
			text = serviceText.checkingOrSetBlank(section.getDescription(), language);
			text.setText("marka zabawek");
			serviceText.save(text);
		}	
			
		
		Assert.assertNotNull(serviceSection.findById(section.getId()));

	}
}
