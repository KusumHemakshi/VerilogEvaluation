package com.daoimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.QuestionDao;
import com.entities.Question;

@Repository
public class QuestionDaoImp implements QuestionDao 
{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public void updateQuestion(String str, String que, int no_files, String cases)
	{
		try
		{
			sessionFactory.getCurrentSession().createQuery("update Question set que=:que where str=:str").setString("que",que).setString("str",str).executeUpdate();
			sessionFactory.getCurrentSession().createQuery("update Question set no_files=:no_files where str=:str").setInteger("no_files",no_files).setString("str",str).executeUpdate();
			
			sessionFactory.getCurrentSession().createQuery("update Question set que_cases=:cases where str=:str").setString("cases",cases).setString("str",str).executeUpdate();
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
	}

	@Transactional
	public boolean addQuestion(Question question) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate (question);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Question> listQuestion(String test)
	{
		List<Question> result=sessionFactory.getCurrentSession().createQuery("from Question where test_id=:test").setParameter("test",test).list();
		return result;	
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Question> listQuestions(String test,int que)
	{
		List<Question> result=sessionFactory.getCurrentSession().createQuery("from Question where test_id=:test and que_no=:que").setParameter("test",test).setParameter("que",que).list();
		return result;	
	}
	
	@Transactional
	public boolean deleteQuestion(String test_id)
	{
		sessionFactory.getCurrentSession().createQuery("delete from Question where test_id=:test_id").setString("test_id",test_id).executeUpdate();
		return true;
	}
}
