package com.parma.fse.projectmangerrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parma.fse.projectmangerrest.model.ResponseObject;
import com.parma.fse.projectmangerrest.model.User;
import com.parma.fse.projectmangerrest.service.UserService;

@RestController
@RequestMapping("/api/pm/user")
public class UserController {
	Logger LOGGER = LoggerFactory.getLogger(UserController.class);
		
	@Autowired
	private UserService userService;
	
	@RequestMapping(path="/saveUser", method= RequestMethod.POST)
	public ResponseObject<String> addUser(@RequestBody User user){
		LOGGER.info("Inside saveUser:{}", user.getEmployeeId());
		ResponseObject<String> responseObject;
		try{
			user=userService.saveUser(user);
			responseObject = new ResponseObject<String>(user.getUserId().toString(), "SUCCESS", "200");
		}catch(Exception e){
			responseObject = new ResponseObject<String>(null, "FAIL", "000");
		}		
		return responseObject;		
	}
	
	@RequestMapping(path="/getUsers", method= RequestMethod.POST)
	public ResponseObject<List<User>> getUsers(){
		LOGGER.info("Inside getUser:");
		ResponseObject<List<User>> responseObject;
		List<User> users = new ArrayList<User>();
		
		try{
			users=userService.getUsers();
			responseObject = new ResponseObject<List<User>>(users, "SUCCESS", "200");
		}catch(Exception e){
			responseObject = new ResponseObject<List<User>>(null, "FAIL", "000");
		}		
		return responseObject;		
	}
}
