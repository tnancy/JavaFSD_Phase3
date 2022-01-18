package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	//get methods
	public List<User> getUsers()
	{
		return (List<User>) repository.findAll();
	}
}
