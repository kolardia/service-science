package pl.service.science.translation.service;

import org.springframework.stereotype.Service;

import pl.service.science.translation.domain.Language;

@Service
public interface ServiceLanguage {

	/**
	 * @param id
	 * @return
	 */
	public Language findById(Long id);

	/**
	 * @param code
	 * @return
	 */
	public Language findByCode(String code);

	/**
	 * @param language
	 */
	public void save(Language language);
}
