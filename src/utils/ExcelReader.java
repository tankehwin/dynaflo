package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;

import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import data.*;

public class ExcelReader {

	public void ingestExcelFile(String filePath) throws Exception {
		
		// Open workbook
		Workbook dynafloBook = Workbook.getWorkbook(new File("C:/Users/tankehwin/Desktop/DYNAFLO PRICE 2016 - 8.8.16.xls")); // TODO: Modify this to get from uploaded file
		// Instantiate hard-coded master file for field name schemes
		FieldNameScheme fnsScroll = new FieldNameScheme();
		// Start loop
		for(int i=0; i<dynafloBook.getNumberOfSheets(); i++){
			// Access next worksheet
			Sheet sheet = dynafloBook.getSheet(i);
			// Find out which worksheet it is based on worksheet name (Kawasaki, EUROTECH, Hosco, PHALBOK etc.)
			String dynafloSheetName = sheet.getName();
			System.out.println("Sheet name: " + dynafloSheetName);
			// Retrieve the appropriate field name scheme (hard-coded or properties file)
			ArrayList arrFieldNames = fnsScroll.getColumns(dynafloSheetName);
			if(arrFieldNames == null) {
				System.out.println(dynafloSheetName + " skipped.");
				continue;
				// throw new Exception("This worksheet is not recognised. Please contact this programme's designer to fix this."); // TODO: uncomment this after testing
			}
			else{
				System.out.println(dynafloSheetName + " has " + arrFieldNames.size() + " columns.");
			}
			// Create field name array
			ArrayList arrFieldColumns = new ArrayList();
			int headerRow = 0;
			// Start loop
			for(int j=0; j<arrFieldNames.size(); j++){
				// Find cells associated with each field name according to field name scheme for that worksheet, taking into account column numbers
				String fieldName = (String) arrFieldNames.get(j);
				System.out.println("Column name is: " + fieldName);
				Cell cellColumn = sheet.findCell(fieldName);
				// Store in a field name array
				arrFieldColumns.add(cellColumn.getColumn());
				// Keep row of where headers start
				headerRow = cellColumn.getRow();
			// End loop
			}		
			// Find the row from which all data starts
			int currentRow = headerRow + 1;
			// Start loop
			boolean endOfData = false;
			System.out.println("Number of columns detected: " + arrFieldColumns.size());
			System.out.println("Initial currentRow: " + currentRow);
			while(endOfData==false){
				// Does the row have data? if so, continue. Otherwise, end loop
				Cell cellData = sheet.getCell(1, currentRow);
				if(cellData.getContents().trim().equals("")){
					System.out.println("No more data rows detected: " + currentRow);
					endOfData = true;
					break;
				}
				// Based on field name array created earlier, read in data into product object
				for(int k=0;k<arrFieldColumns.size();k++){
					int colNumber = (int) arrFieldColumns.get(k);
					String cellValue = "";
					if(k==0){ // This if statement is because the first column (PART NUMBER) actually contains 2 cells of info, so requires concatenation
						cellData = sheet.getCell(colNumber, currentRow);
						cellValue = cellData.getContents().trim();
						cellData = sheet.getCell(colNumber + 1, currentRow);
						cellValue += cellData.getContents().trim();
					}
					else{
						cellData = sheet.getCell(colNumber, currentRow);
						cellValue = cellData.getContents().trim();
					}					
					System.out.println(cellValue);
				}
				System.out.println("==========");
				// Go to next row
				currentRow++;
			// End loop
			}
			// Write all product objects into database. Overwrite where necessary if there is a product code match
			// Should there be code to check for items to delete?
		// End loop
		}
		dynafloBook.close();	
		
		/*
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
		*/
	}
	
}
