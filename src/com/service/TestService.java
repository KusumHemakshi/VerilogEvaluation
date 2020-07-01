package com.service;

import java.util.List;

import com.entities.Test;

public interface TestService 
{
	public boolean addTest(Test test);
	public List<Test> listFaculty(String usr);
	public List<Test> list();
	public List<Test> listTest(String test);
	public boolean deleteTest(String id);
	public boolean updateTestTime(String test_id, int hr, int min);
	public boolean UpdateTest(Test test);
}
