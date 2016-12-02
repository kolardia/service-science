package pl.service.science.section.service;

import org.springframework.stereotype.Service;

import pl.service.science.section.domain.SectionType;

@Service
public interface ServiceSectionType {

	public SectionType findById(Long id);

	public void save(SectionType type);
}
