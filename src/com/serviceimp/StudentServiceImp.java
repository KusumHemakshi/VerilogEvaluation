package com.serviceimp;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.dao.SubmissionDao;
import com.entities.Student;
import com.service.StudentService;

@Service
@Transactional
public class StudentServiceImp implements StudentService
{
	@Autowired
    private StudentDao studentDAO;
	
	@Autowired
	private SubmissionDao subDAO;
	
	@Transactional
	public boolean pwdStudent (String s_username, String pwd)
	{
		List<Student> result=studentDAO.getStudent(s_username);
		if(result.isEmpty())
		{
			return false;
		}
		else
		{
			return studentDAO.updateStudent(s_username, pwd);
		}
	}
	
	@Transactional
	public boolean timeDeleteStudent(Timestamp time)
	{
		return studentDAO.timeDeleteStudent(time);
	}
	
	@Transactional
	public boolean addStudent(Student student)
	{
		List<Student> result=studentDAO.getStudent(student.getS_username());
		//System.out.println(student.getS_username());

		if(result.isEmpty())
		{
			//System.out.println("reached to serviceimp");
			return studentDAO.addStudent(student);
		}
		else
		{
			//System.out.println("reached to serviceimp error");
			return false;
		}
	}
	
	@Transactional
	public boolean validStudent(String username, String pwd)
	{
		List<Student> result=studentDAO.getStudent(username);
		BCryptPasswordEncoder bct=new BCryptPasswordEncoder();
		if(result.isEmpty())
		{
			return false;
		}
		else
		{
			for(Student std: result)
			{
				String usr=std.getS_pwd();
				if(bct.matches(pwd, usr))
				{
					return true;
				}
			}
			return false;
		}
	}
	@Transactional
	public boolean deleteStudent(String usr)
	{
		subDAO.deleteSubmision(usr);
		return studentDAO.deleteStudent(usr);
	}

	@Transactional
	public List<Student> list()
	{
		return studentDAO.list();
	}
}
