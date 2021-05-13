package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.service.DepartmentService;
import com.cognizant.springlearn.Department;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(value = "/departments")
	public ArrayList<Department> getAllDepartments(){
		return departmentService.getAllDepartments();
	}
	
}
