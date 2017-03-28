package pl.service.science.authorization.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.authorization.domain.Status;
import pl.service.science.translation.domain.Translation;

@Repository
public interface StatusDAO extends CrudRepository<Status, Long> {

	public Status findById(Long id);

	public Status findByAuthorizationStatus(Translation translation);

	public List<Status> findAll();

}
