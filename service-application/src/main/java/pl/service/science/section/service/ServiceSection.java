package pl.service.science.section.service;

import org.springframework.stereotype.Service;

import pl.service.science.section.domain.Section;

@Service
public interface ServiceSection {

	public Section findById(Long id);

	public void save(Section section);
}
