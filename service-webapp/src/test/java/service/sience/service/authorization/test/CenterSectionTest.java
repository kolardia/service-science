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
import pl.service.science.section.domain.Center;
import pl.service.science.section.service.SectionService;
import pl.service.science.section.service.TypeService;
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
	protected TypeService serviceType;
	
	@Before
	public void section(){
		
		Type typeTemp = serviceType.checkOrSaveByLeadingLanguage("Instytut", "PL");
		Section section = new Section();
		section = serviceSection.checkingOrSetBlank("wmi@uam.com");
		section.setEmail("wmi@uam.com");
		section.setPhone("887-098-543");
		section.setEnabled(true);
		section.setType(serviceType.findById(typeTemp.getId()));
		serviceSection.save(section);
		
		typeTemp = serviceType.checkOrSaveByLeadingLanguage("Instytut", "PL");
		Section sectionOrder = new Section();
		sectionOrder = serviceSection.checkingOrSetBlank("wb@uam.com");
		sectionOrder.setEmail("wb@uam.com");
		sectionOrder.setPhone("807-098-543");
		sectionOrder.setEnabled(true);
		sectionOrder.setType(serviceType.findById(typeTemp.getId()));
		serviceSection.save(section);
		
		typeTemp = serviceType.checkOrSaveByLeadingLanguage("Instytut", "PL");
		Section sectionCenter = new Section();
		sectionCenter = serviceSection.checkingOrSetBlank("uam@uam.com");
		sectionCenter.setEmail("uam@uam.com");
		sectionCenter.setPhone("618294000");
		sectionCenter.setEnabled(true);
		sectionCenter.setType(serviceType.findById(typeTemp.getId()));
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
