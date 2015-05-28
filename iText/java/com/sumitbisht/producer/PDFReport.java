package com.sumitbisht.producer;

import java.io.FileOutputStream;
import java.util.Map;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PDFReport{

	private PDFReport(){
	}
	public static void buildPdfDocument(String docName, Map<String, String> map)
	{
		try {
			Document doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(docName));
			doc.open();
			addMetaData(doc);
			Table table = new Table(2);
			table.addCell("Name");
			table.addCell("Address");
			
			for (String key : map.keySet()) {
				table.addCell(key);
				table.addCell(map.get(key));
			}
			doc.add(table);
			doc.close();
		} catch (Exception e) {
			System.out.println("Error while trying to generate PDF");
			e.printStackTrace();
		}
		
	}

	static void addMetaData(Document doc) {
		doc.addTitle("Form Capture Report");
		doc.addAuthor("sumit bisht");
		doc.addKeywords("itext,pdf");
	}

}
