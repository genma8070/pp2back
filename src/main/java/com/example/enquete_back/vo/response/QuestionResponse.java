package com.example.enquete_back.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QuestionResponse {

	private Integer questionId;
	
	private Integer questionnaireId;
	
	private Integer questionType;
	
	private String questionText;
	
	private Boolean isRequired;

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Boolean getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	public QuestionResponse(Integer questionId, Integer questionnaireId, Integer questionType, String questionText,
			Boolean isRequired) {
		super();
		this.questionId = questionId;
		this.questionnaireId = questionnaireId;
		this.questionType = questionType;
		this.questionText = questionText;
		this.isRequired = isRequired;
	}

	public QuestionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
