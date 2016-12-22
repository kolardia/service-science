package pl.service.science.publication.service;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.service.science.publication.domain.Publication;
import pl.service.science.translation.domain.Translation;

@Service
public interface ServicePublication {

	public Publication findById(Long id);

	public List<Publication> findAll();

	public Publication save(Publication contest);

	public List<Publication> searchLanguage(String language, List<Publication> listLanguage_en,
			List<Publication> listLanguage_pl);

	public void delete(Long id);

	public void saveText(Translation translation, String text, String code);

	Translation insert(Translation translation);

	public void deleteAllPublicationParts(Publication poublication);
}
