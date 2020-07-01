package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="faculty")
public class Faculty 
{
	@Id
	@Column(name="f_username")
	private String f_username;
	
	@Column(name="f_name")
	private String f_name;

	@Column(name="f_pwd")
	private String f_pwd;

//	@Email
	@Column(name="f_email")
	private String f_email;
	@OneToMany

	public String getF_username() {
		return f_username;
	}

	public void setF_username(String f_username) {
		this.f_username = f_username;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getF_pwd() {
		return f_pwd;
	}

	public void setF_pwd(String f_pwd) {
		this.f_pwd = f_pwd;
	}

	public String getF_email() {
		return f_email;
	}

	public void setF_email(String f_email) {
		this.f_email = f_email;
	}
}