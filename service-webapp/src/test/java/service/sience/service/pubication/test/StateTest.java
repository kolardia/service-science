package service.sience.service.pubication.test;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.publication.service.ServiceState;
import pl.service.science.translation.service.TranslationService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class StateTest {


	@Autowired
	public TranslationService serviceTranslation;

	
	@Autowired
	ServiceState serviceState;
	
	@Test
	public void state() {
		
		serviceState.checkOrSaveByLeadingLanguage("archiwa", "PL");
	}

}
