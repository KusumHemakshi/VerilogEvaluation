package com.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.QuestionDao;
import com.entities.Question;
import com.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImp implements QuestionService 
{
	@Autowired
    private QuestionDao questionDAO;
	
	@Transactional
	public void updateQuestion(String str, String que, int no_files,String cases)
	{
		questionDAO.updateQuestion(str, que, no_files,cases);
	}
	

	@Transactional
	public boolean addQuestion(String test_id, int que_no, String que, int no_files, String cases) 
	{
		Question question=new Question();
		question.setTest_id(test_id);
		question.setQue_no(que_no);
		question.setQue(que);
		question.setNo_files(no_files);
		question.setStr(test_id, que_no);
		question.setQue_cases(cases);
		return questionDAO.addQuestion(question);
	}
	@Transactional
	public List<Question> listQuestion(String test)
	{
		return questionDAO.listQuestion(test);
	}

	@Transactional
	public List<Question> listQuestions(String test,int que)
	{
		return questionDAO.listQuestions(test,que);
	}
}
