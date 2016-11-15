package pl.service.science.publication.dao;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.publication.domain.Publication;

@Repository
public interface Interfejs extends CrudRepository<Publication, Long>{
	
	List<Publication> publications = new ArrayList<Publication>();
	
	 public Publication findById(int id);
	 public List<Publication> findAll();

}
