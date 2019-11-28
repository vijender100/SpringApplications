package com.sathyatech.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.sathyatech.app.model.Uom;

public class UomXlsxView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 
		//set BookName (Excel File Name)
		response.setHeader("Content-Disposition", "attachment;filename=uomsdata.xlsx");
		
		//1.read data
		List<Uom>uoms = (List<Uom>) model.get("uomList");
		 
		//2.create sheet
		Sheet sheet  =workbook.createSheet("UOMs");
		
		//3.set Head (Excel Head Row)
		setHead(sheet);
		
		//4.set Body (Excel Remaining Row or Body)
		setBody(sheet,uoms);
	}
	
	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("MODEL");
		row.createCell(3).setCellValue("DESC");
		row.createCell(4).setCellValue("CREATED ON");
		row.createCell(5).setCellValue("MODIFIED ON");
	}
	
	private void setBody(Sheet sheet, List<Uom> uoms) {
	   int rowNum=1;
	   for(Uom uom:uoms) {
		   Row row = sheet.createRow(rowNum++);
		   row.createCell(0).setCellValue(uom.getUomId());
		   row.createCell(1).setCellValue(uom.getUomType());
		   row.createCell(2).setCellValue(uom.getUomModel());
		   row.createCell(3).setCellValue(uom.getDescription());
		   row.createCell(4).setCellValue(uom.getCreatedOn().toString());
		   row.createCell(5).setCellValue(uom.getModifiedOn().toString());
	   }
	
	}
}
