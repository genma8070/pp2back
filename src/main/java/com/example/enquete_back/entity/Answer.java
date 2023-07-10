package com.example.enquete_back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {
	

	@Id
	@Column(name = "answer_id")
	private Integer answerId;
	
	@Column(name = "questionnaire_id")
	private Integer questionnaireId;
	
	@Column(name = "question_id")
	private Integer questionId;
	
	@Column(name = "selected_options")
	private String selectedOptions;
	
	@Column(name = "answer_text")
	private String answerText;
	
	@Column(name = "answer_name")
	private String answerName;
	
	@Column(name = "answer_phone")
	private Integer answerPhone;
	
	@Column(name = "answer_email")
	private String answerEmail;
	
	@Column(name = "answer_age")
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

	public Answer(Integer answerId, Integer questionnaireId, Integer questionId, String selectedOptions,
			String answerText, String answerName, Integer answerPhone, String answerEmail, Integer answerAge) {
		super();
		this.answerId = answerId;
		this.questionnaireId = questionnaireId;
		this.questionId = questionId;
		this.selectedOptions = selectedOptions;
		this.answerText = answerText;
		this.answerName = answerName;
		this.answerPhone = answerPhone;
		this.answerEmail = answerEmail;
		this.answerAge = answerAge;
	}

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
