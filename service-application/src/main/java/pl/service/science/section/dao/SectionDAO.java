package pl.service.science.section.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.section.domain.Section;

@Repository
public interface SectionDAO extends CrudRepository<Section, Long> {

	public Section findById(Long id);
	public Section findByEmail(String email);
}
