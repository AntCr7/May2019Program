package com.mastek.training.hrapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.DepartmentService;
import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.entities.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentApplicationTests {
	
	@Autowired
	DepartmentService depService;
	
	@Autowired
	Department dep;
	
	
	@Test
	public void  addEmployeeUsingService() {
		dep.setDeptno(0);
		dep.setLocation("London");
		dep.setName("New Department");;
		dep = depService.registerOrUpdateEmployee(dep);
		assertNotNull(dep);
		
	}
	
	
//	@Test
//	public void findByDepnoUsingService() {
//		int depno = 7;
//		assertNotNull(depService.findByDepno(depno));
//		
//	}
	
	@Test
	public void deleteByDepnoUsingService() {
		int depno =12;
		depService.deleteBydepno(depno);
		assertNull(depService.findByDepno(depno));
	}
	
//	@Test
//	public void checkFetchBySalary() {
//		List<Employee> deps = depService.fetchEmployeeBySalaryRange(0, 1000);
//		for (Employee employee : emps) {
//			System.out.println(employee);;
//		}
//		assertEquals(emps.size(),2);
//	}
//	
	
	@Test
	public void contextLoads() {
	}
	}


