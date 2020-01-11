package com.app.service;

import java.util.List;

import com.app.entity.Employee;

public interface EmpService {
	public String save(Employee emp);
	public List<Employee> getAll();
	public void delete(int empId);
	public String update(Employee employee);
	public Employee getOne(int empId);
	public boolean isExist(int empId);

}
