package pl.service.science.section.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.section.domain.Section;
import pl.service.science.section.domain.Center;

@Service
public interface CenterService {
	
public Center findById(Long id);
	
	public Center findBySubsection(Section section);
	
	public Center findBySectionCenterAndSubsection(Section center, Section subsection);
	
	public List<Center> findBySectionCenter(Section section);
	
	public void save(Center center);

}
