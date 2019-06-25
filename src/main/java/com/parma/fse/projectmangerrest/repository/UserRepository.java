package com.parma.fse.projectmangerrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parma.fse.projectmangerrest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
