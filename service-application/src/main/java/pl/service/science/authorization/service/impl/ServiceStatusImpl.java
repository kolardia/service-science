package pl.service.science.authorization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.authorization.dao.StatusDAO;
import pl.service.science.authorization.domain.Status;
import pl.service.science.authorization.service.StatusService;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.TranslationService;

@Service
public class ServiceStatusImpl implements StatusService {
	
	@Autowired
	protected StatusDAO dao;
	
	@Autowired 
	protected TranslationService serviceTranslation;
	
	public Status checkOrSaveStatusByLeadingLanguage(String name, String languageCode){
		

			Translation translation = new Translation();

			if (serviceTranslation.findTextTranslation(name, languageCode) == null) {
				serviceTranslation.save(translation);
				translation = serviceTranslation.newTranslationForObject(translation, name, languageCode);

			} else {
				translation = serviceTranslation.findTextTranslation(name, languageCode);
			}

			if (dao.findByAuthorizationStatus(translation) == null) {
				Status status = new Status();
				translation = serviceTranslation.save(translation);
				status.setAuthorizationStatus(serviceTranslation.findById(translation.getId()));
				dao.save(status);
				
			}
			return dao.findByAuthorizationStatus(translation);
	}
	
	public Status findById(Long id){
		return dao.findById(id);
	}
	
	public void save(Status status){
		dao.save(status);
	}
	
	public List<Status> findAll(){
		return dao.findAll();
	}
	
	public Status findByTranslation(Translation translation){
		return dao.findByAuthorizationStatus(translation);
	}
}
