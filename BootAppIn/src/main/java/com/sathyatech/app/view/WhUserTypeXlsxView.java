package com.sathyatech.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.sathyatech.app.model.WhUserType;

public class WhUserTypeXlsxView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		response.setHeader("Content-Disposition", "attachment;filename=whUserTypeData.xlsx");
		
		List<WhUserType> whUserTypeList=(List<WhUserType>) map.get("whUserTypeList");
		Sheet sheet=workbook.createSheet();
		
		setHead(sheet);
		setBody(sheet,whUserTypeList);
		
	}

	public void setHead(Sheet sheet)
	{
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("USED FOR");
		row.createCell(4).setCellValue("EMAIL");
		row.createCell(5).setCellValue("CONTACT");
		row.createCell(6).setCellValue("ID TYPE");
		row.createCell(7).setCellValue("OTHER");
		row.createCell(8).setCellValue("ID NUMBER");
		row.createCell(9).setCellValue("CREATED");
		row.createCell(10).setCellValue("MODIFIED");
	}
	public void setBody(Sheet sheet,List<WhUserType> whUserTypeList)
	{
		int rowNum=1;
		for(WhUserType whUserType:whUserTypeList)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(whUserType.getWhUserTypeId());
			row.createCell(1).setCellValue(whUserType.getUserType());
			row.createCell(2).setCellValue(whUserType.getUserCode());
			row.createCell(3).setCellValue(whUserType.getUserFor());
			row.createCell(4).setCellValue(whUserType.getUserEmail());
			row.createCell(5).setCellValue(whUserType.getUserContact());
			row.createCell(6).setCellValue(whUserType.getUserIdType());
			row.createCell(7).setCellValue(whUserType.getIfOther());
			row.createCell(8).setCellValue(whUserType.getIdNumber());
			row.createCell(9).setCellValue(whUserType.getCreatedOn().toString());
			row.createCell(10).setCellValue(whUserType.getModifiedOn().toString());
		}
	}
}
