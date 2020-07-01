package com.daoimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.FileDao;
import com.entities.Faculty;
import com.entities.File;
import com.entities.Submission;

@Repository
public class FileDaoImp implements FileDao
{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public boolean addFile(File file)
	{
		sessionFactory.getCurrentSession().saveOrUpdate (file);
		return true;		
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<File> getFile(String str)
	{
		List<File> result=sessionFactory.getCurrentSession().createQuery("from File where str=:str").setParameter("str",str).list();
		return result;
	}
}
