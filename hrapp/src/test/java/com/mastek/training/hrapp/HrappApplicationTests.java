package com.mastek.training.hrapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

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
		emp.setEmpno(5);
		emp.setName("New Empoyee 5");
		emp.setSalary(9882);
		emp = empService.registerOrUpdateEmployee(emp);
		assertNotNull(emp);
		
	}
	
	
	@Test
	public void findByEmpnoUsingService() {
		int empno = 4;
		assertNotNull(empService.findByEmpno(empno));
		
	}
	
	@Test
	public void deleteByEmpnoUsingService() {
		int empno =6;
		empService.deleteByEmpno(empno);
		assertNull(empService.findByEmpno(empno));
	}
	
	@Test
	public void checkFetchBySalary() {
		List<Employee> emps = empService.fetchEmployeeBySalaryRange(0, 1000);
		for (Employee employee : emps) {
			System.out.println(employee);;
		}
		assertEquals(emps.size(),1);
	}
	
	
	@Test
	public void contextLoads() {
	}
	}


