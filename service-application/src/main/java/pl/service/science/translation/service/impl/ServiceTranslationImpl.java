package pl.service.science.translation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.translation.dao.DaoTranslation;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.ServiceTranslation;

@Service
public class ServiceTranslationImpl implements ServiceTranslation{
	
	@Autowired
	DaoTranslation dao;
	
	public Translation findById(Long id){
		return dao.findById(id);
	}
	
	public List<Translation> findAll(){
		return dao.findAll();
	}
	
	public void save(Translation transaltion){
		dao.save(transaltion);
	}
	
	public void delete(Translation translation){
		dao.delete(translation);
	}

}
