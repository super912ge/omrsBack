package com.proship.omrs.todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.proship.omrs.todoList.entity.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList,Long>,QueryDslPredicateExecutor<TodoList>{
	
	
}
