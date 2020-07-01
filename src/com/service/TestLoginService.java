package com.service;

import java.util.List;

import com.entities.TestLogin;

public interface TestLoginService 
{
	public boolean addTestLogin(TestLogin testlogin);
	public List<TestLogin> getTestLogin(String username,String test_id);
	public List<TestLogin> getTestLoginStudent(String test_id);
}
