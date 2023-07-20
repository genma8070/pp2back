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

//	更新問卷
	@Override
	public QuestionnaireResponse updateEnquete(QuestionnaireRequest newReq) {

//		判斷是否有輸入日期，若沒有則自動帶入當下日期並在七天後結束問券
		LocalDate startTime = newReq.getStartTime() != null ? newReq.getStartTime() : LocalDate.now();
		LocalDate endTime = newReq.getEndTime() != null ? newReq.getEndTime() : startTime.plusDays(7);

//		判斷日期是否有誤
		if (startTime.compareTo(endTime) > 0 || endTime.compareTo(startTime) <= 0) {
			return new QuestionnaireResponse("開始日期不得晚於結束日期且至少相隔一日");
		}

		String title = newReq.getTitle();
		String description = newReq.getDescription();

//		設定執行方法當下日期
		LocalDate now = LocalDate.now();

//		比較開始日期與結束日期和當下日期的關係
		int startDate = startTime.compareTo(now);
		int endDate = endTime.compareTo(now);
//		判斷問券狀態
		Boolean status = (startDate <= 0 && endDate >= 0) ? true : false;

//		輸入要更新哪個問券的ID
		Integer id = newReq.getQuestionnaireId();

//		防呆不得為空
		if (title.isEmpty() || description.isEmpty()) {
			return new QuestionnaireResponse("標題或簡述不得空白");
		}

//		更新問卷
		questionnaireDao.updateEnquete(title, description, startTime, endTime, status, id);

		return new QuestionnaireResponse("更新成功");

	}

//	新增問卷
	@Override
	public QuestionnaireResponse addEnquete(QuestionnaireRequest newReq) {

//		判斷是否有輸入日期，若沒有則自動帶入當下日期並在七天後結束問券
		LocalDate startTime = newReq.getStartTime() != null ? newReq.getStartTime() : LocalDate.now();
		LocalDate endTime = newReq.getEndTime() != null ? newReq.getEndTime() : startTime.plusDays(7);

//		判斷日期是否有誤
		if (startTime.compareTo(endTime) > 0 || endTime.compareTo(startTime) <= 0) {
			return new QuestionnaireResponse("開始日期不得晚於結束日期且必須至少相隔一日");
		}

		String title = newReq.getTitle();
		String description = newReq.getDescription();

//		設定執行方法當下日期
		LocalDate now = LocalDate.now();

//		比較開始日期與結束日期和當下日期的關係
		int startDate = startTime.compareTo(now);
		int endDate = endTime.compareTo(now);
//		判斷問券狀態
		Boolean status = (startDate <= 0 && endDate >= 0) ? true : false;
		if (startDate < 0) {
			return new QuestionnaireResponse("開始日期不可早於今日");
		}
		if (endDate < 0) {
			return new QuestionnaireResponse("結束日期須晚於今日");
		}
//		防呆不得為空
		if (title.isEmpty() || description.isEmpty()) {
			return new QuestionnaireResponse("標題或簡述不得空白");
		}

		questionnaireDao.addEnquete(title, description, startTime, endTime, status);

		return new QuestionnaireResponse();

	}

//	找出該分頁的問卷
	@Override
	public QuestionnaireResponse findAllEnquete(QuestionnaireRequest newReq) {

		List<QuestionnaireResponse> eList = new ArrayList<QuestionnaireResponse>();

//		輸入INDEX找尋該頁號的問卷
		Integer index = newReq.getIndex();
		List<Map<String, Object>> res = questionnaireDao.findAllQuestionnairePaging(index);

//		將找出的問卷物件重組
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
//					//					設定執行方法當下日期
					LocalDate now = LocalDate.now();
					LocalDate startTime = e.getStartTime();
					LocalDate endTime = e.getEndTime();
//					比較開始日期與結束日期和當下日期的關係
					int startDate = startTime.compareTo(now);
					int endDate = endTime.compareTo(now);
//					判斷問券狀態
					Boolean status = (startDate <= 0 && endDate >= 0) ? true : false;

					questionnaireDao.updateEnqueteStatus(status, e.getQuestionnaireId());

					break;
//					布林值要轉型態
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
			return new QuestionnaireResponse("此頁無資料");
		}
		return new QuestionnaireResponse(eList);
	}

//	取得最新問券的ID
	@Override
	public QuestionnaireResponse findNewst() {
		Questionnaire q = questionnaireDao.findNewstEnquete();
		QuestionnaireResponse e = new QuestionnaireResponse();

		e.setQuestionnaireId(q.getQuestionnaireId());
		return e;
	}

//	取得所有問券
	@Override
	public QuestionnaireResponse findAll() {
		List<QuestionnaireResponse> eList = new ArrayList<QuestionnaireResponse>();

		List<Map<String, Object>> res = questionnaireDao.findAllQuestionnaire();

//		將找出的問卷物件重組
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
//					設定執行方法當下日期
					LocalDate now = LocalDate.now();
					LocalDate startTime = e.getStartTime();
					LocalDate endTime = e.getEndTime();
//					比較開始日期與結束日期和當下日期的關係
					int startDate = startTime.compareTo(now);
					int endDate = endTime.compareTo(now);
//					判斷問券狀態
					Boolean status = (startDate <= 0 && endDate >= 0) ? true : false;

					questionnaireDao.updateEnqueteStatus(status, e.getQuestionnaireId());

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
			return new QuestionnaireResponse("尚無問卷");
		}
		return new QuestionnaireResponse(eList);
	}

//	用日期或標題模糊搜尋問券
	@Override
	public QuestionnaireResponse findQuestionnaireByTitleOrDate(QuestionnaireRequest newReq) {
//		不輸入則搜尋全部所以不用設定防空白
		String title = newReq.getTitle();
		LocalDate startTime = newReq.getStartTime();
		LocalDate endTime = newReq.getEndTime();
		Integer index = newReq.getIndex();
		if (startTime != null && endTime != null && startTime.compareTo(endTime) > 0) {
			return new QuestionnaireResponse("結束結束時間不可早於開始時間");
		}

		List<QuestionnaireResponse> eList = new ArrayList<QuestionnaireResponse>();

		List<Map<String, Object>> res = questionnaireDao.findQuestionnaireByTitleOrDate(title, startTime, endTime,
				index);

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
			return new QuestionnaireResponse("查無資料");
		}
		return new QuestionnaireResponse(eList);
	}

//	刪除問卷
	@Override
	public QuestionnaireResponse deleteEnquete(QuestionnaireRequest newReq) {
//		可一次刪除多筆
		List<Integer> id = newReq.getId();
		if (id.size() == 0) {
			return new QuestionnaireResponse("未選擇欲刪除問卷");
		}
		int x = 0;
		for (x = 0; x < id.size(); x++) {
//			因為有使用外來鍵所以從最尾端的DB開始刪除
			questionnaireDao.deleteEnqueteOptions(id.get(x));
			questionnaireDao.deleteEnqueteAnswer(id.get(x));
			questionnaireDao.deleteEnqueteQuestion(id.get(x));
			questionnaireDao.deleteEnqueteEnquete(id.get(x));
		}
		return new QuestionnaireResponse("刪除成功");
	}

//	用ID找問券
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
					LocalDate now = LocalDate.now();
					LocalDate startTime = e.getStartTime();
//					比較開始日期與結束日期和當下日期的關係
					int startDate = startTime.compareTo(now);
//					判斷問券狀態
					Boolean status = (startDate <= 0) ? true : false;
					questionnaireDao.updateEnqueteStatus(status, e.getQuestionnaireId());
					break;
				case "end_time":
					e.setEndTime(((Date) map.get(item)).toLocalDate());
//					設定執行方法當下日期
					LocalDate now2 = LocalDate.now();
					LocalDate endTime = e.getEndTime();
//					比較開始日期與結束日期和當下日期的關係

					int endDate = endTime.compareTo(now2);
//					判斷問券狀態
					Boolean status2 = (endDate >= 0) ? true : false;
					questionnaireDao.updateEnqueteStatus(status2, e.getQuestionnaireId());

					break;
//					布林值要轉型態
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
			return new QuestionnaireResponse("查無資料");
		}
		return new QuestionnaireResponse(eList);
	}
}
