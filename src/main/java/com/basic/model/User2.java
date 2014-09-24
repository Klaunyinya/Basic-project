package com.basic.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USERS2 database table.
 * 
 */
@Entity
@Table(name="USERS2")
@NamedQuery(name="User2.findAll", query="SELECT u FROM User2 u")
public class User2 implements Serializable {
	
	private static final Long serialVersionUID = 1L;
	
	@SequenceGenerator(name="User2", sequenceName="USERS2_SEQ")
	@Id @GeneratedValue(generator="User2")
	private Long id;
	
	@Column(name="EMAIL")
	private String email;

	@Column(name="FULL_NAME")
	private String fullName;
	
	@Column(name="PASSWORD")
	private String password;

	@Column(name="USER_NAME")
	private String userName;

	public User2() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
