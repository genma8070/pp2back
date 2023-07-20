package com.example.enquete_back.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enquete_back.repository.AnswerDao;
import com.example.enquete_back.service.ifs.AnswerService;
import com.example.enquete_back.vo.request.AnswerRequest;
import com.example.enquete_back.vo.response.AnswerResponse;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	AnswerDao answerDao;

//	新增回答
	@Override
	public AnswerResponse addAnswer(AnswerRequest req) {
		LocalDateTime currentDateTime = LocalDateTime.now();

		// 创建自定义的格式模式，包含年、月、日、小时和分钟
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		// 格式化LocalDateTime对象为字符串
		String formattedDateTime = currentDateTime.format(formatter);
		answerDao.addAnswer(req.getQuestionnaireId(), req.getSelectedOptions(), req.getAnswerName(),
				req.getAnswerPhone(), req.getAnswerEmail(), req.getAnswerAge(), formattedDateTime);
		return new AnswerResponse("感謝填寫");

	}

//	取得畫統計圖需要用到的資料
	@Override
	public AnswerResponse getGraphData(AnswerRequest req) {
		List<AnswerResponse> eList = new ArrayList<AnswerResponse>();
		List<Map<String, Object>> res = answerDao.getAnswerDataByEnqueteId(req.getQuestionnaireId());

		for (Map<String, Object> map : res) {
			AnswerResponse e = new AnswerResponse();
			for (String item : map.keySet()) {
				switch (item) {

				case "selected_options":
					e.setSelectedOptions((String) map.get(item));
					break;

				}
			}
			eList.add(e);
		}
		if (eList.size() == 0) {
			return new AnswerResponse("目前尚無人填寫此問券");
		}
		return new AnswerResponse(eList);
	}

//	取得該分頁的回答者資料
	@Override
	public AnswerResponse getAllAnswer() {

		List<AnswerResponse> eList = new ArrayList<AnswerResponse>();

		List<Map<String, Object>> res = answerDao.findAllAnswer();

		for (Map<String, Object> map : res) {
			AnswerResponse e = new AnswerResponse();
			for (String item : map.keySet()) {
				switch (item) {
				case "answer_id":
					e.setAnswerId((Integer) map.get(item));
					break;
				case "questionnaire_id":
					e.setQuestionnaireId((Integer) map.get(item));
					break;
				case "selected_options":
					e.setSelectedOptions((String) map.get(item));
					break;
				case "answer_name":
					e.setAnswerName(((String) map.get(item)));
					break;
				case "answer_phone":
					e.setAnswerPhone(((String) map.get(item)));

					break;

				case "answer_email":
					e.setAnswerEmail(((String) map.get(item)));
					break;

				case "answer_age":
					e.setAnswerAge(((Integer) map.get(item)));
					break;

				case "answer_time":
					String originalDateTime = map.get(item).toString();
					String formattedDateTime = convertDateTime(originalDateTime, "yyyy-MM-dd HH:mm:ss.S");
					e.setAnswerTime(formattedDateTime);
					break;
				}
			}
			eList.add(e);
		}
		if (eList.size() == 0) {
			return new AnswerResponse("此頁無資料");
		}
		return new AnswerResponse(eList);
	}

//	用id找尋該回答者資料
	@Override
	public AnswerResponse findAnswerById(AnswerRequest req) {
		List<AnswerResponse> eList = new ArrayList<AnswerResponse>();

		Integer Id = req.getAnswerId();
		List<Map<String, Object>> res = answerDao.findAnswerById(Id);

		for (Map<String, Object> map : res) {
			AnswerResponse e = new AnswerResponse();
			for (String item : map.keySet()) {
				switch (item) {
				case "answer_id":
					e.setAnswerId((Integer) map.get(item));
					break;
				case "questionnaire_id":
					e.setQuestionnaireId((Integer) map.get(item));
					break;
				case "selected_options":
					e.setSelectedOptions((String) map.get(item));
					break;
				case "answer_name":
					e.setAnswerName(((String) map.get(item)));
					break;
				case "answer_phone":
					e.setAnswerPhone(((String) map.get(item)));
					break;
				case "answer_email":
					e.setAnswerEmail(((String) map.get(item)));
					break;
				case "answer_age":
					e.setAnswerAge(((Integer) map.get(item)));
					break;
				case "answer_time":
					String originalDateTime = map.get(item).toString();
					String formattedDateTime = convertDateTime(originalDateTime, "yyyy-MM-dd HH:mm:ss.S");
					e.setAnswerTime(formattedDateTime);
					break;
				}
			}
			eList.add(e);
		}
		if (eList.size() == 0) {
			return new AnswerResponse("此頁無資料");
		}
		return new AnswerResponse(eList);
	}

//	取得所有回答者資料
	@Override
	public AnswerResponse findAllAnswer(AnswerRequest req) {
		List<AnswerResponse> eList = new ArrayList<AnswerResponse>();

		Integer index = req.getIndex();
		List<Map<String, Object>> res = answerDao.findAllAnswerPaging(index);

		for (Map<String, Object> map : res) {
			AnswerResponse e = new AnswerResponse();
			for (String item : map.keySet()) {
				switch (item) {
				case "answer_id":
					e.setAnswerId((Integer) map.get(item));
					break;
				case "questionnaire_id":
					e.setQuestionnaireId((Integer) map.get(item));
					break;
				case "selected_options":
					e.setSelectedOptions((String) map.get(item));
					break;
				case "answer_name":
					e.setAnswerName(((String) map.get(item)));
					break;
				case "answer_phone":
					e.setAnswerPhone(((String) map.get(item)));
					break;
				case "answer_email":
					e.setAnswerEmail(((String) map.get(item)));
					break;
				case "answer_age":
					e.setAnswerAge(((Integer) map.get(item)));
					break;
				case "answer_time":
					String originalDateTime = map.get(item).toString();
					String formattedDateTime = convertDateTime(originalDateTime, "yyyy-MM-dd HH:mm:ss.S");
					e.setAnswerTime(formattedDateTime);
					break;
				}
			}
			eList.add(e);
		}
		if (eList.size() == 0) {
			return new AnswerResponse("此頁無資料");
		}
		return new AnswerResponse(eList);
	}

//	轉換時間格式
	private String convertDateTime(String dateTimeString, String originalFormat) {
		SimpleDateFormat originalDateFormat = new SimpleDateFormat(originalFormat);
		SimpleDateFormat targetDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		try {
			Date date = originalDateFormat.parse(dateTimeString);
			return targetDateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
