package com.example.enquete_back.service.ifs;

import com.example.enquete_back.vo.request.QuestionnaireRequest;
import com.example.enquete_back.vo.response.QuestionnaireResponse;

public interface QuestionnaireService {

//	新增問卷
	public QuestionnaireResponse addEnquete(QuestionnaireRequest newReq);
	
//	更新問券
	public QuestionnaireResponse updateEnquete(QuestionnaireRequest newReq);
	
//	刪除問券及所屬資料
	public QuestionnaireResponse deleteEnquete(QuestionnaireRequest newReq);
	
//	取得所有問券
	public QuestionnaireResponse findAll();
	
//	取得最新問券ID，創建問券後新增題目用
	public QuestionnaireResponse findNewst();
	
//	以問券ID取得問卷資料
	public QuestionnaireResponse findById(QuestionnaireRequest newReq);
	
//	取得該分頁所有問券
	public QuestionnaireResponse findAllEnquete(QuestionnaireRequest newReq);
	
//	以問券名稱或日期模糊搜尋
	public QuestionnaireResponse findQuestionnaireByTitleOrDate(QuestionnaireRequest newReq);
}
