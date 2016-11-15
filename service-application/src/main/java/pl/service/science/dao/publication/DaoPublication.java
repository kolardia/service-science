package pl.service.science.dao.publication;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.publication.domain.Publication;


@Repository
public interface DaoPublication extends CrudRepository<Publication, Long>{
	
	 public Publication findById(int id);
	 public List<Publication> findAll();
	
	 
	 
}