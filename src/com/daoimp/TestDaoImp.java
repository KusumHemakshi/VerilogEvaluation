package com.daoimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TestDao;
import com.entities.Test;

@Repository
public class TestDaoImp implements TestDao
{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public boolean addTest(Test test)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(test);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	@Transactional
	public boolean UpdateTest(Test test)
	{
		try
		{
			sessionFactory.getCurrentSession().update(test);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	@Transactional
	public boolean updateTestTime(String test_id, int hr, int min)
	{
		sessionFactory.getCurrentSession().createQuery("update Test set test_hr=:hr where test_id=:test_id").setInteger("hr", hr).setString("test_id",test_id).executeUpdate();
		sessionFactory.getCurrentSession().createQuery("update Test set test_min=:min where test_id=:test_id").setInteger("min", min).setString("test_id",test_id).executeUpdate();
		return true;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Test> getTest(String username)
	{
		List<Test> result=sessionFactory.getCurrentSession().createQuery("from Test where test_id=:usr").setParameter("usr",username).list();
			return result;
	}
	@Transactional
	public List<Test> list()
	{
		try{
			@SuppressWarnings("unchecked")
			List<Test> result = sessionFactory.getCurrentSession().createQuery("from Test").list();	
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Test> listFaculty(String usr)
	{
		List<Test> result=sessionFactory.getCurrentSession().createQuery("from Test where f_username=:usr").setParameter("usr",usr).list();
			return result;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Test> listTest(String test)
	{
		List<Test> result=sessionFactory.getCurrentSession().createQuery("from Test where test_id=:test").setParameter("test",test).list();
		return result;
	}
	
	@Transactional
	public boolean deleteTest(String id)
	{
		try
		{	
			sessionFactory.getCurrentSession().createQuery("delete from Test where test_id=:id").setString("id",id).executeUpdate();

			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
}
