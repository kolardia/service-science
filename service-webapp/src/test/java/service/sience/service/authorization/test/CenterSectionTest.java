package service.sience.service.authorization.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.section.domain.Section;
import pl.service.science.section.domain.Center;
import pl.service.science.section.service.SectionService;
import pl.service.science.section.service.CenterService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class CenterSectionTest {

	@Autowired
	protected CenterService serviceCenter;

	@Autowired
	protected SectionService serviceSection;

	@Test
	public void setCenterTest() {

		Center sectionCenter = new Center();

		Section centerTemp = new Section();
		Section subsectionTemp = new Section();
		centerTemp = serviceSection.findById(new Long(403));
		subsectionTemp = serviceSection.findById(new Long(418));
		
		serviceCenter.checkSectionAssociatedWithCenter(centerTemp, subsectionTemp);

		Assert.assertEquals(serviceCenter.checkSectionAssociatedWithCenter(centerTemp, subsectionTemp).getId(), serviceCenter.findById(new Long(431)).getId());
		Assert.assertNotNull(serviceSection.findById(new Long(403)));
		Assert.assertNotNull(serviceSection.findById(new Long(418)));
		Assert.assertNotNull(serviceCenter.findBySectionCenter(serviceSection.findById(new Long(403))));
		
	}

}
