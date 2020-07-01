package com.service;

import java.util.List;

import com.entities.Question;

public interface QuestionService 
{
	public boolean addQuestion(String test_id,int que_no,String que,int no_files, String cases);
	public List<Question> listQuestion(String test);
	public List<Question> listQuestions(String test,int que);
	public void updateQuestion(String str, String que, int no_files,String cases);
}
