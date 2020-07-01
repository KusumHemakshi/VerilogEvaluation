package com.dao;

import java.util.List;

import com.entities.TestLogin;

public interface TestLoginDao 
{
	public boolean addTestLogin(TestLogin testlogin);
	public List<TestLogin> getTestLogin(String username,String test_id);
	public List<TestLogin> getTestLoginStudent(String test_id);
	public boolean deleteTestLogin(String id);
}
