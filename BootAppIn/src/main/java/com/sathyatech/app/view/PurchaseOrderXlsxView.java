package com.sathyatech.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.sathyatech.app.model.PurchaseOrder;

public class PurchaseOrderXlsxView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		res.setHeader("Content-Disposition", "attachment;filename=po.xlsx");
		
		List<PurchaseOrder> listPo=(List<PurchaseOrder>) model.get("listPo");
		
		Sheet sheet= book.createSheet();
		
		setHeader(sheet);
		
		setBody(sheet, listPo);
		
	}
	
	public void setHeader(Sheet sheet){
		Row row= sheet.createRow(0);
		
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("Order Code");
		row.createCell(2).setCellValue("Mode");
		row.createCell(3).setCellValue("Vendor");
		row.createCell(4).setCellValue("Ref Num");
		row.createCell(5).setCellValue("Quality Check ");
		row.createCell(6).setCellValue("Status");
		row.createCell(7).setCellValue("Desc");
		row.createCell(8).setCellValue("Ct Date");
		row.createCell(9).setCellValue("Md Date");
	}
	
	public void setBody(Sheet sheet,List<PurchaseOrder> listPo){
		int rowNum = 1;
		for(PurchaseOrder po:listPo){
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(po.getOrderId());
			row.createCell(1).setCellValue(po.getOrderCode());
			row.createCell(2).setCellValue(po.getShipmentMode().getShipmentCode());
			row.createCell(3).setCellValue(po.getVendor().getUserCode());
			row.createCell(4).setCellValue(po.getRefernceNumber());
			row.createCell(5).setCellValue(po.getQualityCheck());
			row.createCell(6).setCellValue(po.getStatus());
			row.createCell(7).setCellValue(po.getDescription());
			row.createCell(8).setCellValue(po.getCreatedOn().toString());
			row.createCell(9).setCellValue(po.getModifiedOn().toString());
		}
	}
}
