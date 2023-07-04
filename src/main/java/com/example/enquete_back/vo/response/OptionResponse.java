package com.example.enquete_back.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OptionResponse {

	private Integer optionId;
	
	private Integer questionId;
	
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

	public OptionResponse(Integer optionId, Integer questionId, String optionText) {
		super();
		this.optionId = optionId;
		this.questionId = questionId;
		this.optionText = optionText;
	}

	public OptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
