package pl.service.science.section.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.section.dao.CenterDAO;
import pl.service.science.section.domain.Section;
import pl.service.science.section.domain.Center;
import pl.service.science.section.service.CenterService;

@Service
public class ServiceSectionCenterImpl implements CenterService {
	
	@Autowired
	CenterDAO dao;
	
	public List<Center> findAll(){
		return dao.findAll();
	}
	
	public Center findById(Long id){
		return dao.findById(id);
	}
	
	public Center findBySubsection(Section section){
		return dao.findBySubsection(section);
	}
	
	public Center checkSectionAssociatedWithCenter(Section center, Section subsection){
		
		Center transaction = new Center();
		
		if (dao.findBySectionCenterAndSubsection(center, subsection) == null) {
			transaction.setSectionCenter(center);
			transaction.setSubsection(subsection);
			dao.save(transaction);
			
			return transaction;
		}
		
		return dao.findBySectionCenterAndSubsection(center, subsection);
	}
	
	public List<Center> findBySectionCenter(Section section){
		return dao.findBySectionCenter(section);
	}
	
	public void save(Center center){
		dao.save(center);
	}

}
