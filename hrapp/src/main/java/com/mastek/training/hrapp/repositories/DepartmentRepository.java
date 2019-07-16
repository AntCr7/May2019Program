package com.mastek.training.hrapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mastek.training.hrapp.entities.Department;


public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
