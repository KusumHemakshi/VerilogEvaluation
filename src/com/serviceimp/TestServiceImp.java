package com.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.QuestionDao;
import com.dao.SubmissionDao;
import com.dao.TestDao;
import com.dao.TestLoginDao;
import com.entities.Test;
import com.service.TestService;

@Service
@Transactional
public class TestServiceImp implements TestService
{
	@Autowired
    private TestDao testDAO;
	
	@Autowired
	private QuestionDao queDAO;
	
	@Autowired
	private SubmissionDao subDAO;
	
	@Autowired
	private TestLoginDao testlogDAO;
	
	@Transactional
	public boolean UpdateTest(Test test)
	{
		return testDAO.UpdateTest(test);
	}
	
	
	@Transactional
	public boolean addTest(Test test)
	{
		List<Test> result=testDAO.getTest(test.getTest_id());

		if(result.isEmpty())
		{
			return testDAO.addTest(test);
		}
		else
		{
			return false;
		}
	}
	
	@Transactional
	public boolean updateTestTime(String test_id, int hr, int min)
	{
		return testDAO.updateTestTime(test_id, hr, min);
	}
	
	@Transactional
	public boolean deleteTest(String id)
	{
		testlogDAO.deleteTestLogin(id);
		subDAO.addSub(id);
		queDAO.deleteQuestion(id);
		return testDAO.deleteTest(id);
	}
	
	@Transactional
	public List<Test> listFaculty(String usr)
	{
		return testDAO.listFaculty(usr);
	}
	@Transactional
	public List<Test> list()
	{
		return testDAO.list();
	}
	@Transactional
	public List<Test> listTest(String test)
	{
		return testDAO.listTest(test);
	}
}
