package service.sience.presentation.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.service.science.localization.dao.DaoCity;
import pl.service.science.localization.dao.DaoRegion;
import pl.service.science.localization.domain.City;
import pl.service.science.localization.domain.Region;
import pl.service.science.publication.service.ServicePublication;
import pl.service.science.publication.service.ServicePublicationCategory;
import pl.service.science.translation.dao.DaoLanguage;
import pl.service.science.translation.dao.DaoTranslationText;
import pl.service.science.translation.domain.Language;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.domain.TranslationText;
import pl.service.science.translation.service.ServiceTranslation;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class DataBaseSimpleOperationTest {

	@Autowired
	ServicePublication servicePublication;

	@Autowired
	ServicePublicationCategory servicePublicationCategory;

	@Autowired
	ServiceTranslation serviceTranslation;

	@Autowired
	DaoCity serviceCity;

	@Autowired
	DaoRegion serviceRegion;

	@Autowired
	DaoTranslationText serviceTranslationText;

	@Autowired
	DaoLanguage serviceLanguage;

	@Test
	public void testCity() {

		Language codeLanguage = new Language();
		codeLanguage.setCode("PL");
		serviceLanguage.save(codeLanguage);

		Translation idRegionTranslation = new Translation();
		serviceTranslation.save(idRegionTranslation);

		TranslationText translationRegionText = new TranslationText();
		translationRegionText.setLanguage(codeLanguage);
		translationRegionText.setTranslation(idRegionTranslation);
		translationRegionText.setText("Wielkopolska");
		serviceTranslationText.save(translationRegionText);

		Region tempRegion = new Region();
		tempRegion.setRegionTranslation(idRegionTranslation);
		serviceRegion.save(tempRegion);

		Translation idCityTranslation = new Translation();
		serviceTranslation.save(idCityTranslation);

		TranslationText translationCityText = new TranslationText();
		translationCityText.setLanguage(codeLanguage);
		translationCityText.setTranslation(idCityTranslation);
		translationCityText.setText("Poznan");
		serviceTranslationText.save(translationCityText);

		City tempCity = new City();
		tempCity.setCityTranslation(idCityTranslation);
		tempCity.setRegion(tempRegion);
		serviceCity.save(tempCity);

	}

	/*
	 * @Test public void testTranslation() {
	 * 
	 * Translation tempTranslation = new Translation();
	 * 
	 * for(int i=0; i<10; i++){
	 * 
	 * tempTranslation.setId(new Long(i)); tempTranslation.setPolish("record" +
	 * i + ": polish"); tempTranslation.setEnglish("record" + i + ": english");
	 * serviceTranslation.save(tempTranslation);
	 * assertNotNull(serviceTranslation.findById(new Long(i)));
	 * 
	 * }
	 * 
	 * List<Translation> translations = serviceTranslation.findAll();
	 * assertNotNull(translations.toString());
	 * 
	 * }
	 * 
	 * @Test public void testPublicationCategory() {
	 * 
	 * PublicationCategory tempPublicationCategory = new PublicationCategory();
	 * 
	 * for(int i=0; i<10; i++){
	 * 
	 * tempPublicationCategory.setId(Long.valueOf(i));
	 * tempPublicationCategory.setName("test insert catregoty: " + i);
	 * servicePublicationCategory.save(tempPublicationCategory);
	 * assertNotNull(servicePublicationCategory.findById(new Long(i)));
	 * 
	 * }
	 * 
	 * List<PublicationCategory> tempPublicationCategories =
	 * servicePublicationCategory.findAll();
	 * assertNotNull(tempPublicationCategories.toString()); }
	 * 
	 * @Test public void testPublication() {
	 * 
	 * Publication tempPublication = new Publication();
	 * 
	 * for(int i=0; i<10; i++){
	 * 
	 * PublicationCategory tempCategory = new PublicationCategory();
	 * 
	 * tempCategory = servicePublicationCategory.findById(new Long(i));
	 * 
	 * tempPublication.setId(Long.valueOf(i));
	 * tempPublication.setTitle("test insert publication: " + i);
	 * tempPublication.setContents("test insert contents: record: " + i);
	 * tempPublication.setCategory(tempCategory);
	 * servicePublication.save(tempPublication);
	 * assertNotNull(servicePublication.findById(new Long(i)));
	 * 
	 * }
	 * 
	 * List<Publication> tempPublications = servicePublication.findAll();
	 * assertNotNull(tempPublications.toString()); }
	 */

}
