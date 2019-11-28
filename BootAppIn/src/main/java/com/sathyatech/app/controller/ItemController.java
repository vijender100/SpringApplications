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

import com.sathyatech.app.model.Item;
import com.sathyatech.app.service.IItemService;
import com.sathyatech.app.spec.ItemSpecification;
import com.sathyatech.app.util.ItemUtil;
import com.sathyatech.app.validator.ItemValidator;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private IItemService service;
	
	@Autowired
	private ItemUtil util;
	
	@Autowired
	private ItemValidator validator;
	
	/**
	 * 1. To Show Register Page */
	@GetMapping("/register")
	 public String showRegister(@ModelAttribute Item item,ModelMap map) {
		 // Send ModelAttribute to form
		 map.addAttribute("item",new Item());
		 //Specify UI Page Name
		 map.addAttribute("baseCurrency",util.getBaseCurrencies());
		 util.addUiComponents(map);
		 return "ItemRegister";
	 }
	
	/**
	 * 2. save Data to DB  */
	@PostMapping("/register")
	public String saveData(@ModelAttribute Item item,Errors errors,ModelMap map) {
		// Before save do validation
		//validator.setEdit(false);
		validator.validate(item, errors);
		if(!errors.hasErrors()) {
		Long itemId = service.save(item);
		//Clear form (model Object) after save
		map.addAttribute("item",new Item());
		//Send Message to UI After save
		map.addAttribute("message","Item created with ID: "+ itemId);
		}
		map.addAttribute("baseCurrency",util.getBaseCurrencies());
		util.addUiComponents(map);
		return "ItemRegister";
	}
	/**
	 * 3.Get All Records With PageNation */
	@GetMapping("/all")
	public String getAllRecords(@PageableDefault(size=4,sort="itemId",direction=Direction.ASC)Pageable p,@ModelAttribute Item item,ModelMap map) {
		ItemSpecification spec = new ItemSpecification(item);
		Page<Item> page = service.findAll(spec,p);
		map.addAttribute("page", page);
		map.addAttribute("item",new Item());
		util.addUiComponents(map);
		return "ItemData";
	}
	/*
	 * 4.Delete Item By ItemId
	 */
	@GetMapping("/delete")
	public String delete(@RequestParam Long itemId) {
		service.delete(itemId);
		return "redirect:all";
	}
	/*
	 * 5.Show ItemEdit Page
	 */
	@GetMapping("/edit")
	public String edit(@RequestParam Long itemId,ModelMap map) {
		Item item = service.getOne(itemId);
		map.addAttribute("item", item);
		util.addUiComponents(map);
		return "ItemDataEdit";
	}

	/*
	 * 6.Update ItemData to DB
	 */
	@PostMapping("/update")
	public String update(@ModelAttribute Item item,Errors errors,ModelMap map) {
		//validator.setEdit(true);
		validator.validate(item, errors);
		String page = null;
		if(errors.hasErrors()) {
			util.addUiComponents(map);
			page="ItemDataEdit";
		}else {
			service.update(item);
			return "redirect:all";
		}
		return page;
	  }
	/*
	 * 7.View WhUserTypeData
	 */
	@GetMapping("/view")
	public String view(@RequestParam Long itemId,ModelMap map)
	{
		Item item=service.getOne(itemId);
		map.addAttribute("item", item);
		return "ItemDataView";
	}
}	
	
