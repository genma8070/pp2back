package com.example.enquete_back.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enquete_back.entity.User;
import com.example.enquete_back.repository.UserDao;
import com.example.enquete_back.service.ifs.UserService;
import com.example.enquete_back.vo.request.UserRequest;
import com.example.enquete_back.vo.response.UserResponse;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

//	註冊新帳號
	public UserResponse newUser(UserRequest req) {
		String account = req.getAccount();
		String password = req.getPassword();
		if (account.isEmpty() || password.isEmpty()) {
			return new UserResponse("帳號密碼皆必填");
		}
		Optional<User> users = userDao.findById(account);

		if (users.isPresent()) {
			return new UserResponse("該帳號已被使用");
		} else {
			User user = new User(account, password, 2);
			userDao.save(user);
		}
		return new UserResponse("註冊成功");
	}

//	登入
	public UserResponse login(UserRequest req) {
		String account = req.getAccount();
		String password = req.getPassword();
		if (account.isEmpty() || password.isEmpty()) {
			return new UserResponse("帳號密碼皆必填");
		}
		Optional<User> users = userDao.findById(account);

		if (users.isPresent()) {

			Optional<User> res = userDao.findById(account);
			if (account.equals(res.get().getAccount()) && password.equals(res.get().getPassword())) {
				return new UserResponse(account, password, res.get().getPosition(), "登入成功");

			} else {
				return new UserResponse("帳號或密碼錯誤");
			}

		} else {
			return new UserResponse("無此帳號");
		}
	}

	
//	取得該分頁所有回答者資料
	public UserResponse findAllPaging(UserRequest req) {
		List<UserResponse> eList = new ArrayList<UserResponse>();

//		輸入INDEX找尋該頁號的回答者
		Integer index = req.getIndex()+1;
		List<Map<String, Object>> res = userDao.findAllUserPaging(index);

//		將找出的回答者物件重組
		for (Map<String, Object> map : res) {
			UserResponse e = new UserResponse();
			for (String item : map.keySet()) {
				switch (item) {
				case "account":
					e.setAccount((String) map.get(item));
					break;
				case "password":
					e.setPassword((String) map.get(item));
					break;
				case "position":
					e.setPosition((Integer) map.get(item));
					break;
				
				}
			}
			eList.add(e);
		}
		if (eList.size() == 0) {
			return new UserResponse("此頁無資料");
		}
		return new UserResponse(eList);
	}
	
//	取得所有回答者資料
	public UserResponse findAll() {
		List<UserResponse> eList = new ArrayList<UserResponse>();
		
		List<Map<String, Object>> res = userDao.findAllUser();

//		將找出的回答者物件重組
		for (Map<String, Object> map : res) {
			UserResponse e = new UserResponse();
			for (String item : map.keySet()) {
				switch (item) {
				case "account":
					e.setAccount((String) map.get(item));
					break;
				case "password":
					e.setPassword((String) map.get(item));
					break;
				case "position":
					e.setPosition((Integer) map.get(item));
					break;
				
				}
			}
			eList.add(e);
		}
		if (eList.size() == 0) {
			return new UserResponse("此頁無資料");
		}
		return new UserResponse(eList);
	}

//	更改權限
	public UserResponse changePosition(UserRequest req) {
		String account = req.getAccount();
		String password = req.getPassword();
		Integer position = req.getPosition();
		User user = new User(account, password, position);
		userDao.save(user);
		return new UserResponse("權限更變成功");

	}

}
