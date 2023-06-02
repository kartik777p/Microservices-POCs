package com.nit;

import static org.junit.Assert.assertNotNull;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nit.dao.UserDao;
import com.nit.service.UserService;

public class UserTest {
	
	private static UserService service=null;
	
	@BeforeClass
	public static void init() {
		//prepare mock obj of Dao class
		UserDao userDao = EasyMock.createMock(UserDao.class);
		//set behaviours
		EasyMock.expect(userDao.findNameById(101)).andReturn("Kartik");
		EasyMock.expect(userDao.findEmailById(102)).andReturn("kartik@123");
		//add all details to mock obj
		EasyMock.replay(userDao);
		//create service class obj having dao class obj
		service=new UserService(userDao);
	}
	
	@Test
	public void test_Name() {
		String name = service.findNameById(101);
		assertNotNull(name);
	}
	
	@Test
	public void test_Email() {
		String email = service.findEmailById(102);
		assertNotNull(email);
	}
	
	@AfterClass
	public static void destroy() {
		service=null;
	}
}
