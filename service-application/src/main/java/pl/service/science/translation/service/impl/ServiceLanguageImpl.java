package pl.service.science.translation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.translation.dao.DaoLanguage;
import pl.service.science.translation.domain.Language;
import pl.service.science.translation.service.ServiceLanguage;

@Service
public class ServiceLanguageImpl implements ServiceLanguage{

	@Autowired
	protected DaoLanguage dao;
	
	public Language findById(Long id){
		return dao.findById(id);
	}
	
	public Language findByCode(String code){
		return dao.findByCode(code);
	}
}
