package com.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.model.User2;
import com.basic.repository.UserDAO;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public List<User2> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public String saveUser(User2 user) {
		return userDAO.saveUser(user);
	}

	@Override
	public User2 getUser(String userName, String password) {
		return userDAO.getUser(userName, password);
	}

}
