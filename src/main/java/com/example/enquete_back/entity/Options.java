package com.example.enquete_back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "optionsS")
public class Options {
	
	@Id
	@Column(name = "option_id")
	private Integer optionId;
	
	@Column(name = "question_id")
	private Integer questionId;
	
	@Column(name = "option_text")
	private String optionText;

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public Options(Integer optionId, Integer questionId, String optionText) {
		super();
		this.optionId = optionId;
		this.questionId = questionId;
		this.optionText = optionText;
	}

	public Options() {
		super();
		// TODO Auto-generated constructor stub
	}

}
