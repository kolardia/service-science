package service.sience.service.authorization.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.authorization.service.ServiceUser;
import pl.service.science.user.domain.User;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class UserTest {

	@Autowired
	protected ServiceUser serviceUser;

	@Test // this user does not exist --> new user
	public void newUser() {

		User user = new User();
		user = serviceUser.ifExistFindByEmail("m.senderecka@gmail.com");

		user.setName("Monika Senderecka");
		user.setEmail("m.senderecka@gmail.com");
		user.setEnabled(true);
		user.setPassword("password");
		user.setAddressOfResidence(null);
	
		serviceUser.save(user);
		Assert.assertNotNull(serviceUser.findByEmail("m.senderecka@gmail.com"));
	}

	@Test // this user exists --> update user
	public void updateUser() {

		
		User user = new User();
		user = serviceUser.ifExistFindByEmail("m.senderecka@gmail.com");

		user.setName("Monika Senderecka");
		user.setEmail("kolardia@gmail.com");
		user.setEnabled(true);
		user.setPassword("password");
		user.setAddressOfResidence(null);
		
		serviceUser.save(user);
		Assert.assertNotNull(serviceUser.findByEmail("kolardia@gmail.com"));
		Assert.assertNull(serviceUser.findByEmail("m.senderecka@gmail.com"));
		serviceUser.delete(user);
		
	}
	
}
