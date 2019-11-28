package com.sathyatech.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sathyatech.app.model.Uom;
import com.sathyatech.app.service.IUomService;
import com.sathyatech.app.util.UomUtil;

@Component
public class UomValidator implements Validator {

	private boolean isEdit;
	
	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	@Autowired
	private UomUtil uomUtil;
	
	@Autowired
	private IUomService uomService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Uom uom = (Uom)target;
		if(!uomUtil.getUomTypes().contains(uom.getUomType())) {
			errors.rejectValue("uomType", "", "Please choose valid Uom Type");
		}
		if(!Pattern.compile("[A-Z \\t\\n\\x0B\\f\\r]{4,12}").matcher(uom.getUomModel()).matches()){
			errors.rejectValue("uomModel", "", "Enter 4-12 Uppercase letters only");
		}
		if(!Pattern.compile("[a-zA-Z \\t\\n\\x0B\\f\\r]{10,255}").matcher(uom.getDescription()).matches()) {
			errors.rejectValue("description", "", "Chars only range of 10-255 accepted");
		}
		if(!isEdit &&  uomService.isUomTypeAndModelExist(uom.getUomType(), uom.getUomModel())) {
			errors.rejectValue("uomModel", "", "Uom '"+uom.getUomModel()+"' with '"+uom.getUomType()+"' exist");
		}
	}
}
