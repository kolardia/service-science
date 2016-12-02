package pl.service.science.section.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.section.dao.DaoSectionType;
import pl.service.science.section.domain.SectionType;
import pl.service.science.section.service.ServiceSectionType;

@Service
public class ServiceTypeSectionImpl implements ServiceSectionType {

	@Autowired
	DaoSectionType dao;

	public SectionType findById(Long id) {
		return dao.findById(id);
	}

	public void save(SectionType type) {
		dao.save(type);
	}
}
