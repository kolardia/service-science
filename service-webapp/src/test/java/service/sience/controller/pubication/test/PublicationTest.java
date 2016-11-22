package service.sience.controller.pubication.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.service.science.publication.dao.DaoPublication;
import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.service.ServicePublication;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Random;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Test;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class PublicationTest { 
	@Autowired 
	ServicePublication servicePublication;
	
	@Autowired
	DaoPublication dao;
    
	@Test
    public void testInsertPublication() {
    	
    	Publication temp = new Publication();

		for(int i=0; i<10; i++){
			
		   	temp.setId(Long.valueOf(i));
	    	servicePublication.save(temp);
	    	assertNotNull(temp);
			
		}
    }
	
	 	@Test
		public void testUpdatePublication() {
    	
    	Publication temp = new Publication();

		for(int i=0; i<10; i++){
			
		   	temp.setId(Long.valueOf(i));
	    	servicePublication.save(temp);
			
		} 
    }
	
	 	@Test
	    public void testFindAllPublications() {
		   List<Publication> publicationTemp = servicePublication.findAll();
	     	   assertNotNull(publicationTemp.toString());
	    }

	 	@Test
	    public void findByIdPublication() {
	    	Random generator = new Random();
	    	Publication publicationTemp = new Publication();
	    	
	        publicationTemp = servicePublication.findById(Long.valueOf(generator.nextInt(9)));
	        assertNotNull(publicationTemp);

	    }
	    
	 	@Test
	    public void deleteRecordTestPublication() {
	    	Publication publicationTemp = new Publication();
	    	
		    for(int i=0; i<10; i++){
		    	dao.delete(new Long(i));	
		    }
		    
		    for(int i=0; i<10; i++){
		    	publicationTemp =  servicePublication.findById(new Long(i));
		    	assertNull(publicationTemp);
		    }
		    
		    
	    }
}
