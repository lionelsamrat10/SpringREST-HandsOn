package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.Scanner;

import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Repository
public class EmployeeDao {
	private ArrayList<Employee> employeeList;
	public EmployeeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		 employeeList = context.getBean("employeeList", ArrayList.class);
	}
	//This method returns the EmployeeList
	public ArrayList<Employee> getAllEmployees(){
		return employeeList;
	}
	//Find employee by Id
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		for(Employee employee: employeeList) {
			if(employee.getId() == id) {
				return employee;
			}
		}
		throw new EmployeeNotFoundException("Employee with id: " + id + " not found!!");
	}
	//Update employee based on id
	public void updateEmployee(int id, @Valid Employee employee) throws EmployeeNotFoundException {
		for(Employee employees: employeeList) {
			if(employees.getId() == id) {
				employees.setId(employee.getId());
				employees.setName(employee.getName());
				employees.setPermanent(employee.isPermanent());
				employees.setSalary(employee.getSalary());
				return;
			}
		}
		throw new EmployeeNotFoundException("Employee not present with id: " + id);
	}
	//Delete employee based on id
	public ArrayList<Employee> deleteEmployee(int id) throws EmployeeNotFoundException {
		for(Employee employees: employeeList) {
			if(id == employees.getId()) {
				employeeList.removeIf(t -> t.getId() == id);
				return employeeList;
			}
		}
		throw new EmployeeNotFoundException("Cannot Delete!! Employee not present with id: " + id);
	}
}
