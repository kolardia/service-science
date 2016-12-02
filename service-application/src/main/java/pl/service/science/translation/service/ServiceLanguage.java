package pl.service.science.translation.service;

import org.springframework.stereotype.Service;

import pl.service.science.translation.domain.Language;

@Service
public interface ServiceLanguage {

	public Language findById(Long id);

	public Language findByCode(String code);

	public void save(Language language);
}
