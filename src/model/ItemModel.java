package model;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import data.FieldNameScheme;

public class ItemModel {

	public static final String COLNAME_PARTNUMBER = "part_number";
	public static final String COLNAME_DESCRIPTION = "description";
	public static final String COLNAME_ADDITIONALINFORMATION1 = "add_info_1";
	public static final String COLNAME_ADDITIONALINFORMATION2 = "add_info_2";
	public static final String COLNAME_ADDITIONALINFORMATION3 = "add_info_3";
	public static final String COLNAME_DUTIES = "duties";
	public static final String COLNAME_SELLINGPRICE = "selling_price";
	public static final String COLNAME_LEADTIMEARO = "lead_time_aro";
	public static final String COLNAME_DYNAFLODISCOUNTCODE = "dynaflo_discount_code";
	public static final String COLNAME_OLDPARTNUMBER = "old_part_number";
	public static final String COLNAME_LATESTDATEPURCHASED = "latest_date_purchased";
	public static final String COLNAME_SUPPLIER = "supplier";
	public static final String COLNAME_ITEMREFERENCE = "item_reference";
	public static final String COLNAME_EQUIPMENTPACKAGEREFERENCE = "equipment_package_reference";
	public static final String COLNAME_GRACOREFERENCE = "graco_reference";
	public static final String COLNAME_GRACOFAMILYTYPE = "graco_fam_type";
	public static final String COLNAME_GRACOFAMILYDISCOUNT = "graco_fam_discount";
	public static final String COLNAME_GRACOSTDDISCOUNTCODE = "graco_std_discount_code";
	public static final String COLNAME_GRACOSTDDISCOUNT = "graco_std_discount";
	public static final String COLNAME_SUPPLIERCODE = "supplier_code";
	public static final String COLNAME_BRAND = "brand";
	
	public static final String TABLENAME = "items_master";
	
	public static final int MODE_INT = 1;
	public static final int MODE_FRACTION = 2;
	
	private String partNumber;
	private String description;
	private String addInfo1;
	private String addInfo2;
	private String addInfo3;
	private BigDecimal duties;
	private BigDecimal sellingPrice;
	private Integer leadTimeARO;
	private String dynafloDiscountCode;
	private String oldPartNumber;
	private Timestamp latestDatePurchased;
	private String supplier;
	private String itemReference;
	private String equipmentPackageReference;
	private String gracoReference;
	private String gracoFamType;
	private BigDecimal gracoFamDiscount;
	private String gracoStdDiscountCode;
	private BigDecimal gracoStdDiscount;
	private String supplierCode;
	private String brand;
	
	public ItemModel() {
		this.partNumber = "";
		this.description = "";
		this.addInfo1 = "";
		this.addInfo2 = "";
		this.addInfo3 = "";
		this.duties = new BigDecimal(0);
		this.sellingPrice = new BigDecimal(0);
		this.leadTimeARO = new Integer(0);
		this.dynafloDiscountCode = "";
		this.oldPartNumber = "";
		this.latestDatePurchased = Timestamp.valueOf("1970-01-01 00:00:01");
		this.supplier = "";
		this.itemReference = "";
		this.equipmentPackageReference = "";
		this.gracoReference = "";
		this.gracoFamType = "";
		this.gracoFamDiscount = new BigDecimal(0);
		this.gracoStdDiscountCode = "";
		this.gracoStdDiscount = new BigDecimal(0);
		this.supplierCode = "";
	}
	
	private String removeInvalidValueInNumberField(String result, int mode) throws Exception {
		result = result.replaceAll("%", "");
		if(result.trim().equals("")){
			if(mode==MODE_INT){
				result = "0";
			}
			else{
				result = "0.0";
			}		
		}
		else if(!StringUtils.isNumeric(result.trim())){
			if(mode==MODE_INT){
				result = "0";
			}
			else{
				result = "0.0";
			}
		}
		
		return result;
	}
	
	public void setFieldValue(String fieldName, Object value) throws Exception {
		if(FieldNameScheme.FIELDNAME_PART_NUMBER.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.partNumber = result;
		}
		else if(FieldNameScheme.FIELDNAME_DESCRIPTION.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.description = result;
		}
		else if(FieldNameScheme.FIELDNAME_ADDITIONAL_INFORMATION_1.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			result = result.replace("\\", "");
			this.addInfo1 = result;		
		}
		else if(FieldNameScheme.FIELDNAME_ADDITIONAL_INFORMATION_2.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			result = result.replace("\\", "");
			this.addInfo2 = result;
		}
		else if(FieldNameScheme.FIELDNAME_ADDITIONAL_INFORMATION_3.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			result = result.replace("\\", "");
			this.addInfo3 = result;
		}
		else if(FieldNameScheme.FIELDNAME_DUTIES.equals(fieldName)){
			String result = value.toString();			
			result = removeInvalidValueInNumberField(result, MODE_FRACTION);
			this.duties = new BigDecimal(result);
		}
		else if(FieldNameScheme.FIELDNAME_SELLING_PRICE.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll(",", "");
			result = removeInvalidValueInNumberField(result, MODE_FRACTION);
			this.sellingPrice = new BigDecimal(result);
		}
		else if(FieldNameScheme.FIELDNAME_LEAD_TIME.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll(",", "");
			result = removeInvalidValueInNumberField(result, MODE_INT);
			this.leadTimeARO = new Integer(result.toString());
		}
		else if(FieldNameScheme.FIELDNAME_DYNAFLO_DISCOUNT_CODE.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.dynafloDiscountCode = result;
		}
		else if(FieldNameScheme.FIELDNAME_OLD_PART_NUMBER.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.oldPartNumber = result;
		}
		else if(FieldNameScheme.FIELDNAME_LATEST_DATE_PURCHASED.equals(fieldName)){			
			if(!value.toString().trim().equals("")){
				// There is a problem with Excel extracting dates - the dates being extracted is nth day of year, e.g. 56/02/2014
				// This code counteracts this issue, but we cannot be sure that this will always be the case
				// Currently just a workaround
				Calendar calendar = Calendar.getInstance();
				int slashIndex = value.toString().indexOf("/");
				int dayOfYear = new Integer(value.toString().substring(0, slashIndex)).intValue();
				slashIndex = value.toString().lastIndexOf("/");
				int year = new Integer(value.toString().substring(slashIndex+1)).intValue();
				calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
				calendar.set(Calendar.YEAR, year);
				Timestamp timestamp = new java.sql.Timestamp(calendar.getTime().getTime());
				/*// This is a more conventional method of saving date data, assuming the data extracted from Excel is conventional
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			    Date parsedDate;
			    try{
			    	parsedDate = dateFormat.parse((String) value);	    	
			    }
			    catch(Exception e){
			    	throw e;
			    }	    
			    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
			    */			
				this.latestDatePurchased = timestamp;
			}			
		}
		else if(FieldNameScheme.FIELDNAME_SUPPLIER.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.supplier = result;
		}
		else if(FieldNameScheme.FIELDNAME_ITEM_REF.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.itemReference = result;
		}
		else if(FieldNameScheme.FIELDNAME_GRACO_FAMILY_TYPE.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");		
			if(result.trim().equals("STD")){
				result = "0.0";
			}
			result = removeInvalidValueInNumberField(result, MODE_FRACTION);
			this.gracoFamType = result;
		}
		else if(COLNAME_BRAND.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.brand = result;
		}
		else if(FieldNameScheme.FIELDNAME_GRACO_FAMILY_DISCOUNT.equals(fieldName)){
			String result = value.toString();
			if(result.trim().equals("STD")){
				result = "0.0";
			}
			result = removeInvalidValueInNumberField(result, MODE_FRACTION);
			this.gracoFamDiscount = new BigDecimal(result);
		}
		else if(FieldNameScheme.FIELDNAME_GRACO_STD_DISCOUNT.equals(fieldName)){
			String result = value.toString();			
			if(result.trim().equals("STD")){
				result = "0.0";
			}
			result = removeInvalidValueInNumberField(result, MODE_FRACTION);
			this.gracoStdDiscount = new BigDecimal(result);
		}
		else if(FieldNameScheme.FIELDNAME_SUPPLIER_CODE.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.supplierCode = result;
		}
	}
	
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddInfo1() {
		return addInfo1;
	}
	public void setAddInfo1(String addInfo1) {
		this.addInfo1 = addInfo1;
	}
	public String getAddInfo2() {
		return addInfo2;
	}
	public void setAddInfo2(String addInfo2) {
		this.addInfo2 = addInfo2;
	}
	public String getAddInfo3() {
		return addInfo3;
	}
	public void setAddInfo3(String addInfo3) {
		this.addInfo3 = addInfo3;
	}
	public BigDecimal getDuties() {
		int decimalPlaces = 1;
		BigDecimal bd = new BigDecimal(duties.doubleValue());

		// setScale is immutable
		bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
		duties = bd;
		return duties;
	}
	public void setDuties(BigDecimal duties) {
		this.duties = duties;
	}
	public BigDecimal getSellingPrice() {
		int decimalPlaces = 2;
		BigDecimal bd = new BigDecimal(sellingPrice.doubleValue());

		// setScale is immutable
		bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
		sellingPrice = bd;
		return sellingPrice;
	}
	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public Integer getLeadTimeARO() {
		return leadTimeARO;
	}
	public void setLeadTimeARO(Integer leadTimeARO) {
		this.leadTimeARO = leadTimeARO;
	}
	public String getDynafloDiscountCode() {
		return dynafloDiscountCode;
	}
	public void setDynafloDiscountCode(String dynafloDiscountCode) {
		this.dynafloDiscountCode = dynafloDiscountCode;
	}
	public String getOldPartNumber() {
		return oldPartNumber;
	}
	public void setOldPartNumber(String oldPartNumber) {
		this.oldPartNumber = oldPartNumber;
	}
	public Timestamp getLatestDatePurchased() {
		return latestDatePurchased;
	}
	public void setLatestDatePurchased(Timestamp latestDatePurchased) {
		this.latestDatePurchased = latestDatePurchased;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getItemReference() {
		return itemReference;
	}
	public void setItemReference(String itemReference) {
		this.itemReference = itemReference;
	}
	public String getEquipmentPackageReference() {
		return equipmentPackageReference;
	}
	public void setEquipmentPackageReference(String equipmentPackageReference) {
		this.equipmentPackageReference = equipmentPackageReference;
	}
	public String getGracoReference() {
		return gracoReference;
	}
	public void setGracoReference(String gracoReference) {
		this.gracoReference = gracoReference;
	}
	public String getGracoFamType() {
		return gracoFamType;
	}
	public void setGracoFamType(String gracoFamType) {
		this.gracoFamType = gracoFamType;
	}
	public BigDecimal getGracoFamDiscount() {
//		int decimalPlaces = 2;
//		BigDecimal bd = new BigDecimal(gracoFamDiscount.doubleValue());
//
//		// setScale is immutable
//		bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
//		gracoFamDiscount = bd;
		return gracoFamDiscount;
	}
	public void setGracoFamDiscount(BigDecimal gracoFamDiscount) {
		this.gracoFamDiscount = gracoFamDiscount;
	}
	public String getGracoStdDiscountCode() {
		return gracoStdDiscountCode;
	}
	public void setGracoStdDiscountCode(String gracoStdDiscountCode) {
		this.gracoStdDiscountCode = gracoStdDiscountCode;
	}
	public BigDecimal getGracoStdDiscount() {
//		int decimalPlaces = 2;
//		BigDecimal bd = new BigDecimal(gracoStdDiscount.doubleValue());
//
//		// setScale is immutable
//		bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
//		gracoStdDiscount = bd;
		return gracoStdDiscount;
	}
	public void setGracoStdDiscount(BigDecimal gracoStdDiscount) {
		this.gracoStdDiscount = gracoStdDiscount;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
}
