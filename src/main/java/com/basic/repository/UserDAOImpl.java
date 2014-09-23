package com.basic.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.basic.model.User2;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<User2> getAllUsers() {
		@SuppressWarnings("unchecked")
		List<User2> users = entityManager.createQuery("SELECT u FROM User2 u Order by id Asc").getResultList();
		return users;
	}
	
	
	@Override
	@Transactional
	public String saveUser(User2 user){
		System.out.println("*********" + user.getFullName() + "**************");
		//boolean userExists = userExist(user.getUserName());
		//if(!userExists) {
			entityManager.persist(user);
			entityManager.flush();
		//} else {
		//	return "NOT OK";
		//}
		boolean userCreated = userExist(user.getUserName());
		if(userCreated) {
			return "OK";
		} else {
			return "NOT OK";
		}
		
	}
	
	private boolean userExist(String userName) {
		User2 user = (User2) entityManager.createQuery("Select u From User2 as u Where u.userName = :userName")
				.setParameter("userName",userName).getSingleResult();
		if(user != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public User2 getUser(String userName, String password){
		try{
			User2 user = (User2) entityManager.createQuery("Select u From User2 as u Where u.userName = :userName and u.password = :password")
			.setParameter("userName",userName)
			.setParameter("password", password)
			.getSingleResult();
			return user;
		} catch(NoResultException e) {
	        return null;
	    }
	}
}
