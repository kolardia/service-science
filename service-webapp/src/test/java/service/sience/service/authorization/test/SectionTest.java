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
import pl.service.science.localization.service.ServiceLocation;
import pl.service.science.section.domain.Section;
import pl.service.science.section.domain.SectionType;
import pl.service.science.section.service.ServiceSection;
import pl.service.science.section.service.ServiceSectionType;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.ServiceTranslation;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class SectionTest {

	@Autowired
	ServiceSection serviceSection;

	@Autowired
	ServiceLocation serviceSectionLocation;

	@Autowired
	ServiceSectionType serviceSectionType;

	@Autowired

	ServiceTranslation serviceTranslation;

	@Test
	public void nullSection() {

		Section section = new Section();
		section.setEnabled(false);
		section.setSection(null);
		section.setType(null);
		section.setLocation(null);
		section.setDescription(null);

		serviceSection.save(section);

		Assert.assertNotNull(serviceSection.findById(section.getId()));

	}

	@Test
	public void saveSection() {

		Translation nameSection = new Translation();
		Translation nameDescription = new Translation();
		Translation nameType = new Translation();
		serviceTranslation.save(nameSection);
		serviceTranslation.save(nameDescription);
		serviceTranslation.save(nameType);

		SectionType type = new SectionType();
		type.setType(nameType);
		serviceSectionType.save(type);

		Location location = new Location();
//		location.setSectonCity(null);
		location.setPostalAddress("dupa na zadupiu");

		serviceSectionLocation.save(location);

		Section section = new Section();
		section.setEnabled(true);
		section.setSection(nameSection);
		section.setType(null);
		section.setLocation(location);
		section.setDescription(nameDescription);

		serviceSection.save(section);

		serviceTranslation.newText(nameSection, "Marka zabawek dla dzieci", "PL");
		serviceTranslation.newText(nameDescription, "LEGO", "PL");
		serviceTranslation.newText(nameType, "marka komercyjna", "PL");

		Assert.assertNotNull(serviceSection.findById(section.getId()));

	}

}
