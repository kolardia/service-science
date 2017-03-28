package pl.service.science.authorization.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.authorization.domain.Authorization;
import pl.service.science.authorization.domain.Status;
import pl.service.science.authorization.domain.User;
import pl.service.science.section.domain.Section;

@Repository
public interface AuthorizationDAO extends CrudRepository<Authorization, Long>{
	
	public Authorization findById(Long id);

	public Authorization findByUserAndSectionAndAuthorization(User user, Section section, Status status);

}
