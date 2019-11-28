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
import org.springframework.web.multipart.MultipartFile;

import com.sathyatech.app.model.Uom;

@Component
public class UomUtil {

	
	
	public List<String> getUomTypes(){
		
		return Arrays.asList("PACKING","NO PACKING","--NA--");
		
		/*List<String> list = new ArrayList<String>();
		  list.add("PACKING");
		  list.add("NO PACKING");
		  list.add("--NA--");
		  return list;
		*/
	}
	
	public List<Uom> processMultipart(MultipartFile uomFile){
		List<Uom> uomList = null;
		if(uomFile!=null) {
			uomList = new ArrayList<Uom>();
			try {
				InputStream is = uomFile.getInputStream();
				XSSFWorkbook book = new XSSFWorkbook(is);
				XSSFSheet sheet = book.getSheet("uoms");
				
				Iterator<Row> rows = sheet.iterator();
				while (rows.hasNext()) {
					Row row = rows.next();
					if (row.getRowNum()==0) continue;
					//3 param constructor
					Uom uom = new Uom(
										row.getCell(0)==null? " " : row.getCell(0).getStringCellValue(),
										row.getCell(1)==null? " " : row.getCell(1).getStringCellValue(),
										row.getCell(2)==null? " " :	row.getCell(2).getStringCellValue()
									 );
					//add uom obj to uomList
					uomList.add(uom);
				}//while()
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}//if()
		return uomList;
	}
}
