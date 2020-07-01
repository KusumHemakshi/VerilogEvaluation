package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Test 
{
	@Id
	@Column(name="test_id")
	private String test_id;

	@Column(name="test_name")
	private String test_name;
	
	@Column(name="test_hr")
	private int test_hr;
	
	@Column(name="test_min")
	private int test_min;

	@Column(name="no_que")
	private int no_que;

	@Column(name="f_username")
	private String f_username;
	
	@Column(name="test_sem")
	private String test_sem;
	
	@Column(name="test_course")
	private String test_course;
	
	@Column(name="test_endDate")
	private String test_endDate;
	
	@Column(name="test_startDate")
	private String test_startDate;
	
	@Column(name="test_shr")
	private int test_shr;
	
	@Column(name="test_smin")
	private int test_smin;
	

	public String getTest_sem() {
		return test_sem;
	}

	public void setTest_sem(String test_sem) {
		this.test_sem = test_sem;
	}

	public String getTest_course() {
		return test_course;
	}

	public void setTest_course(String test_course) {
		this.test_course = test_course;
	}

	public String getTest_endDate() {
		return test_endDate;
	}

	public void setTest_endDate(String test_endDate) {
		this.test_endDate = test_endDate;
	}

	public String getTest_id() {
		return test_id;
	}

	public void setTest_id(String test_id) {
		this.test_id = test_id;
	}

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	

	public int getTest_hr() {
		return test_hr;
	}

	public void setTest_hr(int test_hr) {
		this.test_hr = test_hr;
	}

	public int getTest_min() {
		return test_min;
	}

	public void setTest_min(int test_min) {
		this.test_min = test_min;
	}

	public int getNo_que() {
		return no_que;
	}

	public void setNo_que(int no_que) {
		this.no_que = no_que;
	}

	public String getF_username() {
		return f_username;
	}

	public void setF_username(String f_username) {
		this.f_username = f_username;
	}

	public String getTest_startDate() {
		return test_startDate;
	}

	public void setTest_startDate(String test_startDate) {
		this.test_startDate = test_startDate;
	}

	public int getTest_shr() {
		return test_shr;
	}

	public void setTest_shr(int test_shr) {
		this.test_shr = test_shr;
	}

	public int getTest_smin() {
		return test_smin;
	}

	public void setTest_smin(int test_smin) {
		this.test_smin = test_smin;
	}
}
