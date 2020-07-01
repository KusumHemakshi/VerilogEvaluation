package com.daoimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.FacultyDao;
import com.entities.Faculty;

@Repository
public class FacultyDaoImp implements FacultyDao
{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public boolean addFaculty(Faculty faculty)
	{
		sessionFactory.getCurrentSession().saveOrUpdate (faculty);
			return true;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Faculty> getEmail(String email)
	{
		List<Faculty> result=sessionFactory.getCurrentSession().createQuery("from Faculty where f_email=:email").setParameter("email",email).list();
		return result;
		
	}
	
	@Transactional
	public List<Faculty> list()
	{
		try{
			@SuppressWarnings("unchecked")
			List<Faculty> result = sessionFactory.getCurrentSession().createQuery("from Faculty").list();
			
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Transactional
	public boolean deleteFaculty(String usr)
	{
		Faculty faculty = (Faculty) sessionFactory.getCurrentSession().load(Faculty.class, usr);
		if (null != faculty) 
		{
			try
			{
				sessionFactory.getCurrentSession().createQuery("delete from Faculty where f_username=:user").setString("user",usr).executeUpdate();
				return true;
			}
			catch(Exception ex)
			{
				return false;
			}
		}
		return false;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Faculty> getFaculty(String username)
	{
		List<Faculty> result=sessionFactory.getCurrentSession().createQuery("from Faculty where f_username=:usr").setParameter("usr",username).list();
			return result;
	}
	public boolean updateFaculty (String f_username, String pwd)
	{
		sessionFactory.getCurrentSession().createQuery("update Faculty set f_pwd=:pwd where f_username=:f_username").setString("pwd",pwd).setString("f_username",f_username).executeUpdate();
		return true;
	}
}
