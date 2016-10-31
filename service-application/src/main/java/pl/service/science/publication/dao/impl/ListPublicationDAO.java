package pl.service.science.publication.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import pl.service.science.publication.dao.PublicationDAO;
import pl.service.science.publication.domain.Publication;

@Repository
public class ListPublicationDAO implements PublicationDAO {
	
	List<Publication> publications = new ArrayList<Publication>();
	

	public void addPublication(Publication publication) {
		publications.add(publication);
		
	}

	public List<Publication> getPublications() {
		return publications;
		
	}

	
}
