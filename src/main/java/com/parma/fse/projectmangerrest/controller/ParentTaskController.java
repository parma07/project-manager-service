package com.parma.fse.projectmangerrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parma.fse.projectmangerrest.model.ParentTask;
import com.parma.fse.projectmangerrest.model.ResponseObject;
import com.parma.fse.projectmangerrest.service.ParentTaskService;

@RestController
@RequestMapping("/api/pm/parenttask")
public class ParentTaskController {
	
	@Autowired
	private ParentTaskService parentTaskService;
	
	@RequestMapping(path="/getParentTasks", method = RequestMethod.POST)
	public ResponseObject<List<ParentTask>> getParentTasks(){
		ResponseObject<List<ParentTask>> responseObject = null;
		try{
			List<ParentTask> ParentTaskList = parentTaskService.getParentTasks();
			responseObject = new ResponseObject<List<ParentTask>>(ParentTaskList, "SUCCESS", "200");
		}catch(Exception e){
			e.printStackTrace();
			responseObject = new ResponseObject<List<ParentTask>>(null, "FAIL", "500");
		}
		return responseObject;
	}
}
