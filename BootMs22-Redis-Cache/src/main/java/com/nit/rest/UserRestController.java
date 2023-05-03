package com.nit.rest;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.User;
import com.nit.service.UserService;

@RestController
public class UserRestController {

	private UserService service;

	public UserRestController(UserService service) {
		this.service = service;
	}

	@PostMapping(value = "/user")
	public String addUser(@RequestBody User user) {
		String msg = service.saveUser(user);
		return msg;
	}

	@GetMapping("/user/{id}")
	public User fetchById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}
	
	@GetMapping("/users")
	public Collection<User> fetchAllRecord(){
		return service.fetchAll();
	}
}
