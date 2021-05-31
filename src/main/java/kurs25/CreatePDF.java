package kurs25;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.stream.Stream;

import javax.servlet.jsp.PageContext;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class CreatePDF {
		
    public CreatePDF() {
    	
    }
    public void Create(String numberpdf) throws IOException {
      	
    	Document document = new Document(); //создание класса Document
    	
String filepath = CreatePDF.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    	
		File currentClass = new File(URLDecoder.decode(CreatePDF.class
	                .getProtectionDomain()
	                .getCodeSource()
	                .getLocation()
	                .getPath(), "UTF-8"));
		
		filepath = currentClass.getParent();
		File currentClass2 = new File(URLDecoder.decode(filepath, "UTF-8"));
		filepath = currentClass2.getParent();
			
		filepath=filepath + "/Check.pdf";
		try {	
			PdfWriter.getInstance(document, new FileOutputStream(filepath));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		Font fontpath =FontFactory.getFont(filepath + "/times.ttf");
		document.open(); 
		
		BaseFont times =fontpath.getBaseFont();
		
		String string_pdf = "Result for Calculate";
		Paragraph paragraph = new Paragraph();
	    paragraph.add(new Paragraph(string_pdf, new Font(times,14)));
	    
	    String string_pdf2 = "";
	    paragraph.add(new Paragraph(string_pdf2, new Font(times,14)));
	
	    try {
			document.add(paragraph);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	    
	  //организация перехода на следующую строку
		 paragraph.clear();
		 String string_pdf3 = " ";
		 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
		 
		 try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
	    
	    
		 //организация перехода на следующую строку
		 paragraph.clear();
		 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
		 
		 try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
	    
		 
		//добавление таблицы
		 PdfPTable table = new PdfPTable(7); //создание таблицы с 4 столбцами
		 addHeader(table);
		 addRows(table, times);
		 
		 try {
			document.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	    
	    document.close(); //закрытие и сохранение документа PDF
    }
    
private void addRows(PdfPTable table, BaseFont BaseFont) {
	
		
		//заполнение таблицы вводимыми значения в текстовые поля на главной форме
		Phrase cell1 = new Phrase(Calc.creditAmount,new Font(BaseFont,14));
		Phrase cell2 = new Phrase(Calc.firstPayPDF,new Font(BaseFont,14));
		Phrase cell3 = new Phrase(Calc.paymentPerMonth,new Font(BaseFont,14));
		Phrase cell4 = new Phrase(Calc.purposeOfTheLoan,new Font(BaseFont,14));
		Phrase cell5 = new Phrase(Calc.currencyPDF,new Font(BaseFont,14));
		Phrase cell6 = new Phrase(Calc.dataPDF,new Font(BaseFont,14));
		Phrase cell7 = new Phrase(Calc.strahovkaPDF,new Font(BaseFont,14));
				
		table.addCell(cell1);
	    table.addCell(cell2);
	    table.addCell(cell3);
	    table.addCell(cell4);
	    table.addCell(cell5);
	    table.addCell(cell6);
	    table.addCell(cell7);
		
	}

private void addHeader(PdfPTable table) {
	Stream.of("credit amount", "first pay", "payment per month", "purpose of the loan","currency", "data", "insurance")
      .forEach(columnTitle -> {
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        header.setBorderWidth(2);
        header.setPhrase(new Phrase(columnTitle));
        table.addCell(header);
    });
}
}
