package com.nit.service;

import com.nit.dao.UserDao;

public class UserService {
  
	private UserDao userDao=null;
	//setter injection
	public void setUserDao(UserDao userDao) {
		this.userDao=userDao;
	}
	
	public String findNameById(Integer id) {
		String name = userDao.findNameById(id);
		return name;
	}
	
	public String findEmailById(Integer id) {
		String email = userDao.findEmailById(id);
		return email;
	}
	
	//private method
	private Boolean isUserActive(Integer id) {
		//logic
		return true;
	}
	
	//void method
	public void doWork() {
		//logic
	}
}
