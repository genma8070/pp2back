package com.example.enquete_back.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	
	@Override
	public List<SessionAddVo> addSessionQuestion(SessionAddVo sessionReq) {

		List<SessionAddVo> questions = (List<SessionAddVo>) sessionReq.getList();
	
		if (questions == null) {
			questions = new ArrayList<>();
		}
		Integer questionSessionId = questions.size() + 1;
		Integer questionnaireId = sessionReq.getQuestionnaireId();
		Boolean questionType = sessionReq.getQuestionType();
		String questionText = sessionReq.getQuestionText();
		Boolean isRequired = sessionReq.getIsRequired();
		String options = sessionReq.getOptions();

		SessionAddVo add = new SessionAddVo(questionSessionId, questionnaireId, questionType, questionText, isRequired, options);
		questions.add(add);

		return questions;
	}

	@Override
	public SessionAddVo findQuestionAndOptionsById(SessionAddVo sessionReq) {
		List<SessionAddVo> eList = new ArrayList<SessionAddVo>();
		List<Map<String, Object>> res = questionDao.findQuestionByQuestionnaireId(sessionReq.getQuestionnaireId());
		Integer i = 1;
		for (Map<String, Object> map : res) {
			SessionAddVo e = new SessionAddVo();
			for (String item : map.keySet()) {
				switch (item) {
				case "question_type":
					Object value = map.get(item);
					int intValue = Integer.parseInt(value.toString());
					if (intValue == 0) {
						e.setQuestionType(false);
					} else {
						e.setQuestionType(true);
					}
					break;
				case "question_text":
					e.setQuestionText((String) map.get(item));
					break;
				case "is_required":
					Object value2 = map.get(item);
					int intValue2 = Integer.parseInt(value2.toString());
					if (intValue2 == 0) {
						e.setIsRequired(false);
					} else {
						e.setIsRequired(true);
					}
					break;
				case "question_id":
					e.setQuestionId((Integer) map.get(item));
					e.setQuestionSessionId(i);
					i++;
					List<Map<String, Object>> res2 = optionDao.findOptionByQuestionId((Integer) map.get(item));
					List<String> str = new ArrayList<>();
					for (Map<String, Object> map2 : res2) {
						for (String item2 : map2.keySet()) {
							switch (item2) {
							case "option_text":
								str.add((String) map2.get(item2));
								break;
							}
						}
					}
					String opstr = String.join(";", str);
					e.setOptions(opstr);
					break;
				}
			}
			eList.add(e);
		}
		if (eList.size() == 0) {
			return new SessionAddVo();
		}
		return new SessionAddVo(eList);
	}

}

