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

import com.sathyatech.app.model.OrderMethod;
import com.sathyatech.app.service.IOrderMethodService;
import com.sathyatech.app.spec.OrderMethodSpecification;
import com.sathyatech.app.util.OrderMethodUtil;
import com.sathyatech.app.validator.OrderMethodValidator;

@Controller
@RequestMapping("/orderMethod")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;
	
	@Autowired
	private OrderMethodValidator validator;
	
	@Autowired
	private OrderMethodUtil util;
	
	/*
	 * 1.To Show Register Page
	 */
	@GetMapping("/register")
	public String showRegister(ModelMap map) {
		//Send ModelAttribute to Form
		map.addAttribute("orderMethod",new OrderMethod());
		//Specify UI Page Name
		util.uiComponents(map);
		return "OrderMethodRegister";
	}
	
	/*
	 * 2.Save Data to DB
	 */
	@PostMapping("/register")
	public String saveData(@ModelAttribute OrderMethod orderMethod,Errors errors,ModelMap map) {
		//Before save do validation
		validator.setEdit(false);
		validator.validate(orderMethod, errors);
		if(!errors.hasErrors()) {
			//If no errors
			//save data to db using service layer
			Long orderMethdId = service.save(orderMethod);
			//clear form [model object] after creation
			map.addAttribute("orderMethod", new OrderMethod());
			//send Message to UI after save
			map.addAttribute("message", "Order Created With ID:: "+orderMethdId);
		}
		util.uiComponents(map);
		return "OrderMethodRegister";
	}
	
	/*
	 * 3.Get All Records With Pagination
	 */
	@GetMapping("/all")
	public String getAllRecords(@PageableDefault(size=4,sort="orderMethdId",direction=Direction.ASC)Pageable p,@ModelAttribute OrderMethod orderMethod,ModelMap map) {
		OrderMethodSpecification spec = new OrderMethodSpecification(orderMethod);
		Page<OrderMethod> page = service.findAll(spec, p);
		map.addAttribute("page", page);
		map.addAttribute("orderMethod", orderMethod);
		util.uiComponents(map);
		return "OrderMethodData";
	}
	/*
	 * 4.Delete Order By OrderId
	 */
	@GetMapping("/delete")
	public String delete(@RequestParam Long orderMethdId) {
		service.delete(orderMethdId);
		return "redirect:all";
	}
	/*
	 * 5.Show OrderMethodEdit Page
	 */
	@GetMapping("/edit")
	public String edit(@RequestParam Long orderMethdId,ModelMap map) {
		OrderMethod orderMethod = service.getOne(orderMethdId);
		map.addAttribute("orderMethod", orderMethod);
		util.uiComponents(map);
		return "OrderMethodDataEdit";
	}
	/*
	 * 6.Update OrderMethodData to DB
	 */
	@PostMapping("/update")
	public String update(@ModelAttribute OrderMethod orderMethod,Errors errors,ModelMap map) {
		validator.setEdit(true);
		validator.validate(orderMethod, errors);
		String page = null;
		if(errors.hasErrors()) {
			util.uiComponents(map);
			page="OrderMethodDataEdit";
		}else {
			service.update(orderMethod);
			return "redirect:all";
		}
		return page;
	}
}
