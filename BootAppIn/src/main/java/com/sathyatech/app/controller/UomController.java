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

import com.sathyatech.app.model.Uom;
import com.sathyatech.app.service.IUomService;
import com.sathyatech.app.spec.UomSpecification;
import com.sathyatech.app.util.UomUtil;
import com.sathyatech.app.validator.UomValidator;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;
	@Autowired
	private UomValidator validator;
	@Autowired
	private UomUtil util;
	
	/**
	 * 1. To Show Register Page */
	@GetMapping("/register")
	 public String showRegister(ModelMap map) {
		 // Send ModelAttribute to form
		 map.addAttribute("uom",new Uom());
		 //Specify UI Page Name
		 map.addAttribute("uomTypes",util.getUomTypes());
		 return "UomRegister";
	 }
	
	/**
	 * 2. save Data to DB  */
	@PostMapping("/register")
	public String saveData(@ModelAttribute Uom uom,Errors errors,ModelMap map) {
		// Before save do validation
		validator.setEdit(false);
		validator.validate(uom, errors);
		if(!errors.hasErrors()) {
		//if no errors	
		//Save Data to DB using service Layer
		Long uomId = service.save(uom);
		//Clear form (model Object) after save
		map.addAttribute("uom",new Uom());
		//Send Message to UI After save
		map.addAttribute("message","Uom created with ID: "+ uomId);
		}
		map.addAttribute("uomTypes",util.getUomTypes());
		return "UomRegister";
	}
	/**
	 * 3.Get All Records With PageNation */
	@GetMapping("/all")
	public String getAllRecords(@PageableDefault(size=4,sort="uomId",direction=Direction.ASC)Pageable p,@ModelAttribute Uom uom,ModelMap map) {
		UomSpecification spec = new UomSpecification(uom);
		Page<Uom> page = service.findAll(spec,p);
		map.addAttribute("page", page);
		map.addAttribute("uom", uom);
		map.addAttribute("uomTypes", util.getUomTypes());
		return "UomData";
	}
	/**
	 * 4.delete one uom by Id */
	@GetMapping("/delete")
    public String delete(@RequestParam Long uomId) {
		service.delete(uomId);
		return "redirect:all";
	}
	/**
	 * 5.show UomEdit Page  */
	@GetMapping("/edit")
	public String edit(@RequestParam Long uomId, ModelMap map) {
		Uom uom=service.getOne(uomId);
		map.addAttribute("uom", uom);
		map.addAttribute("uomTypes",util.getUomTypes());
		return "UomDataEdit";
	}
	/**
	 * 6.update UomData to DB */
	@PostMapping("/update")
    public String update(@ModelAttribute Uom uom,Errors errors,ModelMap map) {
		validator.setEdit(true);
		validator.validate(uom, errors);
		String page=null;
		if(errors.hasErrors()) {
			map.addAttribute("uomTypes", util.getUomTypes());
			page="UomDataEdit";
		}else {
    	service.update(uom);
    	return "redirect:all";
		}
		return page;
    }
 }
