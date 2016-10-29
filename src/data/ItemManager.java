package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.ItemModel;

public class ItemManager {

	public static void insertObject(ItemModel value, Connection conn) throws Exception {
		String sql = "INSERT INTO " + ItemModel.TABLENAME + "(" + 
				ItemModel.COLNAME_PARTNUMBER + ", " +
				ItemModel.COLNAME_DESCRIPTION + ", " +
				ItemModel.COLNAME_ADDITIONALINFORMATION1 + ", " +
				ItemModel.COLNAME_ADDITIONALINFORMATION2 + ", " +
				ItemModel.COLNAME_ADDITIONALINFORMATION3 + ", " +
				ItemModel.COLNAME_DUTIES + ", " +
				ItemModel.COLNAME_SELLINGPRICE + ", " +
				ItemModel.COLNAME_LEADTIMEARO + ", " +
				ItemModel.COLNAME_DYNAFLODISCOUNTCODE + ", " +
				ItemModel.COLNAME_OLDPARTNUMBER + ", " +
				ItemModel.COLNAME_LATESTDATEPURCHASED + ", " +
				ItemModel.COLNAME_SUPPLIER + ", " +
				ItemModel.COLNAME_ITEMREFERENCE + ", " +
				ItemModel.COLNAME_EQUIPMENTPACKAGEREFERENCE + ", " +
				ItemModel.COLNAME_GRACOREFERENCE + ", " +
				ItemModel.COLNAME_GRACOFAMILYTYPE + ", " +
				ItemModel.COLNAME_GRACOFAMILYDISCOUNT + ", " +
				ItemModel.COLNAME_GRACOSTDDISCOUNTCODE + ", " +
				ItemModel.COLNAME_GRACOSTDDISCOUNT + ", " +
				ItemModel.COLNAME_BRAND + ", " +
				ItemModel.COLNAME_SUPPLIERCODE + 
				")" +
				" VALUES ('" +
				value.getPartNumber().trim() + "', '" +
				value.getDescription().trim() + "', '" +
				value.getAddInfo1().trim() + "', '" +
				value.getAddInfo2().trim() + "', '" +
				value.getAddInfo3().trim() + "', " +
				value.getDuties().toString() + ", " +
				value.getSellingPrice().toString() + ", " +
				value.getLeadTimeARO().toString() + ", '" +
				value.getDynafloDiscountCode().trim() + "', '" +
				value.getOldPartNumber().trim() + "', '" +
				value.getLatestDatePurchased().toString() + "', '" +
				value.getSupplier().trim() + "', '" +
				value.getItemReference().trim() + "', '" +
				value.getEquipmentPackageReference().trim() + "', '" +
				value.getGracoReference().trim() + "', '" +
				value.getGracoFamType().trim() + "', " +
				value.getGracoFamDiscount().toString() + ", '" +
				value.getGracoStdDiscountCode().trim() + "', " +
				value.getGracoStdDiscount().toString() + ", '" +
				value.getBrand().toString() + "', '" +
				value.getSupplierCode().trim() + 
				"');";
		Statement st = conn.createStatement();
//		System.out.println(sql);
		st.executeUpdate(sql);

	}
	
	public static void clearTable(Connection conn) throws Exception {
		String sql = "DELETE FROM " + ItemModel.TABLENAME + ";";
		Statement st = conn.createStatement();
		// System.out.println(sql);
		st.executeUpdate(sql);
	}
	
	public static ItemModel getObject(String partNumber, Integer qty, Connection conn) throws Exception {
		return new ItemModel();
	}
	
	public static ItemModel getObject(String partNumber, Connection conn) throws Exception {
		
		String sql = "SELECT * FROM " + ItemModel.TABLENAME + " WHERE " + ItemModel.COLNAME_PARTNUMBER + " LIKE '" +
				partNumber + "%';";
		Statement st = conn.createStatement();
		// System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		ItemModel itemObj = new ItemModel();
		while(rs.next()) {
			itemObj.setAddInfo1(rs.getString(ItemModel.COLNAME_ADDITIONALINFORMATION1));
			itemObj.setAddInfo2(rs.getString(ItemModel.COLNAME_ADDITIONALINFORMATION2));
			itemObj.setAddInfo3(rs.getString(ItemModel.COLNAME_ADDITIONALINFORMATION3));
			itemObj.setDescription(rs.getString(ItemModel.COLNAME_DESCRIPTION));
			itemObj.setDuties(rs.getBigDecimal(ItemModel.COLNAME_DUTIES));
			itemObj.setDynafloDiscountCode(rs.getString(ItemModel.COLNAME_DYNAFLODISCOUNTCODE));
			itemObj.setEquipmentPackageReference(rs.getString(ItemModel.COLNAME_EQUIPMENTPACKAGEREFERENCE));
			itemObj.setGracoFamDiscount(rs.getBigDecimal(ItemModel.COLNAME_GRACOFAMILYDISCOUNT));
			itemObj.setGracoFamType(rs.getString(ItemModel.COLNAME_GRACOFAMILYTYPE));
			itemObj.setGracoReference(rs.getString(ItemModel.COLNAME_GRACOREFERENCE));
			itemObj.setGracoStdDiscount(rs.getBigDecimal(ItemModel.COLNAME_GRACOSTDDISCOUNT));
			itemObj.setGracoStdDiscountCode(rs.getString(ItemModel.COLNAME_GRACOSTDDISCOUNTCODE));
			itemObj.setItemReference(rs.getString(ItemModel.COLNAME_ITEMREFERENCE));
			itemObj.setLatestDatePurchased(rs.getTimestamp(ItemModel.COLNAME_LATESTDATEPURCHASED));
			itemObj.setLeadTimeARO(new Integer(rs.getInt(ItemModel.COLNAME_LEADTIMEARO)));
			itemObj.setOldPartNumber(rs.getString(ItemModel.COLNAME_OLDPARTNUMBER));
			itemObj.setPartNumber(rs.getString(ItemModel.COLNAME_PARTNUMBER));
			itemObj.setSellingPrice(rs.getBigDecimal(ItemModel.COLNAME_SELLINGPRICE));
			itemObj.setSupplier(rs.getString(ItemModel.COLNAME_SUPPLIER));
			itemObj.setSupplierCode(rs.getString(ItemModel.COLNAME_SUPPLIERCODE));
			itemObj.setBrand(rs.getString(ItemModel.COLNAME_BRAND));
		}	
		return itemObj;
	}
	
}
