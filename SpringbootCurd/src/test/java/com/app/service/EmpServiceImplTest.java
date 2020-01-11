package com.app.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.dao.EmpDao;
import com.app.entity.Employee;

@RunWith(SpringRunner.class)

public class EmpServiceImplTest {
	
	@MockBean
	 EmpServiceImpl service;
	
	@MockBean
	EmpDao dao;
	
	@Test
	public void testSave() {
		Employee emp = new Employee();
		emp.setEmpId(12);
		emp.setEmpName("vijender");
		emp.setEmpPh("9700554587");
		emp.setEmpSal(908.0);
		Mockito.when(dao.save(emp)).thenReturn(emp);
		Mockito.when(service.save(emp)).thenReturn("employee saved");
	 assertEquals(service.save(emp),"employee saved");
	}
}
