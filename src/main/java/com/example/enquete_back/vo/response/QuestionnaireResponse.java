package com.example.enquete_back.vo.response;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QuestionnaireResponse {


	private List<QuestionnaireResponse> list;

	private Integer questionnaireId;

	private String title;

	private String description;

	private LocalDate startTime;

	private LocalDate endTime;

	private Boolean status;

	public Integer getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public QuestionnaireResponse(Integer questionnaireId, String title, String description, LocalDate startTime,
			LocalDate endTime, Boolean status) {
		super();
		this.questionnaireId = questionnaireId;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}

	public QuestionnaireResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionnaireResponse(String title, String description, LocalDate startTime, LocalDate endTime) {
		super();
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public List<QuestionnaireResponse> getList() {
		return list;
	}

	public void setList(List<QuestionnaireResponse> list) {
		this.list = list;
	}

	public QuestionnaireResponse(List<QuestionnaireResponse> list) {
		super();
		this.list = list;
	}

}
