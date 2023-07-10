package com.example.enquete_back.service.ifs;

import java.util.List;

import com.example.enquete_back.vo.response.SessionAddVo;

public interface QuestionService {

	public List<SessionAddVo> addSessionQuestion(SessionAddVo sessionReq);

	public SessionAddVo addQuestion(SessionAddVo sessionReq);

	public SessionAddVo findQuestionAndOptionsById(SessionAddVo sessionReq);
	
	public SessionAddVo editQuestionAndOption(SessionAddVo sessionReq);
	
	public SessionAddVo deleteQuestionAndOption(SessionAddVo sessionReq);
	
	public List<SessionAddVo> deleteSessionQuestion(SessionAddVo sessionReq);

}
