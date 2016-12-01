package pl.service.science.localization.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.localization.domain.City;
import pl.service.science.translation.domain.Translation;

@Repository
public interface DaoCity extends CrudRepository<City, Long> {

	public City findById(Long id);

	public List<City> findAll();

	public City findByCity(Translation translation);

}