package com.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dao.FacultyDao;
import com.entities.Faculty;
import com.service.FacultyService;
import com.service.StudentService;
import com.service.TestService;

@Service
@Transactional
public class FacultyServiceImp implements FacultyService
{
	@Autowired
    private FacultyDao facultyDAO;
	
	@Autowired
	private StudentService stdService;
	
	@Autowired
	private TestService testService;
	
	@Transactional
	public boolean addFaculty(Faculty faculty)
	{
		List<Faculty> result=facultyDAO.getFaculty(faculty.getF_username());

		if(result.isEmpty())
		{
			return facultyDAO.addFaculty(faculty);
		}
		else
		{
			return false;
		}
	}
	
	@Transactional
	public List<Faculty> list()
	{
		return facultyDAO.list();
	}
	
	@Transactional
	public boolean deleteFaculty(String usr)
	{
		return facultyDAO.deleteFaculty(usr);
	}

	@Transactional
	public boolean validFaculty(String username, String pwd)
	{
		List<Faculty> result=facultyDAO.getFaculty(username);
		BCryptPasswordEncoder bct=new BCryptPasswordEncoder();
		if(result.isEmpty())
		{
			return false;
		}
		else
		{
			for(Faculty f: result)
			{
				String usr=f.getF_pwd();
				if(bct.matches(pwd, usr))
				{
					return true;
				}
			}
			return false;
		}
	}
	
	@Transactional
	public boolean pwdAdmin (String f_username, String pwd)
	{
		List<Faculty> result=facultyDAO.getFaculty(f_username);
		if(result.isEmpty())
		{
			return false;
		}
		else
		{
			return facultyDAO.updateFaculty(f_username, pwd);
		}
	}
}
