package com.parma.fse.projectmangerrest.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity()
@Table(name = "TASK")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "task_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;

	@Column(name = "task_name")
	private String taskName;

	private String priority;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = true)
	@JoinColumn(name = "parent_id", nullable = true)
	private ParentTask parentTask;
	
	@Column(name= "user_id")
	private String userId;
	
	@Column(name = "project_id")
	private String projectId;
	
	@Column(name = "start_Date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate startDate;

	@Column(name = "end_date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate endDate;
	
	@Column(name = "edit_enabled")
	private String editEnabled;
	
	@Column(name= "status", insertable=false)
	private String status;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
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

	public String getEditEnabled() {
		return editEnabled;
	}

	public void setEditEnabled(String editEnabled) {
		this.editEnabled = editEnabled;
	}	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public ParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", priority=" + priority + ", parentTask="
				+ parentTask + ", userId=" + userId + ", projectId=" + projectId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", editEnabled=" + editEnabled + ", status=" + status + "]";
	}

	
	
	

	
	

	
	
	

}
