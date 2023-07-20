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

//	加入至session
	@PostMapping("/new_session")
	public List<SessionAddVo> addSessionQuestion(@RequestBody SessionAddVo sessionReq) {
		return questionService.addSessionQuestion(sessionReq);
	};

//	移除session
	@PostMapping("/delete_session")
	public List<SessionAddVo> deleteSessionQuestion(@RequestBody SessionAddVo sessionReq) {
		return questionService.deleteSessionQuestion(sessionReq);
	};

//	將session內容存進db
	@PostMapping("/go_db")
	public SessionAddVo addQuestion(@RequestBody SessionAddVo sessionReq) {
		return questionService.addQuestion(sessionReq);
	};

//	用問卷ID找出其問題及選項，將選項和選項ID存成字串
	@PostMapping("/find_q_o")
	public SessionAddVo findQuestionAndOptionsById(@RequestBody SessionAddVo sessionReq) {
		return questionService.findQuestionAndOptionsById(sessionReq);
	};

//	用問卷ID找出其問題及選項
	@PostMapping("/get_q_o")
	public SessionAddVo getQuestionAndOptionsById(@RequestBody SessionAddVo sessionReq) {
		return questionService.getQuestionAndOptionsById(sessionReq);
	};

//	更新問題選項
	@PostMapping("/update_qo")
	public SessionAddVo editQuestionAndOption(@RequestBody SessionAddVo sessionReq) {
		return questionService.editQuestionAndOption(sessionReq);
	};

//	刪除問題選項
	@PostMapping("/delete_qo")
	public SessionAddVo deleteQuestionAndOption(@RequestBody SessionAddVo sessionReq) {
		return questionService.deleteQuestionAndOption(sessionReq);
	};
}
