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

import com.sathyatech.app.controller.multipart.validator.ShipmentTypeMultipartValidator;
import com.sathyatech.app.model.ShipmentType;
import com.sathyatech.app.service.IShipmentTypeService;
import com.sathyatech.app.util.ShipmentTypeUtil;
import com.sathyatech.app.view.ShipmentTypeXlsxView;

@Controller
@RequestMapping("/shipmentTypeMultipart")
public class ShipmentTypeMultipartController {

	@Autowired
	private ShipmentTypeUtil util;
	
	@Autowired
	private IShipmentTypeService service;
	
	@Autowired
	private ShipmentTypeMultipartValidator validator;
	
	/*
	 * 1.To show uom multipart JSP Page
	 */
	@GetMapping("/show")
	public String showMultipartPage() {
		return "ShipmentTypeMultipart";
	}
	
	/*
	 * 2.On click Import Button
	 */
	@PostMapping("/shipmentTypeImport")
	public String importShipments(@RequestParam MultipartFile shipmentTypeFile,ModelMap map) {
		//check uploaded file is valid or not?
		if(shipmentTypeFile==null || !shipmentTypeFile.getOriginalFilename().contains(".xlsx")) {
			map.addAttribute("message", "Choose valid File");
		}else {
			List<ShipmentType> shipmentTypeList = util.processMultipart(shipmentTypeFile);
			if(shipmentTypeList.isEmpty()) {
				map.addAttribute("message", "No Records (Rows) Found in Sheet");
			}else {
				Map<String,List<String>> errorMap = validator.validateShipmentType(shipmentTypeList); 
			    if(errorMap.isEmpty()) {
			    	service.save(shipmentTypeList);
			    	map.addAttribute("message", "File Uoms Data Uploaded Successfully!");
			    }else {
			    	map.addAttribute("errorsMap",errorMap);
			    }
			}
		}
		return "ShipmentTypeMultipart";
	}
	
	/*
	 * 3.Uom Export (To Excel Sheet)
	 */
	@RequestMapping("/exportShipmentType")
	public ModelAndView exportData() {
		List<ShipmentType> shipmentType = service.getAll();
		return new ModelAndView(new ShipmentTypeXlsxView(),"shipmentTypeList",shipmentType);
	}

}
