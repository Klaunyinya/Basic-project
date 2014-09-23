package com.basic.repository;

import java.util.List;

import com.basic.model.User2;

public interface UserDAO {
	
	public List<User2> getAllUsers();

	public String saveUser(User2 user);

	public User2 getUser(String userName, String password);
}
