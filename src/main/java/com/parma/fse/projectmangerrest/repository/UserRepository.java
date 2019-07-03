package com.parma.fse.projectmangerrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parma.fse.projectmangerrest.model.User;

	@Repository
	public interface UserRepository extends JpaRepository<User, Integer> {		
		static final String FIND_ALL_USERS_WITH_NO_PROJECT = "SELECT u FROM User u where u.projectId = 0 or u.projectId is null";
		
		@Query(FIND_ALL_USERS_WITH_NO_PROJECT)
		List<User> getUsersWithNoProject();
}
