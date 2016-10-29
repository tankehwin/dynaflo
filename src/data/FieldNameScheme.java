package data;

import java.util.ArrayList;

public class FieldNameScheme {
	
	public static String FIELDNAME_PART_NUMBER = "PART NO.";
	public static String FIELDNAME_DESCRIPTION = "DESCRIPTION";
	public static String FIELDNAME_ADDITIONAL_INFORMATION_1 = "ADDITIONAL INFORMATION 1";
	public static String FIELDNAME_ADDITIONAL_INFORMATION_2 = "ADDITIONAL INFORMATION 2";
	public static String FIELDNAME_ADDITIONAL_INFORMATION_3 = "ADDITIONAL INFORMATION 3";
	public static String FIELDNAME_ITEM_REF = "ITEM REF.";
	public static String FIELDNAME_SELLING_PRICE = "SELLING PRICE (RM)";
	public static String FIELDNAME_DYNAFLO_DISCOUNT_CODE = "DYN DISC. CODE";
	public static String FIELDNAME_DUTIES = "DUTIES";
	public static String FIELDNAME_GRACO_FAMILY_TYPE = "FAMILY TYPE";
	public static String FIELDNAME_GRACO_FAMILY_DISCOUNT = "FAMILY DISC.";	
	public static String FIELDNAME_GRACO_STD_DISCOUNT = "STD DISC.";
	public static String FIELDNAME_LEAD_TIME = "LEAD TIME (DAYS)";
	public static String FIELDNAME_OLD_PART_NUMBER = "OLD PART NUMBER";
	public static String FIELDNAME_LATEST_DATE_PURCHASED = "LATEST DATE PURCHASED";
	public static String FIELDNAME_SUPPLIER = "SUPPLIER";
	public static String FIELDNAME_SUPPLIER_CODE = "SUPPLIER PART NO.";
		
	public ArrayList getColumns(String scheme) {
		if(scheme.toUpperCase().trim().equals("KAWASAKI")) {
			return getKawasakiFields();
		}
		else if(scheme.toUpperCase().trim().equals("LOCAL")) {
			return getLocalFields();
		}
		else if(scheme.toUpperCase().trim().equals("DS TECH")) {
			return getDSTechFields();
		}
		else if(scheme.toUpperCase().trim().equals("EUROTECH")) {
			return getEuroTechFields();
		}
		else if(scheme.toUpperCase().trim().equals("HOSCO")) {
			return getHoscoFields();
		}
		else if(scheme.toUpperCase().trim().equals("INOX")) {
			return getInoxFields();
		}
		else if(scheme.toUpperCase().trim().equals("ITW")) {
			return getITWFields();
		}
		else if(scheme.toUpperCase().trim().equals("IRAC")) {
			return getIracFields();
		}
		else if(scheme.toUpperCase().trim().equals("PHALBOK")) {
			return getPhalbokFields();
		}
		else if(scheme.toUpperCase().trim().equals("SCHUTZE")) {
			return getSchutzeFields();
		}
		else if(scheme.toUpperCase().trim().equals("TONSON")) {
			return getTonsonFields();
		}
		else if(scheme.toUpperCase().trim().equals("WALMEC")) {
			return getWalmecFields();
		}
		else if(scheme.toUpperCase().trim().equals("BANDO")) {
			return getBandoFields();
		}
		else if(scheme.toUpperCase().trim().equals("IPM")) {
			return getIPMFields();
		}
		else if(scheme.toUpperCase().trim().equals("BEDFORD")) {
			return getBedfordFields();
		}
		else if(scheme.toUpperCase().trim().equals("REXSON")) {
			return getRexsonFields();
		}
		else if(scheme.toUpperCase().trim().equals("KREMLIN")) {
			return getKremlinFields();
		}
		else if(scheme.toUpperCase().trim().equals("TITAN")) {
			return getTitanFields();
		}
		else if(scheme.toUpperCase().trim().equals("SAMES")) {
			return getSamesFields();
		}
		else if(scheme.toUpperCase().trim().equals("GRACO")) {
			return getGracoFields();
		}
		else if(scheme.toUpperCase().trim().equals("IWATA")) {
			return getIwataFields();
		}
		else if(scheme.toUpperCase().trim().equals("TAISHO")) {
			return getTaishoFields();
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
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getLocalFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getDSTechFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);		
		return result;
	}
	
	public ArrayList getEuroTechFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getHoscoFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);		
		return result;
	}
	
	public ArrayList getInoxFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getITWFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getIracFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getPhalbokFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);		
		return result;
	}
	
	public ArrayList getSchutzeFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);		
		return result;
	}
	
	public ArrayList getTonsonFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getWalmecFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getBandoFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getIPMFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getBedfordFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getRexsonFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getKremlinFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getTitanFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getSamesFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);		
		return result;
	}
	
	public ArrayList getGracoFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getIwataFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
	
	public ArrayList getTaishoFields() {
		ArrayList result = new ArrayList();
		result.add(FIELDNAME_PART_NUMBER);
		result.add(FIELDNAME_DESCRIPTION);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_1);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_2);
		result.add(FIELDNAME_ADDITIONAL_INFORMATION_3);
		result.add(FIELDNAME_ITEM_REF);
		result.add(FIELDNAME_SELLING_PRICE);
		result.add(FIELDNAME_DYNAFLO_DISCOUNT_CODE);	
		result.add(FIELDNAME_DUTIES);	
		result.add(FIELDNAME_GRACO_FAMILY_TYPE);	
		result.add(FIELDNAME_GRACO_FAMILY_DISCOUNT);	
		result.add(FIELDNAME_GRACO_STD_DISCOUNT);	
		result.add(FIELDNAME_LEAD_TIME);	
		result.add(FIELDNAME_OLD_PART_NUMBER);	
		result.add(FIELDNAME_LATEST_DATE_PURCHASED);	
		result.add(FIELDNAME_SUPPLIER);
		result.add(FIELDNAME_SUPPLIER_CODE);	
		return result;
	}
}
