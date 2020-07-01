package com.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ConfirmationTokenDao;
import com.dao.FacultyDao;
import com.dao.StudentDao;
import com.entities.ConfirmationToken;
import com.entities.Faculty;
import com.entities.Student;
import com.entities.Test;
import com.service.FacultyService;
import com.service.StudentService;
import com.service.TestService;

@Controller
public class StudentController 
{
	@Autowired
	FacultyService facultyService;
	
	@Autowired
    private FacultyDao facultyDAO;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	TestService testService;
	
	@Autowired 
	StudentDao studentDAO;
	
	@Autowired
	private ConfirmationTokenDao configTDAO;

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/welcomes")
	public ModelAndView homeStudent(HttpSession session,ModelAndView model)
	{
		if(session.getAttribute("username")==null)
		{
			model.setViewName("redirect:/");
			return model;
		}
		
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");  
	    Date dt = new Date();  
	    String strDate2 = formatter2.format(dt); 
	    
	    String strDateFormat2="HH";
	    String strDateFormat3="mm";
		DateFormat dateFormat2=new SimpleDateFormat(strDateFormat2);
		int hour= Integer.parseInt(dateFormat2.format(dt));
		DateFormat dateFormat3=new SimpleDateFormat(strDateFormat3);
		int minutes= Integer.parseInt(dateFormat3.format(dt));
		
		int hr=-10;
		int min=-10;
		int total=0;
		
		String user=session.getAttribute("username").toString();
		List<Student> std=studentDAO.getStudent(user);
		String course=std.get(0).getS_course();
		String sem=std.get(0).getS_sem();
		List<Test> t_list=testService.list();
		List<Test> test=new ArrayList<Test>();
		for(Test t: t_list)
		{
			if(t.getTest_sem().equals("All") && t.getTest_course().equals("All"))
			{
				if((t.getTest_startDate().toString().equals(strDate2)||(t.getTest_startDate().toString().compareTo(strDate2)<0))&& (t.getTest_endDate().toString().equals(strDate2) || (t.getTest_endDate().toString().compareTo(strDate2)>0)))
				{
					if(t.getTest_endDate().toString().equals(strDate2))
					{
						total=(t.getTest_hr()*60+t.getTest_min())-(hour*60+minutes);
						hr=total%60;
						min=total-(hr*60);
						if(total>2)
						{
							test.add(t);
						}
					}
					else if(t.getTest_startDate().toString().equals(strDate2))
					{
						total=(t.getTest_shr()*60+t.getTest_smin())-(hour*60+minutes);
						if(total<0)
						{
							test.add(t);
						}
					}
					else
					{
						test.add(t);
					}
				}
			}
		    else if(t.getTest_sem().equals(sem) && t.getTest_course().equals("All"))
			{
		    	if((t.getTest_startDate().toString().equals(strDate2)||(t.getTest_startDate().toString().compareTo(strDate2)<0))&& (t.getTest_endDate().toString().equals(strDate2) || (t.getTest_endDate().toString().compareTo(strDate2)>0)))
				{
					if(t.getTest_endDate().toString().equals(strDate2))
					{
						total=(t.getTest_hr()*60+t.getTest_min())-(hour*60+minutes);
						hr=total%60;
						min=total-(hr*60);
						if(total>2)
						{
							test.add(t);
						}
					}
					else if(t.getTest_startDate().toString().equals(strDate2))
					{
						total=(t.getTest_shr()*60+t.getTest_smin())-(hour*60+minutes);
						if(total<0)
						{
							test.add(t);
						}
					}
					else
					{
						test.add(t);
					}
				}
			}
			else if(t.getTest_sem().equals("All") && t.getTest_course().equals(course))
			{
				
				if((t.getTest_startDate().toString().equals(strDate2)||(t.getTest_startDate().toString().compareTo(strDate2)<0))&& (t.getTest_endDate().toString().equals(strDate2) || (t.getTest_endDate().toString().compareTo(strDate2)>0)))
				{
					if(t.getTest_endDate().toString().equals(strDate2))
					{
						total=(t.getTest_hr()*60+t.getTest_min())-(hour*60+minutes);
						hr=total%60;
						min=total-(hr*60);
						if(total>2)
						{
							test.add(t);
						}
					}
					else if(t.getTest_startDate().toString().equals(strDate2))
					{
						total=(t.getTest_shr()*60+t.getTest_smin())-(hour*60+minutes);
						if(total<0)
						{
							test.add(t);
						}
					}
					else
					{
						test.add(t);
					}
				}
			}
			else if(t.getTest_sem().equals(sem) && t.getTest_course().equals(course))
			{
				if((t.getTest_startDate().toString().equals(strDate2)||(t.getTest_startDate().toString().compareTo(strDate2)<0))&& (t.getTest_endDate().toString().equals(strDate2) || (t.getTest_endDate().toString().compareTo(strDate2)>0)))
				{
					if(t.getTest_endDate().toString().equals(strDate2))
					{
						total=(t.getTest_hr()*60+t.getTest_min())-(hour*60+minutes);
						hr=total%60;
						min=total-(hr*60);
						if(total>2)
						{
							test.add(t);
						}
					}
					else if(t.getTest_startDate().toString().equals(strDate2))
					{
						total=(t.getTest_shr()*60+t.getTest_smin())-(hour*60+minutes);
						if(total<0)
						{
							test.add(t);
						}
					}
					else
					{
						test.add(t);
					}
				}
			}
		}
		model.addObject("t_list",test);
		model.setViewName("welcomes");
		return model;
	}
	
	@RequestMapping(value="/fsp")
	public ModelAndView pagepwdStudent2(HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
			return new ModelAndView("fsp");
	}
	
	
	@RequestMapping(value="/fsp2", method=RequestMethod.POST)
	public ModelAndView pwdStudent2(HttpSession session,@RequestParam(value="s_username") String s_username,@RequestParam(value="s_pwd") String s_pwd)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		BCryptPasswordEncoder bct=new BCryptPasswordEncoder();
		s_pwd=bct.encode(s_pwd);
		if(studentService.pwdStudent(s_username,s_pwd))
		{
			List<Student> slist = studentService.list();
			ModelAndView model=new ModelAndView();
			model.addObject("slist", slist);
			model.setViewName("fsp2");
			return model;
		}
		else
		{
			return new ModelAndView("asp3");
		}
	}
	
	@RequestMapping(value="/asp")
	public ModelAndView pagepwdStudent(HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
			return new ModelAndView("asp");
	}
	@RequestMapping(value="/aasp", method=RequestMethod.POST)
	public ModelAndView pwdStudent(HttpSession session,@RequestParam(value="s_username") String s_username,@RequestParam(value="s_pwd") String s_pwd)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		BCryptPasswordEncoder bct=new BCryptPasswordEncoder();
		s_pwd=bct.encode(s_pwd);
		if(studentService.pwdStudent(s_username,s_pwd))
		{
			List<Student> slist = studentService.list();
			ModelAndView model=new ModelAndView();
			model.addObject("slist", slist);
			model.setViewName("asp2");
			return model;
		}
		else
		{
			return new ModelAndView("asp3");
		}
	}
	
	@RequestMapping(value="/fas")
	public ModelAndView pageaddStudent(ModelAndView model,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		List<Faculty> flist = facultyService.list();
		model.addObject("flist", flist);
		String usr=session.getAttribute("username").toString();
		model.addObject("f_username", usr);
		model.setViewName("fas");
		return model;
	}

	@RequestMapping(value="/ars")
	public ModelAndView pageremoveStudent(ModelAndView model,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		List<Student> slist = studentService.list();
		model.addObject("slist", slist);
		model.setViewName("ars");
		return model;
	}
	
	@RequestMapping(value="/frs")
	public ModelAndView pageremoveStudent2(ModelAndView model,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		List<Student> slist = studentService.list();
		model.addObject("slist", slist);
		model.setViewName("frs");
		return model;
	}
	
	@RequestMapping(value="/aars", method=RequestMethod.GET)
	public ModelAndView removeStudent(HttpServletRequest request,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		ModelAndView model=new ModelAndView();
		
		String usr=request.getParameter("id");
		studentService.deleteStudent(usr);
		

		List<Student> slist = studentService.list();
		model.addObject("slist", slist);
		model.setViewName("ars");
		return model;
	}
	@RequestMapping(value="/ffrs", method=RequestMethod.GET)
	public ModelAndView removeStudent2(HttpServletRequest request,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		ModelAndView model=new ModelAndView();
		
		String usr=request.getParameter("id");
		studentService.deleteStudent(usr);
		

		List<Student> slist = studentService.list();
		model.addObject("slist", slist);
		model.setViewName("frs");
		return model;
	}
	
	@RequestMapping(value="/ffas",method=RequestMethod.POST)
	public ModelAndView addStudent(Student student,HttpSession session,ModelAndView model,HttpServletRequest request)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		BCryptPasswordEncoder bct=new BCryptPasswordEncoder();
		student.setS_pwd(bct.encode(student.getS_pwd()));
		student.setS_course(request.getParameter("test_course"));
		student.setS_sem(request.getParameter("test_sem"));

		List<Faculty> existingFaculty = facultyDAO.getEmail(student.getS_email());
		List<Student> existingStudent =studentDAO.getEmail(student.getS_email());
		 if(existingFaculty != null || existingStudent!=null)
	        {
	        	new ModelAndView("aaf3");
	        }
	          
		studentService.addStudent(student);
		String token= UUID.randomUUID().toString();
        ConfirmationToken configT=new ConfirmationToken();
        configT.setUsername(student.getS_username());
        configT.setEnable(false);
        configT.setToken(token);
        configT.setToken_id(configT.getToken_id());
        configTDAO.addConfirmationToken(configT);
        
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
	     simpleMessage.setTo(student.getS_email());
	     simpleMessage.setSubject("Complete Registration!");
	     simpleMessage.setText("To confirm your account, please click here : "+"http://localhost:8080/VerilogEvaluation/confirm-account?token="+configT.getToken());
	        
	        
	     mailSender.send(simpleMessage); 
			model.setViewName("fas2");
			return model;
	}
	
	@RequestMapping(value="/ffas2",method=RequestMethod.POST)
	public ModelAndView addCSVStudent(@RequestParam MultipartFile fileStudent, HttpSession session,ModelAndView model,HttpServletRequest request)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		BCryptPasswordEncoder bct=new BCryptPasswordEncoder();
		try
		{
			InputStream is = fileStudent.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String line="";
			
			while((line=br.readLine())!=null)
			{
				String[] data=line.split(",");
				Student std=new Student();
				std.setS_username(data[0]);
				std.setS_name(data[1]);
				std.setS_email(data[2]);
				std.setS_course(data[3]);
				std.setS_sem(data[4]);
				std.setS_pwd(bct.encode(data[0]));
				std.setF_username(session.getAttribute("username").toString());
				List<Faculty> existingFaculty = facultyDAO.getEmail(std.getS_email());
				List<Student> existingStudent =studentDAO.getEmail(std.getS_email());
				if(existingFaculty.isEmpty() && existingStudent.isEmpty())
			    {
					if(studentService.addStudent(std))
					{
						System.out.println("******");
							System.out.println("Added Student");
							System.out.println("******");
					}
					else
					{
						System.out.println("******");
							System.out.println("Error in adding");
							System.out.println("******");
					}
					String token= UUID.randomUUID().toString();
			        ConfirmationToken configT=new ConfirmationToken();
			        configT.setUsername(std.getS_username());
			        configT.setEnable(false);
			        configT.setToken(token);
			        configT.setToken_id(configT.getToken_id());
			        configTDAO.addConfirmationToken(configT);
			        
			        SimpleMailMessage simpleMessage = new SimpleMailMessage();
				     simpleMessage.setTo(std.getS_email());
				     simpleMessage.setSubject("Complete Registration!");
				     simpleMessage.setText("To confirm your account, please click here : "+"http://localhost:8080/VerilogEvaluation/confirm-account?token="+configT.getToken());
				        
				        
				     mailSender.send(simpleMessage);
			    }
				else
				{
					System.out.println("******");
					System.out.println("list is not null");
					System.out.println("******");
				}
			}
		}
		catch(Exception ex)
		{
			new ModelAndView("ffas2error");
		}
		
			model.setViewName("fas2");
			return model;
	}
	@RequestMapping(value="/ssp")
	public ModelAndView pagepwdStudent(HttpSession session,ModelAndView model)
	{
	
		if(session.getAttribute("username")==null)
		{
			model.setViewName("redirect:/");
			return model;
		}
		String usr=session.getAttribute("username").toString();
		model.addObject("s_username", usr);
		model.setViewName("ssp");
		return model;
	}
	@RequestMapping(value="/sp2", method=RequestMethod.POST)
	public ModelAndView pwdStudent3(HttpSession session,@RequestParam(value="s_username") String s_username,@RequestParam(value="s_pwd") String s_pwd)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		BCryptPasswordEncoder bct=new BCryptPasswordEncoder();
		s_pwd=bct.encode(s_pwd);
		if(studentService.pwdStudent(s_username,s_pwd))
		{
			return new ModelAndView("ssp2");
		}
		else
		{
			return new ModelAndView("ssp3");
		}
	}
}
