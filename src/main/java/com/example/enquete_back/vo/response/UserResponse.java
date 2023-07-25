package com.example.enquete_back.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserResponse {
	private String account;

	private String password;
	
	private Integer position;
	
	private String message;
	
	private List<UserResponse> list;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public UserResponse(String account, String password, Integer position) {
		super();
		this.account = account;
		this.password = password;
		this.position = position;
	}

	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserResponse(String account, String password, Integer position, String message) {
		super();
		this.account = account;
		this.password = password;
		this.position = position;
		this.message = message;
	}

	public UserResponse(String message) {
		super();
		this.message = message;
	}

	public List<UserResponse> getList() {
		return list;
	}

	public void setList(List<UserResponse> list) {
		this.list = list;
	}

	public UserResponse(String account, String password, Integer position, String message, List<UserResponse> list) {
		super();
		this.account = account;
		this.password = password;
		this.position = position;
		this.message = message;
		this.list = list;
	}

	public UserResponse(List<UserResponse> list) {
		super();
		this.list = list;
	}

	
}