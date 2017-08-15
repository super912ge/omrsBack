package com.proship.omrs.todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proship.omrs.base.controller.BaseController;
import com.proship.omrs.todoList.entity.TodoList;
import com.proship.omrs.todoList.repository.TodoListRepository;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping(value="/todo/")
@CrossOrigin
public class TodoListController extends BaseController<TodoList,Long>{


	@Autowired
	public TodoListController(TodoListRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
//	@Autowired
//	TodoListService todoService;

}
