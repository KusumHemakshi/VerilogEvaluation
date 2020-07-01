package com.dao;

import java.sql.Timestamp;
import java.util.List;

import com.entities.Faculty;
import com.entities.Student;

public interface StudentDao 
{
	public boolean addStudent(Student student);
	public List<Student> list();
	public  List<Student> getStudent(String username);
	public boolean deleteStudent(String usr);
	public boolean updateStudent (String s_username, String pwd);
	public boolean timeDeleteStudent(Timestamp time);
	public List<Student> getEmail(String email);
}
