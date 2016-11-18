package pl.service.science.publication.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.service.science.publication.dao.DaoPublicationCategory;
import pl.service.science.publication.domain.PublicationCategory;
import pl.service.science.publication.service.ServicePublicationCategory;


@Service
public class ServicePublicationCategoryImpl implements ServicePublicationCategory{
	
	@Autowired
	protected  DaoPublicationCategory dao;

	 public PublicationCategory findById(Long id){
		 return dao.findById(id); 
	 };
	 
	 public List<PublicationCategory> findAll(){
		 return dao.findAll();
	 };
	 public PublicationCategory  save(PublicationCategory category){
		 return dao.save(category);
	 };
}
