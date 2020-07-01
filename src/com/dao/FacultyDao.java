package com.dao;

import java.util.List;

import com.entities.Faculty;

public interface FacultyDao 
{
	public boolean addFaculty(Faculty faculty);
	public List<Faculty> list();
	public boolean deleteFaculty(String usr);
	public List<Faculty> getFaculty(String username);
	public List<Faculty> getEmail(String email);
	public boolean updateFaculty (String f_username, String pwd);
}
