package pl.service.science.publication.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.service.science.publication.domain.State;

@Repository
public interface StateDAO extends CrudRepository<State, Long> {

	public State findById(Long id);

	public List<State> findAll();

}
