 package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/saveEmp")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<String>(service.saveEmp(employee),HttpStatus.OK);
	}
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<List<Employee>>(service.getAll(),HttpStatus.OK);
		
	}
}
