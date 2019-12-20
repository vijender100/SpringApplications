package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDao;
import com.app.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao Dao;

	@Override
	public String saveEmp(Employee employee) {
		Employee e = Dao.save(employee);
		return "Employee saved with Id" + e.getEmpId();
	}

	@Override
	public List<Employee> getAll() {
		return Dao.findAll();
	}
}
