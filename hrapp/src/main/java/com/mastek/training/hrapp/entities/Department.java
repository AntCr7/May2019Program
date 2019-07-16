package com.mastek.training.hrapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // one copy for each test
@Entity //declares the class as an Entity
@Table(name="JPA_DEPARTMENT") //declare table name for the class
//@NamedQueries({
//	@NamedQuery(name="Employee.findBySalary", query="select e from Employee e where e.salary between:min and :max")
//	
//})
public class Department implements Serializable {
		
	
private int deptno;
private String name;
private String location;
// OneToMany: One Department has many Employees
private Set<Employee> members = new HashSet<>();

public Department() {
	System.out.println("Department Created");
}

//ONETOMANY: used on the get method of set to configure association 
//fetch = LAZY: delay the initialization until method getMembers() is called using additional select query 
//EAGER: Initialize the collection on entity find post load event 
//cascade=ALL the entity operation done on Department would be performed on each associated employee object
// ALL: [Persist, Merge, Delete, Refresh]
//mappedBy: identifies the propertyname in Child class where the JoinColumn confguration is present joinColumn:: ForeignKEy

@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="currentDepartment")
public Set<Employee> getMembers() {
	return members;
}

public void setMembers(Set<Employee> members) {
	this.members = members;
}

@Id //declare the property as primary key
@Column(name="department_number") //declRE THE COLUMN NAME
@GeneratedValue(strategy=GenerationType.AUTO)
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}

@Column(name="department_name",nullable=false, length=45)
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}


public void setLocation(String location) {
	this.location = location;
}

@Override
public String toString() {
	return "Department [deptno=" + deptno + ", name=" + name + ", location=" + location + "]";
}
	
}
	