package com.sathyatech.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sathyatech.app.model.ShipmentType;
import com.sathyatech.app.service.IShipmentTypeService;
import com.sathyatech.app.util.ShipmentTypeUtil;

@Component
public class ShipmentTypeValidator implements Validator {

	private boolean isEdit;

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}
	@Autowired
	private ShipmentTypeUtil util;

	@Autowired
	private IShipmentTypeService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ShipmentType shipmentType = (ShipmentType) target;

		if(!util.getShipmentModes().contains(shipmentType.getShipmentMode())) {
			errors.rejectValue("shipmentMode", "", "Please select one of Shipment Mode");
		}
		if(!Pattern.compile("[a-zA-Z \\t\\n\\x0B\\f\\r]{4,12}").matcher(shipmentType.getShipmentMode()).matches()) {
			errors.rejectValue("shipmentCode", "", "Shipment Code must between 4-12 characters only!");
		}
		if(!util.getShipmentGrades().contains(shipmentType.getShipmentGrade())) {
			errors.rejectValue("shipmentGrade", "", "Please Choose one of Shipment Grade!");
		}
		if(!Pattern.compile("[a-zA-Z \\t\\n\\x0B\\f\\r]{8,255}").matcher(shipmentType.getDescription()).matches()) {
			errors.rejectValue("description", "", "Description must between 8-255 Characters Only!");
		}
		if(!isEdit && service.isShipmentModeAndCodeExist(shipmentType.getShipmentMode(), shipmentType.getShipmentCode())) {
			errors.rejectValue("shipmentMode", "", "ShipmentType '"+shipmentType.getShipmentMode()+"' with '"+shipmentType.getShipmentCode()+"' exist");
		}
	}

}
