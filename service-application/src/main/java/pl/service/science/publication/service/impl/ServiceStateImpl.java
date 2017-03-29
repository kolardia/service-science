package pl.service.science.publication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.publication.dao.StateDAO;
import pl.service.science.publication.domain.State;
import pl.service.science.publication.service.ServiceState;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.TranslationService;

@Service
public class ServiceStateImpl implements ServiceState {

	@Autowired
	public TranslationService serviceTranslation;

	@Autowired
	public StateDAO dao;

	public State checkOrSaveByLeadingLanguage(String name, String languageCode) {

		Translation translation = new Translation();

		if (serviceTranslation.findTextTranslation(name, languageCode) == null) {
			serviceTranslation.save(translation);
			translation = serviceTranslation.newTranslationForObject(translation, name, languageCode);

		} else {
			translation = serviceTranslation.findTextTranslation(name, languageCode);
		}

		if (dao.findByStatusName(translation) == null) {
			State state = new State();
			state.setStatusName(serviceTranslation.findById(translation.getId()));
			dao.save(state);
		}

		return dao.findByStatusName(translation);
	}

}
