package com.example.enquete_back.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enquete_back.entity.Questionnaire;
import com.example.enquete_back.repository.QuestionnaireDao;
import com.example.enquete_back.service.ifs.QuestionnaireService;
import com.example.enquete_back.vo.request.QuestionnaireRequest;
import com.example.enquete_back.vo.response.QuestionnaireResponse;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	QuestionnaireDao questionnaireDao;

	@Override
	public QuestionnaireResponse updateEnquete(QuestionnaireRequest newReq) {
		LocalDate now = LocalDate.now();
		LocalDate startTime = newReq.getStartTime() != null ? newReq.getStartTime() : LocalDate.now();
		LocalDate endTime = newReq.getEndTime() != null ? newReq.getEndTime() : startTime.plusDays(7);
		int startDate = startTime.compareTo(now);
		int endDate = endTime.compareTo(now);
		if (startTime.compareTo(endTime) > 0 || endTime.compareTo(startTime) <= 0) {
			return new QuestionnaireResponse();
		}
		String title = newReq.getTitle();
		String description = newReq.getDescription();
		Boolean status = (startDate <= 0 && endDate >= 0) ? true : false;
		Integer id = newReq.getQuestionnaireId();
		questionnaireDao.updateEnquete(title, description, startTime, endTime, status, id);

		return new QuestionnaireResponse();

	}

	@Override
	public QuestionnaireResponse addEnquete(QuestionnaireRequest newReq) {
		LocalDate now = LocalDate.now();
		LocalDate startTime = newReq.getStartTime() != null ? newReq.getStartTime() : LocalDate.now();
		LocalDate endTime = newReq.getEndTime() != null ? newReq.getEndTime() : startTime.plusDays(7);
		int startDate = startTime.compareTo(now);
		int endDate = endTime.compareTo(now);
		if (startTime.compareTo(endTime) > 0 || endTime.compareTo(startTime) <= 0) {
			return new QuestionnaireResponse();
		}
		String title = newReq.getTitle();
		String description = newReq.getDescription();
		Boolean status = (startDate <= 0 && endDate >= 0) ? true : false;
		questionnaireDao.addEnquete(title, description, startTime, endTime, status);

		return new QuestionnaireResponse();

	}

	@Override
	public QuestionnaireResponse findAllEnquete(QuestionnaireRequest newReq) {
		List<QuestionnaireResponse> eList = new ArrayList<QuestionnaireResponse>();
		Integer index = newReq.getIndex();

		List<Map<String, Object>> res = questionnaireDao.findAllQuestionnairePaging(index);

		for (Map<String, Object> map : res) {
			QuestionnaireResponse e = new QuestionnaireResponse();
			for (String item : map.keySet()) {
				switch (item) {
				case "questionnaire_id":
					e.setQuestionnaireId((Integer) map.get(item));
					break;
				case "title":
					e.setTitle((String) map.get(item));
					break;
				case "description":
					e.setDescription((String) map.get(item));
					break;
				case "start_time":
					e.setStartTime(((Date) map.get(item)).toLocalDate());
					break;
				case "end_time":
					e.setEndTime(((Date) map.get(item)).toLocalDate());
					break;
				case "status":
					Object value = map.get(item);
					int intValue = Integer.parseInt(value.toString());
					if (intValue == 0) {
						e.setStatus(false);
					} else {
						e.setStatus(true);
					}
					break;
				}
			}
			eList.add(e);
		}
		if (eList.size() == 0) {
			return new QuestionnaireResponse();
		}
		return new QuestionnaireResponse(eList);
	}
	@Override
	public QuestionnaireResponse findNewst() {
		Questionnaire q = questionnaireDao.findNewstEnquete();
		QuestionnaireResponse e = new QuestionnaireResponse();
		
		e.setQuestionnaireId(q.getQuestionnaireId());
		return e;
	}

	@Override
	public QuestionnaireResponse findAll() {
		List<QuestionnaireResponse> eList = new ArrayList<QuestionnaireResponse>();

		List<Map<String, Object>> res = questionnaireDao.findAllQuestionnaire();

		for (Map<String, Object> map : res) {
			QuestionnaireResponse e = new QuestionnaireResponse();
			for (String item : map.keySet()) {
				switch (item) {
				case "questionnaire_id":
					e.setQuestionnaireId((Integer) map.get(item));
					break;
				case "title":
					e.setTitle((String) map.get(item));
					break;
				case "description":
					e.setDescription((String) map.get(item));
					break;
				case "start_time":
					e.setStartTime(((Date) map.get(item)).toLocalDate());
					break;
				case "end_time":
					e.setEndTime(((Date) map.get(item)).toLocalDate());
					break;
				case "status":
					Object value = map.get(item);
					int intValue = Integer.parseInt(value.toString());
					if (intValue == 0) {
						e.setStatus(false);
					} else {
						e.setStatus(true);
					}
					break;
				}
			}
			eList.add(e);
		}
		if (eList.size() == 0) {
			return new QuestionnaireResponse();
		}
		return new QuestionnaireResponse(eList);
	}

	@Override
	public QuestionnaireResponse findQuestionnaireByTitleOrDate(QuestionnaireRequest newReq) {
		String title = newReq.getTitle();
		LocalDate st = newReq.getStartTime();
		LocalDate et = newReq.getEndTime();
		Integer index = newReq.getIndex();
		List<QuestionnaireResponse> eList = new ArrayList<QuestionnaireResponse>();

		List<Map<String, Object>> res = questionnaireDao.findQuestionnaireByTitleOrDate(title, st, et, index);

		for (Map<String, Object> map : res) {
			QuestionnaireResponse e = new QuestionnaireResponse();
			for (String item : map.keySet()) {
				switch (item) {
				case "questionnaire_id":
					e.setQuestionnaireId((Integer) map.get(item));
					break;
				case "title":
					e.setTitle((String) map.get(item));
					break;
				case "description":
					e.setDescription((String) map.get(item));
					break;
				case "start_time":
					e.setStartTime(((Date) map.get(item)).toLocalDate());
					break;
				case "end_time":
					e.setEndTime(((Date) map.get(item)).toLocalDate());
					break;
				case "status":
					Object value = map.get(item);
					int intValue = Integer.parseInt(value.toString());
					if (intValue == 0) {
						e.setStatus(false);
					} else {
						e.setStatus(true);
					}
					break;
				}
			}
			eList.add(e);
		}
		if (eList.size() == 0) {
			return new QuestionnaireResponse();
		}
		return new QuestionnaireResponse(eList);
	}

	@Override
	public QuestionnaireResponse deleteEnquete(QuestionnaireRequest newReq) {
		List<Integer> id = newReq.getId();
		int x = 0;
		for (x = 0; x < id.size(); x++) {
			questionnaireDao.deleteEnqueteOptions(id.get(x));
			questionnaireDao.deleteEnqueteAnswer(id.get(x));
			questionnaireDao.deleteEnqueteQuestion(id.get(x));
			questionnaireDao.deleteEnqueteEnquete(id.get(x));
		}
		return new QuestionnaireResponse();
	}

	@Override
	public QuestionnaireResponse findById(QuestionnaireRequest newReq) {
		List<QuestionnaireResponse> eList = new ArrayList<QuestionnaireResponse>();

		List<Map<String, Object>> res = questionnaireDao.findByQuestionnaireId(newReq.getQuestionnaireId());

		for (Map<String, Object> map : res) {
			QuestionnaireResponse e = new QuestionnaireResponse();
			for (String item : map.keySet()) {
				switch (item) {
				case "questionnaire_id":
					e.setQuestionnaireId((Integer) map.get(item));
					break;
				case "title":
					e.setTitle((String) map.get(item));
					break;
				case "description":
					e.setDescription((String) map.get(item));
					break;
				case "start_time":
					e.setStartTime(((Date) map.get(item)).toLocalDate());
					break;
				case "end_time":
					e.setEndTime(((Date) map.get(item)).toLocalDate());
					break;
				case "status":
					Object value = map.get(item);
					int intValue = Integer.parseInt(value.toString());
					if (intValue == 0) {
						e.setStatus(false);
					} else {
						e.setStatus(true);
					}
					break;
				}
			}
			eList.add(e);
		}
		if (eList.size() == 0) {
			return new QuestionnaireResponse();
		}
		return new QuestionnaireResponse(eList);
	}
}
