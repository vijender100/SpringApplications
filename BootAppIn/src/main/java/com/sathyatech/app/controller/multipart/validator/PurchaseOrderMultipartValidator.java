package com.sathyatech.app.controller.multipart.validator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sathyatech.app.model.PurchaseOrder;
import com.sathyatech.app.service.IPurchaseOrderService;
import com.sathyatech.app.util.PurchaseOrderUtil;

@Component
public class PurchaseOrderMultipartValidator {
	
	@Autowired
	private IPurchaseOrderService pOService;
	
	@Autowired
	private PurchaseOrderUtil poUtil;
	
	public Map<String,List<String>> orderValidator(List<PurchaseOrder> orders){
		
		Map<String,List<String>> errorMap = new LinkedHashMap<String,List<String>>();
		
		int row = 1;
		
		for(PurchaseOrder pOrder : orders){
			List<String> errorList = new ArrayList<String>();
			
			if(StringUtils.isEmpty(pOrder.getOrderCode())){
				errorList.add("Plz Enter Order Code");
			}
			
			else if(pOService.findByOrderCode(pOrder.getOrderCode())!= null ){
				errorList.add("Order Code is Already Exist");
			}
			
			
			if(pOrder.getShipmentMode() == null || pOrder.getShipmentMode().getShipmentTypeId()==null){
				errorList.add("Plz Enter Valid Shipment Code");
			}

			if(pOrder.getVendor() == null || pOrder.getVendor().getWhUserTypeId()==null){
				errorList.add("Plz Enter Valid Vendor");
			}
			
			if(StringUtils.isEmpty(pOrder.getRefernceNumber())){
				errorList.add("Plz Enter Ref Number");
			}
			
			if(StringUtils.isEmpty(pOrder.getQualityCheck())){
				errorList.add("Plz provide Quality Check");
			}
			else if(!poUtil.getQualityChecks().contains(pOrder.getQualityCheck())){
				errorList.add("Plz provide Quality Check From "+poUtil.getQualityChecks());
			}
			
			if(StringUtils.isEmpty(pOrder.getDescription())){
				errorList.add("Plz Write Description");
			}
			else if(!Pattern.compile("[a-zA-Z \\t\\n\\x0B\\f\\r]{4,255}").matcher(pOrder.getDescription()).matches()){
				errorList.add("Chars only range of 10-255 accepted");
			}
			
			if(!errorList.isEmpty()){
				errorMap.put("Error At Row#"+row, errorList);
			}
			row++;
		}
		return errorMap;
	}
}
