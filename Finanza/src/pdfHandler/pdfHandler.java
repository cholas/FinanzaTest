package pdfHandler;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class pdfHandler {
	
	public static String[] pdfSearch()
	{
		//PATH
			String current="";
				try {
						current = new java.io.File(".").getCanonicalPath();
					} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File directoryPath = new File(current+"/PDF");
			String pdfs[]=directoryPath.list();
			return pdfs;
		
	}
	
	public static String[] ImportPDF(String name)
	{
		String[] tokenizedPDF = null;
		//PATH
		String current="";
		try {
				current = new java.io.File(".").getCanonicalPath();
			} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		File file=new File(current+"/PDF/"+name+".pdf"); //IMPORT FILE PDF
		PDDocument document = null;
		try {
			document=PDDocument.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	      PDFTextStripper pdfStripper = null;
		try {
			pdfStripper = new PDFTextStripper();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	      //GET PDF TEXT
	      String text = null;
		try {
			text = pdfStripper.getText(document);
			
			tokenizedPDF=pdfTokenizer(text,name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      

	      //Closing the document
	      try {
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return tokenizedPDF;
	}

	public static String[] pdfTokenizer(String text, String name)
	{
		//String parsing
		String t="Vietata la pubblicazione, la riproduzione e la divulgazione a scopo di lucro.";
		while (text.contains(t)) {
		    text = text.replaceFirst(Pattern.quote(t), "");
		   
		}
		
		
		String array1[]=text.split(name);
		
		
		return array1;
	}
}
