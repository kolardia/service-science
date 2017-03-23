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
	
	public Center findById(Long id){
		return dao.findById(id);
	}
	
	public Center findBySubsection(Section section){
		return dao.findBySubsection(section);
	}
	
	public Center findBySectionCenterAndSubsection(Section center, Section subsection){
		return dao.findBySectionCenterAndSubsection(center, subsection);
	}
	
	public List<Center> findBySectionCenter(Section section){
		return dao.findBySectionCenter(section);
	}
	
	public void save(Center center){
		dao.save(center);
	}

}
