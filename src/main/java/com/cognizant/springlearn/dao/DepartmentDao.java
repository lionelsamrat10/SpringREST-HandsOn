package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Department;

@Repository
public class DepartmentDao {
	private static ArrayList<Department> departmentList;
	public DepartmentDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("department.xml");
		departmentList = context.getBean("departmentList", ArrayList.class);
	}
	public ArrayList<Department> getAllDepartments(){
		return departmentList;
	}
}
