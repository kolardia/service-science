package service.sience.service.authorization.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.section.domain.Type;
import pl.service.science.section.service.TypeService;
import pl.service.science.translation.domain.Language;
import pl.service.science.translation.domain.TextTranslation;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationTextService;
import pl.service.science.translation.service.TranslationService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class TypeTest {
	
	@Autowired
	protected TypeService servicetype;
	
	@Autowired
	protected TranslationService serviceTranslation;
	
	@Autowired
	protected TranslationTextService serviceText;
	
	@Autowired
	protected LanguageService servicelanguage;

	@Test
	public void setType(){
		
		TextTranslation text = new TextTranslation();
	
		Language language = new Language();
		language = servicelanguage.adaptCode("PL");
		
		Type type = new Type();
		type.setType(serviceTranslation.save(new Translation()));
		servicetype.save(type);
		
		text = serviceText.checkingOrSetBlank(type.getType(), language);
		text.setText("fundacja");
		serviceText.save(text);
		
	}
	
}
