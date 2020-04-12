package com.app.dao;

import java.io.Serializable;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.entity.Employee;

@RunWith(SpringRunner.class)
//@DataJpaTest
public class EmpDaoTest {
	
	@MockBean
	JpaRepository<Employee, Serializable> jpaRepository;
	
	@Test
	public void test1() {
		Mockito.when(jpaRepository.findAll()).thenReturn(Collections.emptyList());
		jpaRepository.findAll();
		
	}

	
}
