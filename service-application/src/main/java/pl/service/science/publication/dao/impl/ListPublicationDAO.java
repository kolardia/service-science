package pl.service.science.publication.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.service.science.publication.domain.Publication;
import pl.service.science.translation.domain.Translation;

@Repository
public class ListPublicationDAO  {
	
	List<Publication> publications = new ArrayList<Publication>();
	
    @PersistenceContext
    EntityManager e;


    @Transactional 
	public void addPublication(Publication publication) {
    	e.merge(publication);
		
	}
    
	@SuppressWarnings("unchecked")
	public List<Publication> getPublications_en(String select) {
		Query query = e.createQuery(select);
		return query.getResultList();
		
	}
   
	@SuppressWarnings("unchecked")
	public List<Publication> getPublications_pl(String select) {
		Query query = e.createQuery(select);
		return query.getResultList();
		
	}
	
	public Publication getPublication(int id){
		Publication publication = new Publication();
		publication = e.find(Publication.class, id);
		return publication;
	} 
	@Transactional 
	public Translation getTranslation(int id){
		Translation translation = new Translation();
		translation = e.find(Translation.class, id);
		return translation;
	} 
		}
	
