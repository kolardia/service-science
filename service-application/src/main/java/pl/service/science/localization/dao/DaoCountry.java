package pl.service.science.localization.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.service.science.localization.domain.Country;
import pl.service.science.translation.domain.Translation;

@Repository
public interface DaoCountry extends CrudRepository<Country, Long> {

	public Country findById(Long id);
	
	public Country findByCountry(Translation translation);
	
	public List <Country> findAll();
}