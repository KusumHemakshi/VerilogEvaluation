package com.daoimp;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.StudentDao;
import com.entities.Faculty;
import com.entities.Student;

@Repository
public class StudentDaoImp implements StudentDao 
{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Student> getEmail(String email)
	{
		List<Student> result=sessionFactory.getCurrentSession().createQuery("from Student where s_email=:email").setParameter("email",email).list();
		return result;
		
	}
	
	@Transactional
	public boolean addStudent(Student student)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(student);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	public boolean updateStudent (String s_username, String pwd)
	{
		sessionFactory.getCurrentSession().createQuery("update Student set s_pwd=:pwd where s_username=:s_username").setString("pwd",pwd).setString("s_username",s_username).executeUpdate();
		return true;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Student> getStudent(String username)
	{
		List<Student> result=sessionFactory.getCurrentSession().createQuery("from Student where s_username=:usr").setParameter("usr",username).list();
			return result;
	}
	@Transactional
	public List<Student> list()
	{
		try{
			@SuppressWarnings("unchecked")
			List<Student> result = sessionFactory.getCurrentSession().createQuery("from Student").list();
			
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Transactional
	public boolean timeDeleteStudent(Timestamp time)
	{
//		sessionFactory.getCurrentSession().createQuery("delete from Student where ts_created=:DATE_ADD(time,INTERVAL -(2*24*365*4) HOUR)").setParameter("time",time).executeUpdate();
		return true;
	}
	
	@Transactional
	public boolean deleteStudent(String usr)
	{
		Student student = (Student) sessionFactory.getCurrentSession().load(Student.class, usr);
		if (null != student) 
		{
			try
			{
				sessionFactory.getCurrentSession().createQuery("delete from Student where S_username=:user").setString("user",usr).executeUpdate();
				return true;
			}
			catch(Exception ex)
			{
				return false;
			}
		}
		return false;
	}
}
