package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entity.Employee;
import com.app.service.EmpService;
import com.app.validator.EmpValidator;

@Controller

public class EmpController {
	String msg = "";
	@Autowired
	private EmpService service;
	@Autowired
	private EmpValidator validate;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage() {
		/*
		 * ModelAndView model=new ModelAndView(); model.setViewName("showPage"); return
		 * model;
		 */
		return "index";
	}

	@GetMapping(value = "/reg")
	public String regPage(@ModelAttribute Employee employee, ModelMap map) {
		map.addAttribute("employee", new Employee());
		return "register";
	}

	@PostMapping(value = "/save")
	public String register(@Valid @ModelAttribute("employee") Employee employee, BindingResult errors, ModelMap map) {
		validate.validate(employee, errors);

		if (errors.hasErrors()) {
			map.addAttribute("employee", employee);
		} else {
			String msg = service.save(employee);
			map.addAttribute("msg", msg);
			map.addAttribute("employee", new Employee());
		}
		return "register";

	}

	@RequestMapping(value = "select")
	public String getAll(ModelMap map) {
		List<Employee> list = service.getAll();
		map.addAttribute("list", list);
		return "getAll";

	}

	@GetMapping(value = "delete")
	public String delete(@RequestParam int empId) {
		service.delete(empId);
		return "redirect:select";
	}

	@RequestMapping(value = "/edit")
	public String update(@RequestParam Integer empId, ModelMap map) {
		Employee employee = service.getOne(empId);
		map.addAttribute("employee", employee);
		return "edit";
	}

	@RequestMapping(value = "/update")
	public String update(@ModelAttribute Employee employee, ModelMap map) {
		String msg = service.update(employee);
		map.addAttribute("msg", msg);
		return "redirect:select";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}

}
