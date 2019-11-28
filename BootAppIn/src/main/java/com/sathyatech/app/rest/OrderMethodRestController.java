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

import com.sathyatech.app.model.OrderMethod;
import com.sathyatech.app.service.IOrderMethodService;
import com.sathyatech.app.validator.OrderMethodValidator;

@RestController
@RequestMapping("/rest/orderMethod")
public class OrderMethodRestController {

	@Autowired
	private IOrderMethodService service;
	@Autowired
	private OrderMethodValidator validator;
	
	/*
	 * 1.save Uom Data 
	 */
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody OrderMethod orderMethod, Errors errors){
		
		validator.validate(orderMethod,errors);
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else {
			Long orderMethdId = service.save(orderMethod);
			return ResponseEntity.ok("OrderMethod Created with Id: "+orderMethdId);
		}
	}//method
	
	/*
	 * 2.get All Records 
	 */
	@GetMapping("/all")
	public ResponseEntity<Object> getAll(){
		
		Object response = null;
		List<OrderMethod> orderMethodList = service.getAll();
		if(orderMethodList==null || orderMethodList.size()==0) {
			response  = "No OrderMethod Records Exist.";
		}else {
			response = orderMethodList;
		}
		return ResponseEntity.ok(response);
	}//method
	
	/*
	 * 3.update Uom Record 
	 */
	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody OrderMethod orderMethod,Errors errors){
		
		Object response = null;
		validator.validate(orderMethod, errors);
		if(errors.hasErrors()) {
			response = errors.getAllErrors();
			return ResponseEntity.badRequest().body(response);
		}else {
			service.update(orderMethod);
			response = "OrderMethod updated with Id:"+orderMethod.getOrderMethdId();
			return ResponseEntity.ok(response);
		}//method
	}
	
	/*
	 * 4.Delete Record 
	 */
	@DeleteMapping("/delete/{orderMethdId}")
	public ResponseEntity<Object> delete(@PathVariable Long orderMethdId){
		
		Object response = null;
		boolean exist = service.isExist(orderMethdId);
		if(!exist) {
			response = "OrderMethod "+orderMethdId+" not exist.";
		}else {
			service.delete(orderMethdId);
			response = "OrderMethod "+orderMethdId+" is deleted";
		}
		return ResponseEntity.ok(response);
	}//method

}
