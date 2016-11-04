package pl.service.science.publication.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.service.science.publication.dao.PublicationDAO;
import pl.service.science.publication.domain.Publication;

@Repository
public class ListPublicationDAO implements PublicationDAO {
	
	List<Publication> publications = new ArrayList<Publication>();

    @PersistenceContext
    EntityManager entityManager;

    @Transactional 
    public void xxxx() {
    	
    	Publication publication = new Publication();
    	//uzupełniamy dane kota
    	publication = entityManager.merge(publication);
    		
        // jakieś operacje z EntityManagerem ...

 
    }


	public void addPublication(Publication publication) {
		publications.add(publication);
		
	}

	public List<Publication> getPublications() {
		return publications;
		
	}

	
}
