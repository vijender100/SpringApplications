package com.sathyatech.app.controller.multipart.validator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sathyatech.app.model.ShipmentType;
import com.sathyatech.app.service.IShipmentTypeService;
import com.sathyatech.app.util.ShipmentTypeUtil;

@Component
public class ShipmentTypeMultipartValidator {

	@Autowired
	private ShipmentTypeUtil util;
	
	@Autowired
	private IShipmentTypeService service;
	
	public Map<String,List<String>> validateShipmentType(List<ShipmentType> shipmentTypes){
		
		Map<String,List<String>> errorsMap = new LinkedHashMap<String,List<String>>(); 
		int i = 1;
		for(ShipmentType shipmentType:shipmentTypes) {
			List<String> errorList = new ArrayList<String>();
		
			if(StringUtils.isEmpty(shipmentType.getShipmentMode())) {
				errorList.add("Shipment Mode Cannot be Empty.");
			}
			else if(!util.getShipmentModes().contains(shipmentType.getShipmentMode())) {
				errorList.add("ShipmentType must be one of: "+util.getShipmentModes());
			}
			if(StringUtils.isEmpty(shipmentType.getShipmentCode())) {
				errorList.add("Shipment Code Cannot be Empty.");
			}
			else if(!Pattern.compile("[A-Z \\t\\n\\x0B\\f\\r]{4,12}").matcher(shipmentType.getShipmentCode()).matches()) {
				errorList.add("Shipment Code must be 4-12 Uppercase letters only");
			}
			if(StringUtils.isEmpty(shipmentType.getEnableShipment()))
			{
				errorList.add("Enable ShipmentType Can not be empty");
			}
			if(StringUtils.isEmpty(shipmentType.getShipmentGrade()))
			{
				errorList.add("ShipmentType Grade Can not be empty");
			}
			else if(!util.getShipmentGrades().contains(shipmentType.getShipmentGrade()))
			{
				errorList.add("ShipmentType Grade Must be one of:"+util.getShipmentGrades().toString());
			}
			if(StringUtils.isEmpty(shipmentType.getDescription())) {
				errorList.add("Description can not be empty");
			}
			
			else if(!Pattern.compile("[a-zA-Z \\t\\n\\x0B\\f\\r]{10,255}").matcher(shipmentType.getDescription()).matches()) {
				errorList.add("Description must between 10-255 characters only.");
			}
			if(service.isShipmentModeAndCodeExist(shipmentType.getShipmentMode(), shipmentType.getShipmentCode())) {
				errorList.add("ShipmentType '"+shipmentType.getShipmentMode()+"' already exist with '"+shipmentType.getShipmentCode()+"' ");
			}
			if(!errorList.isEmpty()) {
				errorsMap.put("Errors at Row# "+i,errorList);
			}
			i++;
		}
		return errorsMap;
	}
}
