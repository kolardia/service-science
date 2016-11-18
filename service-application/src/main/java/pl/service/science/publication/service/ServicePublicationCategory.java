package pl.service.science.publication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.publication.domain.PublicationCategory;

@Service
public interface ServicePublicationCategory {
	
	public PublicationCategory findById(Long id);
	public List<PublicationCategory> findAll();
	public PublicationCategory  save(PublicationCategory category);

}
