package com.example.enquete_back.service.ifs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.enquete_back.vo.request.QuestionRequest;
import com.example.enquete_back.vo.response.QuestionResponse;
import com.example.enquete_back.vo.response.SessionAddVo;

public interface QuestionService {
	
//	public QuestionResponse addQuestion (QuestionRequest newReq, Integer questionnaireId);

	public QuestionResponse addQuestion (QuestionRequest newReq);
//	public QuestionResponse addQuestionSession (QuestionRequest newReq, HttpSession httpSessio	n);
	public List<SessionAddVo> addSessionQuestion (SessionAddVo sessionReq);
	public SessionAddVo addQuestion (SessionAddVo sessionReq);


}
