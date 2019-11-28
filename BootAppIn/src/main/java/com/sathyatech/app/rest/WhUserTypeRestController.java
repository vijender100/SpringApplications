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

import com.sathyatech.app.model.WhUserType;
import com.sathyatech.app.service.IWhUserTypeService;
import com.sathyatech.app.validator.WhUserTypeValidator;

@RestController
@RequestMapping("/rest/whUserType")
public class WhUserTypeRestController {

	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private WhUserTypeValidator validator;
	
	/*
	 * 1.save Uom Data 
	 */
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody WhUserType whUserType, Errors errors){
		
		validator.validate(whUserType,errors);
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else {
			Long whUserTypeId = service.save(whUserType);
			return ResponseEntity.ok("WhUserType Created with Id: "+whUserTypeId);
		}
	}//method
	
	/*
	 * 2.get All Records 
	 */
	@GetMapping("/all")
	public ResponseEntity<Object> getAll(){
		
		Object response = null;
		List<WhUserType> whUserTypeList = service.getAll();
		if(whUserTypeList==null || whUserTypeList.size()==0) {
			response  = "No WhUserType Records Exist.";
		}else {
			response = whUserTypeList;
		}
		return ResponseEntity.ok(response);
	}//method
	
	/*
	 * 3.update Uom Record 
	 */
	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody WhUserType whUserType,Errors errors){
		
		Object response = null;
		validator.validate(whUserType, errors);
		if(errors.hasErrors()) {
			response = errors.getAllErrors();
			return ResponseEntity.badRequest().body(response);
		}else {
			service.update(whUserType);
			response = "WhUserType updated with Id:"+whUserType.getWhUserTypeId();
			return ResponseEntity.ok(response);
		}//method
	}
	
	/*
	 * 4.Delete Record 
	 */
	@DeleteMapping("/delete/{whUserTypeId}")
	public ResponseEntity<Object> delete(@PathVariable Long whUserTypeId){
		
		Object response = null;
		boolean exist = service.isExist(whUserTypeId);
		if(!exist) {
			response = "WhUserType "+whUserTypeId+" not exist.";
		}else {
			service.delete(whUserTypeId);
			response = "WhUserType "+whUserTypeId+" is deleted";
		}
		return ResponseEntity.ok(response);
	}//method
}

