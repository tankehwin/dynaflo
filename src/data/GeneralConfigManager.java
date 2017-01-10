package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.GeneralConfigModel;

public class GeneralConfigManager {

	public static GeneralConfigModel getConfig(String name, Connection conn) throws Exception {
		GeneralConfigModel generalConfig = null;
		try {		
			String sql = "SELECT * FROM " + GeneralConfigModel.TABLENAME + " WHERE " + GeneralConfigModel.COLNAME_NAME + " = '" +
					name + "'";
			Statement st= conn.createStatement();
	
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				generalConfig = new GeneralConfigModel();
				generalConfig.setId(new Integer(rs.getInt(GeneralConfigModel.COLNAME_ID)));
				generalConfig.setName(rs.getString(GeneralConfigModel.COLNAME_NAME));
				generalConfig.setContents(rs.getString(GeneralConfigModel.COLNAME_CONTENTS));
			}
		}
		catch (Exception ex) {
			throw ex;
		}
		return generalConfig;
	}
		
	public static void addConfig(String name, String contents, Connection conn) throws Exception {

		try {
			// TODO: Need to insert transaction lock
			String sql = "INSERT INTO " + GeneralConfigModel.TABLENAME + "(" + 
					GeneralConfigModel.COLNAME_NAME + ", " +
					GeneralConfigModel.COLNAME_CONTENTS + 
					")" +
					" VALUES ('" +
					name.trim() + "', '" +
					contents.trim() + 
					"');";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
					
		}
		catch (Exception ex) {
			throw ex;
		}
		
	}
	
	public static void updateConfig(String name, String contents, Connection conn) throws Exception {

		try {
			// TODO: Need to insert transaction lock
			String sql = "UPDATE " + GeneralConfigModel.TABLENAME + " SET " + 
					GeneralConfigModel.COLNAME_CONTENTS + " = '" + contents + 
					"' WHERE " + GeneralConfigModel.COLNAME_NAME + " = '" + name + "';";

			Statement st = conn.createStatement();
			st.executeUpdate(sql);
					
		}
		catch (Exception ex) {
			throw ex;
		}
		
	}
	
}
