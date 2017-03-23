package pl.service.science.localization.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.localization.domain.Location;

@Repository
public interface LocationDAO extends CrudRepository<Location, Long> {

	public Location findById(Long id);

}
