package com.proship.omrs.todoList.controller;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Date;
import java.sql.Timestamp;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import com.proship.omrs.todoList.entity.TodoList;
import com.proship.omrs.todoList.repository.TodoListRepository;
import com.proship.omrs.user.entity.User;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@RunWith(JUnitPlatform.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
//@SpringJUnitJupiterWebConfig(WebConfig.class)
public class TestTodoListController {
	
	
	@Mock
	TodoListRepository repo;
//	
//	@Mock
//	TodoListController controller;
//	
	@InjectMocks
	TodoListController controller;
	
	@BeforeAll
	void initAll(){
		MockitoAnnotations.initMocks(this);
	}
	@SuppressWarnings("deprecation")
	@BeforeEach
	void init(){
		TodoList todoList = new TodoList();
		todoList.setCreateDate(new Timestamp(System.currentTimeMillis()));
		todoList.setDone(false);
		todoList.setDueDate(new Timestamp(new Date(2017,10,5).getTime()));
		todoList.setId((long) 2);
		todoList.setPriorityId((long)2);
		todoList.setText("todoList test 1");
		User user = new User();
		user.setId((long)1);
		user.setName("testUser");
		todoList.setUser(user);
		
	}

	@Test
	void testCreate(){
		
	}
	
	@Test
	void testGet(){
		
	}
	@Test
	void testUpdate(){
		
	}
	@Test
	void testList(){
		
	}
	
	@AfterEach
	void tearDown(){
		
	}
	@AfterAll
	void tearAll(){
		
	}
}	
