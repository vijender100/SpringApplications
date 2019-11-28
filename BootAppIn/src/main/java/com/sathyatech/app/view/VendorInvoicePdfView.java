package com.sathyatech.app.view;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sathyatech.app.model.PurchaseOrder;
import com.sathyatech.app.model.PurchaseOrderDetails;

public class VendorInvoicePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment;filename=poinvoice.pdf");
		PurchaseOrder po=(PurchaseOrder) model.get("po");
		
		List<PurchaseOrderDetails> poDtls=po.getDetails();
		double finalCost=0.0;
		for(PurchaseOrderDetails dtl:poDtls){
			finalCost+=dtl.getItemDetails().getBaseCost()*dtl.getItemsQty();
		}
		
		doc.add(new Paragraph("VENDOR INVOICE CODE:VEN-"+po.getOrderCode()));
        
		// define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
		
        
		PdfPTable heading=new PdfPTable(4);
		heading.setWidthPercentage(100.0f);
		heading.setWidths(new float[]{2.5f,2.5f,2.5f,2.5f});
		heading.setSpacingBefore(10);
		
		cell.setPhrase(new Phrase("Vendor Code", font));
		heading.addCell(cell);
		heading.addCell(po.getVendor().getUserCode());
		
		cell.setPhrase(new Phrase("Order Code", font));
		heading.addCell(cell);
		heading.addCell(po.getOrderCode());
		
		cell.setPhrase(new Phrase("Final Cost", font));
		heading.addCell(cell);
		heading.addCell(new BigDecimal(finalCost).setScale(3, RoundingMode.CEILING).toString());
		
		cell.setPhrase(new Phrase("Shipment Type", font));
		heading.addCell(cell);
		heading.addCell(po.getShipmentMode().getShipmentCode());
		
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {1.0f, 3.0f, 2.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);
         
         
        // write table header
        cell.setPhrase(new Phrase("Sl No", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Item", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Cost", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Quantity", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Total", font));
        table.addCell(cell);
         
        // write table row data
        for (PurchaseOrderDetails details : poDtls) {
            table.addCell(String.valueOf(details.getSlno()));
            table.addCell(details.getItemDetails().getItemCode());
            table.addCell(String.valueOf(details.getItemDetails().getBaseCost()));
            table.addCell(String.valueOf(details.getItemsQty()));
            table.addCell(String.valueOf(details.getItemDetails().getBaseCost()*details.getItemsQty()));
        }
         
        doc.add(heading);
        doc.add(table);
		
		doc.add(new Paragraph("Generated On:"+new Date()));
		
	}

}
