package service.sience.service.authorization.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.authorization.domain.User;
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
	protected LocationService serviceLocation;
	
	@Autowired
	protected CityService serviceCity;


	@Test // this user does not exist --> new user
	public void newUser() {

		Location location = new Location();
		
		User user = new User();
		user = serviceUser.CheckingUser("m.senderecka@gmail.com");
		
		user.setName("Monika");
		user.setSurname("Senderecka");
		user.setPhone("608-987-934");
		user.setEmail("m.senderecka@gmail.com");
		user.setEnabled(true);
		user.setPassword("password");
		
		if(user.getAddressOfResidence() == null){
		serviceLocation.save(location);
		user.setAddressOfResidence(location);
		}
		serviceUser.save(user);
		
		location.setId(user.getAddressOfResidence().getId());
		location.setPostalAddress("Nowowiejskiego 6/7");
		location.setRegon(serviceLocation.findOrSaveRegionForCountry("PL", "Wielkopolske", "Polska"));
		location.setCity(serviceCity.findOrSaveCity("Poznan", "PL"));
		serviceCity.addCityTranslation("Poznan", "PL", "Posen", "EN");
		serviceLocation.save(location);
		
		
		Assert.assertNotNull(serviceUser.CheckingUser("m.senderecka@gmail.com"));
	}

	@Test // this user exists --> update user
	public void updateUser() {

		
		User user = new User();
		user = serviceUser.CheckingUser("m.senderecka@gmail.com");

		user.setName("Monika Senderecka");
		user.setEmail("kolardia@gmail.com");
		user.setEnabled(true);
		user.setPassword("password");
		user.setAddressOfResidence(null);
		
		serviceUser.save(user);
		Assert.assertNotNull(serviceUser.CheckingUser("kolardia@gmail.com"));
		Assert.assertNull(serviceUser.CheckingUser("m.senderecka@gmail.com"));
		//serviceUser.delete(user);
		
	}
	
}
