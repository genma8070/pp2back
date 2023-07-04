package com.example.enquete_back.vo.request;

public class QuestionRequest {

	private Integer questionId;
	
	private Integer questionnaireId;
	
	private Boolean questionType;
	
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

	public Boolean getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Boolean questionType) {
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

}
