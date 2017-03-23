package pl.service.science.authorization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.authorization.dao.UserDAO;
import pl.service.science.authorization.domain.User;
import pl.service.science.authorization.service.UserService;
import pl.service.science.localization.service.CityService;
import pl.service.science.localization.service.CountryService;
import pl.service.science.localization.service.RegionService;
import pl.service.science.translation.service.TranslationService;

@Service
public class ServiceUserImpl implements UserService {

	@Autowired
	protected UserDAO dao;

	@Autowired
	protected TranslationService serviceTranslation;

	@Autowired
	protected CountryService serviceCountry;

	@Autowired
	protected RegionService serviceRegion;

	@Autowired
	protected CityService serviceCity;

	public User findById(Long id) {
		return dao.findById(id);
	}
	
	public List<User> findAll(){
		return dao.findAll();
	}

	public void save(User user) {
		dao.save(user);
	}
	
	public User CheckingUser(String email) {
		if (dao.findByEmail(email) == null) {
			User user = new User();
			return user;
		}
		return dao.findByEmail(email);
	}

	public void delete(User user) {
		dao.delete(user);
	}

}
