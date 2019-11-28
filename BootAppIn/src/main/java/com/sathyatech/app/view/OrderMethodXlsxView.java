package com.sathyatech.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.sathyatech.app.model.OrderMethod;

public class OrderMethodXlsxView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		response.setHeader("Content-Disposition", "attachment;filename=ordersdata.xlsx");
		
		@SuppressWarnings("unchecked")
		List<OrderMethod> orderMethodList=(List<OrderMethod>) model.get("orderMethodList");
		Sheet sheet=workbook.createSheet();
		
		setHead(sheet);
		setBody(sheet,orderMethodList);
		
	}
	
	public void setHead(Sheet sheet)
	{
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("ORDER MODE");
		row.createCell(2).setCellValue("ORDER CODE");
		row.createCell(3).setCellValue("ORDER METHOD");
		row.createCell(4).setCellValue("ORDER ACCEPT");
		row.createCell(5).setCellValue("DESCRIPTION");
		row.createCell(6).setCellValue("CREATED");
		row.createCell(7).setCellValue("MODIFIED");
	}
	public void setBody(Sheet sheet,List<OrderMethod> orderMethodList)
	{
		int rowNum=1;
		for(OrderMethod orderMethod:orderMethodList)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(orderMethod.getOrderMethdId());
			row.createCell(1).setCellValue(orderMethod.getOrderMode());
			row.createCell(2).setCellValue(orderMethod.getOrderCode());
			row.createCell(3).setCellValue(orderMethod.getOrderMethd());
			row.createCell(4).setCellValue(orderMethod.getOrderAccept().toString());
			row.createCell(5).setCellValue(orderMethod.getDescription());
			row.createCell(6).setCellValue(orderMethod.getCreatedOn());
			row.createCell(7).setCellValue(orderMethod.getModifiedOn());			
		}
	}

}
