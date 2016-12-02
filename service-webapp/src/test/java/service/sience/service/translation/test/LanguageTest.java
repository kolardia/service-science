package service.sience.service.translation.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.translation.domain.Language;
import pl.service.science.translation.service.ServiceLanguage;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class LanguageTest {

	@Autowired
	protected ServiceLanguage serviceLanguage;

	@Test
	public void testLanguage() {

		Language languagePL = new Language();
		languagePL.setId(new Long(1));
		languagePL.setCode("PL");

		serviceLanguage.save(languagePL);

		Language languageEN = new Language();
		languageEN.setId(new Long(2));
		languageEN.setCode("EN");

		serviceLanguage.save(languageEN);

		Language languageDE = new Language();
		languageDE.setId(new Long(3));
		languageDE.setCode("DE");

		serviceLanguage.save(languageDE);

		Language languageJP = new Language();
		languageJP.setId(new Long(4));
		languageJP.setCode("JP");

		serviceLanguage.save(languageJP);

	}
}
