package pl.service.science.model;

import java.util.List;

import pl.service.science.publication.domain.Publication;

public interface Introduce {
	
	public List<Publication> searchLanguage(String ParameterLanguage, List<Publication> list_en, List<Publication> list_pl);
}
