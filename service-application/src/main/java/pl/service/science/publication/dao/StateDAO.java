package pl.service.science.publication.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.service.science.publication.domain.State;
import pl.service.science.translation.domain.Translation;

@Repository
public interface StateDAO extends CrudRepository<State, Long> {

	public State findById(Long id);

	public List<State> findAll();
	
	public State findByStatusName(Translation translation);

}
