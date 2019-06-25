package com.parma.fse.projectmangerrest.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.parma.fse.projectmangerrest.model.Task;

public interface TaskService {
	String ping();
	Task saveTask(Task task) throws DataAccessException;
	List<Task> getTasks() throws DataAccessException;
	Task getTask(Integer taskId);
	void updateTaskEditEnabled(Task task);
}
