package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<User> findAllUsers()
	{
		return service.getUsers();
	}
}
