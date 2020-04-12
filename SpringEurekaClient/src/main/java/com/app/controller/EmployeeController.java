package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {
	
	@Autowired
    RestTemplate restTemplate;


	@GetMapping(value = "/getEmployees")
	public ResponseEntity<?> getEmployees() {
		/*
		 * List<Employee> employess = new ArrayList<>(); Employee emp = new Employee();
		 * emp.setEmpId(100); emp.setEmpName("Vijender"); emp.setEmpAddress("Chennai");
		 * employess.add(emp);
		 */
		return new ResponseEntity<>(restTemplate.getForObject("http://employee1-service/getEmployees",List.class), HttpStatus.OK);

	}

}
