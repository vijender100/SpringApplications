package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.app.dao.EmpDao;
import com.app.entity.Employee;

@Service
public class EmpServiceImpl implements EmpService {

	String msg = "";

	@Autowired
	private EmpDao dao;

	@Override
	public String save(Employee emp) {
		Employee e = dao.save(emp);
		int i = e.getEmpId();
		if (i > 0) {
			msg = "Employee saved with " + i;

		} else {
			// System.out.println("failed");
			msg = "Employee Registration failed";
		}
		return msg;
	}

	@Override
	@Cacheable(value = "allempCache")
	public List<Employee> getAll() {
		System.out.println("schduled job");
		List<Employee> list = dao.findAll();
		System.out.println(list);
		return list;
	}

	@Override
	public void delete(int empId) {
		dao.delete(empId);

	}

	@Override
	public String update(Employee employee) {
		Employee e = dao.save(employee);
		int n = e.getEmpId();
		if (n > 0) {
			msg = "Record updated";
		} else {
			msg = "record updatin failed";
		}
		return msg;
	}

	@Override
	public Employee getOne(int empId) {
		Employee emp = dao.findOne(empId);
		return emp;
	}

	@Override
	public boolean isExist(int empId) {
		return dao.exists(empId);
	}

}
