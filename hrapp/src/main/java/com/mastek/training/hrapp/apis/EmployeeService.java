package com.mastek.training.hrapp.apis;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Employee;
//indicate to spring to create and object of this class as component 
//@scope: singleton: one object for application [default]
//			prototype: one object copy for each usage

@Component
@Scope("singleton")
public class EmployeeService {
		//constructor
		public EmployeeService() {
			System.out.println("Employee Service Created");
		}
	
		public Employee registerEmployee(Employee emp) {
			System.out.println("Employee Registered "+emp);
			return emp;
		}

}
