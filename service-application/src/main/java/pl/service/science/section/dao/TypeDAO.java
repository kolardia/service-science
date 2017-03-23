package pl.service.science.section.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.section.domain.Type;
import pl.service.science.translation.domain.Translation;

@Repository
public interface TypeDAO extends CrudRepository<Type, Long>{
	
	public Type findById(Long id);
	
	public Type findByType(Translation type);
	
	public List<Type> findAll();

}
