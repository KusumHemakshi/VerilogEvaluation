package com.entities;

import javax.persistence.*;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;


@Entity
@Table(name="student")
public class Student 
{
	@Id
	@Column(name="s_username")
	private String s_username;
	
	@Column(name="s_name")
	private String s_name;
	
	@Column(name="s_pwd")
	private String s_pwd;
	
	@Email
	@Column(name="s_email")
	private String s_email;
	
	@Column(name="s_sem")
	private String s_sem;
	
	@Column(name="s_course")
	private String s_course;
	
public String getS_sem() {
		return s_sem;
	}

	public void setS_sem(String s_sem) {
		this.s_sem = s_sem;
	}

	public String getS_course() {
		return s_course;
	}

	public void setS_course(String s_course) {
		this.s_course = s_course;
	}

	//	@ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="f_username")//,nullable=false
//    private Faculty faculty;
	@Column(name="f_username")
	private String f_username;

	public String getS_username() {
		return s_username;
	}

	public void setS_username(String s_username) {
		this.s_username = s_username;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_pwd() {
		return s_pwd;
	}

	public void setS_pwd(String s_pwd) {
		this.s_pwd = s_pwd;
	}

	public String getS_email() {
		return s_email;
	}

	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public String getF_username() {
		return f_username;
	}

	public void setF_username(String f_username) {
		this.f_username = f_username;
	}
}
