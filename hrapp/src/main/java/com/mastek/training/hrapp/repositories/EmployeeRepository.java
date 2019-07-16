package com.mastek.training.hrapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Employee;


@Component 
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	//eclare the custom query method 
	public List<Employee> findBySalary(
			@Param("min") Double mon, //declare parameter name being used at param
			@Param("max") Double max);
	

}
