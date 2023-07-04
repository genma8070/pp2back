package com.example.enquete_back.vo.request;

public class AnswerRequest {
	private Integer answerId;
	
	private Integer questionnaireId;
	
	private Integer questionId;
	
	private String selectedOptions;
	
	private String answerText;

	private String answerName;

	private Integer answerPhone;
	
	private String answerEmail;
	
	private Integer answerAge;

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

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getSelectedOptions() {
		return selectedOptions;
	}

	public void setSelectedOptions(String selectedOptions) {
		this.selectedOptions = selectedOptions;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public String getAnswerName() {
		return answerName;
	}

	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}

	public Integer getAnswerPhone() {
		return answerPhone;
	}

	public void setAnswerPhone(Integer answerPhone) {
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


}
