package com.parma.fse.projectmangerrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parma.fse.projectmangerrest.model.ResponseObject;
import com.parma.fse.projectmangerrest.model.Task;
import com.parma.fse.projectmangerrest.service.TaskService;

@RestController
@RequestMapping("/api/pm/task")
public class TaskController {
	
	Logger LOGGER=LoggerFactory.getLogger(TaskController.class);
	@Autowired
	private TaskService taskService;

	@GetMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
	public String ping() {		
		return taskService.ping();
	}
	
	@RequestMapping(path="/saveTask",method =RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject<String> saveTask(@RequestBody Task task) throws Exception{
		LOGGER.info("saveTask Entry "+ task);
		ResponseObject<String> response;		
		try {
			task=taskService.saveTask(task);
			response= new ResponseObject<String>(task.getTaskId().toString(),"SUCCESS", "0");
		}catch(Exception e) {
			e.printStackTrace();
			//LOGGER.error("Error while persisting task data", e);
			response= new ResponseObject<String>(null,"FAILURE", "1");
		}
		return response;
	}
	
	@RequestMapping(path="/getTasks",method =RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject<List<Task>> getTasks() throws Exception{
		LOGGER.info("inside getTasks");
		ResponseObject<List<Task>> response;
		List<Task> list;
		try {
			list=taskService.getTasks();
			System.out.println("lit:"+list);
			LOGGER.info("saveTask Entry ", list);
			response= new ResponseObject<List<Task>>(list,"SUCCESS", "0");
		}catch(Exception e) {
			LOGGER.error("Error while persisting task data", e);
			response= new ResponseObject<List<Task>>(null,"FAILURE", "2");
		}
		return response;
	}
	
	@RequestMapping(path="/getTask",method =RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject<Task> getTask(@RequestBody Task task) throws Exception{
		ResponseObject<Task> response;
		try {
			task=taskService.getTask(task.getTaskId());
			LOGGER.info(" getTask ==----------------------->", task);
			response= new ResponseObject<Task>(task,"SUCCESS", "0");
		}catch(Exception e) {
			LOGGER.error("Error while persisting task data", e.toString());
			e.printStackTrace();
			response= new ResponseObject<Task>(null,"FAILURE", "2");
		}
		return response;
	}
	@RequestMapping(path="/updateTaskEditEnabled",method =RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject<String> updateTaskEditEnabled(@RequestBody Task task)throws Exception{
		LOGGER.info("completetTask Entry {}", task);
		ResponseObject<String> response;
		try {
			taskService.updateTaskEditEnabled(task);
			response= new ResponseObject<String>(task.getTaskId().toString(),"SUCCESS", "0");
		}catch(Exception e) {
			e.printStackTrace();
			LOGGER.error("Error while persisting task data", e);
			response= new ResponseObject<String>(null,"FAILURE", "1");
		}
		return response;
	}
	
	
}
