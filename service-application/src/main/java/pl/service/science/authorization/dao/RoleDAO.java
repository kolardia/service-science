package pl.service.science.authorization.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.authorization.domain.Role;
import pl.service.science.authorization.domain.User;

@Repository
public interface RoleDAO extends CrudRepository<Role, Long> {
	
	public Role findById(Long id);
	
	public Role findByUserAndRola(User user, String role);
	
	public List <Role> findByUser(User user);

}
