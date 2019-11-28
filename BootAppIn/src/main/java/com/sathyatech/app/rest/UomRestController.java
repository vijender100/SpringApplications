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

import com.sathyatech.app.model.Uom;
import com.sathyatech.app.service.IUomService;
import com.sathyatech.app.validator.UomValidator;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {

	@Autowired
	private IUomService service;
	@Autowired
	private UomValidator validator;
	
	/*
	 * 1.save Uom Data 
	 */
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Uom uom, Errors errors){
		
		validator.validate(uom,errors);
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else {
			Long uomId = service.save(uom);
			return ResponseEntity.ok("Uom Created with Id: "+uomId);
		}
	}//method
	
	/*
	 * 2.get All Records 
	 */
	@GetMapping("/all")
	public ResponseEntity<Object> getAll(){
		
		Object response = null;
		List<Uom> uomList = service.getAll();
		if(uomList==null || uomList.size()==0) {
			response  = "No Uom Records Exist.";
		}else {
			response = uomList;
		}
		return ResponseEntity.ok(response);
	}//method
	
	/*
	 * 3.update Uom Record 
	 */
	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody Uom uom,Errors errors){
		
		Object response = null;
		validator.validate(uom, errors);
		if(errors.hasErrors()) {
			response = errors.getAllErrors();
			return ResponseEntity.badRequest().body(response);
		}else {
			service.update(uom);
			response = "Uom updated with Id:"+uom.getUomId();
			return ResponseEntity.ok(response);
		}//method
	}
 	/*
	 * 4.Delete Record 
	 */
	@DeleteMapping("/delete/{uomId}")
	public ResponseEntity<Object> delete(@PathVariable Long uomId){
		
		Object response = null;
		boolean exist = service.isExist(uomId);
		if(!exist) {
			response = "Uom "+uomId+" not exist.";
		}else {
			service.delete(uomId);
			response = "Uom "+uomId+" is deleted";
		}
		return ResponseEntity.ok(response);
	}//method
}//class
