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

import com.sathyatech.app.controller.multipart.validator.PurchaseOrderMultipartValidator;
import com.sathyatech.app.model.PurchaseOrder;
import com.sathyatech.app.service.IPurchaseOrderService;
import com.sathyatech.app.util.PurchaseOrderUtil;
import com.sathyatech.app.view.PurchaseOrderXlsxView;

@Controller
@RequestMapping("/po/multipart")
public class PurchaseOrderMultipartController {
	
	@Autowired
	private IPurchaseOrderService poService;
	
	@Autowired
	private PurchaseOrderUtil poUtil;
	
	@Autowired
	private PurchaseOrderMultipartValidator validator;
	
	@GetMapping("/save")
	public String show(){
		return "PurchaseOrderMultipart";
	}
	
	@PostMapping("/save")
	public String saveFile(@RequestParam MultipartFile poFile,ModelMap map){
		if(poFile ==null || !poFile.getOriginalFilename().contains(".xlsx")){
			map.addAttribute("message", "Invalid File");
		}
		else{
			List<PurchaseOrder> listPo= poUtil.convertFileToList(poFile);
			
			if(listPo.isEmpty()|| listPo==null){
				map.addAttribute("message", "No records");
			}
			else{
				Map<String,List<String>> errorMap= validator.orderValidator(listPo);
				if(errorMap.isEmpty()){
					poService.saveFile(listPo);
					map.addAttribute("message", "Saved Successfully");
				}
				else {
			    	map.addAttribute("errorMap",errorMap);
			    }
			}
		}
		return "PurchaseOrderMultipart";
	}
	
	@GetMapping("/download")
	public ModelAndView export(){
		List<PurchaseOrder> listPo= poService.findAll();
		return new ModelAndView(new PurchaseOrderXlsxView(),"listPo",listPo);
	}
}