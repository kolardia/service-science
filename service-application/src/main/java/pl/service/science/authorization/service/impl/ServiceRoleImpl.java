package pl.service.science.authorization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.authorization.dao.RoleDAO;
import pl.service.science.authorization.domain.Role;
import pl.service.science.authorization.domain.User;
import pl.service.science.authorization.service.ServiceRole;

@Service
public class ServiceRoleImpl implements ServiceRole {

	@Autowired
	public RoleDAO dao;

	public Role findById(Long id) {
		return dao.findById(id);
	}

	public Role findByUserAndRola(User user, String role) {
		return dao.findByUserAndRola(user, role);
	}

	public List<Role> findByUser(User user) {
		return dao.findByUser(user);
	}

	public void save(Role role){
		dao.save(role);
	}
}
