package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.entity.Employee;
@Component
public class EmpValidator implements  Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee emp=(Employee)target;
		//Pattern pattern =new Pattern("[0-9]{4,12}", 0);
		if(!Pattern.compile("[a-zA-Z]{5,20}").matcher(emp.getEmpName()).matches()) {
			//System.out.println(emp.getEmpSal());
			errors.rejectValue("empName", "", "EmpName muse be [a-zA-Z] 10 to 20 chars only");
		}
		/*
		 * if(!Pattern.compile("[0-9]{4,12}").){
		 * 
		 * errors.rejectValue("empSal", "", "Plz Enter your salary"); }
		 */
		
		
		/*
		 * else if(!Pattern.compile("[0-9]{4,12}").matcher(emp.getEmpSal()).matches()){
		 * errors.rejectValue("refernceNumber", "", "4-12 Digits Only"); }
		 */
		if(!Pattern.compile("\\w{10}").matcher(emp.getEmpPh()).matches()) {
			errors.rejectValue("empPh", "", "Please Enter Valid Mobile Number");
		}
		
		
	}

}
