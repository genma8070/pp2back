package com.example.enquete_back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@Column(name = "question_id")
	private Integer questionId;
	
	@Column(name = "questionnaire_id")
	private Integer questionnaireId;
	
	@Column(name = "question_type")
	private Boolean questionType;
	
	@Column(name = "question_text")
	private String questionText;
	
	@Column(name = "is_required")
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

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(Integer questionId, Integer questionnaireId, Boolean questionType, String questionText,
			Boolean isRequired) {
		super();
		this.questionId = questionId;
		this.questionnaireId = questionnaireId;
		this.questionType = questionType;
		this.questionText = questionText;
		this.isRequired = isRequired;
	}


}
