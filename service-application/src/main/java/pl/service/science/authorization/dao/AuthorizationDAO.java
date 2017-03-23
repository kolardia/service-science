package pl.service.science.authorization.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.authorization.domain.Authorization;

@Repository
public interface AuthorizationDAO extends CrudRepository<Authorization, Long>{
	
	public Authorization findById(Long id);

}
