package com.basic.repository;

import java.util.List;

import com.basic.model.User;

public interface UserDAO {
	
	public List<User> getAllUsers();

	public String saveUser(User user);

	public User getUser(String userName, String password);
}
