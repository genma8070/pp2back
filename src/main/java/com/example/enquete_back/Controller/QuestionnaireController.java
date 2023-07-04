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

	@PostMapping("/new_enquete")
	public QuestionnaireResponse addEnquete(@RequestBody QuestionnaireRequest newReq) {
		return questionnaireService.addEnquete(newReq);
	};
	
	@PostMapping("/update_enquete")
	public QuestionnaireResponse updateEnquete(@RequestBody QuestionnaireRequest newReq) {
		return questionnaireService.updateEnquete(newReq);
	};

	@PostMapping("/find_by_id")
	public QuestionnaireResponse findById(@RequestBody QuestionnaireRequest newReq) {
		return questionnaireService.findById(newReq);
	};

	@PostMapping("/delete_enquete")
	public QuestionnaireResponse deleteEnquete(@RequestBody QuestionnaireRequest newReq) {
		return questionnaireService.deleteEnquete(newReq);
	};

	@PostMapping("/find_all_enquete")
	public QuestionnaireResponse findAllEnquete(@RequestBody QuestionnaireRequest newReq) {
		return questionnaireService.findAllEnquete(newReq);
	};

	@GetMapping("/find_all")
	public QuestionnaireResponse findAll() {
		return questionnaireService.findAll();
	};

	@GetMapping("/find_newst")
	public QuestionnaireResponse findNewst() {
		return questionnaireService.findNewst();
	};
	
	@PostMapping("/find_questionnaire_by_title_or_date")
	public QuestionnaireResponse findQuestionnaireByTitleOrDate(@RequestBody QuestionnaireRequest newReq) {
		return questionnaireService.findQuestionnaireByTitleOrDate(newReq);
	};

}
