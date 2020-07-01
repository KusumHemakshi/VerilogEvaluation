package com.dao;

import java.util.List;

import com.entities.LoginIP;

public interface LoginIPDao 
{
	public boolean addLoginIP(LoginIP log);
	public List<LoginIP> allLoginIP();
}
