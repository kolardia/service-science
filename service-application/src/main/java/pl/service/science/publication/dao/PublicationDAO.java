package pl.service.science.publication.dao;

import java.util.List;

import pl.service.science.publication.domain.Publication;

public interface PublicationDAO {
	
	public void addPublication(Publication publication);
	public List<Publication> getPublications();

}
