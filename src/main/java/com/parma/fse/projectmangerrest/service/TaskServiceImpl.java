package com.parma.fse.projectmangerrest.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parma.fse.projectmangerrest.model.Task;
import com.parma.fse.projectmangerrest.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	TaskRepository taskRepository;

	@Override
	public String ping() {
		return "Ping Success";
	}

	@Override
	@Transactional
	public Task saveTask(Task task) throws DataAccessException {
		System.out.println("Inside save task");
		task = taskRepository.save(task); 
		return task;
	}

	@Override
	public List<Task> getTasks() throws DataAccessException {
		return taskRepository.findAll();
	}

	@Override
	public Task getTask(Integer taskId) {
		Optional<Task> task = taskRepository.findById(taskId);
		return task.isPresent()?task.get():null;
	}

	@Override
	public void updateTaskEditEnabled(Task task) {
		taskRepository.updateTaskEditEnabled(task.getEditEnabled(), task.getTaskId());	
	}
	
	
}
