 package com.serviceimp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dao.AdminDao;
import com.dao.FacultyDao;
import com.dao.StudentDao;
import com.entities.Admin;
import com.entities.Faculty;
import com.entities.Student;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
 
	@Autowired
	AdminDao adminDAO;
	 
    @Autowired
    FacultyDao facultyDAO;
	
	@Autowired
	StudentDao studentDAO;
     
    @Override
    public UserDetails loadUserByUsername(String usrname)throws UsernameNotFoundException 
    {
    	System.out.println("Reached to security block");
    	List<Admin> result1=adminDAO.getAdmin(usrname);
    	List<Faculty> result2=facultyDAO.getFaculty(usrname);
    	List<Student> result3=studentDAO.getStudent(usrname);
    	
    	Admin ad=result1.get(0);
    	Faculty fac=result2.get(0);
    	Student std=result3.get(0);
        
    	GrantedAuthority authority = new SimpleGrantedAuthority("");
    	User user =new User("","",Arrays.asList(authority));  		

        if(result1.isEmpty() && result2.isEmpty() && result3.isEmpty())
        {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        else if(!result1.isEmpty() && result2.isEmpty() && result3.isEmpty())
        {
        	System.out.println("Assigned role Admin");
        	GrantedAuthority authorityy = new SimpleGrantedAuthority("Admin");
        	user=new User(ad.getA_username(),ad.getA_pwd(),Arrays.asList(authorityy));
        }
        else if(result1.isEmpty() && !result2.isEmpty() && result3.isEmpty())
        {
        	System.out.println("Assigned role Faculty");
        	GrantedAuthority authorityy = new SimpleGrantedAuthority("Faculty");
        	user=new User(fac.getF_username(),fac.getF_pwd(),Arrays.asList(authorityy));	
        }
        else if(result1.isEmpty() && result2.isEmpty() && !result3.isEmpty())
        {
        	System.out.println("Assigned role Student");
        	GrantedAuthority authorityy = new SimpleGrantedAuthority("Student");
        	user=new User(std.getS_username(),std.getS_pwd(),Arrays.asList(authorityy));
        }
        System.out.println("User : "+user);
      
        UserDetails userDetails = (UserDetails)user;
        
        return userDetails;
    }  
}