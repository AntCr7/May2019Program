package com.mastek.training.hrapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Employee;
//indicate to spring to create and object of this class as component 
//@scope: singleton: one object for application [default]
//			prototype: one object copy for each usage
import com.mastek.training.hrapp.repositories.EmployeeRepository;

@Component
@Scope("singleton")
public class EmployeeService {
	
		@Autowired
		private EmployeeRepository employeeRepository;
	
		//constructor
		public EmployeeService() {
			System.out.println("Employee Service Created");
		}
	
		public Employee registerOrUpdateEmployee(Employee emp) {
			emp = employeeRepository.save(emp);
			System.out.println("Employee Registered "+emp);
			return emp;
		}

//		public Employee findByEmpno(int empno) {
//			// TODO Auto-generated method stub
//			return employeeRepository.findById(empno).get();
//		}

		public Employee findByEmpno(int empno) {
			// fetches the Employee details from DB by empno
			try {
				return employeeRepository.findById(empno).get();
			} catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}
		
		public void deleteByEmpno(int empno) {
			employeeRepository.deleteById(empno);
		}
			
		
		public List<Employee> fetchEmployeeBySalaryRange(
				double min, double max){
			return employeeRepository.findBySalary(min, max);
		}
}
