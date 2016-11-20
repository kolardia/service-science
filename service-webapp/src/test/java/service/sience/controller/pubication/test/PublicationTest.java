package service.sience.controller.pubication.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.service.science.publication.dao.DaoPublication;
import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.service.ServicePublication;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class PublicationTest { 
	@Autowired 
	ServicePublication servicePublication;
	
	@Autowired
	DaoPublication dao;
	
	@Test
	public void testCRUD() throws Exception {
		testInsert();
		testUpdate();
		testFindAll();
		findById();
		deleteRecordTest();
	}
    
	
    public void testInsert() {
    	
    	Publication temp = new Publication();

		for(int i=0; i<10; i++){
			
		   	temp.setId(Long.valueOf(i));
	    	temp.setTitle("test insert " + i);
	    	temp.setContents("test insert contents: record: " + i);
	    	servicePublication.save(temp);
	    	assertNotNull(temp);
			
		}
    }
	
	
    public void testUpdate() {
    	
    	Publication temp = new Publication();

		for(int i=0; i<10; i++){
			
		   	temp.setId(Long.valueOf(i));
	    	temp.setTitle("test update " + i);
	    	temp.setContents("test update contents: record: " + i);
	    	servicePublication.save(temp);
	    
	    	assertEquals(temp.getTitle(), "test update " + i);
			
		} 
    }
	
	 
	    public void testFindAll() {
		   List<Publication> publicationTemp = servicePublication.findAll();
	     	   assertNotNull(publicationTemp.toString());
	    }

	   
	    public void findById() {
	    	Random generator = new Random();
	    	Publication publicationTemp = new Publication();
	    	
	        publicationTemp = servicePublication.findById(Long.valueOf(generator.nextInt(9)));
	        assertNotNull(publicationTemp);

	    }
	    
	
	    public void deleteRecordTest() {
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
