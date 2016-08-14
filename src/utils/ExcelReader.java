package utils;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;

import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelReader {

	public void ingestExcelFile(String filePath) throws Exception {
		
		// Open workbook
		Workbook dynafloBook = Workbook.getWorkbook(new File("DYNAFLO PRICE 2016.xls")); // TODO: Modify this to get from uploaded file
		// Start loop
		for(int i=0; i<dynafloBook.getNumberOfSheets(); i++){
		// 		Access next worksheet
			Sheet sheet = dynafloBook.getSheet(i);
		// 		Find out which worksheet it is based on worksheet name (Kawasaki, EUROTECH, Hosco, PHALBOK etc.)
			String dynafloSheetName = sheet.getName();
			
		// 		Retrieve the appropriate field name scheme (hard-coded or properties file)
		// 		Start loop
		// 			Find cells associated with each field name according to field name scheme for that worksheet, taking into account column numbers
		// 			Store in a field name array
		// 		End loop
		// 		Find the row from which all data starts
		// 		Start loop
		// 			Does the row have data? if so, continue. Otherwise, end loop
		// 			Based on field name array created earlier, read in data into product object
		// 			Go to next row
		// 		End loop
		//		Write all product objects into database. Overwrite where necessary if there is a product code match
		//		Should there be code to check for items to delete?
		// End loop
		}
		
		// Example code follows
		WritableWorkbook wworkbook;
		wworkbook = Workbook.createWorkbook(new File("output.xls"));
		WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
		Label label = new Label(0, 2, "A label record");
		wsheet.addCell(label);
		Number number = new Number(3, 4, 3.1459);
		wsheet.addCell(number);
		wworkbook.write();
		wworkbook.close();
	
		Workbook workbook = Workbook.getWorkbook(new File("output.xls"));
		Sheet sheet = workbook.getSheet(0);
		Cell cell1 = sheet.getCell(0, 2);
		System.out.println(cell1.getContents());
		Cell cell2 = sheet.getCell(3, 4);
		System.out.println(cell2.getContents());
		workbook.close();
	}
	
}
