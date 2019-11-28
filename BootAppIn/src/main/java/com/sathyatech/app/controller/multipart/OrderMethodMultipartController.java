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

import com.sathyatech.app.controller.multipart.validator.OrderMethodMultipartValidator;
import com.sathyatech.app.model.OrderMethod;
import com.sathyatech.app.service.IOrderMethodService;
import com.sathyatech.app.util.OrderMethodUtil;
import com.sathyatech.app.view.OrderMethodXlsxView;

@Controller
@RequestMapping("/orderMethodMultipart")
public class OrderMethodMultipartController {

	@Autowired
	private OrderMethodUtil util;
	
	@Autowired
	private IOrderMethodService service;
	
	@Autowired
	private OrderMethodMultipartValidator validator;
	
	/*
	 * 1.To show uom multipart JSP Page
	 */
	@GetMapping("/show")
	public String showMultipartPage() {
		return "OrderMethodMultipart";
	}
	
	/*
	 * 2.On click Import Button
	 */
	@PostMapping("/orderMethodImport")
	public String importOrders(@RequestParam MultipartFile orderMethodFile,ModelMap map) {
		//check uploaded file is valid or not?
		if(orderMethodFile==null || !orderMethodFile.getOriginalFilename().contains(".xlsx")) {
			map.addAttribute("message", "Choose valid File");
		}else {
			List<OrderMethod> orderMethodList = util.processMultipart(orderMethodFile);
			if(orderMethodList.isEmpty()) {
				map.addAttribute("message", "No Records (Rows) Found in Sheet");
			}else {
				Map<String,List<String>> errorMap = validator.validateOrderMethod(orderMethodList);
			    if(errorMap.isEmpty()) {
			    	service.save(orderMethodList);
			    	map.addAttribute("message", "File OrderMethods Data Uploaded Successfully!");
			    }else {
			    	map.addAttribute("errorsMap",errorMap);
			    }
			}
		}
		return "OrderMethodMultipart";
	}
	
	/*
	 * 3.Uom Export (To Excel Sheet)
	 */
	@RequestMapping("/exportOrderMethod")
	public ModelAndView exportData() {
		List<OrderMethod> orderMethod = service.getAll();
		return new ModelAndView(new OrderMethodXlsxView(),"orderMethodList",orderMethod);
	}
}
