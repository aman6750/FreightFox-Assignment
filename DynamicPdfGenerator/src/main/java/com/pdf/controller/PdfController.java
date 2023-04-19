package com.pdf.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.DocumentException;
import com.pdf.model.InputData;
import com.pdf.services.PdfService;

@Controller
@RequestMapping("/pdf")
public class PdfController {
	
	@Autowired
	private PdfService pdfService;
	
	@PostMapping("/generate-pdf")
	public ResponseEntity<Resource> generatePDF(@RequestBody InputData inputData) throws DocumentException, IOException {
	
	    
	    // Return the PDF file as a response
	    Resource fileResource = pdfService.createPdf(inputData);
	    
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
