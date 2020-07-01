package com.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin 
{
	@Id
	@Column(name="a_username")
	private String a_username;
	
	@Column(name="a_name")
	private String a_name;
	
	@Column(name="a_pwd")
	private String a_pwd;
	

//	@Email
	@Column(name="a_email")
	private String a_email;
	
	public String getA_username() 
	{
		return a_username;
	}
	public void setA_username(String a_username) 
	{
		this.a_username = a_username;
	}
	public String getA_name() 
	{
		return a_name;
	}
	public void setA_name(String a_name) 
	{
		this.a_name = a_name;
	}
	public String getA_pwd() 
	{
		return a_pwd;
	}
	public void setA_pwd(String a_pwd) 
	{
		this.a_pwd = a_pwd;
	}
	public String getA_email() 
	{
		return a_email;
	}
	public void setA_email(String a_email) 
	{
		this.a_email = a_email;
	}
}