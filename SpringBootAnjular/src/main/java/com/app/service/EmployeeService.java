package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface EmployeeService {
	
	public String saveEmp(Employee employee);
	public List<Employee> getAll();

}
