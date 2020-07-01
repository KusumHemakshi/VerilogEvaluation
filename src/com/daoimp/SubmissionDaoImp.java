package com.daoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.SubmissionDao;
import com.entities.Faculty;
import com.entities.Submission;
import com.entities.Transcript;

@Repository
public class SubmissionDaoImp implements SubmissionDao
{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public boolean addSubmission(Submission submission)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(submission);
		return true;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Submission> getSub(String test_id,String username)
	{
		List<Submission> result=sessionFactory.getCurrentSession().createQuery("from Submission where test_id=:test_id and 	s_username=:username").setParameter("test_id",test_id).setParameter("username",username).list();
		return result;
	}
	
	@Transactional
	public boolean deleteSubmision(String usr)
	{
		sessionFactory.getCurrentSession().createQuery("delete from Submission where s_username=:user").setString("user",usr).executeUpdate();
		return true;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Submission> getSubmission(String test_id)
	{
		List<Submission> result=sessionFactory.getCurrentSession().createQuery("from Submission where test_id=:test_id").setParameter("test_id",test_id).list();
		return result;
	}
	
	@Transactional
	public boolean addSub(String test_id)
	{
		sessionFactory.getCurrentSession().createQuery("delete from Submission where test_id=:test_id").setString("test_id",test_id).executeUpdate();
		return true;
	}
	

	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Submission> downloadSubmission(String test_id, int que_no, String s_username)
	{
		List<Submission> result=sessionFactory.getCurrentSession().createQuery("from Submission where test_id=:test_id and s_username=:s_username and que_no=:que_no").setParameter("que_no",que_no).setParameter("test_id",test_id).setParameter("s_username",s_username).list();
		return result;
	}
}
