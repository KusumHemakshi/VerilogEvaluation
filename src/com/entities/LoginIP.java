package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loginip")
public class LoginIP 
{
	@Column(name="username")
	private String username;
	
	@Column(name="ip")
	private String ip;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@Id
	@Column(name="str")
	private String str;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String username,String ip,String date,String time) 
	{
		this.str = username+ip+date+time;
	}	
}
