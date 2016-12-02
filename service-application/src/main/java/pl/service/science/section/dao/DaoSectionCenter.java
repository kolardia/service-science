package pl.service.science.section.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.section.domain.SectionCenter;

@Repository
public interface DaoSectionCenter extends CrudRepository<SectionCenter, Long> {
	
	public SectionCenter findById(Long id);

}
