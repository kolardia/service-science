package pl.service.science.translation.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.domain.Language;
import pl.service.science.translation.domain.TextTranslation;

@Repository
public interface DaoTranslationText extends CrudRepository<TextTranslation, Long> {

	public TextTranslation findById(Long id);

	public List<TextTranslation> findAll();

	public List<TextTranslation> findByTranslation(Translation translation);

	public TextTranslation findByTranslationAndLanguage(Translation translation, Language language);

	public TextTranslation findByText(String text);

	public TextTranslation findByTextAndLanguage(String text, Language language);
}
