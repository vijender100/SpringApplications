package com.sathyatech.app.controller.multipart.validator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sathyatech.app.model.Uom;
import com.sathyatech.app.service.IUomService;
import com.sathyatech.app.util.UomUtil;

@Component
public class UomMultipartValidator {

	@Autowired
	private UomUtil util;
	
	@Autowired
	private IUomService service;
	
	
	public Map<String,List<String>> validateUoms(List<Uom> uoms){
		
		Map<String,List<String>> errorsMap = new LinkedHashMap<String,List<String>>(); 
		int i = 1;
		for(Uom uom:uoms) {
			List<String> errorList = new ArrayList<String>();
			//check one by one obj
			if(StringUtils.isEmpty(uom.getUomType())) {
				errorList.add("Uom Type Cannot be Empty.");
			}
			
			else if(!util.getUomTypes().contains(uom.getUomType())) {
				errorList.add("Uom Type must be one of: "+util.getUomTypes().toString());
			}
			
			if(StringUtils.isEmpty(uom.getUomModel())) {
				errorList.add("Uom Model Cannot be Empty.");
			}
			
			else if(!Pattern.compile("[A-Z \\t\\n\\x0B\\f\\r]{4,12}").matcher(uom.getUomModel()).matches()) {
				errorList.add("Uom Model must be 4-12 Uppercase letters only");
			}
			
			if(StringUtils.isEmpty(uom.getDescription())) {
				errorList.add("Description can not be empty");
			}
			
			else if(!Pattern.compile("[a-zA-Z \\t\\n\\x0B\\f\\r]{10,255}").matcher(uom.getDescription()).matches()) {
				errorList.add("Description must between 10-255 characters only.");
			}
			
			if (service.isUomTypeAndModelExist(uom.getUomType(), uom.getUomModel())) {
				errorList.add("Uom '"+uom.getUomModel()+"' already exist with Type '"+uom.getUomType()+"' ");
			}
			
			if(!errorList.isEmpty()) {
				errorsMap.put("Errors at Row# "+i,errorList);
			}
			i++;
				
		}
		return errorsMap;
	}
}
