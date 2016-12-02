package pl.service.science.section.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.section.domain.SectionType;

@Repository
public interface DaoSectionType extends CrudRepository<SectionType, Long>{
	
	public SectionType findById(Long id);

}
