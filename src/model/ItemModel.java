package model;

import java.sql.Timestamp;

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
