package com.sathyatech.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.sathyatech.app.model.ShipmentType;

@Component
public class ShipmentTypeUtil {

	public List<String> getShipmentModes(){
		return Arrays.asList("Air","Truck","Ship","Train");
	}
	
	public List<String> getShipmentGrades(){
		return Arrays.asList("A","B","C");
	}
	
	public void uiComponent(ModelMap map) {
		map.addAttribute("shipmentMode", getShipmentModes());
		map.addAttribute("shipmentGrade", getShipmentGrades());
	}
	
	public List<ShipmentType> processMultipart(MultipartFile shipmentTypeFile){
		List<ShipmentType> shipmentTypeList = null;
		if(shipmentTypeFile!=null) {
			shipmentTypeList = new ArrayList<ShipmentType>();
			try {
				InputStream is = shipmentTypeFile.getInputStream();
				XSSFWorkbook book = new XSSFWorkbook(is);
				XSSFSheet sheet = book.getSheet("shipments");
				
				Iterator<Row> rows = sheet.iterator();
				while (rows.hasNext()) {
					Row row = rows.next();
					if (row.getRowNum()==0) continue;
					//3 param constructor
					ShipmentType shipmentType = new ShipmentType(
									row.getCell(0)==null? "" : row.getCell(0).getStringCellValue(),
									row.getCell(1)==null? "" : row.getCell(1).getStringCellValue(),
									row.getCell(2)==null? "" : row.getCell(2).getStringCellValue(),
									row.getCell(3)==null? "" : row.getCell(3).getStringCellValue(),
									row.getCell(4)==null? "" : row.getCell(4).getStringCellValue()
											);
					//add uom obj to uomList
					shipmentTypeList.add(shipmentType);
				}//while()
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}//if()
		return shipmentTypeList;
	}
}
