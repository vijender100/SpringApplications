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

import com.sathyatech.app.model.WhUserType;
@Component
public class WhUserTypeUtil {

	public List<String> getUserType(){
		return Arrays.asList("Vendor","Customer");
	}
	
	public List<String> getUserIdType(){
		return Arrays.asList("PAN CARD","AADHAR","VOTERID","OTHERS");
	}
	
	public void addUiComponents(ModelMap map) {
		map.addAttribute("userType", getUserType());
		map.addAttribute("userIdType", getUserIdType());
	}
	public List<WhUserType> processMultipart(MultipartFile whUserTypeFile){
		List<WhUserType> whUserTypeList = null;
		XSSFWorkbook book =null;
		if(whUserTypeFile!=null) {
			whUserTypeList = new ArrayList<WhUserType>();
			try {
				InputStream is = whUserTypeFile.getInputStream();
				book = new XSSFWorkbook(is);
				XSSFSheet sheet = book.getSheet("whUserTypes");
				
				Iterator<Row> rows = sheet.iterator();
				while (rows.hasNext()) {
					Row row = rows.next();
					if (row.getRowNum()==0) continue;
					
					//8 param constructor
					WhUserType whUserType = new WhUserType(
									row.getCell(0)==null? " " : row.getCell(0).getStringCellValue(),
									row.getCell(1)==null? " " : row.getCell(1).getStringCellValue(),
									row.getCell(2)==null? " " :	row.getCell(2).getStringCellValue(),
									row.getCell(3)==null? " " :	row.getCell(3).getStringCellValue(),
									row.getCell(4)==null? " " :	row.getCell(4).getStringCellValue(),
									row.getCell(5)==null? " " :	row.getCell(5).getStringCellValue(),
									row.getCell(6)==null? " " :	row.getCell(6).getStringCellValue(),
									row.getCell(7)==null? " " :	row.getCell(7).getStringCellValue()
											);
					//add uom obj to uomList
					whUserTypeList.add(whUserType);
				}//while()
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}//if()
		return whUserTypeList;
	}

}
