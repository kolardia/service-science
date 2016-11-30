package pl.service.science.translation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.translation.domain.Language;
import pl.service.science.translation.domain.TextTranslation;
import pl.service.science.translation.domain.Translation;

@Service
public interface ServiceTextTranslation {

	public TextTranslation findById(Long id);

	public TextTranslation findByTranslationAndLanguage(Translation translation, Language language);

	public TextTranslation findByText(String text);

	public void save(TextTranslation text);

	public List<TextTranslation> findByTranslation(Translation translation);

	public void delete(List<TextTranslation> text);

	public void delete(TextTranslation text);
}
