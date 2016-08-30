package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.ItemModel;
import utils.TableNames;
import utils.TimestampGenerator;

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
				value.getSupplierCode().trim() + 
				"');";
		Statement st= conn.createStatement();
		System.out.println(sql);
		st.executeUpdate(sql);

	}
	
	public static void clearTable(Connection conn) {
		
	}
	
	public static void getObjects(Connection conn) {
		/*
		String sql = "SELECT * FROM " + TableNames.userLoginTable + " WHERE " + UserLoginModel.COLNAME_NAME + " = '" +
				username + "' AND " + UserLoginModel.COLNAME_PASSWORD + " = '" + password + "'";
		Statement st= conn.createStatement();
		System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			userLogin = new UserLoginModel();
			userLogin.setId(new Integer(rs.getInt(UserLoginModel.COLNAME_ID)));
			userLogin.setName(rs.getString(UserLoginModel.COLNAME_NAME));
			userLogin.setPassword(rs.getString(UserLoginModel.COLNAME_PASSWORD));
			userLogin.setFkAcc(new Integer(rs.getInt(UserLoginModel.COLNAME_ACCFK)));
			userLogin.setDateCreated(rs.getTimestamp(UserLoginModel.COLNAME_DATECREATED));
			userLogin.setDateUpdated(rs.getTimestamp(UserLoginModel.COLNAME_DATEUPDATED));
		}	
		*/	
	}
	
}
