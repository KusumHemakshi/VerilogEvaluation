package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="file")
public class File 
{
	@Id
	@Column(name="str")
	private String str;
	
	@Column(name="test_id")
	private String test_id;
	
	@Column(name="que_no")
	private int que_no; 
	
	@Column(name="file_no")
	private int file_no;
	
	@Column(name="header")
	private String header;
	
	@Column(name="footer")
	private String footer;
	
	@Column(name="file_name")
	private String file_name;

	public String getStr() {
		return str;
	}

	public void setStr(String test_id, int que_no, int file_no) 
	{
		this.str = test_id+que_no+file_no;
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

	public int getFile_no() {
		return file_no;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
}
