package com.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SubmissionDao;
import com.entities.Submission;
import com.entities.Transcript;
import com.service.SubmissionService;

@Service
@Transactional
public class SubmissionServiceImp implements SubmissionService 
{
	@Autowired
    private SubmissionDao subDAO;
	
	@Transactional
	public boolean addSubmission(Submission submission)
	{
		return subDAO.addSubmission(submission);
	}
	@Transactional
	public List<Submission> getSubmission(String test_id)
	{
		return subDAO.getSubmission(test_id);
	}
	@Transactional
	public List<Submission> getSub(String test_id,String username)
	{
		return subDAO.getSub(test_id,username);
	}
	
	@Transactional
	public List<Submission> downloadSubmission(String test_id, int que_no, String s_username)
	{
		return subDAO.downloadSubmission(test_id,que_no,s_username);
	}
	
}
