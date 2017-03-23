package pl.service.science.authorization.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.service.science.authorization.domain.User;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {

	public User findById(Long id);

	public User findByEmail(String email);

	public List<User> findAll();
}
