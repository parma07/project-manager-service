package com.parma.fse.projectmangerrest.service;

import java.util.List;

import com.parma.fse.projectmangerrest.model.User;

public interface UserService {
	public User saveUser(User user);
	public List<User> getUsers();
}
