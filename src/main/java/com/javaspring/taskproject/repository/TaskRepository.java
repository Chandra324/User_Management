package com.javaspring.taskproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspring.taskproject.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	
	List<Task> findAllByUsersId(long userid);
}
