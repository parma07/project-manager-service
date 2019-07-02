package com.parma.fse.projectmangerrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.parma.fse.projectmangerrest.model.Project;
import com.parma.fse.projectmangerrest.model.ResponseObject;
import com.parma.fse.projectmangerrest.service.ProjectService;

@RestController
@RequestMapping("/api/pm/project")
public class ProjectController {
Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(path="/saveProject", method = RequestMethod.POST )
	public ResponseObject<String> saveProject(@RequestBody Project project){
		ResponseObject<String> responseObject = null;
		LOGGER.info("PROJECT:"+project);
		try{
			project=projectService.saveProject(project);
			responseObject = new ResponseObject<String>(project.getProject().toString(), "Success", "200");
		}catch(Exception e){
			LOGGER.error("Error occured while saving Project Details");
			responseObject = new ResponseObject<String>(null, "FAIL", "500");
		}
		return responseObject;
	}
	
	@RequestMapping(path="/getProjects", method = RequestMethod.POST)
	public ResponseObject<List<Project>> getProjects(){
		ResponseObject<List<Project>> responseObject = null;
		try{
			List<Project> projectList = projectService.getProjects();			
			responseObject = new ResponseObject<List<Project>>(projectList, "SUCCESS", "200");
		}catch(Exception e){
			responseObject = new ResponseObject<List<Project>>(null, "FAIL", "500");
		}
		return responseObject;
	}
	

}
