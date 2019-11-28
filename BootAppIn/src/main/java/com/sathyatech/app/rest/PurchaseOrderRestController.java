package com.sathyatech.app.rest;

import io.swagger.annotations.ApiImplicitParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sathyatech.app.model.PurchaseOrder;
import com.sathyatech.app.service.IPurchaseOrderService;
import com.sathyatech.app.validator.PurchaseOrderValidator;

@RestController
@RequestMapping("/rest/po")
public class PurchaseOrderRestController {

	@Autowired
	private IPurchaseOrderService service;
	
	@Autowired
	private PurchaseOrderValidator poValidator;
	
	private Object response;
	
	@PostMapping("/save")
	public ResponseEntity<Object> save(@RequestBody PurchaseOrder purchaseOrder,Errors errors){
		//Do Validations
		poValidator.setEdit(false);
		poValidator.validate(purchaseOrder, errors);
		if(errors.hasErrors()){
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}
		else{
			Long poId= service.save(purchaseOrder);
			return ResponseEntity.ok("Order Placed With Id "+poId);
		}
	}
	
	@GetMapping("/viewAll")
	@ApiImplicitParam(name="page",dataType="String",paramType="query",value="Enter Page Number 0 to N",required=true )
	public ResponseEntity<Object> viewAll(@PageableDefault(size=3,sort="orderId",direction=Direction.ASC) Pageable pageable){
		Page<PurchaseOrder> page= service.findAll(pageable);
		if(page != null){
			response = "Page is Empty";
		}
			if(page.getNumber() > page.getTotalPages()-1){
				response = "Page Number is Greter than Total Pages";
			}
			else{
				response = page;
			}
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Object> delete(@RequestParam Long orderId){
		if(service.isExist(orderId)){
			service.deleteById(orderId);
			response = "Order Deleted Id:"+orderId;
		}
		else{
			response ="Id: "+orderId+" Not Exist";
		}
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody PurchaseOrder purchaseOrder,Errors errors){
		poValidator.setEdit(true);
		poValidator.validate(purchaseOrder, errors);
		if(errors.hasErrors()){
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}
		else {
			if(service.isExist(purchaseOrder.getOrderId())){
				//Set CreatedOn Date  
				purchaseOrder.setCreatedOn(service.findOneById(purchaseOrder.getOrderId()).getCreatedOn());
				service.update(purchaseOrder);
				response = "Order Updated with Id: "+purchaseOrder.getOrderId();
			}
			else{
				response = "Order is Not Exist with Id "+purchaseOrder.getOrderId();
			}
		}
		return ResponseEntity.ok(response);
	}
}
