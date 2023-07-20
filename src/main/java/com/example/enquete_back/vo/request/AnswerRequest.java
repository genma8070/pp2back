package com.example.enquete_back.vo.request;

public class AnswerRequest {
private Integer answerId;
	
	private Integer questionnaireId;
	
	private Integer Index;
	
	private String selectedOptions;
	
	private String answerTime;

	private String answerName;

	private String answerPhone;
	
	private String answerEmail;
	
	private Integer answerAge;
	
	private String message;

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public Integer getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	

	public String getSelectedOptions() {
		return selectedOptions;
	}

	public void setSelectedOptions(String selectedOptions) {
		this.selectedOptions = selectedOptions;
	}

	public String getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}

	public String getAnswerName() {
		return answerName;
	}

	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}

	public String getAnswerPhone() {
		return answerPhone;
	}

	public void setAnswerPhone(String answerPhone) {
		this.answerPhone = answerPhone;
	}

	public String getAnswerEmail() {
		return answerEmail;
	}

	public void setAnswerEmail(String answerEmail) {
		this.answerEmail = answerEmail;
	}

	public Integer getAnswerAge() {
		return answerAge;
	}

	public void setAnswerAge(Integer answerAge) {
		this.answerAge = answerAge;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getIndex() {
		return Index;
	}

	public void setIndex(Integer index) {
		Index = index;
	}
}