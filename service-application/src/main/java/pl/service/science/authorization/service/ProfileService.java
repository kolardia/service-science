package pl.service.science.authorization.service;

import org.springframework.stereotype.Service;

import pl.service.science.authorization.domain.Profile;
import pl.service.science.translation.domain.Translation;

@Service
public interface ProfileService {

	public Profile findById(Long id);

	public Profile findByPortfolio(Translation translation);

	public void save(Profile profile);

}
