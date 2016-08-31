package model;

import java.util.Calendar;
import java.util.Date;
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
	
	public static final String TABLENAME = "items_master";
	
	private String partNumber;
	private String description;
	private String addInfo1;
	private String addInfo2;
	private String addInfo3;
	private Double duties;
	private Double sellingPrice;
	private Integer leadTimeARO;
	private String dynafloDiscountCode;
	private String oldPartNumber;
	private Timestamp latestDatePurchased;
	private String supplier;
	private String itemReference;
	private String equipmentPackageReference;
	private String gracoReference;
	private String gracoFamType;
	private Double gracoFamDiscount;
	private String gracoStdDiscountCode;
	private Double gracoStdDiscount;
	private String supplierCode;
	
	public ItemModel() {
		this.partNumber = "";
		this.description = "";
		this.addInfo1 = "";
		this.addInfo2 = "";
		this.addInfo3 = "";
		this.duties = new Double(0);
		this.sellingPrice = new Double(0);
		this.leadTimeARO = new Integer(0);
		this.dynafloDiscountCode = "";
		this.oldPartNumber = "";
		this.latestDatePurchased = Timestamp.valueOf("1970-01-01 00:00:01");
		this.supplier = "";
		this.itemReference = "";
		this.equipmentPackageReference = "";
		this.gracoReference = "";
		this.gracoFamType = "";
		this.gracoFamDiscount = new Double(0);
		this.gracoStdDiscountCode = "";
		this.gracoStdDiscount = new Double(0);
		this.supplierCode = "";
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
			this.addInfo1 = result;		
		}
		else if(FieldNameScheme.FIELDNAME_ADDITIONAL_INFORMATION_2.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.addInfo2 = result;
		}
		else if(FieldNameScheme.FIELDNAME_ADDITIONAL_INFORMATION_3.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.addInfo3 = result;
		}
		else if(FieldNameScheme.FIELDNAME_DUTIES.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("%", "");
			if(result.trim().equals("")){
				result = "0.0";
			}
			this.duties = new Double(result);
		}
		else if(FieldNameScheme.FIELDNAME_SELLING_PRICE.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll(",", "");
			if(result.trim().equals("#N/A!")){
				result = "-1.0";
			}
			this.sellingPrice = new Double(result);
		}
		else if(FieldNameScheme.FIELDNAME_LEAD_TIME.equals(fieldName)){
			this.leadTimeARO = new Integer(value.toString());
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
		else if(FieldNameScheme.FIELDNAME_EQUIPMENT_PACKAGE_REF.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.equipmentPackageReference = result;
		}
		else if(FieldNameScheme.FIELDNAME_GRACO_REF.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.gracoReference = result;
		}
		else if(FieldNameScheme.FIELDNAME_GRACO_FAMILY_TYPE.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.gracoFamType = result;
		}
		else if(FieldNameScheme.FIELDNAME_GRACO_FAMILY_DISCOUNT.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("%", "");
			if(result.trim().equals("")){
				result = "0.0";
			}
			if(result.trim().equals("#N/A!")){
				result = "-1.0";
			}
			if(result.trim().equals("STD")){
				result = "0.0";
			}
			this.gracoFamDiscount = new Double(result);
		}
		else if(FieldNameScheme.FIELDNAME_GRACO_STD_DISCOUNT_CODE.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("'", "''");
			this.gracoStdDiscountCode = result;
		}
		else if(FieldNameScheme.FIELDNAME_GRACO_STD_DISCOUNT.equals(fieldName)){
			String result = value.toString();
			result = result.replaceAll("%", "");
			if(result.trim().equals("")){
				result = "0.0";
			}
			if(result.trim().equals("#N/A!")){
				result = "-1.0";
			}
			if(result.trim().equals("STD")){
				result = "0.0";
			}
			this.gracoStdDiscount = new Double(result);
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
	public Double getDuties() {
		return duties;
	}
	public void setDuties(Double duties) {
		this.duties = duties;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
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
	public Double getGracoFamDiscount() {
		return gracoFamDiscount;
	}
	public void setGracoFamDiscount(Double gracoFamDiscount) {
		this.gracoFamDiscount = gracoFamDiscount;
	}
	public String getGracoStdDiscountCode() {
		return gracoStdDiscountCode;
	}
	public void setGracoStdDiscountCode(String gracoStdDiscountCode) {
		this.gracoStdDiscountCode = gracoStdDiscountCode;
	}
	public Double getGracoStdDiscount() {
		return gracoStdDiscount;
	}
	public void setGracoStdDiscount(Double gracoStdDiscount) {
		this.gracoStdDiscount = gracoStdDiscount;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public static String getColnamePartnumber() {
		return COLNAME_PARTNUMBER;
	}
	public static String getColnameDescription() {
		return COLNAME_DESCRIPTION;
	}
	public static String getColnameAdditionalinformation1() {
		return COLNAME_ADDITIONALINFORMATION1;
	}
	public static String getColnameAdditionalinformation2() {
		return COLNAME_ADDITIONALINFORMATION2;
	}
	public static String getColnameAdditionalinformation3() {
		return COLNAME_ADDITIONALINFORMATION3;
	}
	public static String getColnameDuties() {
		return COLNAME_DUTIES;
	}
	public static String getColnameSellingprice() {
		return COLNAME_SELLINGPRICE;
	}
	public static String getColnameLeadtimearo() {
		return COLNAME_LEADTIMEARO;
	}
	public static String getColnameDynaflodiscountcode() {
		return COLNAME_DYNAFLODISCOUNTCODE;
	}
	public static String getColnameOldpartnumber() {
		return COLNAME_OLDPARTNUMBER;
	}
	public static String getColnameLatestdatepurchased() {
		return COLNAME_LATESTDATEPURCHASED;
	}
	public static String getColnameSupplier() {
		return COLNAME_SUPPLIER;
	}
	public static String getColnameItemreference() {
		return COLNAME_ITEMREFERENCE;
	}
	public static String getColnameEquipmentpackagereference() {
		return COLNAME_EQUIPMENTPACKAGEREFERENCE;
	}
	public static String getColnameGracoreference() {
		return COLNAME_GRACOREFERENCE;
	}
	public static String getColnameGracofamilytype() {
		return COLNAME_GRACOFAMILYTYPE;
	}
	public static String getColnameGracofamilydiscount() {
		return COLNAME_GRACOFAMILYDISCOUNT;
	}
	public static String getColnameGracostddiscountcode() {
		return COLNAME_GRACOSTDDISCOUNTCODE;
	}
	public static String getColnameGracostddiscount() {
		return COLNAME_GRACOSTDDISCOUNT;
	}
	public static String getColnameSuppliercode() {
		return COLNAME_SUPPLIERCODE;
	}

}
