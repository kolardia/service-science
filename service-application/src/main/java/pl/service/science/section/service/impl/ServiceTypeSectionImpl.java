package pl.service.science.section.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.section.dao.TypeDAO;
import pl.service.science.section.domain.Type;
import pl.service.science.section.service.TypeService;
import pl.service.science.translation.domain.Translation;

@Service
public class ServiceTypeSectionImpl implements TypeService {

	@Autowired
	TypeDAO dao;

	public Type findById(Long id) {
		return dao.findById(id);
	}

	public void save(Type type) {
		dao.save(type);
	}
	
	public Type findByType(Translation type){
		return dao.findByType(type);
	};
	
	public List<Type> findAll(){
		return dao.findAll();
	};
}
