package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="testlogin")
public class TestLogin 
{
	@Column(name="username")
	private String username;
	
	@Column(name="test_id")
	private String test_id;
	
	@Column(name="login")
	private boolean login;

	@Id
	@Column(name="ID")
	private String ID;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTest_id() {
		return test_id;
	}

	public void setTest_id(String test_id) {
		this.test_id = test_id;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public String getID() {
		return ID;
	}

	public void setID(String username, String test_id) {
		this.ID = username+test_id;
	}
}
