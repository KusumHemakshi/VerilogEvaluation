package com.service;

import java.util.List;

import com.entities.LoginIP;

public interface LoginIPService 
{
	public boolean addLoginIP(String username,String ip,String date,String time);
	public List<LoginIP> allLoginIP();
}
