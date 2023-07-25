package com.example.enquete_back.service.ifs;

import com.example.enquete_back.vo.request.UserRequest;
import com.example.enquete_back.vo.response.UserResponse;

public interface UserService {

//	註冊新帳號
	public UserResponse newUser(UserRequest req);

//	登入
	public UserResponse login(UserRequest req);
	
//	取得所有回答者資料
	public UserResponse findAll();
	
//	取得該分頁所有回答者資料
	public UserResponse findAllPaging(UserRequest req);
	
//	更改權限
	public UserResponse changePosition(UserRequest req);
}
