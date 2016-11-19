package pl.service.science.translation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.translation.domain.Translation;

@Repository
public interface DaoTranslation extends CrudRepository <Translation, Long> {
	
 public Translation findById(Long id);
	
}
