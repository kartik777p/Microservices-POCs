package com.nit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import com.nit.dao.UserDao;
import com.nit.service.UserService;

public class UserTest {

	@Test
	public void test_findName() {
		//prepare userdao obj
		UserDao userDao = PowerMockito.mock(UserDao.class);
		//decide behaviors of mock obj
		when(userDao.findNameById(101)).thenReturn("NareshIt");
		//inject dao mock obj to service class
		UserService userService=new UserService();
		userService.setUserDao(userDao);
		String name = userService.findNameById(101);
		assertNotNull(name);
	}
	
	@Test
	public void test_findEmail() {
		//prepare userdao obj
		UserDao userDao = PowerMockito.mock(UserDao.class);
		//decide behaviors of mock obj
		when(userDao.findEmailById(102)).thenReturn("nareshit@gmail.com");
		//inject dao mock obj to service class
		UserService userService=new UserService();
		userService.setUserDao(userDao);
		String email = userService.findEmailById(102);
		assertNotNull(email);
	}
	
	@Test
	public void test_IsActive() throws Exception {
		//need to perform testing on private method
		UserService service =new UserService();
		Boolean isActive =(Boolean)Whitebox.invokeMethod(service, "isUserActive", 101);
		assertTrue(isActive);
	}
	
	@Test
	public void test_DoWork() {
		//get service class obj using mocking
	UserService service = PowerMockito.mock(UserService.class);
		doNothing().when(service).doWork();
	}
}
