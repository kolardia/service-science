package pl.service.science.localization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.localization.dao.DaoCity;
import pl.service.science.localization.domain.City;
import pl.service.science.localization.service.ServiceCity;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.ServiceTranslation;

@Service
public class ServiceCityImpl implements ServiceCity {
	
	@Autowired
	protected DaoCity dao;
	
	@Autowired
	protected ServiceTranslation serviceTranslation;
	
	public City findById(Long id){
		return dao.findById(id);
	}
	
	public Translation insert(Translation translation){
		serviceTranslation.save(translation);
		
		return translation;
	}
	
	public void save(City city){
		dao.save(city);
	}
	
	public void newText(Translation translation, String text, String languageCode){
		serviceTranslation.newText(translation, text, languageCode);
	}
}
