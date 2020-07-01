package com.daoimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AdminDao;
import com.entities.Admin;

@Repository
public class AdminDaoImp implements AdminDao 
{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	@SuppressWarnings("unchecked")
	public  List<Admin> getAdmin(String username)
	{
		List<Admin> result=sessionFactory.getCurrentSession().createQuery("from Admin where a_username=:usr").setParameter("usr",username).list();
		return result;
	}
	
	
	@Transactional
	public boolean updateAdmin (String a_username, String pwd)
	{
		try
		{
			sessionFactory.getCurrentSession().createQuery("update Admin set a_pwd=:pwd where a_username=:a_username").setString("pwd",pwd).setString("a_username",a_username).executeUpdate();
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
}
