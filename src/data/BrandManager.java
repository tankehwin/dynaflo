package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.BrandModel;
import model.BrandModel;
import model.LoginModel;

import utils.TimestampGenerator;

public class BrandManager {

	public static void insertObject(BrandModel value, Connection conn) throws Exception {
		String sql = "INSERT INTO " + BrandModel.TABLENAME + "(" + 
				BrandModel.COLNAME_NAME + ", " +
				BrandModel.COLNAME_FREIGHT_CHARGES + ", " +
				BrandModel.COLNAME_EXPIRY_DATE + ", " +
				BrandModel.COLNAME_EXCHANGE_RATE + ", " +
				BrandModel.COLNAME_DATE_CREATED + ", " +
				BrandModel.COLNAME_DATE_UPDATED + 
				")" +
				" VALUES ('" +
				value.getName().trim() + "', '', '', '', '" +
				TimestampGenerator.getTimestamp() + "', '" +
				TimestampGenerator.getTimestamp() +
				"');";
		Statement st = conn.createStatement();
//		System.out.println(sql);
		st.executeUpdate(sql);

	}
	
	public static void clearTable(Connection conn) throws Exception {
		String sql = "DELETE FROM " + BrandModel.TABLENAME + ";";
		Statement st = conn.createStatement();
		// System.out.println(sql);
		st.executeUpdate(sql);
	}
	
public static ArrayList<BrandModel> getAllObjects(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM " + BrandModel.TABLENAME + " ORDER BY " + BrandModel.COLNAME_NAME + ";";
		Statement st = conn.createStatement();
//		System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		ArrayList<BrandModel> result = new ArrayList<BrandModel>();
		BrandModel brandObj = null;
		while(rs.next()) {
			brandObj = new BrandModel();
			brandObj.setName(rs.getString(BrandModel.COLNAME_NAME));
			brandObj.setExchangeRate(rs.getString(BrandModel.COLNAME_EXCHANGE_RATE));
			brandObj.setExpiryDate(rs.getString(BrandModel.COLNAME_EXPIRY_DATE));
			brandObj.setFreightCharges(rs.getString(BrandModel.COLNAME_FREIGHT_CHARGES));
			brandObj.setId(new Integer(rs.getInt(BrandModel.COLNAME_ID)));
			brandObj.setDateCreated(rs.getTimestamp(LoginModel.COLNAME_DATE_CREATED));
			brandObj.setDateUpdated(rs.getTimestamp(LoginModel.COLNAME_DATE_UPDATED));
			result.add(brandObj);
		}	
		return result;
	}
	
	public static BrandModel getObject(String name, Connection conn) throws Exception {
		BrandModel brandObj = null;
		try {		
			String sql = "SELECT * FROM " + BrandModel.TABLENAME + " WHERE " + BrandModel.COLNAME_NAME + " = '" +
					name + "'";
			Statement st = conn.createStatement();
			// System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				brandObj = new BrandModel();
				brandObj.setId(new Integer(rs.getInt(BrandModel.COLNAME_ID)));
				brandObj.setName(rs.getString(BrandModel.COLNAME_NAME));
				brandObj.setFreightCharges(rs.getString(BrandModel.COLNAME_FREIGHT_CHARGES));
				brandObj.setExpiryDate(rs.getString(BrandModel.COLNAME_EXPIRY_DATE));
				brandObj.setExchangeRate(rs.getString(BrandModel.COLNAME_EXCHANGE_RATE));
				brandObj.setDateCreated(rs.getTimestamp(BrandModel.COLNAME_DATE_CREATED));
				brandObj.setDateUpdated(rs.getTimestamp(BrandModel.COLNAME_DATE_UPDATED));
			}	
		}
		catch (Exception ex) {
			throw ex;
		}
		return brandObj;
	}
	
	public static void updateBrandsList(ArrayList<String> brands, Connection conn) throws Exception {
		ArrayList<BrandModel> compare = getAllObjects(conn);
		ArrayList<String> leftover = new ArrayList<String>();
		for(String brand : brands){
			boolean found = false;
			for(BrandModel brandObj : compare){
				if(brand.equals(brandObj.getName())){
					found = true;
					break;
				}
			}
			if(!found){
				leftover.add(brand);
			}
		}
		for(String name : leftover){
			BrandModel insertObj = new BrandModel();
			insertObj.setName(name);
			insertObject(insertObj, conn);
		}
	}
		
	public static void updateObject(String name, String exchangeRate, String expiryDate, String freightCharges, Connection conn) throws Exception {
		String sql = "UPDATE " + BrandModel.TABLENAME + " SET " +
				BrandModel.COLNAME_EXCHANGE_RATE + " = '" + exchangeRate + "', " +
				BrandModel.COLNAME_EXPIRY_DATE + " = '" + expiryDate + "', " +
				BrandModel.COLNAME_FREIGHT_CHARGES + " = '" + freightCharges + "' " +
				"WHERE " + BrandModel.COLNAME_NAME + " = '" + name + "';";
		Statement st = conn.createStatement();
//		System.out.println(sql);
		st.executeUpdate(sql);
	}
}
