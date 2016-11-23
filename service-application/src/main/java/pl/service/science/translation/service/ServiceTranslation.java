package pl.service.science.translation.service;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.service.science.translation.domain.Translation;

@Service
public interface ServiceTranslation {

	public Translation findById(Long id);

	public List<Translation> findAll();

	public void save(Translation transaltion);

	public void delete(Translation translation);

}
