package pl.service.science.publication.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.service.science.publication.domain.Publication;


@Repository
public interface DaoPublication extends CrudRepository<Publication, Long>{
	
	 public Publication findById(Long id);
	 public List<Publication> findAll();
}