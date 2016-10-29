package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;

import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import model.ItemModel;
import data.*;

public class ExcelReader {

	public int ingestExcelFile(String filePath, Connection conn) throws Exception {
		String errSheet = "";
		int importCount = 0;
		try{
			String samplePath = "C:/Users/tankehwin/Desktop/DYNAFLO PRICE 2016 - 14.10.16 - Rev 2.xls";
			// Open workbook
			Workbook dynafloBook = Workbook.getWorkbook(new File(filePath)); 
			// Instantiate hard-coded master file for field name schemes
			FieldNameScheme fnsScroll = new FieldNameScheme();
			// Delete all items from database TODO: Transaction object really required for this whole section
			ItemManager.clearTable(conn);
			
			// Start loop
			for(int i=0; i<dynafloBook.getNumberOfSheets(); i++){
				// Access next worksheet
				Sheet sheet = dynafloBook.getSheet(i);
				// Find out which worksheet it is based on worksheet name (Kawasaki, EUROTECH, Hosco, PHALBOK etc.)
				String dynafloSheetName = sheet.getName();
				// Record sheet name for info later if there are errors
				errSheet = dynafloSheetName;
				System.out.println("Sheet name: " + dynafloSheetName);
				// Retrieve the appropriate field name scheme (hard-coded or properties file)
				ArrayList arrFieldNames = fnsScroll.getColumns(dynafloSheetName);
				if(arrFieldNames == null) {
					System.out.println(dynafloSheetName + " skipped.");
					continue;
				}
				else{
					System.out.println(dynafloSheetName + " has " + arrFieldNames.size() + " columns.");
				}
				// Create column number array
				ArrayList arrFieldColumns = new ArrayList();
				int headerRow = 0;
				// Start loop
				for(int j=0; j<arrFieldNames.size(); j++){
					// Find cells associated with each field name according to field name scheme for that worksheet, taking into account column numbers
					String fieldName = (String) arrFieldNames.get(j);
					System.out.println("Column name is: " + fieldName);
					Cell cellColumn = sheet.findCell(fieldName);
					// Store in a column number array
					arrFieldColumns.add(cellColumn.getColumn());
					// Keep row of where headers start
					headerRow = cellColumn.getRow();
				// End loop
				}		
				// Find the row from which all data starts: adding 2 because of rowspan issue in header
				int currentRow = headerRow + 2;
				
				boolean endOfData = false;
				System.out.println("Number of columns detected: " + arrFieldColumns.size());
				System.out.println("Initial currentRow: " + currentRow);
				// Create product object collection
				ArrayList arrProdList = new ArrayList();
				// Start loop
				while(endOfData==false){
					// Does the row have data? if so, continue. Otherwise, end loop
					if(sheet.getRows() <= currentRow){
						System.out.println("Reached end of document: " + currentRow);
						endOfData = true;
						break;
					}
					Cell cellData = sheet.getCell(1, currentRow);
					if(cellData.getContents().trim().equals("")){
						System.out.println("No more data rows detected: " + currentRow);
						endOfData = true;
						break;
					}
					// Create product object
					ItemModel itmObj = new ItemModel();
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
//						System.out.println("column: " + arrFieldNames.get(k));
//						System.out.println("cellValue: " + cellValue);
						// Depending on which column it belongs to, add it to appropriate property
						System.out.print(cellValue + ",");
						itmObj.setFieldValue((String) arrFieldNames.get(k), cellValue);				
					}					
					// special consideration for brand property, which is derived from sheet name
					itmObj.setFieldValue(ItemModel.COLNAME_BRAND, dynafloSheetName);
					// Add to product object collection
					arrProdList.add(itmObj);
					System.out.println("=0=");
					// Go to next row
					currentRow++;
				// End loop
				}
				// Start loop
				for(int m=0;m<arrProdList.size();m++){
					// Write all product objects into database
					ItemModel writeObj = (ItemModel) arrProdList.get(m);
					ItemManager.insertObject(writeObj, conn);
					importCount++;
				// End loop
				}
			// End loop
			}
			dynafloBook.close();	
		}
		catch(Exception ex){
			System.out.println("Sheet error: " + errSheet);
			ex.printStackTrace();
			importCount = 0;
		}
		return importCount;
	}
	
}
