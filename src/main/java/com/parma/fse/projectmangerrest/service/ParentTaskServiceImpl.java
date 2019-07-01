package com.parma.fse.projectmangerrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parma.fse.projectmangerrest.model.ParentTask;
import com.parma.fse.projectmangerrest.repository.ParentTaskRepository;

@Service
public class ParentTaskServiceImpl implements ParentTaskService {
	
	@Autowired
	ParentTaskRepository parentTaskRepository;

	@Override
	public List<ParentTask> getParentTasks() {
		return parentTaskRepository.findAll();
	}

}
