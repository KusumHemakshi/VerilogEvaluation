package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entities.LoginIP;
import com.service.AdminService;
import com.service.LoginIPService;

@Controller
public class AdminController
{
	@Autowired
	AdminService adminService; 
	
	@Autowired
	LoginIPService logService;
	
	@RequestMapping(value="/welcomea")
	public ModelAndView homeAdmin(HttpSession session,ModelAndView model)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}

		List<LoginIP> list=logService.allLoginIP();
		model.addObject("list",list);
		model.setViewName("welcomea");
			return model;
	}
	
	@RequestMapping(value="/aap")
	public ModelAndView pagepwdAdmin(HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
			return new ModelAndView("aap");
	}
	
	@RequestMapping(value="/aaap", method=RequestMethod.POST)
	public ModelAndView pwdAdmin(HttpSession session,@RequestParam(value="a_username") String a_username,@RequestParam(value="a_pwd") String a_pwd,@RequestParam(value="a2_pwd") String a2_pwd)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		
		BCryptPasswordEncoder bct=new BCryptPasswordEncoder();
		a_pwd=bct.encode(a_pwd);
		if(adminService.pwdAdmin(a_username,a_pwd))
		{
			return new ModelAndView("aap2");
		}
		else
		{
			return new ModelAndView("aap3");
		}
	}
}
