package pl.service.science.authorization.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.user.domain.User;

@Repository
public interface DaoUser extends CrudRepository<User, Long> {

	public User findById(Long id);
	public User findByEmail(String email);

}
