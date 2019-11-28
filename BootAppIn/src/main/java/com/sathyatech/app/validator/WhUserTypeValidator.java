package com.sathyatech.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sathyatech.app.model.WhUserType;
import com.sathyatech.app.util.WhUserTypeUtil;

@Component
public class WhUserTypeValidator implements Validator {

	private boolean isEdit;

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	@Autowired
	private WhUserTypeUtil util;

	@Override
	public boolean supports(Class<?> clazz) {
		return WhUserType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		WhUserType whUserType = (WhUserType) target;
		if(!util.getUserType().contains(whUserType.getUserType())) {
			errors.rejectValue("userType", "", "Please select one of User Type");
		}
		if(!Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}").matcher(whUserType.getUserEmail()).matches()) {
			errors.rejectValue("userEmail", "", "Enter Valid User Email!");
		}
		if(!Pattern.compile("\\w{10}").matcher(whUserType.getUserContact()).matches()) {
			errors.rejectValue("userContact", "", "Please Enter Valid Mobile Number");
		}
		if(!util.getUserIdType().contains(whUserType.getUserIdType())) {
			errors.rejectValue("userIdType", "", "Please Select one of User Id Type");
		}
		if("OTHERS".equalsIgnoreCase(whUserType.getUserIdType())){
			errors.rejectValue("ifOther", "", "Please Provide Other ID Type");
		}
		if(whUserType.getIdNumber().isEmpty()) {
			errors.rejectValue("idNumber", "", "Enter Your Id Number");
		}
	}
}
