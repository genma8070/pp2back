package com.example.enquete_back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.enquete_back.service.ifs.AnswerService;
import com.example.enquete_back.vo.request.AnswerRequest;
import com.example.enquete_back.vo.response.AnswerResponse;

@CrossOrigin
@RestController
public class AnswerController {
	@Autowired
	AnswerService answerService;

//	新增回答
	@PostMapping("/new_answer")
	public AnswerResponse addAnswer(@RequestBody AnswerRequest req) {
		return answerService.addAnswer(req);

	};

//	取得畫統計圖需要用到的資料
	@PostMapping("/draw_g")
	public AnswerResponse getGraphData (@RequestBody AnswerRequest req) {
		return answerService.getGraphData(req);

	};
	
//	取得該分頁的回答者資料
	@PostMapping("/find_all_answer")
	public AnswerResponse findAllAnswer(@RequestBody AnswerRequest req) {
		return answerService.findAllAnswer(req);
	};
	
//	用id找尋該回答者資料
	@PostMapping("/find_answer_by_id")
	public AnswerResponse findAnswerById(@RequestBody AnswerRequest req) {
		return answerService.findAnswerById(req);
	};
	
//	取得所有回答者資料
	@GetMapping("/get_all_answer")
	public AnswerResponse getAllAnswer() {
		return answerService.getAllAnswer();
	};
	
}
