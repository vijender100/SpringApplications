package com.sathyatech.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sathyatech.app.model.PurchaseOrder;
import com.sathyatech.app.service.IPurchaseOrderService;

@Component
public class PurchaseOrderValidator implements Validator {
	
	private boolean isEdit;
	
	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	@Autowired
	private IPurchaseOrderService pOService;

	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseOrder.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		PurchaseOrder po = (PurchaseOrder)target;
		
		if(StringUtils.isEmpty(po.getOrderCode())){
			errors.rejectValue("orderCode", "", "Plz Enter Order Code");
		}
		else if(!isEdit && pOService.findByOrderCode(po.getOrderCode())!= null ){
			errors.rejectValue("orderCode", "", "Order Code is Already Exist");
		}
		
		if(StringUtils.isEmpty(po.getShipmentMode())){
			errors.rejectValue("shipmentMode", "", "Plz Choose ShipmentMode");
		}
		
		if(StringUtils.isEmpty(po.getVendor())){
			errors.rejectValue("vendor", "", "Plz Choose Vendor");
		}
		
		if(StringUtils.isEmpty(po.getRefernceNumber())){
			errors.rejectValue("refernceNumber", "", "Plz Enter Ref Number");
		}
		else if(!Pattern.compile("[0-9]{4,12}").matcher(po.getRefernceNumber()).matches()){
			errors.rejectValue("refernceNumber", "", "4-12 Digits Only");
		}
		
		if(StringUtils.isEmpty(po.getQualityCheck())){
			errors.rejectValue("qualityCheck", "", "Plz Select Quality Check");
		}
		
		if(StringUtils.isEmpty(po.getStatus())){
			errors.rejectValue("status", "", "Plz Provide Status");
		}
		else if(!po.getStatus().equalsIgnoreCase("OPEN")){
			errors.rejectValue("status", "", "Status Should be Always \'OPEN\'");
		}
		
		if(StringUtils.isEmpty(po.getDescription())){
			errors.rejectValue("description", "", "Plz Write Description");
		}
		else if(!Pattern.compile("[a-zA-Z \\t\\n\\x0B\\f\\r]{4,255}").matcher(po.getDescription()).matches()){
			errors.rejectValue("description", "", "Chars only range of 10-255 accepted");
		}
	}
}
