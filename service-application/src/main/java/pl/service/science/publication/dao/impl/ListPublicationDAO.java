package pl.service.science.publication.dao.impl;

import java.util.ArrayList;
import java.util.List;

import pl.service.science.publication.dao.PublicationDAO;
import pl.service.science.publication.domain.Publication;

public class ListPublicationDAO implements PublicationDAO {
	
	List<Publication> publications = new ArrayList<Publication>();
	

	public void getPublication(Publication publication) {
		publications.add(publication);
		
	}

	public List<Publication> addPublications() {
		return publications;
		
	}

	
}
