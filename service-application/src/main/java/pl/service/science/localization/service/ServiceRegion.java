package pl.service.science.localization.service;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.Region;
import pl.service.science.translation.domain.Translation;

@Service
public interface ServiceRegion {

	public Region findById(Long id);

	public void save(Region region);

	public Translation insert(Translation translation);
	
	public void newText(Translation translation, String text, String languageCode);

}
