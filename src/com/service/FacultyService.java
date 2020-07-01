package com.service;

import java.util.List;

import com.entities.Faculty;

public interface FacultyService 
{
	public boolean addFaculty(Faculty faculty);
	public List<Faculty> list();
	public boolean deleteFaculty(String usr);
	public boolean validFaculty(String username, String pwd);
	public boolean pwdAdmin (String f_username, String pwd);
}
