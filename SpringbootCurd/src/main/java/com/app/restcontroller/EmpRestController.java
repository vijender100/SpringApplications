package com.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.EmpService;

@RestController

public class EmpRestController {
	@Autowired
	private EmpService service;
	
	@GetMapping("/restall")
	public ResponseEntity<?> getAll(){
		List<Employee> list=service.getAll();
		return  new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	@PostMapping("/restsave")
	public ResponseEntity<?> save(@RequestBody Employee employee){
		 String s=  service.save(employee);
		 return  new ResponseEntity<String>(s,HttpStatus.OK);
	}
	@DeleteMapping("restdel/{empId}")
	public ResponseEntity<?> delete(@PathVariable int  empId){
		if(service.isExist(empId)) {
			service.delete(empId);
			return ResponseEntity.ok("deleted successfully");
		}else {
		return ResponseEntity.ok("Record Not Found");
		}
		
	}

}
