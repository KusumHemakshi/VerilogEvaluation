package com.service;

import java.util.List;

import com.entities.Submission;

public interface SubmissionService 
{
	public boolean addSubmission(Submission submission);
	public List<Submission> getSubmission(String test_id);
	public List<Submission> getSub(String test_id,String username);
	public List<Submission> downloadSubmission(String test_id, int que_no, String s_username);
}
