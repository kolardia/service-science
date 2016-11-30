package pl.service.science.localization.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.service.science.localization.domain.Country;

@Repository
public interface DaoCountry extends CrudRepository<Country, Long> {

	public Country findById(Long id);
	
	public List <Country> findAll();
}