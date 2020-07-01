package com.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Student;
import com.entities.Submission;
import com.entities.Test;
import com.entities.TestLogin;
import com.entities.Transcript;
import com.service.StudentService;
import com.service.SubmissionService;
import com.service.TestLoginService;
import com.service.TestService;
import com.service.TranscriptService;

@Controller
public class SubmissionController 
{
	@Autowired
	TestService testService;
	
	@Autowired
	SubmissionService subService;
	
	@Autowired
	TestLoginService tlogService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	TranscriptService transService;
	
	@RequestMapping(value="/fot")
	public ModelAndView pagesubmissionTest(HttpSession session,ModelAndView model)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		List<Test> list=testService.listFaculty(session.getAttribute("username").toString());
		model.addObject("list",list);
		model.setViewName("fot");
		return model;
	}
	
	@RequestMapping(value="/fst")
	public ModelAndView pagesubmissionTestList(HttpSession session,ModelAndView model,HttpServletRequest request)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		String test=request.getParameter("id");
		List<Submission> sublist=subService.getSubmission(test);
		List<Student> stdlist=studentService.list();
		Map<String, String> map=new HashMap<String,String>();
		if(!sublist.isEmpty())
		{
			for(int i=0;i<sublist.size();i++)
			{
				for (Student std : stdlist) 
				{
					if (std.getS_username().equals(sublist.get(i).getS_username())) 
					{
						map.put(sublist.get(i).getS_username(),std.getS_name());
					}
		        }
		    }
		}
		model.addObject("id",test);
		model.addObject("map",map);
		model.setViewName("fsst");
		return model;
	}
	
	@RequestMapping(value="/fdt")
	public ModelAndView pagesubmissionTranscript(HttpSession session,ModelAndView model,HttpServletRequest request)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		String test=request.getParameter("test_id");
		String user=request.getParameter("user");
		List<Test> tList=testService.listTest(test);
		List<Transcript> transList=transService.getTranscript(test,user);
		model.addObject("test_id",test);
		model.addObject("user",user);
		model.addObject("tList",tList);
		model.addObject("transList",transList);
		model.setViewName("fdt");
		return model;
	}
	@RequestMapping(value="/fdv")
	public ModelAndView pagesubmissionVerilog(HttpSession session,ModelAndView model,HttpServletRequest request)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		String test=request.getParameter("test_id");
		String user=request.getParameter("user");
		List<Test> tList=testService.listTest(test);
		List<Submission> sList=subService.getSub(test,user);
		model.addObject("test_id",test);
		model.addObject("user",user);
		model.addObject("tList",tList);
		model.addObject("sList",sList);
		model.setViewName("fdv");
		return model;
	}
	@RequestMapping(value = { "/downloadTranscript"}, method = RequestMethod.GET)
	public ModelAndView downloadTranscript(HttpSession session,ModelAndView model,HttpServletRequest request, HttpServletResponse response)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		String test_id=request.getParameter("test_id");
		String que=request.getParameter("que");
		String user=request.getParameter("user");
		Transcript trans=transService.downloadTranscript(test_id, Integer.parseInt(que), user).get(0);
        response.setContentLength(trans.getTrans_file().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + trans.getTfile_name() +"\"");
        try
        {
        	FileCopyUtils.copy(trans.getTrans_file(), response.getOutputStream());
        	response.getOutputStream().flush(); 
        	response.getOutputStream().close(); 
        }
        catch(Exception ex)
        {
        	
        }
		String test=request.getParameter("test_id");
		List<Test> tList=testService.listTest(test);
		List<Transcript> transList=transService.getTranscript(test,user);
		model.addObject("test_id",test);
		model.addObject("user",user);
		model.addObject("tList",tList);
		model.addObject("transList",transList);
		model.setViewName("fdt");
		return model;
	}
	
	@RequestMapping(value = { "/downloadVerilog"}, method = RequestMethod.GET)
	public ModelAndView downloadSubmission(HttpSession session,ModelAndView model,HttpServletRequest request, HttpServletResponse response)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		String test_id=request.getParameter("test_id");
		String que=request.getParameter("que");
		String user=request.getParameter("user");
		Submission sub=subService.downloadSubmission(test_id, Integer.parseInt(que), user).get(0);
        response.setContentLength(sub.getFile().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + sub.getVfile_name() +"\"");
        try
        {
        	FileCopyUtils.copy(sub.getFile(), response.getOutputStream());
        	response.getOutputStream().flush(); 
        	response.getOutputStream().close(); 
        }
        catch(Exception ex)
        {
        	
        }
		String test=request.getParameter("test_id");
		List<Test> tList=testService.listTest(test);
		List<Submission> sList=subService.getSub(test,user);
		model.addObject("test_id",test);
		model.addObject("user",user);
		model.addObject("tList",tList);
		model.addObject("sList",sList);
		model.setViewName("fdv");
		return model;
	}
	
	@RequestMapping(value = { "/evaluateVerilog"}, method = RequestMethod.GET)
	public ModelAndView evaluateSubmission(HttpSession session,ModelAndView model,HttpServletRequest request, HttpServletResponse response)
	{
		if(session.getAttribute("username")==null)
		{
			return new ModelAndView("redirect:/");
		}
		String test_id=request.getParameter("test_id");
		String que=request.getParameter("que");
		String user=request.getParameter("user");
		Submission sub=subService.downloadSubmission(test_id, Integer.parseInt(que), user).get(0);
        response.setContentLength(sub.getFile().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + sub.getVfile_name() +"\"");
        String str="D:\\VerilogEvaluation\\"+sub.getTest_id()+"\\"+sub.getQue_no()+"\\"+sub.getFile_no()+"\\"+sub.getS_username();
        Path p1=Paths.get(str);
        try
        {

            Files.createDirectories(p1);
            
            str+="\\"+sub.getVfile_name();
            Blob blob=new SerialBlob(sub.getFile());
            InputStream dis = blob.getBinaryStream();
            String str1=sub.getVfile_name();
            
            byte[] fileData=sub.getFile();

            FileOutputStream fos= new FileOutputStream(new File(str)); //FILE Save Location goes here
            fos.write(fileData);  // write out the file we want to save.
            fos.close(); // close the output stream writer
        	response.getOutputStream().flush(); 
        	response.getOutputStream().close();
        }
        catch(Exception ex)
        {
        	
        }
		String test=request.getParameter("test_id");
		List<Test> tList=testService.listTest(test);
		List<Submission> sList=subService.getSub(test,user);
		model.addObject("test_id",test);
		model.addObject("user",user);
		model.addObject("tList",tList);
		model.addObject("sList",sList);
		model.setViewName("fdv");
		return model;
	}
	
}
