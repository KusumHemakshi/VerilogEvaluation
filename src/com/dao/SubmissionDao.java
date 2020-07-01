package com.dao;

import java.util.List;

import com.entities.Submission;
import com.entities.Transcript;

public interface SubmissionDao 
{
	public boolean addSubmission(Submission submission);
	public boolean deleteSubmision(String username);
	public boolean addSub(String test_id);
	public List<Submission> getSubmission(String test_id);
	public List<Submission> getSub(String test_id,String username);
	public List<Submission> downloadSubmission(String test_id, int que_no, String s_username);
}
