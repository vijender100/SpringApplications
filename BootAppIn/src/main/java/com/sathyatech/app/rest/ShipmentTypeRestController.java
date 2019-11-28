package com.sathyatech.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathyatech.app.model.ShipmentType;
import com.sathyatech.app.service.IShipmentTypeService;
import com.sathyatech.app.validator.ShipmentTypeValidator;

@RestController
@RequestMapping("/rest/shipmentType")
public class ShipmentTypeRestController {

	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ShipmentTypeValidator validator;
	
	/*
	 * 1.save Uom Data 
	 */
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody ShipmentType shipmentType, Errors errors){
		
		validator.validate(shipmentType,errors);
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else {
			Long shipmentTypeId = service.save(shipmentType);
			return ResponseEntity.ok("ShipmentType Created with Id: "+shipmentTypeId);
		}
	}//method
	
	/*
	 * 2.get All Records 
	 */
	@GetMapping("/all")
	public ResponseEntity<Object> getAll(){
		
		Object response = null;
		List<ShipmentType> shipmentTypeList = service.getAll();
		if(shipmentTypeList==null || shipmentTypeList.size()==0) {
			response  = "No ShipmentType Records Exist.";
		}else {
			response = shipmentTypeList;
		}
		return ResponseEntity.ok(response);
	}//method
	
	/*
	 * 3.update Uom Record 
	 */
	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody ShipmentType shipmentType,Errors errors){
		
		Object response = null;
		validator.validate(shipmentType, errors);
		if(errors.hasErrors()) {
			response = errors.getAllErrors();
			return ResponseEntity.badRequest().body(response);
		}else {
			service.update(shipmentType);
			response = "ShipmentType updated with Id:"+shipmentType.getShipmentTypeId();
			return ResponseEntity.ok(response);
		}//method
	}
	
	/*
	 * 4.Delete Record 
	 */
	@DeleteMapping("/delete/{shipmentTypeId}")
	public ResponseEntity<Object> delete(@PathVariable Long shipmentTypeId){
		
		Object response = null;
		boolean exist = service.isExist(shipmentTypeId);
		if(!exist) {
			response = "ShipmentType "+shipmentTypeId+" not exist.";
		}else {
			service.delete(shipmentTypeId);
			response = "ShipmentType "+shipmentTypeId+" is deleted";
		}
		return ResponseEntity.ok(response);
	}//method

	
}
