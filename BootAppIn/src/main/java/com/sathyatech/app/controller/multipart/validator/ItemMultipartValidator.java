package com.sathyatech.app.controller.multipart.validator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sathyatech.app.model.Item;

@Component
public class ItemMultipartValidator {

	public Map<String, List<String>> validateItems(List<Item> items) {
		Map<String, List<String>> errorsMap = new LinkedHashMap<String, List<String>>();
		int i = 1;

		for (Item item : items) {
			List<String> errorList = new ArrayList<String>();
			
			if(StringUtils.isEmpty(item.getItemCode())) {
				errorList.add("Item Code cannot be empty!");
			}
			else if(!Pattern.compile("[a-zA-Z0-9]{4,12}").matcher(item.getItemCode()).matches()) {
				errorList.add("Item Code must be 4-12 chars with digits only!");
			}
			if(StringUtils.isEmpty(item.getBaseCost())){
				errorList.add("Base Cost cannot be empty!");
			}
			if(StringUtils.isEmpty(item.getBaseCurrency())) {
				errorList.add("Base Currency cannot be empty!");
			}
			else if(!Pattern.compile("[A-Z]{3,6}").matcher(item.getBaseCurrency()).matches()) {
				errorList.add("Base Currency must be upperCase digits only!");
			}
			//Uom
			if(StringUtils.isEmpty(item.getUom())) {
				errorList.add("Please Enter Valid Uom");
			}
			if(StringUtils.isEmpty(item.getOmSale())) {
				errorList.add("OrderMethod Sale Type cannot be empty!");
			}
			if(StringUtils.isEmpty(item.getOmPurchase())) {
				errorList.add("OrderMethod Purchase Type cannot be empty!");
			}
			if(StringUtils.isEmpty(item.getWhVendors())) {
				errorList.add("Wh Vendors cannot be empty!");
			}
			if(StringUtils.isEmpty(item.getDescription())) {
				errorList.add("Description can not be empty");
			}
			else if(!Pattern.compile("[a-zA-Z \\t\\n\\x0B\\f\\r]{10,255}").matcher(item.getDescription()).matches()) {
				errorList.add("Description must between 4-255 characters only.");
			}
			 
			if(!errorList.isEmpty()) {
				errorsMap.put("Errors at Row# "+i,errorList);
			}
			i++;
			
		}
		return errorsMap;
	}
}
