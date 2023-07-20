package com.example.enquete_back.service.ifs;

import com.example.enquete_back.vo.request.AnswerRequest;
import com.example.enquete_back.vo.response.AnswerResponse;

public interface AnswerService {
//	新增回答
	public AnswerResponse addAnswer(AnswerRequest req);
	
//	取得畫統計圖需要用到的資料
	public AnswerResponse getGraphData(AnswerRequest req);
	
//	取得該分頁的回答者資料
	public AnswerResponse findAllAnswer(AnswerRequest req);
	
//	用id找尋該回答者資料
	public AnswerResponse findAnswerById(AnswerRequest req);
	
//	取得所有回答者資料
	public AnswerResponse getAllAnswer();


}
