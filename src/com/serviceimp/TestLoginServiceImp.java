package com.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TestLoginDao;
import com.entities.TestLogin;
import com.service.TestLoginService;

@Service
@Transactional
public class TestLoginServiceImp implements TestLoginService
{
	@Autowired
    private TestLoginDao testloginDAO;
	
	@Transactional
	public boolean addTestLogin(TestLogin testlogin)
	{
		return testloginDAO.addTestLogin(testlogin);
	}
	
	@Transactional
	public List<TestLogin> getTestLogin(String username,String test_id)
	{
		return testloginDAO.getTestLogin(username,test_id);
	}
	
	@Transactional
	public List<TestLogin> getTestLoginStudent(String test_id)
	{
		return testloginDAO.getTestLoginStudent(test_id);
	}
}

