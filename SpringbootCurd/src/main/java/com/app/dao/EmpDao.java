package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Employee;

public interface EmpDao extends JpaRepository<Employee, Integer> {

}
