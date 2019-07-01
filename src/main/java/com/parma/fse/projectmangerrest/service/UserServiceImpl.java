package com.parma.fse.projectmangerrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parma.fse.projectmangerrest.model.User;
import com.parma.fse.projectmangerrest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {		
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {		
		return userRepository.findAll();
	}

	@Override
	public List<User> getUsersWithNoProject() {
		return userRepository.getUsersWithNoProject();
	}

}
