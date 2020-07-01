package com.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ConfirmationTokenDao;
import com.dao.FacultyDao;
import com.dao.StudentDao;
import com.entities.ConfirmationToken;
import com.entities.Faculty;
import com.entities.Student;
import com.service.FacultyService;

@Controller
public class FacultyController 
{
	@Autowired
	FacultyService facultyService;
	
	@Autowired
    private FacultyDao facultyDAO;
	
	@Autowired
	private StudentDao studentDAO;
	
	@Autowired
	private ConfirmationTokenDao configTDAO;

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/welcomef")
	public String homeAdmin(HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return "redirect:/";
		}
			return "welcomef";
	}
	
	@RequestMapping(value="/aaf")
	public ModelAndView pageaddFaculty(HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
			
		}
			return new ModelAndView("aaf");
	}
	
	@RequestMapping(value="/afp")
	public ModelAndView pagepwdFaculty(HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
			return new ModelAndView("afp");
	}
	
	@RequestMapping(value="/ffp")
	public ModelAndView pagepwdFaculty(HttpSession session,ModelAndView model)
	{
	
		if(session.getAttribute("username")==null)
		{
			model.setViewName("redirect:/");
			return model;
		}
		String usr=session.getAttribute("username").toString();
		model.addObject("f_username", usr);
		model.setViewName("ffp");
		return model;
	}
	
	@RequestMapping(value="/aaaf", method=RequestMethod.POST)
	public ModelAndView addFaculty(Faculty faculty,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		BCryptPasswordEncoder bct=new BCryptPasswordEncoder();
		faculty.setF_pwd(bct.encode(faculty.getF_pwd()));
		List<Faculty> existingFaculty = facultyDAO.getEmail(faculty.getF_email());
		List<Student> existingStudent =studentDAO.getEmail(faculty.getF_email());
        if(existingFaculty != null || existingStudent!=null)
        {
        	new ModelAndView("aaf3");
        }
            facultyService.addFaculty(faculty);
            
            String token= UUID.randomUUID().toString();
	        ConfirmationToken configT=new ConfirmationToken();
	        configT.setUsername(faculty.getF_username());
	        configT.setEnable(false);
	        configT.setToken(token);
	        configT.setToken_id(configT.getToken_id());
	        configTDAO.addConfirmationToken(configT);
            

			 SimpleMailMessage simpleMessage = new SimpleMailMessage();
		     simpleMessage.setTo(faculty.getF_email());
		     simpleMessage.setSubject("Complete Registration!");
		     simpleMessage.setText("To confirm your account, please click here : "+"http://localhost:8080/VerilogEvaluation/confirm-account?token="+configT.getToken());
		        
		        
		     mailSender.send(simpleMessage);
		        
		     return new ModelAndView("aaf2");
	}
	@RequestMapping(value="/arf")
	public ModelAndView pageremoveFaculty(ModelAndView model,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		List<Faculty> flist = facultyService.list();
		model.addObject("flist", flist);
		model.setViewName("arf");
		return model;
	}
	
	@RequestMapping(value="/aarf", method=RequestMethod.GET)
	public ModelAndView removeFaculty(HttpServletRequest request,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		ModelAndView model=new ModelAndView();
		
		String usr=request.getParameter("id");
		facultyService.deleteFaculty(usr);
		

		List<Faculty> flist = facultyService.list();
		model.addObject("flist", flist);
		model.setViewName("arf");
		return model;
	}
	
	@RequestMapping(value="/aafp", method=RequestMethod.POST)
	public ModelAndView pwdFaculty(HttpSession session,@RequestParam(value="f_username") String f_username,@RequestParam(value="f_pwd") String f_pwd)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		BCryptPasswordEncoder bct=new BCryptPasswordEncoder();
		f_pwd=bct.encode(f_pwd);
		if(facultyService.pwdAdmin(f_username,f_pwd))
		{
			List<Faculty> flist = facultyService.list();
			ModelAndView model=new ModelAndView();
			model.addObject("flist", flist);
			model.setViewName("afp2");
			return model;
		}
		else
		{
			return new ModelAndView("afp3");
		}
	}
	
	@RequestMapping(value="/fp2", method=RequestMethod.POST)
	public ModelAndView pwdFaculty2(HttpSession session,@RequestParam(value="f_username") String f_username,@RequestParam(value="f_pwd") String f_pwd)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		BCryptPasswordEncoder bct=new BCryptPasswordEncoder();
		f_pwd=bct.encode(f_pwd);
		if(facultyService.pwdAdmin(f_username,f_pwd))
		{
			return new ModelAndView("ffp2");
		}
		else
		{
			return new ModelAndView("ffp3");
		}
	}
	

}
