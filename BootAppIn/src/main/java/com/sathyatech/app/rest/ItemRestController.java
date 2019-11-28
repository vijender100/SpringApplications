package com.sathyatech.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathyatech.app.model.Item;
import com.sathyatech.app.service.IItemService;
import com.sathyatech.app.validator.ItemValidator;

@RestController
@RequestMapping("/rest/item")
public class ItemRestController {

	@Autowired
	private IItemService service;
	
	@Autowired
	private ItemValidator validator;

	/*
	 * 1.save Uom Data 
	 */
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Item item, Errors errors,ModelMap map){
		
		validator.validate(item,errors);
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else {
			Long itemId = service.save(item);
			return ResponseEntity.ok("Item Created with Id: "+itemId);
		}
	}//method
	
	/*
	 * 2.get All Records 
	 */
	@GetMapping("/all")
	public ResponseEntity<Object> getAll(){
		
		Object response = null;
		List<Item> itemList = service.getAll();
		if(itemList==null || itemList.size()==0) {
			response  = "No Item Records Exist.";
		}else {
			response = itemList;
		}
		return ResponseEntity.ok(response);
	}//method
	
	/*
	 * 3.update Uom Record 
	 */
	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody Item item,Errors errors){
		
		Object response = null;
		validator.validate(item, errors);
		if(errors.hasErrors()) {
			response = errors.getAllErrors();
			return ResponseEntity.badRequest().body(response);
		}else {
			service.update(item);
			response = "Item updated with Id:"+item.getItemId();
			return ResponseEntity.ok(response);
		}//method
	}
	
	/*
	 * 4.Delete Record 
	 */
	@DeleteMapping("/delete/{itemId}")
	public ResponseEntity<Object> delete(@PathVariable Long itemId){
		
		Object response = null;
		boolean exist = service.isExist(itemId);
		if(!exist) {
			response = "Item "+itemId+" not exist.";
		}else {
			service.delete(itemId);
			response = "Item "+itemId+" is deleted";
		}
		return ResponseEntity.ok(response);
	}//method

	
}
