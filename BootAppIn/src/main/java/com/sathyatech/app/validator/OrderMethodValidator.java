package com.sathyatech.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sathyatech.app.model.OrderMethod;
import com.sathyatech.app.service.IOrderMethodService;
import com.sathyatech.app.util.OrderMethodUtil;

@Component
public class OrderMethodValidator implements Validator {

	private boolean isEdit;

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	@Autowired
	private OrderMethodUtil util;

	@Autowired
	private IOrderMethodService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		OrderMethod orderMethod = (OrderMethod) target;
		if(!util.getOrderModes().contains(orderMethod.getOrderMode())) {
			errors.rejectValue("orderMode", "", "Please choose one of Order Mode!");
		}

		if(!Pattern.compile("[A-Z \\t\\n\\x0B\\f\\r]{4,12}").matcher(orderMethod.getOrderCode()).matches()) {
			errors.rejectValue("orderCode", "", "Order Code must be between 4-12 Characters only!");
		}

		if(!util.getOrderMethods().contains(orderMethod.getOrderMethd())) {
			errors.rejectValue("orderMethd", "", "Please select valid Order Method");
		}

		if(!Pattern.compile("[A-Za-z \\t\\n\\x0B\\f\\r]{8,255}").matcher(orderMethod.getDescription()).matches()){
			errors.rejectValue("description", "", "Description must between 8-255 characters only!");
		}
		if(!isEdit && service.isOrderCodeAndMethodExist(orderMethod.getOrderCode(), orderMethod.getOrderMethd())) {
			errors.rejectValue("orderCode", "", "Order '"+orderMethod.getOrderCode()+"' with '"+orderMethod.getOrderMethd()+"' exist");
		}
	}
}
