package com.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dao.AdminDao;
import com.entities.Admin;
import com.service.AdminService;

@Service
@Transactional
public class AdminServiceImp implements AdminService
{
	@Autowired
    private AdminDao adminDAO;
	
	@Transactional
	public boolean validAdmin(String username, String pwd)
	{
		List<Admin> result=adminDAO.getAdmin(username);
		BCryptPasswordEncoder bct=new BCryptPasswordEncoder();
		if(result.isEmpty())
		{
			return false;
		}
		else
		{
			for(Admin a: result)
			{
				String usr=a.getA_pwd();
				if(bct.matches(pwd, usr))
				{
					return true;
				}
			}
			return false;
		}
	}
	
	@Transactional
	public boolean pwdAdmin(String a_username, String pwd)
	{
		List<Admin> result=adminDAO.getAdmin(a_username);
		if(result.isEmpty())
		{
			return false;
		}
		else
		{
			return adminDAO.updateAdmin(a_username, pwd);
		}

	}
}
