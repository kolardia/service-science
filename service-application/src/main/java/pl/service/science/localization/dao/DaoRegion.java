package pl.service.science.localization.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.localization.domain.City;
import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.translation.domain.Translation;

@Repository
public interface DaoRegion extends CrudRepository<Region, Long> {

	public Region findById(Long id);

	public List<Region> findAll();

	public Region findByRegion(Translation translation);

	public Region findByCity(City city);

	public List <Region> findByCountry(Country country);

}