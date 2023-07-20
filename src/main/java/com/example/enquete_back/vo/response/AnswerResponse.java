package com.example.enquete_back.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AnswerResponse {
private Integer answerId;
	
	private Integer questionnaireId;
	
	private List<AnswerResponse> b;
	
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

	public List<AnswerResponse> getB() {
		return b;
	}

	public void setB(List<AnswerResponse> b) {
		this.b = b;
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

	public AnswerResponse(Integer answerId, Integer questionnaireId, List<AnswerResponse> b, String selectedOptions,
			String answerTime, String answerName, String answerPhone, String answerEmail, Integer answerAge,
			String message) {
		super();
		this.answerId = answerId;
		this.questionnaireId = questionnaireId;
		this.b = b;
		this.selectedOptions = selectedOptions;
		this.answerTime = answerTime;
		this.answerName = answerName;
		this.answerPhone = answerPhone;
		this.answerEmail = answerEmail;
		this.answerAge = answerAge;
		this.message = message;
	}

	public AnswerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public AnswerResponse(String message) {
		super();
		this.message = message;
	}

	public AnswerResponse(List<AnswerResponse> b) {
		super();
		this.b = b;
	}
}