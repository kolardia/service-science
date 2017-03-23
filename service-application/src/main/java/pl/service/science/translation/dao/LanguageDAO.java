package pl.service.science.translation.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.service.science.translation.domain.Language;

@Repository
public interface LanguageDAO extends CrudRepository<Language, Long> {

	public Language findById(Long id);

	public List<Language> findAll();

	public Language findByCode(String code);
}
