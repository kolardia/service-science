package pl.service.science.section.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.section.dao.DaoSection;
import pl.service.science.section.domain.Section;
import pl.service.science.section.service.ServiceSection;

@Service
public class ServiceSectionImpl implements ServiceSection {

	@Autowired
	DaoSection dao;

	public Section findById(Long id) {
		return dao.findById(id);
	}

	public void save(Section section) {
		dao.save(section);
	}

}
