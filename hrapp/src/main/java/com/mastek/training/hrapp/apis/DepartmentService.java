package com.mastek.training.hrapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Department;

import com.mastek.training.hrapp.repositories.DepartmentRepository;


@Component
@Scope("singleton")
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	//constructor
	public DepartmentService() {
		System.out.println("Department Service Created");
	}

	public Department registerOrUpdateEmployee(Department dep) {
		dep = departmentRepository.save(dep);
		System.out.println("Department Registered "+dep);
		return dep;
	}

	

	public Department findByDepno(int depno) {
		// fetches the Employee details from DB by empno
		try {
			return departmentRepository.findById(depno).get();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void deleteBydepno(int depno) {
		departmentRepository.deleteById(depno);
	}
		
		
	
//	public List<Department> fetchBySalaryRange(
//			double min, double max){
//		return employeeRepository.findBySalary(min, max);
//	}
}


