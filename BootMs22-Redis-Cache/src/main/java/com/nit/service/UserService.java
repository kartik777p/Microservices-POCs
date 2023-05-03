package com.nit.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.nit.model.User;

@Service
public class UserService {
	
	private HashOperations<String, Integer, User> hashOperations ;
	
	//cons
	public UserService(RedisTemplate<String,User> template) {
		//create HashOperations for performing oprataions
		hashOperations=template.opsForHash();
	}
	
	public String saveUser(User user) {
		hashOperations.put("USER",user.getId(), user);
		return "User Added into redis chache";
	}
	
	public User findById(Integer id) {
		return hashOperations.get("USER", id);
	}//findById
	
	public Collection<User> fetchAll(){
	Map<Integer,User>  map=hashOperations.entries("USER");
	//fetch values from map and return
	return map.values();
	}//findById	
}
