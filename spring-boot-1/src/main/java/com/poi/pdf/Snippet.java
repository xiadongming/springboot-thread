package com.poi.pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Snippet {
	public static void main(String[] args) {
		test1();
	}
	
	public static void test1(){//生成pdf
	     Document document = new Document();
	       try {
	           PdfWriter.getInstance(document, new FileOutputStream("d:/test.pdf"));
	           document.open();
	           document.add(new Paragraph("hello word"));
	           document.close();
	         } catch (Exception e) {
	             System.out.println("file create exception");
	         }
	     }

}
