package com.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginIPDao;
import com.entities.LoginIP;
import com.service.LoginIPService;

@Service
@Transactional
public class LoginIPServiceImp implements LoginIPService 
{
	@Autowired
    private LoginIPDao logDAO;

	@Transactional
	public boolean addLoginIP(String username,String ip,String date,String time) 
	{
		LoginIP log=new LoginIP();
		log.setUsername(username);
		log.setIp(ip);
		log.setDate(date);
		log.setTime(time);
		log.setStr(username, ip, date, time);
		return logDAO.addLoginIP(log);
	}

	@Transactional
	public List<LoginIP> allLoginIP()
	{
		return logDAO.allLoginIP();
	}
}
