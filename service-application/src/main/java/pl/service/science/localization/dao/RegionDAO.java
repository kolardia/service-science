package pl.service.science.localization.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.translation.domain.Translation;

@Repository
public interface RegionDAO extends CrudRepository<Region, Long> {

	public Region findById(Long id);

	public List<Region> findAll();

	public Region findByRegion(Translation translation);

	public List <Region> findByCountry(Country country);

}