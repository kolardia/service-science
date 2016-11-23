package pl.service.science.localization.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.service.science.localization.domain.Region;

@Repository
public interface DaoRegion extends CrudRepository<Region, Long> {

	public Region findById(Long id);

	public List<Region> findAll();

}