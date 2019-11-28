package com.sathyatech.app.controller.multipart;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sathyatech.app.controller.multipart.validator.ItemMultipartValidator;
import com.sathyatech.app.model.Item;
import com.sathyatech.app.service.IItemService;
import com.sathyatech.app.util.ItemUtil;
import com.sathyatech.app.view.ItemXlsxView;

@Controller
@RequestMapping("/itemMultipart")
public class ItemMultipartController {

	@Autowired
	private ItemUtil util;
	
	@Autowired
	private IItemService service;
	
	@Autowired
	private ItemMultipartValidator validator;
	
	/*
	 * 1.To show ItemMultipart JSP Page
	 */
	@GetMapping("/show")
	public String showMultipartPage() {
		return "ItemMultipart";
	}
	
	/*
	 * 2.On click Import Button
	 */
	@PostMapping("/itemImport")
	public String importOrders(@RequestParam MultipartFile itemFile,ModelMap map) {
		//check uploaded file is valid or not?
		if(itemFile==null || !itemFile.getOriginalFilename().contains(".xlsx")) {
			map.addAttribute("message", "Choose valid File");
		}else {
			List<Item> itemList = util.processMultipart(itemFile);
			if(itemList.isEmpty()) {
				map.addAttribute("message", "No Records (Rows) Found in Sheet");
			}else {
				Map<String,List<String>> errorMap = validator.validateItems(itemList);
			    if(errorMap.isEmpty()) {
			    	service.save(itemList);
			    	map.addAttribute("message", "File Items Data Uploaded Successfully!");
			    }else {
			    	map.addAttribute("errorsMap",errorMap);
			    }
			}
		}
		return "ItemMultipart";
	}
	
	/*
	 * 3.Uom Export (To Excel Sheet)
	 */
	@RequestMapping("/exportItem")
	public ModelAndView exportData() {
		List<Item> item = service.getAll();
		return new ModelAndView(new ItemXlsxView(),"itemList",item);
	}
}
