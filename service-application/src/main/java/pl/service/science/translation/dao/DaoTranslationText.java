package pl.service.science.translation.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.service.science.translation.domain.TranslationText;

@Repository
public interface DaoTranslationText extends CrudRepository<TranslationText, Long> {

	public TranslationText findById(Long id);

	public List<TranslationText> findAll();

}
