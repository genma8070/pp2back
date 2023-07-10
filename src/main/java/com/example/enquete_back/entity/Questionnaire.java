package com.example.enquete_back.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questionnaire")
public class Questionnaire {
	
	@Id
	@Column(name = "questionnaire_id")
	private Integer questionnaireId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "start_time")
	private LocalDate startTime = LocalDate.now();
	
	
	@Column(name = "end_time")
	private LocalDate endTime = startTime.plusDays(7);
	
	@Column(name = "status")
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

	public Questionnaire(Integer questionnaireId, String title, String description, LocalDate startTime, LocalDate endTime,
			Boolean status) {
		super();
		this.questionnaireId = questionnaireId;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}

	public Questionnaire() {
		
	}

}
