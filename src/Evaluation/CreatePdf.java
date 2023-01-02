package Evaluation;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePdf {
	

	public static void main(String[] args) {
		
		
	     for (int i = 1; i <= 100; i++) {
	           
	    	 try {
	                // Create a new document
	                Document document = new Document();

	                // Create a PDF writer
	                PdfWriter.getInstance(document, new FileOutputStream("document" + i + ".pdf"));

	                // Open the document
	                document.open();

	                // Add a paragraph to the document
	                document.add(new Paragraph("Welcome to CodeLine"));

	                // Close the document
	                document.close();
	                
	            } catch (Exception e) {
	                e.printStackTrace();
	           }
	        }
	    }
	}	 