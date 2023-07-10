package com.example.enquete_back.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enquete_back.repository.OptionDao;
import com.example.enquete_back.repository.QuestionDao;
import com.example.enquete_back.service.ifs.QuestionService;
import com.example.enquete_back.vo.response.SessionAddVo;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDao questionDao;
	@Autowired
	OptionDao optionDao;

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
	public List<SessionAddVo> deleteSessionQuestion(SessionAddVo sessionReq) {
		List<SessionAddVo> questions = (List<SessionAddVo>) sessionReq.getList();
		List<Integer> s = sessionReq.getSessions();
		if (s.size() == questions.size()) {
			questions.clear();
			return questions;
		}
		System.out.println(questions);
		System.out.println(s);
		int x = 0;
		for (x = s.size()- 1 ; x >= 0; x--) {
			questions.remove((int)s.get(x));
			System.out.println(s.get(x));
		}

		return questions;

	}

	@Override
	public List<SessionAddVo> addSessionQuestion(SessionAddVo sessionReq) {

		List<SessionAddVo> questions = (List<SessionAddVo>) sessionReq.getList();

		if (questions == null) {
			questions = new ArrayList<>();
		}
		Integer questionSessionId = sessionReq.getQuestionSessionId();
		Integer questionnaireId = sessionReq.getQuestionnaireId();
		Boolean questionType = sessionReq.getQuestionType();
		String questionText = sessionReq.getQuestionText();
		Boolean isRequired = sessionReq.getIsRequired();
		String options = sessionReq.getOptions();

		SessionAddVo add = new SessionAddVo(questionSessionId, questionnaireId, questionType, questionText, isRequired,
				options);
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
					List<String> textStr = new ArrayList<>();
					List<String> idStr = new ArrayList<>();
					for (Map<String, Object> map2 : res2) {
						for (String item2 : map2.keySet()) {
							switch (item2) {
							case "option_text":
								textStr.add((String) map2.get(item2));
								break;
							case "option_id":
								idStr.add(map2.get(item2).toString());
								break;
							}
						}
					}
					String opStr = String.join(";", textStr);
					String opIdStr = String.join(";", idStr);
					e.setOptions(opStr);
					e.setOptionsId(opIdStr);
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

	@Override
	public SessionAddVo editQuestionAndOption(SessionAddVo req) {
		Boolean type = req.getQuestionType();
		String text = req.getQuestionText();
		Boolean is = req.getIsRequired();
		Integer id = req.getQuestionId();
		questionDao.updateQuestion(type, text, is, id);

		String options = req.getOptions();
		String optionIds = req.getOptionsId();
		String[] opArr = options.split(";");
		String[] opIdArr = optionIds.split(";");

		if (opArr.length > opIdArr.length) {
			for (int i = 0; i <= opArr.length - 1; i++) {
				if (i <= opIdArr.length - 1) {
					optionDao.updateOptions(opArr[i], Integer.parseInt(opIdArr[i]));
				} else {
					optionDao.addOption(id, opArr[i]);
				}

			}
		} else if (opArr.length < opIdArr.length) {
			for (int i = 0; i <= opIdArr.length - 1; i++) {
				if (i <= opArr.length - 1) {
					optionDao.updateOptions(opArr[i], Integer.parseInt(opIdArr[i]));
				} else {
					optionDao.deleteQuestionOptions(Integer.parseInt(opIdArr[i]));
				}

			}
		} else {
			for (int i = 0; i <= opIdArr.length - 1; i++) {
				optionDao.updateOptions(opArr[i], Integer.parseInt(opIdArr[i]));
			}

		}

		return new SessionAddVo("更新完成");

	}

	@Override
	public SessionAddVo deleteQuestionAndOption(SessionAddVo sessionReq) {
		optionDao.deleteOptionsByQuestionId(sessionReq.getQuestionId());
		questionDao.deleteById(sessionReq.getQuestionId());

		return new SessionAddVo("刪除完成");

	};
//	@Override
//	public SessionAddVo deleteQuestionAndOption(SessionAddVo sessionReq) {
//		List<Integer> id = sessionReq.getSessions();
//		for(int x = 0; x < id.size(); x++) {
//		optionDao.deleteOptionsByQuestionId(id.get(x));
//		questionDao.deleteById(id.get(x));
//		}
//		return new SessionAddVo("刪除完成");
//
//	};

}
