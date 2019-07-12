package com.mastek.training.hrapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.entities.Employee;

//Intialize the JUnit Test with spring boot Application Environment 
// Spring Boot Test: used to test Spring ApplicationContext
//with all the test cases identified

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrappApplicationTests {
	
	//scan in memory all the components and provide the best match object in the component 
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	Employee emp;
	
	

	@Test
	public void  addEmployeeUsingService() {
		empService.registerEmployee(emp);
		
	}
	
	@Test
	public void contextLoads() {
	}
	}


