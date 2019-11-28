package com.sathyatech.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathyatech.app.model.ShipmentType;
import com.sathyatech.app.service.IShipmentTypeService;
import com.sathyatech.app.spec.ShipmentTypeSpecification;
import com.sathyatech.app.util.ShipmentTypeUtil;
import com.sathyatech.app.validator.ShipmentTypeValidator;

@Controller
@RequestMapping("/shipmentType")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;
	
	@Autowired
	private ShipmentTypeValidator validator;
	
	@Autowired
	private ShipmentTypeUtil util;
	
	/*
	 * 1.To show Register Page
	 */
	@GetMapping("/register")
	public String ShowRegister(ModelMap map) {
		//Send ModelAttribute to Form
		map.addAttribute("shipmentType", new ShipmentType());
		//Specify UI Page Name
		util.uiComponent(map);
		return "ShipmentTypeRegister";
	}
	/*
	 * 2.Save Data To DB
	 */
	@PostMapping("/register")
	public String saveData(@ModelAttribute ShipmentType shipmentType,Errors errors,ModelMap map) {
		//Before save do validation
		validator.setEdit(false);
		validator.validate(shipmentType, errors);
		if(!errors.hasErrors()) {
			//If no errors
			//Save Data to DB using Service Layer
			Long shipmentTypeId = service.save(shipmentType);
			//Clear Form (Model object) after save
			map.addAttribute("shipmentType", new ShipmentType());
			//Send Message to UI Page After save
			map.addAttribute("message", "Shipment Created with ID:: "+ shipmentTypeId);	
		}
		util.uiComponent(map);
		return "ShipmentTypeRegister";
	}
	
	/*
	 * 3.Get All Records With Pagination
	 */
	@GetMapping("/all")
	public String getAllRecords(@PageableDefault(size=4,sort="shipmentTypeId",direction=Direction.ASC)Pageable p,@ModelAttribute ShipmentType shipmentType,ModelMap map) {
		ShipmentTypeSpecification spec = new ShipmentTypeSpecification(shipmentType);
		Page<ShipmentType> page = service.findAll(spec, p);
		map.addAttribute("page", page);
		map.addAttribute("shipmentType", shipmentType);
		util.uiComponent(map);
		return "ShipmentTypeData";
	}
	/*
	 * 4.Delete One Shipment By Id
	 */
	@GetMapping("/delete")
	public String delete(@RequestParam Long shipmentTypeId) {
		service.delete(shipmentTypeId);
		return "redirect:all";
	}
	/*
	 * 5.Show ShipmentTypeEdit Page
	 */
	@GetMapping("/edit")
	public String edit(@RequestParam Long shipmentTypeId,ModelMap map) {
		ShipmentType shipmentType = service.getOne(shipmentTypeId);
		map.addAttribute("shipmentType", shipmentType);
		util.uiComponent(map);
		return "ShipmentTypeDataEdit";
	}
	/*
	 * 6.update Shipment Data To DB
	 */
	@PostMapping("/update")
	public String update(@ModelAttribute ShipmentType shipmentType,Errors errors,ModelMap map) {
		validator.setEdit(true);
		validator.validate(shipmentType, errors);
		String page = null;
		if(errors.hasErrors()) {
			util.uiComponent(map);
			page = "ShipmentTypeDataEdit";
		}else {
			service.update(shipmentType);
			return "redirect:all";
		}
		return page;
	}
}
