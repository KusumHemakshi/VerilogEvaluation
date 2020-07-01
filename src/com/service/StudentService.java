package com.service;

import java.sql.Timestamp;
import java.util.List;

import com.entities.Student;

public interface StudentService 
{
	public boolean addStudent(Student student);
	public boolean validStudent(String username, String pwd);
	public List<Student> list();
	public boolean deleteStudent(String usr);
	public boolean pwdStudent(String s_username, String pwd);
	public boolean timeDeleteStudent(Timestamp time);
}
