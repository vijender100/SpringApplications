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

import com.sathyatech.app.controller.multipart.validator.WhUserTypeMultipartValidator;
import com.sathyatech.app.model.WhUserType;
import com.sathyatech.app.service.IWhUserTypeService;
import com.sathyatech.app.util.WhUserTypeUtil;
import com.sathyatech.app.view.WhUserTypeXlsxView;

@Controller
@RequestMapping("/whUserTypeMultipart")
public class WhUserTypeMultipartController {

	@Autowired
	private WhUserTypeUtil util;
	
	@Autowired
	private IWhUserTypeService service;
	
	@Autowired
	private WhUserTypeMultipartValidator validator;
	
	/*
	 * 1.To show uom multipart JSP Page
	 */
	@GetMapping("/show")
	public String showMultipartPage() {
		return "WhUserTypeMultipart";
	}
	
	/*
	 * 2.On click Import Button
	 */
	@PostMapping("/whUserTypeImport")
	public String importShipments(@RequestParam MultipartFile whUserTypeFile,ModelMap map) {
		//check uploaded file is valid or not?
		if(whUserTypeFile==null || !whUserTypeFile.getOriginalFilename().contains(".xlsx")) {
			map.addAttribute("message", "Choose valid File");
		}else {
			List<WhUserType> whUserTypeList = util.processMultipart(whUserTypeFile);
			if(whUserTypeList.isEmpty()) {
				map.addAttribute("message", "No Records (Rows) Found in Sheet");
			}else {
				Map<String,List<String>> errorMap = validator.validateWhUserTypes(whUserTypeList); 
			    if(errorMap.isEmpty()) {
			    	service.save(whUserTypeList);
			    	map.addAttribute("message", "File WhUserType Data Uploaded Successfully!");
			    }else {
			    	map.addAttribute("errorsMap",errorMap);
			    }
			}
		}
		return "WhUserTypeMultipart";
	}
	
	/*
	 * 3.Uom Export (To Excel Sheet)
	 */
	@RequestMapping("/exportWhUserType")
	public ModelAndView exportData() {
		List<WhUserType> whUserType = service.getAll();
		return new ModelAndView(new WhUserTypeXlsxView(),"whUserTypeList",whUserType);
	}

	
}
