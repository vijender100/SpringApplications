package com.sathyatech.app.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.sathyatech.app.model.Item;
import com.sathyatech.app.model.WhUserType;

public class ItemXlsxView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		response.setHeader("Content-Disposition", "attachment;filename=itemsdata.xlsx");
		
		List<Item> itemList=(List<Item>) model.get("itemList");
		Sheet sheet=workbook.createSheet();
		
		setHead(sheet);
		setBody(sheet,itemList);
		
	}
	
	public void setHead(Sheet sheet)
	{
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("ITEM CODE");
		row.createCell(2).setCellValue("ITEM WIDTH");
		row.createCell(3).setCellValue("ITEM LENGTH");
		row.createCell(4).setCellValue("ITEM HEIGHT");
		row.createCell(5).setCellValue("BASE COST");
		row.createCell(6).setCellValue("BASE CURRENCY");
		row.createCell(7).setCellValue("Uom");
		row.createCell(8).setCellValue("OMSALE");
		row.createCell(9).setCellValue("OMPURCHASE");
		row.createCell(10).setCellValue("WHVENDORS");
		row.createCell(11).setCellValue("WHCUSTOMERS");
		row.createCell(12).setCellValue("DESCRIPTION");
		row.createCell(13).setCellValue("CREATED ON");
		row.createCell(14).setCellValue("MODIFIED ON");
	}
	public void setBody(Sheet sheet,List<Item> itemList)
	{
		int rowNum=1;
		for(Item item:itemList)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(item.getItemId());
			row.createCell(1).setCellValue(item.getItemCode());
			row.createCell(2).setCellValue(item.getItemWdth());
			row.createCell(3).setCellValue(item.getItemLnth());
			row.createCell(4).setCellValue(item.getItemHgth());
			row.createCell(5).setCellValue(item.getBaseCost());
			row.createCell(6).setCellValue(item.getBaseCurrency());
			row.createCell(7).setCellValue(item.getUom().toString());
			row.createCell(8).setCellValue(item.getOmSale().toString());
			row.createCell(9).setCellValue(item.getOmPurchase().toString());
			row.createCell(10).setCellValue(getCodes(item.getWhVendors()).toString());
			row.createCell(11).setCellValue(getCodes(item.getWhCustomers()).toString());
			row.createCell(12).setCellValue(item.getDescription());
			row.createCell(13).setCellValue(item.getCreatedOn().toString());
			row.createCell(14).setCellValue(item.getModifiedOn().toString());			
		}
	}
	public List<String> getCodes(List<WhUserType> users){
		List<String> al=new ArrayList<String>();
		for(WhUserType user:users){
			al.add(user.getUserCode());
		}
		return al; 
	}

}