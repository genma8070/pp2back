package com.example.enquete_back.service.ifs;

import com.example.enquete_back.vo.request.QuestionnaireRequest;
import com.example.enquete_back.vo.response.QuestionnaireResponse;

public interface QuestionnaireService {
	
//	public QuestionnaireResponse addEnquete(QuestionnaireRequest newReq, List<QuestionRequest> questions);

	public QuestionnaireResponse addEnquete(QuestionnaireRequest newReq);
	
	public QuestionnaireResponse updateEnquete(QuestionnaireRequest newReq);
	
	public QuestionnaireResponse deleteEnquete(QuestionnaireRequest newReq);
	
	public QuestionnaireResponse findAll();
	
	public QuestionnaireResponse findNewst();
	
	public QuestionnaireResponse findById(QuestionnaireRequest newReq);
	
	public QuestionnaireResponse findAllEnquete(QuestionnaireRequest newReq);
	
	public QuestionnaireResponse findQuestionnaireByTitleOrDate(QuestionnaireRequest newReq);
}
