package Evaluation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePdf {
	

	public static void main(String[] args) throws DocumentException {
		
		String searchString = "example";
	    
		// Create 100 PDF files
		for (int i = 1; i <= 100; i++) {
			
				// Create a new document
            	Document document = new Document();
	           
				// Set the file name
	    		 String fileName = "document" + i + ".pdf";
	    		 
	    	
	                try {
	                // Create a PDF writer
	                PdfWriter.getInstance(document, new FileOutputStream(fileName));

	                // Open the document
	                document.open();

	                // Add a paragraph to the document
	                document.add(new Paragraph("Welcome to CodeLine" + i));

	                // Close the document
	                document.close();
	                
	            } catch (Exception e) {
	              e.printStackTrace();
	           }
	        }
		// Scan each file for the given string
		 for (int i = 1; i <= 100; i++) {
			 // Set the file name
			 String fileName = "document" + i + ".pdf";

			 
			 try {
			 
			 // Create a new Scanner object to read the file
			 Scanner scanner = new Scanner(new File(fileName));

			 // Search for the string in the file
			 while (scanner.hasNextLine()) {
				 String line = scanner.nextLine();
				 if (line.contains(searchString)) {
					 
					 // String was found, so place the file in the corresponding folder
                    File file = new File(fileName);
                    File folder = new File("folder" + i);
                    if (!folder.exists()) {
                        folder.mkdir();
                    }
                    file.renameTo(new File(folder, fileName));
		
					 break;
				 }
			 }

			 // Close the scanner
			 scanner.close();
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 }
	}
		
}	 