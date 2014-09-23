package com.basic.service;

import java.util.List;

import com.basic.model.User2;

public interface UserService {
	
	public List<User2> getAllUsers();
	
	public String saveUser(User2 user);

	public User2 getUser(String userName, String password);
}
