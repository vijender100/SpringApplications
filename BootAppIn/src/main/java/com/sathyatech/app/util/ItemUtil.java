package com.sathyatech.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.sathyatech.app.model.Item;
import com.sathyatech.app.model.OrderMethod;
import com.sathyatech.app.model.Uom;
import com.sathyatech.app.model.WhUserType;
import com.sathyatech.app.service.IOrderMethodService;
import com.sathyatech.app.service.IUomService;
import com.sathyatech.app.service.IWhUserTypeService;

@Component
public class ItemUtil {

	@Autowired
	private IUomService uomService;

	@Autowired
	private IOrderMethodService orderMethodService;

	@Autowired
	private IWhUserTypeService whUserTypeService;

	public List<String> getBaseCurrencies(){
		return Arrays.asList("INR","USD","AUS","EURO","DNR");
	}

	public void addUiComponents(ModelMap map) {
		map.addAttribute("itemBseCurncies", getBaseCurrencies());
		map.addAttribute("uoms",uomService.getAll());
		map.addAttribute("omSales",uomService.getAll());
		map.addAttribute("omSales",orderMethodService.findByOrderMode("Sale"));
		map.addAttribute("omPurchases",orderMethodService.findByOrderMode("Purchase"));
		map.addAttribute("whVendors",whUserTypeService.findByUserType("Vendor"));
		map.addAttribute("whCustomers", whUserTypeService.findByUserType("Customer"));
	}

	/* For Validation Purpose Fetch List of SALE or PURCHASE
	 * In Validator Checks Whether given code belongs to SALE or PURCHASE 
	 */
	public List<String> listOrderCode(String code){
		List<OrderMethod> orderMethods = orderMethodService.findByOrderMode(code);
		ArrayList<String> codes= new ArrayList<String>();
		for(OrderMethod om :orderMethods){
			codes.add(om.getOrderCode());
		}
		return codes;
	}
	//Fetch Uom based On UomModel
	public Uom getUomModels(String uomModel){
		System.out.println(uomService.findByUomModel(uomModel));
		return uomService.findByUomModel(uomModel);
	}
	//Fetch OrderMethod based On OrderCode
	public OrderMethod getOrderCodes(String orderCode){
		System.out.println(orderMethodService.findByOrderCode(orderCode));
		return orderMethodService.findByOrderCode(orderCode);
	}
	//StringTokenizer To Separate Tokens
	public List<WhUserType> getUserCodes(String cell){
		List<WhUserType> whUserTypes = null;
		StringTokenizer st = new StringTokenizer(cell, ",");
		List<String> userCodeList = new ArrayList<String>();
		while(st.hasMoreTokens()){
			userCodeList.add(st.nextToken().trim());
		}
		//Fetch List of WHUserType based on List of whUserCode
		if(!userCodeList.isEmpty())
			whUserTypes = whUserTypeService.findByUserCodeIn(userCodeList);
		return whUserTypes;
	}

	public List<Item> processMultipart(MultipartFile itemFile){
		List<Item> itemList = null;
		if(itemFile!=null) {
			itemList = new ArrayList<Item>();
			try {
				InputStream is = itemFile.getInputStream();
				XSSFWorkbook book = new XSSFWorkbook(is);
				XSSFSheet sheet = book.getSheet("items");

				Iterator<Row> rows = sheet.iterator();
				DataFormatter formatter = new DataFormatter();
				while (rows.hasNext()) {
					Row row = rows.next();
					if (row.getRowNum()==0) continue;
					//use Multipart 11-param Constructor
					Item item = new Item(
							row.getCell(0)==null? " " : row.getCell(0).getStringCellValue(), 
									Double.parseDouble(formatter.formatCellValue(row.getCell(1))), 
									Double.parseDouble(formatter.formatCellValue(row.getCell(2))), 
									Double.parseDouble(formatter.formatCellValue(row.getCell(3))), 
									Double.parseDouble(formatter.formatCellValue(row.getCell(4))), 
									row.getCell(5)==null? " " : row.getCell(5).getStringCellValue(), 
											getUomModels(row.getCell(6)==null? " " : row.getCell(6).getStringCellValue()), 
											getOrderCodes(row.getCell(7)==null? " " : row.getCell(7).getStringCellValue()), 
											getOrderCodes(row.getCell(8)==null? " " : row.getCell(8).getStringCellValue()), 
											getUserCodes(formatter.formatCellValue(row.getCell(9))), 
											getUserCodes(formatter.formatCellValue(row.getCell(10))),
											row.getCell(11)==null? " " : row.getCell(11).getStringCellValue()
							);
					//add Item to List
					itemList.add(item);
				}
			}catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
		return itemList;
	}		
}		