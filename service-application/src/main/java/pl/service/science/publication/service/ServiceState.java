package pl.service.science.publication.service;

import pl.service.science.publication.domain.State;

public interface ServiceState {
	
	public State checkOrSaveByLeadingLanguage(String name, String languageCode);

}
