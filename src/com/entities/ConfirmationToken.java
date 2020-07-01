package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="confirmationtoken")
public class ConfirmationToken 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="token_id")
    private long token_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="token")
	private String token;
	
	@Column(name="enable")
	private boolean enable;

	public long getToken_id() {
		return token_id;
	}

	public void setToken_id(long token_id) {
		this.token_id = token_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
