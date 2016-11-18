package pl.service.science.publication.service;

import java.util.List;

import org.springframework.stereotype.Service;
import pl.service.science.publication.domain.Publication;

@Service
public interface ServicePublication {
	
	 public Publication findById(Long id);
	 public List<Publication> findAll();
	 public Publication  save(Publication contest);
	 public List<Publication>  searchLanguage(String language, List<Publication> listLanguage_en, List<Publication> listLanguage_pl);

}
