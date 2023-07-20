package com.example.enquete_back.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enquete_back.entity.Options;
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

//	新增問題
	@Override
	public SessionAddVo addQuestion(SessionAddVo sessionReq) {
//		從session取得問題選項
		List<SessionAddVo> add = (List<SessionAddVo>) sessionReq.getList();
		
//		將取得的內容逐個存入db
		for (SessionAddVo items : add) {
			Boolean questionType = items.getQuestionType();
			Integer questionnaireId = items.getQuestionnaireId();
			String questionText = items.getQuestionText();
			Boolean isRequired = items.getIsRequired();
			questionDao.addQuestion(questionType, questionnaireId, questionText, isRequired);
//			存入問券後取得ai生成的id
			Integer questionId = questionDao.findNewstQuestion().getQuestionId();
//			將取得的選項字串切開成矩陣分批存入db
			String options = items.getOptions();
			String[] opArr = options.split(";");
			for (String op : opArr) {
				optionDao.addOption(questionId, op);
			}
		}

		return new SessionAddVo("成功新增");

	}

//	刪除選中的存在SESSION內的問題
	@Override
	public List<SessionAddVo> deleteSessionQuestion(SessionAddVo sessionReq) {
//		取出目前session內的資料
		List<SessionAddVo> questions = (List<SessionAddVo>) sessionReq.getList();
//		勾選中的問題數
		List<Integer> s = sessionReq.getSessions();
//		若全選則清空list
		if (s.size() == questions.size()) {
			questions.clear();
			return questions;
		}
//		迴圈遍歷刪除勾選中的資料
		int x = 0;
		for (x = s.size() - 1; x >= 0; x--) {
			questions.remove((int) s.get(x));
		}
//		返回要存回session的list
		return questions;

	}

//	新增問題進入SESSION
	@Override
	public List<SessionAddVo> addSessionQuestion(SessionAddVo sessionReq) {
//		將目前的session資料取出
		List<SessionAddVo> questions = (List<SessionAddVo>) sessionReq.getList();
//		如果沒有session資料則新增一個空的
		if (questions == null) {
			questions = new ArrayList<>();
		}
//		將要存入session的資料分次存進add後加入list返回
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

//	用問卷ID找出其問題及選項，將選項和選項ID存成字串
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
			return new SessionAddVo("查無資料");
		}
		return new SessionAddVo(eList);
	}

//	用問卷ID找出其問題及選項
	@Override
	public SessionAddVo getQuestionAndOptionsById(SessionAddVo sessionReq) {
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
					List<Options> opList = new ArrayList<>();

					for (Map<String, Object> map2 : res2) {
						Options op = new Options();
						for (String item2 : map2.keySet()) {

							switch (item2) {
							case "option_text":
								op.setOptionText((String) map2.get(item2));
								break;
							case "question_id":
								op.setQuestionId(e.getQuestionId());
								break;
							case "option_id":
								op.setOptionId((Integer) map2.get(item2));
								break;
							}

						}
						opList.add(op);
					}
					e.setOp(opList);
					break;
				}
			}
			eList.add(e);
		}
		if (eList.size() == 0) {
			return new SessionAddVo("查無資料");
		}
		return new SessionAddVo(eList);
	}

//	更新問題選項
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

//		判斷編輯時是否新增問題並更新已有問題
		if (opArr.length > opIdArr.length) {
			for (int i = 0; i <= opArr.length - 1; i++) {
				if (i <= opIdArr.length - 1) {
					optionDao.updateOptions(opArr[i], Integer.parseInt(opIdArr[i]));
				} else {
					optionDao.addOption(id, opArr[i]);
				}

			}
//		判斷編輯時是否刪除問題並更新已有問題
		} else if (opArr.length < opIdArr.length) {
			for (int i = 0; i <= opIdArr.length - 1; i++) {
				if (i <= opArr.length - 1) {
					optionDao.updateOptions(opArr[i], Integer.parseInt(opIdArr[i]));
				} else {
					optionDao.deleteQuestionOptions(Integer.parseInt(opIdArr[i]));
				}

			}
//		判斷是否只須更新
		} else {
			for (int i = 0; i <= opIdArr.length - 1; i++) {
				optionDao.updateOptions(opArr[i], Integer.parseInt(opIdArr[i]));
			}

		}

		return new SessionAddVo("更新完成");

	}

//	刪除問題選項
	@Override
	public SessionAddVo deleteQuestionAndOption(SessionAddVo sessionReq) {
//		因應外來鍵從尾端刪起
		optionDao.deleteOptionsByQuestionId(sessionReq.getQuestionId());
		questionDao.deleteById(sessionReq.getQuestionId());

		return new SessionAddVo("刪除完成");

	};

}
