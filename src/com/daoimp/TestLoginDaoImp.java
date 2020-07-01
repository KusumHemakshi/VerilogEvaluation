package com.daoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.TestLoginDao;
import com.entities.TestLogin;

@Repository
public class TestLoginDaoImp implements TestLoginDao
{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public boolean addTestLogin(TestLogin testlogin)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(testlogin);
				return true;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<TestLogin> getTestLogin(String username,String test_id)
	{
		List<TestLogin> result=sessionFactory.getCurrentSession().createQuery("from TestLogin where username=:usr and test_id=:test_id").setParameter("usr",username).setParameter("test_id", test_id).list();
			return result;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<TestLogin> getTestLoginStudent(String test_id)
	{
		List<TestLogin> result=sessionFactory.getCurrentSession().createQuery("from TestLogin where test_id=:test_id").setParameter("test_id",test_id).list();
		return result;	
	}
	
	@Transactional
	public boolean deleteTestLogin(String id)
	{
		sessionFactory.getCurrentSession().createQuery("delete from TestLogin where test_id=:id").setString("id",id).executeUpdate();
		return true;
	}
}
