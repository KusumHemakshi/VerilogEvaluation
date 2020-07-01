package com.controller;


import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ConfirmationTokenDao;
import com.dao.StudentDao;
import com.entities.ConfirmationToken;
import com.entities.LoginIP;
import com.entities.Student;
import com.entities.Test;
import com.recaptcha.VerifyRecaptcha;
import com.service.AdminService;
import com.service.FacultyService;
import com.service.LoginIPService;
import com.service.StudentService;
import com.service.TestService;

@Controller
public class WelcomeController 
{
	@Autowired
	FacultyService facultyService; 
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	TestService testService;
	
	@Autowired
	LoginIPService logService;
	
	@Autowired
	StudentDao studentDAO;
	
	@Autowired
	ConfirmationTokenDao confirT;
	
	@RequestMapping(value="//errorpage")
	public ModelAndView errorPage(HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
			return new ModelAndView("errorpage");
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public ModelAndView checkUser(HttpServletRequest request,HttpSession session,ModelAndView model) throws IOException,ParseException
	{
		
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		String response = request.getParameter("g-recaptcha-response");
		
		String ipAddress = request.getRemoteAddr();
		
		boolean verify = VerifyRecaptcha.verify(response,ipAddress);
		if(verify)
		{
//			System.out.println("Captcha Successful");
		}
		else
		{
			String msg="<font color=red>You missed the Captcha.</font>";
			return new ModelAndView("errorpage1","message",msg);
		}
		
		Date date=new Date();
		String strDateFormat="hh:mm:ss a";
		DateFormat dateFormat=new SimpleDateFormat(strDateFormat);
		
		
		String time= dateFormat.format(date);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date dte = new Date();  
	    String strDate = formatter.format(dte); 
		
		logService.addLoginIP(username, ipAddress,strDate, time);
		
		
		if(facultyService.validFaculty(username,pwd))
		{
			List<ConfirmationToken> lt=confirT.getConfirmation(username);
			if(lt.isEmpty() || (lt.get(0).isEnable()==false))
			{
				return new ModelAndView("errorpage2");
			}
			session.setAttribute("username", username);
			Timestamp timeStamp = new Timestamp(new Date().getTime());
			studentService.timeDeleteStudent(timeStamp);
			model.setViewName("welcomef");
			return model;
		}
		else if(adminService.validAdmin(username,pwd))
		{
			session.setAttribute("username", username);
			List<LoginIP> list=logService.allLoginIP();
			model.addObject("list",list);
			model.setViewName("welcomea");
			return model;
		}
		else if(studentService.validStudent(username,pwd))
		{
			List<ConfirmationToken> lt=confirT.getConfirmation(username);
			if(lt.isEmpty() || (lt.get(0).isEnable()==false))
			{
				return new ModelAndView("errorpage2");
			}
			session.setAttribute("username", username);
			
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");  
		    Date dt = new Date();  
		    String strDate2 = formatter2.format(dt); 
			
		    String strDateFormat2="HH";
		    String strDateFormat3="mm";
			DateFormat dateFormat2=new SimpleDateFormat(strDateFormat2);
			int hour= Integer.parseInt(dateFormat2.format(date));
			DateFormat dateFormat3=new SimpleDateFormat(strDateFormat3);
			int minutes= Integer.parseInt(dateFormat3.format(date));
			
			int hr=-10;
			int min=-10;
			int total=0;
			
			String user=username;
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
			model.addObject("hr",hr);
			model.addObject("min",min);
			model.addObject("t_list",test);
			model.setViewName("welcomes");
			return model;
		}
		else
		{
			String msg="Incorrect Username or Password";
			return new ModelAndView("errorpage","message",msg);
		}
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)  
    public String username(HttpSession session) 
	{
		session.removeAttribute("username");
		System.err.println(session.getAttribute("username"));
		session.invalidate();
         return "redirect:/";  
     }
	
	
	@RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
    {
        List<ConfirmationToken> token = confirT.findToken(confirmationToken);

        if(!token.isEmpty())
        {
        	confirT.setEnable(confirmationToken);
        	return new ModelAndView("errorpage3");
        }
        return new ModelAndView("errorpage4");
    }
}