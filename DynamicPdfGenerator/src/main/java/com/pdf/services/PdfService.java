package com.pdf.services;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;

import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.pdf.model.InputData;
import com.pdf.model.Item;

@Service
public class PdfService{
	
	
	
	private Logger logger = LoggerFactory.getLogger(PdfService.class);
	
	public FileSystemResource createPdf(InputData inputData) throws DocumentException, FileNotFoundException {
		
		logger.info("create PDF Started : ");
		
	    List<Item> items = inputData.getItems();
	    
	    // Use iText to generate the PDF file
	    Document document = new Document();
	    PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
	    document.open();
	    

	    
	 // Create a new table with 2 columns
	    Table table1 = new Table(2);
	    table1.setWidth(100);
	    table1.setPadding(10);

	    // Add the seller details to the first column of the table
	    Cell sellerCell = new Cell();
	    sellerCell.add(new Paragraph("Seller Details:"));
	    sellerCell.add(new Paragraph("Name: " + inputData.getSeller()));
	    sellerCell.add(new Paragraph("GSTIN: " + inputData.getSellerGstin()));
	    sellerCell.add(new Paragraph("Address: " + inputData.getSellerAddress()));
	    table1.addCell(sellerCell);

	    // Add the buyer details to the second column of the table
	    Cell buyerCell = new Cell();
	    buyerCell.add(new Paragraph("Buyer Details:"));
	    buyerCell.add(new Paragraph("Name: " + inputData.getBuyer()));
	    buyerCell.add(new Paragraph("GSTIN: " + inputData.getBuyerGstin()));
	    buyerCell.add(new Paragraph("Address: " + inputData.getBuyerAddress()));
	    table1.addCell(buyerCell);

	    // Add the table to the document
	    document.add(table1);
	    
	    // Add item details
	    PdfPTable table = new PdfPTable(4);
	    table.setWidthPercentage(100);
	    
	    
	    
	    
	    table.addCell("Item Name");
	    table.addCell("Quantity");
	    table.addCell("Rate");
	    table.addCell("Amount");
	    
	    DecimalFormat decimalFormat = new DecimalFormat("0.00"); // Create a decimal formatter with two decimal places

	    for (Item item : items) {
	        table.addCell(item.getName());
	        table.addCell(item.getQuantity());
	        table.addCell(decimalFormat.format(item.getRate())); // Format the rate to two decimal places
	        table.addCell(decimalFormat.format(item.getAmount())); // Format the amount to two decimal places
	    }
	    
	    document.add(table);
	    
	    // Close the document
	    document.close();
		
		return new FileSystemResource("output.pdf");
		
			
		
		
	}
	

}














//String title = "welcome to Aman channel";
//String content = "learn code with aman ";
//
//ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//Document document = new Document();
//
//PdfWriter.getInstance(document, out);
//
//document.open();
//
//Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);
//Paragraph titlePara =  new Paragraph(title,titleFont);
//titlePara.setAlignment(Element.ALIGN_CENTER);
//document.add(titlePara);
//
//Font paraFont = FontFactory.getFont(FontFactory.HELVETICA,18);
//Paragraph paragraph = new Paragraph(content);
//paragraph.add(new Chunk("lund mein maza hgai "));
//document.add(paragraph);
//
//document.close();
//
//
//return new ByteArrayInputStream(out.toByteArray());


