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

import com.sathyatech.app.controller.multipart.validator.UomMultipartValidator;
import com.sathyatech.app.model.Uom;
import com.sathyatech.app.service.IUomService;
import com.sathyatech.app.util.UomUtil;
import com.sathyatech.app.view.UomXlsxView;

/*
 * Uom Multipart Controller used to get Data from xlsx file
 */

@Controller
@RequestMapping("/uommultipart")
public class UomMultipartController {

	@Autowired
	private UomUtil util;
	
	@Autowired
	private IUomService service;
	
	@Autowired
	private UomMultipartValidator validator;
	
	/*
	 * 1.To show uom multipart JSP Page
	 */
	@GetMapping("/show")
	public String showMultipartPage() {
		return "UomMultipart";
	}
	
	/*
	 * 2.On click Import Button
	 */
	@PostMapping("/uomimport")
	public String importUoms(@RequestParam MultipartFile uomFile,ModelMap map) {
		//check uploaded file is valid or not?
		if(uomFile==null || !uomFile.getOriginalFilename().contains(".xlsx")) {
			map.addAttribute("message", "Choose valid File");
		}else {
			List<Uom> uomList = util.processMultipart(uomFile);
			if(uomList.isEmpty()) {
				map.addAttribute("message", "No Records (Rows) Found in Sheet");
			}else {
				Map<String,List<String>> errorMap = validator.validateUoms(uomList); 
			    if(errorMap.isEmpty()) {
			    	service.save(uomList);
			    	map.addAttribute("message", "File Uoms Data Uploaded Successfully!");
			    }else {
			    	map.addAttribute("errorsMap",errorMap);
			    }
			}
		}
		return "UomMultipart";
	}
	
	/*
	 * 3.Uom Export (To Excel Sheet)
	 */
	@RequestMapping("/exportUoms")
	public ModelAndView exportData() {
		List<Uom> uoms = service.getAll();
		return new ModelAndView(new UomXlsxView(),"uomList",uoms);
	}
}
