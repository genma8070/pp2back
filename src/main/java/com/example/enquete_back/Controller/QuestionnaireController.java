package com.example.enquete_back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.enquete_back.service.ifs.QuestionnaireService;
import com.example.enquete_back.vo.request.QuestionnaireRequest;
import com.example.enquete_back.vo.response.QuestionnaireResponse;

@CrossOrigin
@RestController
public class QuestionnaireController {
	@Autowired
	QuestionnaireService questionnaireService;

//	新增問卷
	@PostMapping("/new_enquete")
	public QuestionnaireResponse addEnquete(@RequestBody QuestionnaireRequest newReq) {
		return questionnaireService.addEnquete(newReq);
	};
	
//	更新問卷
	@PostMapping("/update_enquete")
	public QuestionnaireResponse updateEnquete(@RequestBody QuestionnaireRequest newReq) {
		return questionnaireService.updateEnquete(newReq);
	};

//	用ID找問卷
	@PostMapping("/find_by_id")
	public QuestionnaireResponse findById(@RequestBody QuestionnaireRequest newReq) {
		return questionnaireService.findById(newReq);
	};
	
//	刪除問卷
	@PostMapping("/delete_enquete")
	public QuestionnaireResponse deleteEnquete(@RequestBody QuestionnaireRequest newReq) {
		return questionnaireService.deleteEnquete(newReq);
	};

//	找出所有該分頁的問卷
	@PostMapping("/find_all_enquete")
	public QuestionnaireResponse findAllEnquete(@RequestBody QuestionnaireRequest newReq) {
		return questionnaireService.findAllEnquete(newReq);
	};

//	找出所有問卷
	@GetMapping("/find_all")
	public QuestionnaireResponse findAll() {
		return questionnaireService.findAll();
	};

//	找最新的問卷
	@GetMapping("/find_newst")
	public QuestionnaireResponse findNewst() {
		return questionnaireService.findNewst();
	};
	
//	用日期或標題模糊搜尋問卷
	@PostMapping("/find_questionnaire_by_title_or_date")
	public QuestionnaireResponse findQuestionnaireByTitleOrDate(@RequestBody QuestionnaireRequest newReq) {
		return questionnaireService.findQuestionnaireByTitleOrDate(newReq);
	};

}
