package com.daoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.LoginIPDao;
import com.entities.LoginIP;

@Repository
public class LoginIPDaoImp implements LoginIPDao 
{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public boolean addLoginIP(LoginIP log)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(log);
		return true;
	}
	
	@Transactional
	public List<LoginIP> allLoginIP()
	{
		try
		{
			@SuppressWarnings("unchecked")
			List<LoginIP> result = sessionFactory.getCurrentSession().createQuery("from LoginIP").list();
			
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
