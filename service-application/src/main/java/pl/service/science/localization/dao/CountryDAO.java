package pl.service.science.localization.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.translation.domain.Translation;

@Repository
public interface CountryDAO extends CrudRepository<Country, Long> {

	public Country findById(Long id);
	
	public Country findByCountry(Translation translation);
	
	public Country findByRegion(Region region);
	
	public List <Country> findAll();
}