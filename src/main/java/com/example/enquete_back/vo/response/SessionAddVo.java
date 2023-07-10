package com.example.enquete_back.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SessionAddVo {
	private List<SessionAddVo> list;
	
	private List<Integer> sessions;

	private Integer questionSessionId;
	
	private Integer questionnaireId;
	
	private Integer questionId;
	
	private Boolean questionType;
	
	private String questionText;
		
	private Boolean isRequired;
	
	private String options;
	
	private String optionsId;
	
	private String message;
	

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


	public SessionAddVo() {
		super();
		// TODO Auto-generated constructor stub
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


	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public SessionAddVo(List<SessionAddVo> list, Integer questionSessionId, Integer questionnaireId, Integer questionId,
			Boolean questionType, String questionText, Boolean isRequired, String options) {
		super();
		this.list = list;
		this.questionSessionId = questionSessionId;
		this.questionnaireId = questionnaireId;
		this.questionId = questionId;
		this.questionType = questionType;
		this.questionText = questionText;
		this.isRequired = isRequired;
		this.options = options;
	}

	public SessionAddVo(Integer questionSessionId, Integer questionnaireId, Integer questionId, Boolean questionType,
			String questionText, Boolean isRequired, String options) {
		super();
		this.questionSessionId = questionSessionId;
		this.questionnaireId = questionnaireId;
		this.questionId = questionId;
		this.questionType = questionType;
		this.questionText = questionText;
		this.isRequired = isRequired;
		this.options = options;
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

	public String getOptionsId() {
		return optionsId;
	}

	public void setOptionsId(String optionsId) {
		this.optionsId = optionsId;
	}

	public SessionAddVo(List<SessionAddVo> list, Integer questionSessionId, Integer questionnaireId, Integer questionId,
			Boolean questionType, String questionText, Boolean isRequired, String options, String optionsId) {
		super();
		this.list = list;
		this.questionSessionId = questionSessionId;
		this.questionnaireId = questionnaireId;
		this.questionId = questionId;
		this.questionType = questionType;
		this.questionText = questionText;
		this.isRequired = isRequired;
		this.options = options;
		this.optionsId = optionsId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SessionAddVo(String message) {
		super();
		this.message = message;
	}

	public List<Integer> getSessions() {
		return sessions;
	}

	public void setSessions(List<Integer> sessions) {
		this.sessions = sessions;
	}

	
}
