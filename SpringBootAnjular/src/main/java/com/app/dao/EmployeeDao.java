package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;
@Repository
public interface EmployeeDao  extends JpaRepository<Employee, Long>{
 
	
}
