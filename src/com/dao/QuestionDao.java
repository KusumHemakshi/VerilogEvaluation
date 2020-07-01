package com.dao;

import java.util.List;

import com.entities.Question;

public interface QuestionDao 
{
	public boolean addQuestion(Question question);
	public List<Question> listQuestion(String test);
	public List<Question> listQuestions(String test,int que);
	public void updateQuestion(String str, String que, int no_files, String cases);
	public boolean deleteQuestion(String test_id);
}