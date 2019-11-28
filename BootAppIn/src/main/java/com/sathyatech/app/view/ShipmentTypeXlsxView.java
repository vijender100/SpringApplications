package com.sathyatech.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.sathyatech.app.model.ShipmentType;

public class ShipmentTypeXlsxView extends AbstractXlsxView {

	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 
		//setBookname (excel name)
		response.setHeader("Content-Disposition", "attachment;filename=shipmentsdata.xlsx");

		//1 Read data
		@SuppressWarnings("unchecked")
		List<ShipmentType> shipmentType=(List<ShipmentType>) model.get("shipmentTypeList");

		//2 create sheet
		Sheet sheet=workbook.createSheet();

		//3 set head 
		setHead(sheet);
		//4 set body
		setBody(sheet,shipmentType);

	}

	public void setHead(Sheet sheet)
	{
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ENABLE");
		row.createCell(4).setCellValue("GRADE");
		row.createCell(5).setCellValue("DESCRIPTION");
		row.createCell(6).setCellValue("CREATED");
		row.createCell(7).setCellValue("MODIFIED");

	}
	public void setBody(Sheet sheet,List<ShipmentType> shipmentTypes)
	{
		int rowNum=1;
		for(ShipmentType shipmentType:shipmentTypes)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(shipmentType.getShipmentTypeId());
			row.createCell(1).setCellValue(shipmentType.getShipmentMode());
			row.createCell(2).setCellValue(shipmentType.getShipmentCode());
			row.createCell(3).setCellValue(shipmentType.getEnableShipment());
			row.createCell(4).setCellValue(shipmentType.getShipmentGrade());
			row.createCell(5).setCellValue(shipmentType.getDescription());
			row.createCell(6).setCellValue(shipmentType.getCreatedOn().toString());
			row.createCell(7).setCellValue(shipmentType.getModifiedOn().toString());
			//here we can also write
			//rowNum=rowNum+1;
		}
	}


}