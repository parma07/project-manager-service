package com.parma.fse.projectmangerrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.parma.fse.projectmangerrest.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
	
	

}
