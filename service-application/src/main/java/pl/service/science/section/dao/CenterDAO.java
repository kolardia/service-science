package pl.service.science.section.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.section.domain.Section;
import pl.service.science.section.domain.Center;

@Repository
public interface CenterDAO extends CrudRepository<Center, Long> {
	
	public Center findById(Long id);
	
	public Center findBySubsection(Section section);
	
	public Center findBySectionCenterAndSubsection(Section center, Section subsection);
	
	public List<Center> findBySectionCenter(Section section);
	
}
