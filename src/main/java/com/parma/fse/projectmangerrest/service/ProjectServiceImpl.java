package com.parma.fse.projectmangerrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parma.fse.projectmangerrest.model.Project;
import com.parma.fse.projectmangerrest.model.Task;
import com.parma.fse.projectmangerrest.repository.ProjectRepository;
import com.parma.fse.projectmangerrest.repository.TaskRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImpl.class);
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public List<Project> getProjects() {
		List<Project> projectList = new ArrayList<>();
		List<Task> taskList = new ArrayList<>();
		List<Task> taskListForProject = new ArrayList<>();
		List<Task> completedTaskListForProject = new ArrayList<>();
		taskList = taskRepository.findAll();
		projectList =projectRepository.findAll();
		for(Project p : projectList){			
			taskListForProject=taskList.stream().filter(t -> Integer.parseInt(t.getProjectId()) == p.getProjectId()).collect(Collectors.toList());
			p.setNoOfTask(taskListForProject.size());
			
			completedTaskListForProject=taskList.stream().filter(t -> Integer.parseInt(t.getProjectId()) == p.getProjectId() && t.getStatus().equalsIgnoreCase("COMPLETED")).collect(Collectors.toList());
			p.setNoOfTaskCompleted(completedTaskListForProject.size());
		}
		
		return projectList;
	}

}
