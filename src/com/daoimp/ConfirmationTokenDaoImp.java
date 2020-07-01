package com.daoimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ConfirmationTokenDao;
import com.entities.ConfirmationToken;

@Repository
public class ConfirmationTokenDaoImp implements ConfirmationTokenDao
{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public boolean addConfirmationToken(ConfirmationToken configT)
	{	
		sessionFactory.getCurrentSession().saveOrUpdate (configT);
		return true;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ConfirmationToken> getConfirmation(String username)
	{
		List<ConfirmationToken> result=sessionFactory.getCurrentSession().createQuery("from ConfirmationToken where username=:username").setParameter("username",username).list();
		return result;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ConfirmationToken> findToken(String token)
	{
		List<ConfirmationToken> result=sessionFactory.getCurrentSession().createQuery("from ConfirmationToken where token=:token").setParameter("token",token).list();
		System.out.println("Finding token is okay");
		return result;
	}
	
	@Transactional
	public boolean setEnable(String token)
	{
		sessionFactory.getCurrentSession().createQuery("update ConfirmationToken set enable=true where token=:token").setString("token",token).executeUpdate();
		return true;
	}
}
