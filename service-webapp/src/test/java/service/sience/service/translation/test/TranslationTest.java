package service.sience.service.translation.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.ServiceTextTranslation;
import pl.service.science.translation.service.ServiceTranslation;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class TranslationTest {

	@Autowired
	ServiceTranslation service;

	@Autowired
	ServiceTextTranslation serviceText;

	@Test /* Insert, update, delete */
	public void testPlTranslation() {

		Translation plTranslation = new Translation();
		service.save(plTranslation);

		plTranslation = service.newText(plTranslation, "polski tekst", "PL");
		assertNotNull(serviceText.findByText("polski tekst"));

		service.updateText(plTranslation, "poprawiony- polski tekst", "PL");
		assertNotNull(serviceText.findByText("poprawiony- polski tekst"));

		service.deleteTranslationParts(plTranslation);
		assertNull(serviceText.findByText("polski tekst"));
		assertNull(serviceText.findByText("poprawiony- polski tekst"));
	}

	@Test /* Insert, update, delete */
	public void testEnTranslation() {

		Translation enTranslation = new Translation();
		service.save(enTranslation);

		enTranslation = service.newText(enTranslation, "english text", "EN");
		assertNotNull(serviceText.findByText("english text"));

		service.updateText(enTranslation, "corecttion- english text", "EN");
		assertNotNull(serviceText.findByText("corecttion- english text"));

		service.deleteTranslationParts(enTranslation);
		assertNull(serviceText.findByText("english text"));
		assertNull(serviceText.findByText("corecttion- english text"));
	}

	@Test /* Insert, update, delete */
	public void resumeTestTranslation() {

		Translation translation = new Translation();
		service.save(translation);

		translation = service.newText(translation, "english text", "EN");
		assertNotNull(serviceText.findByText("english text"));

		translation = service.newText(translation, "polski tekst", "PL");
		assertNotNull(serviceText.findByText("polski tekst"));

		service.updateText(translation, "poprawiony- polski tekst", "PL");
		assertNotNull(serviceText.findByText("poprawiony- polski tekst"));

		service.updateText(translation, "corecttion- english text", "EN");
		assertNotNull(serviceText.findByText("corecttion- english text"));

		service.deleteTranslationParts(translation);
		assertNull(service.findById(translation.getId()));
		assertNull(serviceText.findByText("polski tekst"));
		assertNull(serviceText.findByText("poprawiony- polski tekst"));
		assertNull(serviceText.findByText("english text"));
		assertNull(serviceText.findByText("corecttion- english text"));
	}
}
