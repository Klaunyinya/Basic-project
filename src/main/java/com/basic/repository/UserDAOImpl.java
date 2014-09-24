package com.basic.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.basic.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<User> getAllUsers() {
		@SuppressWarnings("unchecked")
		List<User> users = entityManager.createQuery("SELECT u FROM User u Order by id Asc").getResultList();
		return users;
	}
	
	
	@Override
	@Transactional
	public String saveUser(User user){
		entityManager.persist(user);
		entityManager.flush();
		return "OK";
	}
	
	private boolean userExist(String userName) {
		User user = (User) entityManager.createQuery("Select u From User as u Where u.userName = :userName")
				.setParameter("userName",userName).getSingleResult();
		if(user != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public User getUser(String userName, String password){
		try{
			User user = (User) entityManager.createQuery("Select u From User as u Where u.userName = :userName and u.password = :password")
			.setParameter("userName",userName)
			.setParameter("password", password)
			.getSingleResult();
			return user;
		} catch(NoResultException e) {
	        return null;
	    }
	}
}
