package com.parma.fse.projectmangerrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.parma.fse.projectmangerrest.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
	@Modifying(clearAutomatically = true)
	@Query("update Task task set task.editEnabled =:editEnabled, task.endDate = sysdate(), task.status = 'COMPLETED'  where task.taskId =:taskId")
	public void updateTaskEditEnabled(@Param("editEnabled") String editEnabled, @Param("taskId") Integer taskId);
}
