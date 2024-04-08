package com.obbs.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.obbs.exception.ApplicationException;

import com.obbs.model.UsersPojo;
import com.obbs.service.UsersService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })

public class UsersTestJunit {
	UsersPojo usersPojo = new UsersPojo();

	@Autowired
	UsersService usersService;

	@Test
	// correct username and password
	public void testUsersLogin1() throws ApplicationException {
		usersPojo.setEmail("sam@gmail.com");
		usersPojo.setPassword("sam");
		int login = usersService.loginUser(usersPojo);
		assertEquals(1, login);

	}

	@Test
	// correct username and incorrect password
	public void testUsersLogin2() throws ApplicationException {
		usersPojo.setEmail("sam@gmail.com");
		usersPojo.setPassword("samm");
		int login = usersService.loginUser(usersPojo);
		assertEquals(0, login);

	}

	@Test
	// incorrect username and correct password
	public void testUsersLogin3() throws ApplicationException {
		usersPojo.setEmail("samm@gmail.com");
		usersPojo.setPassword("sam");
		int login = usersService.loginUser(usersPojo);
		assertEquals(0, login);

	}

	@Test
	// incorrect username and password
	public void testUsersLogin4() throws ApplicationException {
		usersPojo.setEmail("samm@gmail.com");
		usersPojo.setPassword("samm");
		int login = usersService.loginUser(usersPojo);
		assertEquals(0, login);

	}

	@Test
	// Registering with existing mail
	public void testUserMailCheck1() throws ApplicationException {
		usersPojo.setEmail("sam@gmail.com");
		int login = usersService.mailCheckUser(usersPojo);
		assertEquals(3, login);

	}

	@Test
	// Registering with new mail
	public void testUserMailCheck2() throws ApplicationException {
		usersPojo.setEmail("simran@gmail.com");
		int login = usersService.mailCheckUser(usersPojo);
		assertNotEquals(3, login);

	}
}
