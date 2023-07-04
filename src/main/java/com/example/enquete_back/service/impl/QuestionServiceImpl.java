package com.example.enquete_back.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enquete_back.repository.OptionDao;
import com.example.enquete_back.repository.QuestionDao;
import com.example.enquete_back.service.ifs.QuestionService;
import com.example.enquete_back.vo.request.QuestionRequest;
import com.example.enquete_back.vo.response.QuestionResponse;
import com.example.enquete_back.vo.response.SessionAddVo;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDao questionDao;
	@Autowired
	OptionDao optionDao;

	@Override
	public QuestionResponse addQuestion(QuestionRequest newReq) {

		Boolean questionType = newReq.getQuestionType();
		Integer questionnaireId = newReq.getQuestionId();
		String questionText = newReq.getQuestionText();
		Boolean isRequired = newReq.getIsRequired();
		questionDao.addQuestion(questionType, questionnaireId, questionText, isRequired);

		return new QuestionResponse();

	}

	@Override
	public SessionAddVo addQuestion(SessionAddVo sessionReq) {
		List<SessionAddVo> add = (List<SessionAddVo>) sessionReq.getList();
		for (SessionAddVo items : add) {
			Boolean questionType = items.getQuestionType();
			Integer questionnaireId = items.getQuestionnaireId();
			String questionText = items.getQuestionText();
			Boolean isRequired = items.getIsRequired();
			questionDao.addQuestion(questionType, questionnaireId, questionText, isRequired);
			Integer questionId = questionDao.findNewstQuestion().getQuestionId();
			String options = items.getOptions();
			String[] opArr = options.split(";");
			for (String op : opArr) {
				optionDao.addOption(questionId, op);
			}
		}
		return new SessionAddVo();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SessionAddVo> addSessionQuestion(SessionAddVo sessionReq) {

		List<SessionAddVo> questions = (List<SessionAddVo>) sessionReq.getList();
		System.out.println(questions);
		if (questions == null) {
			questions = new ArrayList<>();
		}
		Integer questionnaireId = sessionReq.getQuestionnaireId();
		Boolean questionType = sessionReq.getQuestionType();
		String questionText = sessionReq.getQuestionText();
		Boolean isRequired = sessionReq.getIsRequired();
		String options = sessionReq.getOptions();

		SessionAddVo add = new SessionAddVo(questionnaireId, questionType, questionText, isRequired, options);
		questions.add(add);

		System.out.println(questions.get(0));

		return questions;
	}

//	@Override
//	public QuestionResponse addQuestion(QuestionRequest newReq, Integer questionnaireId) {
//	    Question question = new Question();
//	    question.setQuestionType(newReq.getQuestionType());
//	    question.setQuestionnaireId(questionnaireId);
//	    question.setQuestionText(newReq.getQuestionText());
//	    question.setIsRequired(newReq.getIsRequired());
//	    questionDao.save(question);
//	    
//	    return null;
//	}

}
