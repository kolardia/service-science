package pl.service.science.authorization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.authorization.dao.DaoUser;
import pl.service.science.authorization.service.ServiceUser;
import pl.service.science.localization.service.ServiceCity;
import pl.service.science.localization.service.ServiceCountry;
import pl.service.science.localization.service.ServiceRegion;
import pl.service.science.translation.service.ServiceTranslation;
import pl.service.science.user.domain.User;

@Service
public class ServiceUserImpl implements ServiceUser {

	@Autowired
	protected DaoUser dao;

	@Autowired
	protected ServiceTranslation serviceTranslation;

	@Autowired
	protected ServiceCountry serviceCountry;

	@Autowired
	protected ServiceRegion serviceRegion;

	@Autowired
	protected ServiceCity serviceCity;

	public User findById(Long id) {
		return dao.findById(id);
	}

	public void save(User user) {
		dao.save(user);
	}

	public User ifExistFindByEmail(String email) {
		if (dao.findByEmail(email) == null) {
			User user = new User();
			return user;
		}
		return dao.findByEmail(email);
	}

	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

	public void delete(User user) {
		dao.delete(user);
	}

}
