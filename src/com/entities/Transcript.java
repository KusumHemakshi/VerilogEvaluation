package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transcript")
public class Transcript 
{

	@Column(name="s_username")
	private String s_username;
	
	@Column(name="test_id")
	private String test_id;
	
	@Column(name="que_no")
	private int que_no;
	
	@Column(name="ip")
	private String ip;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@Column(name="tfile_name")
	private String tfile_name;
	
	@Id
    @Column(name="trans_file")
    private byte[] trans_file;

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

	public byte[] getTrans_file() {
		return trans_file;
	}

	public void setTrans_file(byte[] trans_file) {
		this.trans_file = trans_file;
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

	public String getTfile_name() {
		return tfile_name;
	}

	public void setTfile_name(String tfile_name) {
		this.tfile_name = tfile_name;
	}
	
}
