package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.service.EmployeeService;
import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping()
	public List<Employee> getAllEmployees(){
		LOGGER.info("Start");
		LOGGER.info("End");
		return employeeService.getAllEmployees();
	}
	@GetMapping(value = "{id}")
	public Employee getCountryByCode(@PathVariable("id") int id) throws EmployeeNotFoundException {
		LOGGER.info("Start");
		LOGGER.info("End");
		return employeeService.getEmployeeById(id);
	}
	@PutMapping("{id}")
	public void updateEmployee(@PathVariable("id") int id, @RequestBody @Valid Employee employee) throws EmployeeNotFoundException{
		LOGGER.info("Start");
		LOGGER.info("End");
		employeeService.updateEmployee(id, employee);
	}
	@DeleteMapping("{id}")
	public ArrayList<Employee> deleteEmployee(@PathVariable("id") int id) throws EmployeeNotFoundException, ConcurrentModificationException{
		LOGGER.info("Start");
		LOGGER.info("End");
		return employeeService.deleteEmployee(id);
	}
}
