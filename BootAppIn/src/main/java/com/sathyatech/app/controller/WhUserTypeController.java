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

import com.sathyatech.app.model.WhUserType;
import com.sathyatech.app.service.IWhUserTypeService;
import com.sathyatech.app.spec.WhUserTypeSpecification;
import com.sathyatech.app.util.WhUserTypeUtil;
import com.sathyatech.app.validator.WhUserTypeValidator;

@Controller
@RequestMapping("/whUserType")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;
	
	@Autowired
	private WhUserTypeValidator validator;
	
	@Autowired
	private WhUserTypeUtil util;
	
	/**
	 * 1. To Show Register Page */
	@GetMapping("/register")
	 public String showRegister(ModelMap map) {
		 // Send ModelAttribute to form
		 map.addAttribute("whUserType",new WhUserType());
		 //Specify UI Page Name
		 util.addUiComponents(map);
		 return "WhUserTypeRegister";
	 }
	/**
	 * 2. save Data to DB  */
	@PostMapping("/register")
	public String saveData(@ModelAttribute WhUserType whUserType,Errors errors,ModelMap map) {
		// Before save do validation
		validator.setEdit(false);
		validator.validate(whUserType, errors);
		if(!errors.hasErrors()) {
		//if no errors	
		//Save Data to DB using service Layer
		Long whUserTypeId = service.save(whUserType);
		//Clear form (model Object) after save
		map.addAttribute("whUserType",new WhUserType());
		//Send Message to UI After save
		map.addAttribute("message","WhUser created with ID: "+ whUserTypeId);
		}
		util.addUiComponents(map);
		return "WhUserTypeRegister";
	}
	/*
	 * 3.Get All Records With Pagination
	 */
	@GetMapping("/all")
	public String getAllRecords(@PageableDefault(size=4,sort="whUserTypeId",direction=Direction.ASC)Pageable p,@ModelAttribute WhUserType whUserType,ModelMap map) {
		WhUserTypeSpecification spec = new WhUserTypeSpecification(whUserType);
		Page<WhUserType> page = service.findAll(spec, p);
		map.addAttribute("page", page);
		map.addAttribute("whUserType", whUserType);
		util.addUiComponents(map);
		return "WhUserTypeData";
	}
	/*
	 * 4.Delete WhUser By whUserTypeId
	 */
	@GetMapping("/delete")
	public String delete(@RequestParam Long whUserTypeId) {
		service.delete(whUserTypeId);
		return "redirect:all";
	}
	/*
	 * 5.Show WhUserTypeEdit Page
	 */
	@GetMapping("/edit")
	public String edit(@RequestParam Long whUserTypeId,ModelMap map) {
		WhUserType whUserType = service.getOne(whUserTypeId);
		map.addAttribute("whUserType", whUserType);
		util.addUiComponents(map);
		return "WhUserTypeDataEdit";
	}
	/*
	 * 6.Update WhUserTypeData to DB
	 */
	@PostMapping("/update")
	public String update(@ModelAttribute WhUserType whUserType,Errors errors,ModelMap map) {
		validator.setEdit(true);
		validator.validate(whUserType, errors);
		String page = null;
		if(errors.hasErrors()) {
			util.addUiComponents(map);
			page="WhUserTypeDataEdit";
		}else {
			service.update(whUserType);
			return "redirect:all";
		}
		return page;
	}
	
	/*
	 * 7.View WhUserTypeData
	 */
	@GetMapping("/view")
	public String view(@RequestParam Long whUserTypeId,ModelMap map)
	{
		WhUserType whUserType=service.getOne(whUserTypeId);
		map.addAttribute("whUserType", whUserType);
		return "WhUserTypeDataView";
	}
	
	
	
	
	
	
	
}
