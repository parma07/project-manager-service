package com.parma.fse.projectmangerrest.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity()
@Table(name="project")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "project_id")
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer projectId;
	
	@Column(name="project")
	private String project;
	
	@Column(name= "start_date")
	private LocalDate startDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@Column(name = "priority")
	private Integer priority;
	
	@Column(name= "manager")
	private Integer manager;
	
	@Column(name = "status", insertable=false)
	private String status;
	
	@Transient
	private Integer noOfTask;
	
	@Transient
	private Integer noOfTaskCompleted;
	

	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getManager() {
		return manager;
	}
	public void setManager(Integer manager) {
		this.manager = manager;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getNoOfTask() {
		return noOfTask;
	}
	public void setNoOfTask(Integer noOfTask) {
		this.noOfTask = noOfTask;
	}
	public Integer getNoOfTaskCompleted() {
		return noOfTaskCompleted;
	}
	public void setNoOfTaskCompleted(Integer noOfTaskCompleted) {
		this.noOfTaskCompleted = noOfTaskCompleted;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", project=" + project + ", startDate=" + startDate + ", endDate="
				+ endDate + ", priority=" + priority + ", manager=" + manager + ", status=" + status + "]";
	}
	
	
	
	
	
		

}
