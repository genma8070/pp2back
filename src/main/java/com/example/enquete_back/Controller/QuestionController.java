package com.example.enquete_back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.enquete_back.service.ifs.QuestionService;
import com.example.enquete_back.vo.response.SessionAddVo;

@CrossOrigin
@RestController
public class QuestionController {
	@Autowired
	QuestionService questionService;

	@PostMapping("/new_session")
	public List<SessionAddVo> addSessionQuestion(@RequestBody SessionAddVo sessionReq) {
		return questionService.addSessionQuestion(sessionReq);

	};
	
	@PostMapping("/delete_session")
	public List<SessionAddVo> deleteSessionQuestion(@RequestBody SessionAddVo sessionReq) {
		return questionService.deleteSessionQuestion(sessionReq);

	};

	@PostMapping("/go_db")
	public SessionAddVo addQuestion(@RequestBody SessionAddVo sessionReq) {
		return questionService.addQuestion(sessionReq);
	};

	@PostMapping("/find_q_o")
	public SessionAddVo findQuestionAndOptionsById(@RequestBody SessionAddVo sessionReq) {
		return questionService.findQuestionAndOptionsById(sessionReq);
	};
	
	@PostMapping("/update_qo")
	public SessionAddVo editQuestionAndOption(@RequestBody SessionAddVo sessionReq) {
		return questionService.editQuestionAndOption(sessionReq);
	};
	
	@PostMapping("/delete_qo")
	public SessionAddVo deleteQuestionAndOption(@RequestBody SessionAddVo sessionReq) {
		return questionService.deleteQuestionAndOption(sessionReq);
	};
}
