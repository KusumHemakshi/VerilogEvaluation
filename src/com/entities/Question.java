package com.entities;

import javax.persistence.*;

@Entity
@Table(name="question")
public class Question 
{
	@Column(name="test_id")
	private String test_id;

	@Column(name="que_no")
	private int que_no;

	@Id
	@Column(name="str")
	private String str;
	
	@Column(name="que")
	private String que;

	@Column(name="no_files")
	private int no_files;
	
	@Column(name="que_cases")
	private String que_cases;

	public String getQue_cases() {
		return que_cases;
	}

	public void setQue_cases(String que_cases) {
		this.que_cases = que_cases;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getTest_id() {
		return test_id;
	}

	public void setTest_id(String test_id) {
		this.test_id = test_id;
	}

	public int getQue_no() {
		return que_no;
	}

	public void setQue_no(int que_no) {
		this.que_no = que_no;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String test_id,int que_no) 
	{
		this.str = test_id+"_"+que_no;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public int getNo_files() {
		return no_files;
	}

	public void setNo_files(int no_files) {
		this.no_files = no_files;
	}
}
