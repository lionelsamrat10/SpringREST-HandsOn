package com.cognizant.springlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	//Create a method called sayHello()
	@GetMapping(value = "/hello")
	public String sayHello() {
		return "Hello World!!";
	}
}
