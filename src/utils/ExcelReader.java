package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import jxl.Cell;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;

import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import model.GeneralConfigModel;
import model.ItemModel;
import data.*;

public class ExcelReader {

	public int ingestExcelFile(String filePath, String fileName, Connection conn) throws Exception {
		String errSheet = "";
		int importCount = 0;
		try{
			conn.setAutoCommit(false);
			String samplePath = "C:/Users/tankehwin/Desktop/DYNAFLO PRICE 2016 - 14.10.16 - Rev 2.xls";
			// Open workbook
			File workbookFile = new File(filePath);
			
			Workbook dynafloBook = Workbook.getWorkbook(workbookFile); 
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
				//if(!dynafloSheetName.equals("Local")){
				//	continue;
				//}
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
						//System.out.print(cellValue + ",");
						itmObj.setFieldValue((String) arrFieldNames.get(k), cellValue);				
					}					
					// special consideration for brand property, which is derived from sheet name
					itmObj.setFieldValue(ItemModel.COLNAME_BRAND, dynafloSheetName);
					// Add to product object collection
					arrProdList.add(itmObj);
					//System.out.println("=0=");
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
			
			
			// Update brands list in brands table
			BrandManager.updateBrandsList(ItemManager.getBrands(conn), conn);
			
			// Add code to read the datafile again and extract the brand information then populate the database
			System.out.println("Updating brand information...");
			// Start loop
			for(int i=0; i<dynafloBook.getNumberOfSheets(); i++){
				// Access next worksheet
				Sheet sheet = dynafloBook.getSheet(i);
				// Find out which worksheet it is based on worksheet name (Kawasaki, EUROTECH, Hosco, PHALBOK etc.)
				String dynafloSheetName = sheet.getName();
				// Record sheet name for info later if there are errors
				errSheet = dynafloSheetName;
				System.out.println("Sheet name: " + dynafloSheetName);
				Cell cellEXRRate = sheet.findCell("EXCHANGE RATE:");
				Cell cellEXHDate = sheet.findCell("EXH. RATE DATE:");
				Cell cellFreight = sheet.findCell("FREIGHT:");
				Cell cellNews = sheet.findCell("NEWS:");
				Cell cellPriceDate = sheet.findCell("PRICE DATE:");
				Cell cellEXRRateData = sheet.getCell(cellEXRRate.getColumn() + 2, cellEXRRate.getRow());
				Cell cellEXHDateData = sheet.getCell(cellEXHDate.getColumn() + 2, cellEXHDate.getRow());
				Cell cellFreightData = sheet.getCell(cellFreight.getColumn() + 1, cellFreight.getRow());
				Cell cellNewsData = sheet.getCell(cellNews.getColumn(), cellNews.getRow() + 1);
				Cell cellPriceDateData = sheet.getCell(cellPriceDate.getColumn() + 2, cellPriceDate.getRow());
				// Take the extracted data and stuff it into a class that understands dates extracted from Excel - direct string manipulation 
				// and extraction of date values will not yield satisfactory results
				Calendar calendar = Calendar.getInstance();
				String exhDateString = cellEXHDateData.getContents().trim();
				String priceDateString = cellPriceDateData.getContents().trim();
				if(!exhDateString.equals("-")){
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
					DateCell dateCell = null;
					dateCell = (DateCell) cellEXHDateData;
					exhDateString = dateFormat.format(dateCell.getDate());
				}
				if(!priceDateString.equals("-")){
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
					DateCell dateCell = null;
					dateCell = (DateCell) cellPriceDateData;
					priceDateString = dateFormat.format(dateCell.getDate());
				}
				
				String newsString = cellNewsData.getContents().trim().replaceAll("'", "''");
				BrandManager.updateObject(dynafloSheetName, 
						cellEXRRateData.getContents().trim(),
						exhDateString,
						cellFreightData.getContents().trim(),
						priceDateString,
						newsString,
						conn);
			// End loop
			}
			
			GeneralConfigModel lastFilename = GeneralConfigManager.getConfig(GeneralConfigModel.CONFIG_LAST_IMPORTED_FILENAME, conn);
			if(lastFilename!=null && lastFilename.getName().equals(GeneralConfigModel.CONFIG_LAST_IMPORTED_FILENAME)){
				GeneralConfigManager.updateConfig(GeneralConfigModel.CONFIG_LAST_IMPORTED_FILENAME, fileName, conn);
			}
			else {
				GeneralConfigManager.addConfig(GeneralConfigModel.CONFIG_LAST_IMPORTED_FILENAME, fileName, conn);
			}
			
			
			dynafloBook.close();	
			conn.commit();
		}
		catch(Exception ex){
			System.out.println("Sheet error: " + errSheet);
			ex.printStackTrace();
			importCount = 0;
			conn.rollback();
			throw new Exception("Sheet error: " + errSheet + ". Message: " + ex.getMessage());			
		}
		return importCount;
	}
	
}
