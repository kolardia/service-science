package pl.service.science.translation.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.localization.domain.City;
import pl.service.science.translation.domain.TextTranslation;
import pl.service.science.translation.domain.Translation;

@Repository
public interface TranslationDAO extends CrudRepository<Translation, Long> {

	public Translation findById(Long id);

	public Translation findByCityTranslation(City city);

	public List<Translation> findAll();

	public Translation findByTextTranslation(TextTranslation text);
}
