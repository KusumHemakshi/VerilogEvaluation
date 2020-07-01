package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="submission")
public class Submission 
{
	@Column(name="s_username")
	private String s_username;
	
	@Column(name="test_id")
	private String test_id;
	
	@Column(name="que_no")
	private int que_no;
	
	@Column(name="file_no")
	private int file_no;
	
	@Column(name="ip")
	private String ip;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@Column(name="vfile_name")
	private String vfile_name;
	
	@Id
    @Column(name="file")
    private byte[] file;
	
	

	public int getFile_no() {
		return file_no;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVfile_name() {
		return vfile_name;
	}

	public void setVfile_name(String vfile_name) {
		this.vfile_name = vfile_name;
	}

	public String getS_username() {
		return s_username;
	}

	public void setS_username(String s_username) {
		this.s_username = s_username;
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

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
}
