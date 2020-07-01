package com.service;

import java.util.List;

import com.entities.Transcript;

public interface TranscriptService 
{
	public boolean addTranscript(Transcript transcript);
	public List<Transcript> getTranscript(String test_id,String username);
	public List<Transcript> downloadTranscript(String test_id, int que_no, String s_username);
}
