package com.example.enquete_back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.enquete_back.service.ifs.UserService;
import com.example.enquete_back.vo.request.UserRequest;
import com.example.enquete_back.vo.response.UserResponse;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	UserService userService;


//	用id找尋該回答者資料
	@PostMapping("/new_user")
	public UserResponse newUser(@RequestBody UserRequest req) {
		return userService.newUser(req);
	};
	
	@PostMapping("/login")
	public UserResponse login(@RequestBody UserRequest req) {
		return userService.login(req);
	};
	
	@PostMapping("/change_position")
	public UserResponse changePosition(@RequestBody UserRequest req) {
		return userService.changePosition(req);
	};
	
//	取得所有回答者資料
	@GetMapping("/find_all_user")
	public UserResponse findAll() {
		return userService.findAll();
	};
	
	@PostMapping("/find_pag_user")
	public UserResponse findAllPaging(@RequestBody UserRequest req) {
		return userService.findAllPaging(req);
	};
	
}
