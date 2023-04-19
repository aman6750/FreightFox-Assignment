package com.pdf.controller;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.pdf.model.InputData;
import com.pdf.model.Item;
import com.pdf.services.PdfService;

@Controller
@RequestMapping("/pdf")
public class PdfController {
	
	@Autowired
	private PdfService pdfService;
	
	@PostMapping("/generate-pdf")
	public ResponseEntity<Resource> generatePDF(@RequestBody InputData inputData) throws DocumentException, IOException {
	    // Extract the necessary information from the input data
//	    String seller = inputData.getSeller();
//	    String sellerGstin = inputData.getSellerGstin();
//	    String sellerAddress = inputData.getSellerAddress();
//	    
//	    String buyer = inputData.getBuyer();
//	    String buyerGstin = inputData.getBuyerGstin();
//	    String buyerAddress = inputData.getBuyerAddress();
		
	    List<Item> items = inputData.getItems();
	    
	    // Use iText to generate the PDF file
	    Document document = new Document();
	    PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
	    document.open();
	    
//	    // Add seller and buyer information
//	    Paragraph sellerParagraph = new Paragraph("Seller: " + seller);
//	    Paragraph sellerGstinParagraph = new Paragraph("GSTIN: " + sellerGstin);
//	    Paragraph sellerAddressParagraph = new Paragraph("Address: " + sellerAddress);
//	    
//	    Paragraph buyerParagraph = new Paragraph("Buyer: " + buyer);
//	    Paragraph buyerGstinParagraph = new Paragraph("GSTIN: " + buyerGstin);
//	    Paragraph buyerAddressParagraph = new Paragraph("Address: " + buyerAddress);
//	    
//	    document.add(sellerParagraph);
//	    document.add(sellerGstinParagraph);
//	    document.add(sellerAddressParagraph);
//	    document.add(new Paragraph(" "));
//	    document.add(buyerParagraph);
//	    document.add(buyerGstinParagraph);
//	    document.add(buyerAddressParagraph);
//	    document.add(new Paragraph(" "));
	    
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
	    
	    for (Item item : items) {
	        table.addCell(item.getName());
	        table.addCell(item.getQuantity());
	        table.addCell(String.valueOf(item.getRate()));
	        table.addCell(String.valueOf(item.getAmount()));
	    }
	    
	    document.add(table);
	    
	    // Close the document
	    document.close();
	    
	    // Return the PDF file as a response
	    Resource fileResource = new FileSystemResource("output.pdf");
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=output.pdf");
	    return ResponseEntity.ok()
	        .headers(headers)
	        .contentLength(fileResource.contentLength())
	        .contentType(MediaType.APPLICATION_PDF)
	        .body(fileResource);
	    
	}

	
	
	
	
//	@GetMapping("/createPdf")
//	public ResponseEntity<InputStreamResource> createPdf(){		
//		 
//		ByteArrayInputStream pdf =pdfService.createPdf();
//		
//		HttpHeaders httpheader = new HttpHeaders();
//		
//		httpheader.add("Content-Disposition", "inline;file=aman.pdf");
//		
//		return ResponseEntity
//				.ok()
//				.headers(httpheader)
//				.contentType(MediaType.APPLICATION_PDF)
//				.body(new InputStreamResource(pdf));
//		
//	}
	
}
