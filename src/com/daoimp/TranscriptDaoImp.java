package com.daoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.TranscriptDao;
import com.entities.Submission;
import com.entities.Transcript;

@Repository
public class TranscriptDaoImp implements TranscriptDao
{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Transcript> getTranscript(String test_id,String username)
	{
		List<Transcript> result=sessionFactory.getCurrentSession().createQuery("from Transcript where test_id=:test_id and 	s_username=:username").setParameter("test_id",test_id).setParameter("username",username).list();
		return result;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Transcript> downloadTranscript(String test_id, int que_no, String s_username)
	{
		List<Transcript> result=sessionFactory.getCurrentSession().createQuery("from Transcript where test_id=:test_id and s_username=:s_username and que_no=:que_no").setParameter("que_no",que_no).setParameter("test_id",test_id).setParameter("s_username",s_username).list();
		return result;
	}
	
	
	@Transactional
	public boolean addTranscript(Transcript transcript)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(transcript);
			System.out.println("Uploaded successfully FILE");
		}
		catch(Exception ex)
		{
			System.out.println("Error in uploading FILE");
		}
		return true;
	}
}
