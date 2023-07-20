package com.example.enquete_back.service.ifs;

import java.util.List;

import com.example.enquete_back.vo.response.SessionAddVo;

public interface QuestionService {

//	加入進session
	public List<SessionAddVo> addSessionQuestion(SessionAddVo sessionReq);
//	新增問題
	public SessionAddVo addQuestion(SessionAddVo sessionReq);
//	用問卷ID找出其問題及選項，將選項和選項ID存成字串
	public SessionAddVo findQuestionAndOptionsById(SessionAddVo sessionReq);
//	用問卷ID找出其問題及選項
	public SessionAddVo getQuestionAndOptionsById(SessionAddVo sessionReq);
//	更新問題選項
	public SessionAddVo editQuestionAndOption(SessionAddVo sessionReq);
//	刪除問題選項
	public SessionAddVo deleteQuestionAndOption(SessionAddVo sessionReq);
//	移除session
	public List<SessionAddVo> deleteSessionQuestion(SessionAddVo sessionReq);

}
