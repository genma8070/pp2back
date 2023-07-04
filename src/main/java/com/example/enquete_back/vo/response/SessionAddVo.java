package com.example.enquete_back.vo.response;

import java.util.List;

public class SessionAddVo {
	private List<SessionAddVo> list;
	
	private static int idCounter = 0;

	private Integer questionSessionId;
	
	
	private Integer questionnaireId;
	
	
	private Boolean questionType;
	

	private String questionText;
	
	
	private Boolean isRequired;
	
	private String options;
	 @Override
	public String toString() {
	    return "SessionAddVo{" +
	            "questionSessionId=" + questionSessionId +
	            ", questionnaireId=" + questionnaireId +
	            ", questionType=" + questionType +
	            ", questionText='" + questionText + '\'' +
	            ", isRequired=" + isRequired +
	            ", options='" + options + '\'' +
	            '}';
	}

	public Integer getQuestionSessionId() {
		return questionSessionId;
	}

	public void setQuestionSessionId(Integer questionSessionId) {
		this.questionSessionId = questionSessionId;
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

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public SessionAddVo(Integer questionnaireId, Boolean questionType, String questionText, Boolean isRequired,
			String options) {
		super();
		this.questionSessionId = ++idCounter;
		this.questionnaireId = questionnaireId;
		this.questionType = questionType;
		this.questionText = questionText;
		this.isRequired = isRequired;
		this.options = options;
	}

	public SessionAddVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SessionAddVo(Integer questionSessionId, Integer questionnaireId, Boolean questionType, String questionText,
			Boolean isRequired, String options) {
		super();
		this.questionSessionId = questionSessionId;
		this.questionnaireId = questionnaireId;
		this.questionType = questionType;
		this.questionText = questionText;
		this.isRequired = isRequired;
		this.options = options;
	}

	public List<SessionAddVo> getList() {
		return list;
	}

	public void setList(List<SessionAddVo> list) {
		this.list = list;
	}

	public SessionAddVo(List<SessionAddVo> list) {
		super();
		this.list = list;
	}

}
