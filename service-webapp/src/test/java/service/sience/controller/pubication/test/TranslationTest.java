package service.sience.controller.pubication.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.service.ServicePublication;

import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class TranslationTest {
	
	@Autowired 
	ServicePublication publication;
	
	   @Test
	   public void setTranslation() {
		   
		Publication temp = new Publication();
        	temp.setId(Long.valueOf(666));
        	temp.setTitle("devil");
        	temp.setContents("cos ce jest");
        	publication.save(temp);
        	
        	String str1 = temp.getTitle();
        	assertNotNull(str1);
   
        	
	    }
}
