package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping(value = "/getEmployees")
	public ResponseEntity<?> getEmployees() {
		List<Employee> employess = new ArrayList<>();
		Employee emp = new Employee();
		emp.setEmpId(100);
		emp.setEmpName("Vijender");
		emp.setEmpAddress("Warangal");
		employess.add(emp);
		return new ResponseEntity<>(employess, HttpStatus.OK);

	}

}
