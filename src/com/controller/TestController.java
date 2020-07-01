package com.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.StudentDao;
import com.entities.Faculty;
import com.entities.File;
import com.entities.Question;
import com.entities.Student;
import com.entities.Submission;
import com.entities.Test;
import com.entities.TestLogin;
import com.entities.Transcript;
import com.service.FacultyService;
import com.service.FileService;
import com.service.QuestionService;
import com.service.SubmissionService;
import com.service.TestLoginService;
import com.service.TestService;
import com.service.TranscriptService;
import com.sun.org.apache.xpath.internal.axes.SubContextList;

@Controller
@MultipartConfig
public class TestController 
{
	
	@Autowired
	FacultyService facultyService;
	
	@Autowired
	TestService testService;
	
	@Autowired
	QuestionService questionService; 
	
	@Autowired
	SubmissionService submissionService;
	
	@Autowired
	TestLoginService testloginService;
	
	@Autowired
	TranscriptService transcriptService;
	
	@Autowired
	StudentDao studentDAO;
	
	@Autowired
	FileService fileService;
	
	
	@RequestMapping(value="/fnt")
	public ModelAndView pagenewTest(ModelAndView model,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		List<Faculty> flist = facultyService.list();
		model.addObject("flist", flist);
		String usr=session.getAttribute("username").toString();
		model.addObject("f_username", usr);
		model.setViewName("fnt");
		return model;
	}

	@RequestMapping(value="/frt")
	public ModelAndView pagepwdStudent2(HttpSession session,ModelAndView model)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		List<Test> tlist=testService.list();
		model.addObject("tlist", tlist);
		model.setViewName("frt");
			return model;
	}
	@RequestMapping(value="/ffet")
	public ModelAndView editTest(HttpServletRequest request,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		ModelAndView model=new ModelAndView();
		
		String test=request.getParameter("id");
		List<Test> testlist=testService.listTest(test);
		List<Question> quelist=questionService.listQuestion(test);
		String user=session.getAttribute("username").toString();
		model.addObject("f_username", user);
		model.addObject("testlist", testlist);
		model.addObject("quelist", quelist);
		model.setViewName("ffet");
		return model;
	}
	
	
	@RequestMapping(value="/ffrt", method=RequestMethod.GET)
	public ModelAndView removeTest(HttpServletRequest request,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		ModelAndView model=new ModelAndView();
		
		String test=request.getParameter("id");
		testService.deleteTest(test);
		List<Test> tlist=testService.list();
		model.addObject("tlist", tlist);
		model.setViewName("frt");
		return model;
	}
	
	@RequestMapping(value="/snt")
	public ModelAndView pagesubmitTest(HttpSession session,ModelAndView model,HttpServletRequest request)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		String test=request.getParameter("id");
		String usr=session.getAttribute("username").toString();
		TestLogin testl=new TestLogin();
		testl.setUsername(usr);
		testl.setTest_id(test);
		testl.setLogin(true);
		testl.setID(usr, test);
		
		List<Test> t_list=testService.listTest(test);
		List<Question> q_list=questionService.listQuestion(test);
		
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");  
	    Date dt = new Date();  
	    String strDate2 = formatter2.format(dt); 
		
	    String strDateFormat2="HH";
	    String strDateFormat3="mm";
		DateFormat dateFormat2=new SimpleDateFormat(strDateFormat2);
		int hour= Integer.parseInt(dateFormat2.format(dt));
		DateFormat dateFormat3=new SimpleDateFormat(strDateFormat3);
		int minutes= Integer.parseInt(dateFormat3.format(dt));
		int total=0;
		int hr=-10;
		int min=-10;
		if(t_list.get(0).getTest_endDate().toString().equals(strDate2))
		{
			total=(t_list.get(0).getTest_hr()*60+t_list.get(0).getTest_min())-(hour*60+minutes);
			hr=total/60;
			min=total%60;
		}
		model.addObject("t_list",t_list);
		model.addObject("q_list",q_list);
		model.addObject("usr",usr);
		model.addObject("hr",hr);
		model.addObject("min", min);
		model.setViewName("snt");
		return model;
	}
	@RequestMapping(value="/ffet1", method=RequestMethod.POST)
	public ModelAndView editTTest(Test test,HttpServletRequest request,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		testService.UpdateTest(test);
		ModelAndView model=new ModelAndView();
		model.setViewName("fffet");
		return model;
	}
	@RequestMapping(value="/ffet2", method=RequestMethod.POST)
	public ModelAndView editQuestion(Test test,HttpServletRequest request,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		String test_id=request.getParameter("test_id");
		int que_no=Integer.parseInt(request.getParameter("que_no"));
		String que=request.getParameter("que");
		int no_files=Integer.parseInt(request.getParameter("no_files"));
		String str=test_id+"_"+que_no;		
		String cases=request.getParameter("cases");	
		questionService.updateQuestion(str, que, no_files,cases);
		ModelAndView model=new ModelAndView();
		model.setViewName("fffet");
		return model;
	}
	
	@RequestMapping(value="/ssnt", method=RequestMethod.POST)
	public ModelAndView submitTest(@RequestParam CommonsMultipartFile[] fileUpload,@RequestParam CommonsMultipartFile[] trans,HttpSession session,HttpServletRequest request) throws Exception
	{
		if(session.getAttribute("username")==null)
		{
			System.out.println(session.getAttribute("username"));
			return new ModelAndView("redirect:/");
		}
		ModelAndView model=new ModelAndView();
		String s_username=session.getAttribute("username").toString();
		String test_id=request.getParameter("test_id");
		int ques=Integer.parseInt(request.getParameter("ques"));
		String str="";

		String ipAddress = request.getRemoteAddr();
		Date date=new Date();
		String strDateFormat="hh:mm:ss a";
		DateFormat dateFormat=new SimpleDateFormat(strDateFormat);
		String time= dateFormat.format(date);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date dte = new Date();  
	    String strDate = formatter.format(dte);
	    
	    
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
		
		String username=session.getAttribute("username").toString();
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
		
		
	    if (fileUpload != null && fileUpload.length > 0)
		{
	    	List<Submission> subList=new ArrayList<Submission>();
			int i=1;
			int j=1;
			for (CommonsMultipartFile aFile : fileUpload)
			{
				List<Question> qlist=questionService.listQuestions(test_id,i);
				int files=(qlist.get(0)).getNo_files();
				if(j>files)
				{
					j=1;
					i++;
				}
				if(!aFile.isEmpty()) //!aFile.getOriginalFilename().equals("")
				{
					str=test_id+i+j;
					File fl=fileService.getFile(str).get(0);
					String var1="fileUpload_"+Integer.toString(i)+Integer.toString(j);
					str+="Found file of "+var1+"\n";
					Submission sb=new Submission();
					sb.setS_username(s_username);
					sb.setQue_no(i);
					sb.setTest_id(test_id); 
					sb.setFile(aFile.getBytes());
					sb.setDate(strDate);
					sb.setTime(time);
					sb.setIp(ipAddress);
					sb.setVfile_name(aFile.getOriginalFilename());
					sb.setFile_no(j);
					
					InputStream is = aFile.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					String line,ll="";
					String fli = br.readLine();
					while((line = br.readLine()) != null)
					{
						ll=line;
					}
					br.close();
					if((fl.getFooter().equals(ll)) && (fl.getHeader().equals(fli)))
					{
						subList.add(sb);
					}	
					else
					{
						model.setViewName("ssnterr");
						return model;
					}
				 }
				 j++;
			 }
			while(!subList.isEmpty())
			   {
				   Submission sb=subList.remove(0);
				   submissionService.addSubmission(sb);
			   }
		 }
	   
		if (trans != null && trans.length > 0)
		{
			int i=1;
			for (CommonsMultipartFile aFile : trans)
			{
				if(!aFile.isEmpty())
				{
					Transcript transc=new Transcript();
					transc.setS_username(s_username);
					transc.setTest_id(test_id);
					transc.setQue_no(i);
					transc.setTrans_file(aFile.getBytes());
					transc.setDate(strDate);
					transc.setTime(time);
					transc.setIp(ipAddress);
					transc.setTfile_name(aFile.getOriginalFilename());
					transcriptService.addTranscript(transc);
				}
				i++;
			}
		}
		
		
		model.setViewName("welcomess");
		return model;
	}
	
	@RequestMapping(value="/fet")
	public ModelAndView pageeditTest(HttpSession session,ModelAndView model)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		String usr=session.getAttribute("username").toString();
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd"); 
			Date date= new Date();
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
			
			List<Test> t_list=testService.listFaculty(usr);
			List<Test> test=new ArrayList<Test>();
			
			for(Test t: t_list)
			{
				if(t.getTest_startDate().toString().equals(strDate2)||t.getTest_startDate().toString().compareTo(strDate2)>0)
					{
						if(t.getTest_startDate().toString().equals(strDate2))
						{
							total=(t.getTest_shr()*60+t.getTest_smin())-(hour*60+minutes);
							if(total>2)
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
		model.addObject("t_list",test);
		model.setViewName("fet");
		return model;
	}
	
	@RequestMapping(value="/fat", method=RequestMethod.POST)
	public ModelAndView addTest(Test test,HttpServletRequest request,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}

		String para="";
		int id=1;
		List<Test> lst=testService.list();
		if(!lst.isEmpty())
		{
			for(Test t: lst)
			{
				para=t.getTest_id();
			}
			id=Integer.parseInt(para);
			id++;
			para=Integer.toString(id);
		}
		else
		{
			para="1";
		}
		test.setTest_id(para);
		if(!testService.addTest(test))
		{
			return new ModelAndView("errornt");
		}
		int itr=Integer.parseInt(request.getParameter("no_que"));
		for(int i=1;i<=itr;i++)
		{
			String vr1="txtque_"+Integer.toString(i);
			String vr2="nt_"+Integer.toString(i);
			int var2=i;
			String var3=request.getParameter(vr1);
			int var4=Integer.parseInt(request.getParameter(vr2));
			String var7="cases_"+Integer.toString(i);
			var7=request.getParameter(var7);
			if(!questionService.addQuestion(para, var2, var3, var4,var7))
			{
				return new ModelAndView("ferrornt");
			}
			for(int j=1;j<=var4;j++)
			{
				String fname="format_"+i+"_"+j;
				String ffooter="footer_"+i+"_"+j;
				String fheader="header_"+i+"_"+j;;
				File file=new File();
				file.setTest_id(para);
				file.setQue_no(i);
				file.setFile_no(j);
				file.setFooter(request.getParameter(ffooter));
				file.setHeader(request.getParameter(fheader));
				file.setFile_name(request.getParameter(fname));
				file.setStr(para, i, j);
				if(!fileService.addFile(file))
					return new ModelAndView("ferrornt");
			}
		}
		return new ModelAndView("fnt2");
	}
	
	@RequestMapping(value="/fvt")
	public ModelAndView pageViewTest(HttpSession session,ModelAndView model)
	{

		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		String usr=session.getAttribute("username").toString();
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date= new Date();
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
		
		List<Test> t_list=testService.listFaculty(usr);
		List<Test> test=new ArrayList<Test>();
		for(Test t: t_list)
		{
			if(t.getTest_startDate().toString().equals(strDate2)||t.getTest_startDate().toString().compareTo(strDate2)<0)
			{
				if(t.getTest_startDate().toString().equals(strDate2))
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
		model.addObject("t_list",test);
		model.setViewName("fvt");
		return model;
	}
		
}
