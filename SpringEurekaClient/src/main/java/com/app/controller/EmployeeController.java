package com.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class EmployeeController {
	
	@Autowired
    RestTemplate restTemplate;


	@GetMapping(value = "/getEmployees")
	@HystrixCommand(fallbackMethod = "samplefallbackmethod",commandProperties = { 
	        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
	public ResponseEntity<?> getEmployees() throws InterruptedException {
		/*
		 * List<Employee> employess = new ArrayList<>(); Employee emp = new Employee();
		 * emp.setEmpId(100); emp.setEmpName("Vijender"); emp.setEmpAddress("Chennai");
		 * employess.add(emp);
		 */
		Thread.sleep(3000);
		return new ResponseEntity<>(restTemplate.getForObject("http://employee1-service/getEmployees",List.class), HttpStatus.OK);

	}
	public ResponseEntity<?> samplefallbackmethod() {
		return new ResponseEntity<>("CIRCUIT BREAKER ENABLED!!! No Response From Student Service at this moment. Service will be back shortly - " + new Date(),HttpStatus.OK);
	}

}
