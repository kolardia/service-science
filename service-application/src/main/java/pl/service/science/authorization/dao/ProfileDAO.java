package pl.service.science.authorization.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.authorization.domain.Profile;
import pl.service.science.translation.domain.Translation;

@Repository
public interface ProfileDAO extends CrudRepository<Profile, Long> {

	public Profile findById(Long id);
	
	public Profile findByPortfolio(Translation translation);
	

}
