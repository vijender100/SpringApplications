 package com.sathyatech.app.controller.multipart.validator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sathyatech.app.model.OrderMethod;
import com.sathyatech.app.service.IOrderMethodService;
import com.sathyatech.app.util.OrderMethodUtil;

@Component
public class OrderMethodMultipartValidator {

	@Autowired
	private OrderMethodUtil util;
	
	@Autowired
	private IOrderMethodService service;
	
public Map<String,List<String>> validateOrderMethod(List<OrderMethod> orderMethods){
		
		Map<String,List<String>> errorsMap = new LinkedHashMap<String,List<String>>(); 
		int i = 1;
		for(OrderMethod orderMethod:orderMethods) {
			List<String> errorList = new ArrayList<String>();
			
			if(StringUtils.isEmpty(orderMethod.getOrderMode()))
			{
				errorList.add("OrderMethod Mode Can not be empty");
			}
			else if(!util.getOrderModes().contains(orderMethod.getOrderMode()))
			{
				errorList.add("OrderMethod Mode must be one of: "+util.getOrderModes().toString());
			}
			if(StringUtils.isEmpty(orderMethod.getOrderCode())) {
				errorList.add("Order Code Cannot be Empty.");
			}
			else if(!Pattern.compile("[A-Z \\t\\n\\x0B\\f\\r]{4,12}").matcher(orderMethod.getOrderCode()).matches()) {
				errorList.add("Order Code must be 4-12 Uppercase letters only");
			}
			if(StringUtils.isEmpty(orderMethod.getOrderMethd())) {
				errorList.add("Order Method Cannot be Empty.");
			}
			else if(!util.getOrderMethods().contains(orderMethod.getOrderMethd())) {
				errorList.add("Order Method must be one of: "+util.getOrderMethods());
			}
			if(StringUtils.isEmpty(orderMethod.getDescription())) {
				errorList.add("Description can not be empty");
			}
			
			else if(!Pattern.compile("[a-zA-Z \\t\\n\\x0B\\f\\r]{10,255}").matcher(orderMethod.getDescription()).matches()) {
				errorList.add("Description must between 10-255 characters only.");
			}
			if(service.isOrderCodeAndMethodExist(orderMethod.getOrderCode(), orderMethod.getOrderMethd())) {
				errorList.add("OrderMethod '"+orderMethod.getOrderMode()+"' With '"+orderMethod.getOrderCode()+"' already exist ");
			}
			if(!errorList.isEmpty()) {
				errorsMap.put("Errors at Row# "+i,errorList);
			}
			i++;
		}

		return errorsMap;
	}
}
