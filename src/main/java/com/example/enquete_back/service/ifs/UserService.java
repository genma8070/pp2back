package com.example.enquete_back.service.ifs;

import com.example.enquete_back.vo.request.UserRequest;
import com.example.enquete_back.vo.response.UserResponse;

public interface UserService {

	public UserResponse newUser(UserRequest req);

	public UserResponse login(UserRequest req);
	
	public UserResponse findAll();
	
	public UserResponse findAllPaging(UserRequest req);
	
	public UserResponse changePosition(UserRequest req);
}
