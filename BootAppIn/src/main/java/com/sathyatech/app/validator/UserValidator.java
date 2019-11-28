package com.sathyatech.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sathyatech.app.model.User;
import com.sathyatech.app.service.IUserService;
@Component
public class UserValidator implements Validator{
	
	@Autowired
	private IUserService userService;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user= (User)target;
		
		if(StringUtils.isEmpty(user.getUserName())){
			errors.rejectValue("userName", "", "Plz Provide UserName");
		}
		else if(!Pattern.compile("[a-zA-z0-9]{6,20}").matcher(user.getUserName()).matches()){
			errors.rejectValue("userName", "", "Only Chars and Digits Allowed");
		}
		
		if(!Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}").matcher(user.getUserEmail()).matches()) {
			errors.rejectValue("userEmail", "", "Enter Valid User Email!");
		}
		
		if(StringUtils.isEmpty(user.getPassword())){
			errors.rejectValue("password", "", "Plz Enter Password!");
		}
		else if(!Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$").matcher(user.getPassword()).matches()){
			errors.rejectValue("password", "", "Password must contain: Minimum 8 characters atleast 1 Alphabet and 1 Number!");
		}
		
		/*if(user.getRoles().isEmpty()){
			errors.rejectValue("roles", "", "Plz Select Roles");
		}*/
	}
}