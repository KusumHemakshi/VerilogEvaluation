package com.dao;

import java.util.List;

import com.entities.Admin;

public interface AdminDao 
{
	public  List<Admin> getAdmin(String username);
	public boolean updateAdmin (String a_username, String pwd);
}
