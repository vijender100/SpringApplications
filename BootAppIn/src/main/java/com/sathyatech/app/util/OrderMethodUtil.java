package com.sathyatech.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.sathyatech.app.model.OrderMethod;

@Component
public class OrderMethodUtil {

	
	public List<String> getOrderModes(){
		return Arrays.asList("Sale","Purchase");
	}
	
	public List<String> getOrderMethods(){
		return Arrays.asList("FIFO","LIFO","FMFO","FEFO");
	}
	
	public List<String> getOrderAccepts(){
		return Arrays.asList("Multi-Model","Accept Return");
	}
	
	public void uiComponents(ModelMap map) {
		map.addAttribute("orderMode", getOrderModes());
		map.addAttribute("orderMethd", getOrderMethods());
		map.addAttribute("orderAccept", getOrderAccepts());
	}
	
	public List<String> toList(String str) {
		List<String> l1 = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(str,",");
	//	if(st==null) {
			while(st.hasMoreTokens()) {
				l1.add(st.nextToken());
			}
	//	}
		return l1;
	}
	
	public List<OrderMethod> processMultipart(MultipartFile orderMethodFile){
		List<OrderMethod> orderMethodList = null;
		if(orderMethodFile!=null) {
			orderMethodList = new ArrayList<OrderMethod>();
			try {
				InputStream is = orderMethodFile.getInputStream();
				XSSFWorkbook book = new XSSFWorkbook(is);
				XSSFSheet sheet = book.getSheet("orders");
				
				Iterator<Row> rows = sheet.iterator();
				while (rows.hasNext()) {
					Row row = rows.next();
					if (row.getRowNum()==0) continue;
					//5 param constructor
					OrderMethod orderMethod = new OrderMethod(
							row.getCell(0)==null? " " : row.getCell(0).getStringCellValue(),
							row.getCell(1)==null? " " : row.getCell(1).getStringCellValue(),
							row.getCell(2)==null? " " :	row.getCell(2).getStringCellValue(),
							toList(row.getCell(3)==null? " " :row.getCell(3).getStringCellValue()),
							row.getCell(4)==null? " " :	row.getCell(4).getStringCellValue()
							); 
					
					orderMethodList.add(orderMethod);
				}
			}catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
		return orderMethodList;
	}		
}				