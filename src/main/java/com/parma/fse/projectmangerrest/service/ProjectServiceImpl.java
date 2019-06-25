package com.parma.fse.projectmangerrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parma.fse.projectmangerrest.model.Project;
import com.parma.fse.projectmangerrest.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public List<Project> getProjects() {
		return projectRepository.findAll();
	}

}
