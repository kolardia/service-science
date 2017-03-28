package service.sience.service.authorization.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.authorization.dao.UserDAO;
import pl.service.science.authorization.domain.Role;
import pl.service.science.authorization.domain.User;
import pl.service.science.authorization.service.ServiceRole;
import pl.service.science.authorization.service.UserService;
import pl.service.science.localization.domain.Location;
import pl.service.science.localization.service.CityService;
import pl.service.science.localization.service.LocationService;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class UserTest {

	@Autowired
	protected UserService serviceUser;
	
	@Autowired
	protected ServiceRole serviceRole;
	
	@Autowired
	protected LocationService serviceLocation;
	
	@Autowired
	protected CityService serviceCity;
	
	/**
	 * Helper class for assert
	 */
	@Autowired
	private UserDAO userDao;


	@Test // this user does not exist --> new user
	public void newUser() {

		
		User user = new User();
		user = serviceUser.CheckingUser("m.senderecka@gmail.com");
		
		Boolean noUpdateTemp = true;

		Location location = new Location();
		// In the case of an update
		if (user.getAddressOfResidence() != null) {
			noUpdateTemp = false;
			location = serviceLocation.findById(user.getAddressOfResidence().getId());
			location.setRegon(serviceLocation.countryAssociatedWithRegion("PL", "Wielkopolske", "Polska"));
			location.setCity(serviceCity.findOrSaveCity("Poznań", "PL"));
			location.setPostalAddress("ul. Sloneczna 7");
			serviceLocation.save(location);
		}
		user.setName("Monika");
		user.setSurname("Senderecka");
		user.setPhone("608-987-934");
		user.setEmail("m.senderecka@gmail.com");
		user.setEnabled(true);
		user.setPassword("password");
		// Not required
		serviceLocation.save(location);
		user.setAddressOfResidence(serviceLocation.findById(location.getId()));
		serviceUser.save(user);
		if(serviceRole.findByUserAndRola(user, "USER") == null){
			Role role = new Role();
			role.setRola("USER");
			role.setUser(user);
			serviceRole.save(role);
			}

		// Introduction of a new one
		if (user.getAddressOfResidence()!= null || noUpdateTemp) {
			location = serviceLocation.findById(user.getAddressOfResidence().getId());
			location.setRegon(serviceLocation.countryAssociatedWithRegion("PL", "Wielkopolske", "Polska"));
			location.setCity(serviceCity.findOrSaveCity("Poznań", "PL"));
			location.setPostalAddress("ul. Sloneczna 7");
			serviceLocation.save(location);
		}
		
	
		Assert.assertNotNull(serviceUser.CheckingUser("m.senderecka@gmail.com"));
	}

	@Test // this user exists --> update user
	public void updateUser() {

		
		User user = new User();
		user = serviceUser.CheckingUser("m.senderecka@gmail.com");
		user.setEmail("kolardia@gmail.com");
		serviceUser.save(user);
		Assert.assertNotNull(userDao.findByEmail("kolardia@gmail.com"));
		Assert.assertNull(userDao.findByEmail("m.senderecka@gmail.com"));
		user.setEmail("m.senderecka@gmail.com");
		serviceUser.save(user);
		serviceUser.cleanAndDelete(serviceUser.findById(user.getId()));
		
	}
	
	@Test // this user does not exist --> new user
	public void adminUser() {

		
		User user = new User();
		user = serviceUser.CheckingUser("m.margaretka@gmail.com");
		
		user.setName("Alicja");
		user.setSurname("Margaretka");
		user.setEmail("m.margaretka@gmail.com");
		user.setEnabled(true);
		user.setPassword("password");

		serviceUser.save(user);

		if(serviceRole.findByUserAndRola(user, "ADMIN") == null){
		Role role = new Role();
		role.setRola("ADMIN");
		role.setUser(user);
		serviceRole.save(role);
		Assert.assertEquals(serviceRole.findById(role.getId()).getUser().getId(), userDao.findByEmail("m.margaretka@gmail.com").getId());
		}
		serviceUser.cleanAndDelete(serviceUser.findById(user.getId()));
		
		
	}
	
}
