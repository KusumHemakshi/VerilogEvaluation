package com.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TranscriptDao;
import com.entities.Transcript;
import com.service.TranscriptService;

@Service
@Transactional
public class TranscriptServiceImp implements TranscriptService
{
	@Autowired
    private TranscriptDao transDAO;
	
	@Transactional
	public boolean addTranscript(Transcript transcript)
	{
//		System.out.println("Under ServiceImp");
		return transDAO.addTranscript(transcript);
	}
	
	@Transactional
	public List<Transcript> getTranscript(String test_id,String username)
	{
		return transDAO.getTranscript(test_id, username);
	}
	
	@Transactional
	public List<Transcript> downloadTranscript(String test_id, int que_no, String s_username)
	{
		return transDAO.downloadTranscript(test_id,que_no,s_username);
	}
}
