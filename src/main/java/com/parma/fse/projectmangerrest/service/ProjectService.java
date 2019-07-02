package com.parma.fse.projectmangerrest.service;

import java.util.List;

import com.parma.fse.projectmangerrest.model.Project;

public interface ProjectService {
	public Project saveProject(Project project);
	public List<Project> getProjects();
	

}
