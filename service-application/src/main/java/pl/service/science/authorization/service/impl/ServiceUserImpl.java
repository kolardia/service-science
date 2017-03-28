package pl.service.science.authorization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.authorization.dao.RoleDAO;
import pl.service.science.authorization.dao.UserDAO;
import pl.service.science.authorization.domain.Role;
import pl.service.science.authorization.domain.User;
import pl.service.science.authorization.service.UserService;
import pl.service.science.localization.domain.Location;
import pl.service.science.localization.service.CityService;
import pl.service.science.localization.service.CountryService;
import pl.service.science.localization.service.LocationService;
import pl.service.science.localization.service.RegionService;
import pl.service.science.translation.service.TranslationService;

@Service
public class ServiceUserImpl implements UserService {

	@Autowired
	protected UserDAO dao;

	@Autowired
	protected RoleDAO roleDAO;

	@Autowired
	protected TranslationService serviceTranslation;

	@Autowired
	protected CountryService serviceCountry;

	@Autowired
	protected RegionService serviceRegion;

	@Autowired
	protected CityService serviceCity;

	@Autowired
	LocationService serviceLocation;

	public User findById(Long id) {
		return dao.findById(id);
	}

	public List<User> findAll() {
		return dao.findAll();
	}

	public void save(User user) {
		dao.save(user);
	}

	public User findByEmail(String email){
		return dao.findByEmail(email);
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

	public void cleanAndDelete(User user) {

		Location location = new Location();
		user = dao.findById(user.getId());
		
		
		for (Role role : roleDAO.findByUser(user)) {
			roleDAO.delete(role);
		}

		if (user.getAddressOfResidence() != null) {
			location = serviceLocation.findById(user.getAddressOfResidence().getId());
			user.setAddressOfResidence(null);
			dao.save(user);
		}
		dao.delete(user);
	
		serviceLocation.cleanAndDelete(location);

	}
}
