package pl.service.science.localization.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.service.science.localization.domain.Country;

@Repository
public interface DaoCountry extends CrudRepository<Country, Long>{
	

}