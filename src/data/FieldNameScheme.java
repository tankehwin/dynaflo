package data;

import java.util.ArrayList;

public class FieldNameScheme {
	
	public static String FIELDNAME_PART_NUMBER = "PART NUMBER";
	public static String FIELDNAME_DESCRIPTION = "DESCRIPTION";
	public static String FIELDNAME_ADDITIONAL_INFORMATION_1 = "ADDITIONAL INFORMATION 1";
	public static String FIELDNAME_ADDITIONAL_INFORMATION_2 = "ADDITIONAL INFORMATION 2";
	public static String FIELDNAME_ADDITIONAL_INFORMATION_3 = "ADDITIONAL INFORMATION 3";
	public static String FIELDNAME_DUTIES = "DUTIES (%)";
	public static String FIELDNAME_SELLING_PRICE = "SELLING PRICE (RM)";
	public static String FIELDNAME_LEAD_TIME = "LEAD TIME (ARO)";
	public static String FIELDNAME_DYNAFLO_DISCOUNT_CODE = "DYNAFLO DISCOUNT CODE";
	public static String FIELDNAME_OLD_PART_NUMBER = "OLD PART NUMBER";
	public static String FIELDNAME_LATEST_DATE_PURCHASED = "LATEST DATE PURCHASED";
	public static String FIELDNAME_SUPPLIER = "SUPPLIER";
	public static String FIELDNAME_ITEM_REFE = "ITEM REFERENCE";
	public static String FIELDNAME_EQUIPMENT_PACKAGE_REF = "EQUIPMENT/PACKAGE REFERENCE";
	public static String FIELDNAME_GRACO_REF = "GRACO REFERENCE";
	public static String FIELDNAME_GRACO_FAMILY_TYPE = "GRACO FAMILY TYPE";
	public static String FIELDNAME_GRACO_FAMILY_DISCOUNT = "GRACO FAMILY DISCOUNT";
	public static String FIELDNAME_GRACO_STD_DISCOUNT_CODE = "GRACO STD. DISCOUNT CODE";
	public static String FIELDNAME_GRACO_STD_DISCOUNT = "GRACO STD. DISCOUNT";
	public static String FIELDNAME_SUPPLIER_CODE = "SUPPLIER  CODE";
	
	public ArrayList getColumns(String scheme) {
		if(scheme.toUpperCase().trim().equals("KAWASAKI")) {
			return getKawasakiFields();
		}
		else if(scheme.toUpperCase().trim().equals("LOCAL")) {
			return getLocalFields();
		}
		else {
			return null;
		}
	}
	
	public ArrayList getKawasakiFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_DUTIES);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_LEAD_TIME);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		return result;
	}
	
	public ArrayList getLocalFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_OLD_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);
		result.add(FIELDNAME_SUPPLIER);	
		return result;
	}
	
}
