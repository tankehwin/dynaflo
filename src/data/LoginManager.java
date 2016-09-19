package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.LoginModel;

import utils.TimestampGenerator;

public class LoginManager {

	public static LoginModel login(String username, String password, Connection conn) throws Exception {
		LoginModel userLogin = null;
		
		String sql = "SELECT * FROM " + LoginModel.TABLENAME + " WHERE " + LoginModel.COLNAME_NAME + " = '" +
				username + "' AND " + LoginModel.COLNAME_PASSWORD + " = '" + password + "'";
		Statement st= conn.createStatement();
		System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			userLogin = new LoginModel();
			userLogin.setId(new Integer(rs.getInt(LoginModel.COLNAME_ID)));
			userLogin.setName(rs.getString(LoginModel.COLNAME_NAME));
			userLogin.setPassword(rs.getString(LoginModel.COLNAME_PASSWORD));
			userLogin.setAccType(rs.getString(LoginModel.COLNAME_ACC_TYPE));
			userLogin.setDateCreated(rs.getTimestamp(LoginModel.COLNAME_DATE_CREATED));
			userLogin.setDateUpdated(rs.getTimestamp(LoginModel.COLNAME_DATE_UPDATED));
		}
		return userLogin;
	}
		
	public static void register(String username, String password, Connection conn) throws Exception {

		try {
			// TODO: Need to insert transaction lock
			// Check if user exists
			if (isUserExist(username, conn)) {
				throw new Exception("This user is already registered.");
			}
			// Create user
			String sql = "INSERT INTO " + LoginModel.TABLENAME + "(" + 
					LoginModel.COLNAME_NAME + ", " +
					LoginModel.COLNAME_PASSWORD + ", " +
					LoginModel.COLNAME_ACC_TYPE + ", " +
					LoginModel.COLNAME_DATE_CREATED + ", " +
					LoginModel.COLNAME_DATE_UPDATED + 
					")" +
					" VALUES ('" +
					username.trim() + "', '" +
					password.trim() + "', '" +
					"normal" + "', '" +
					TimestampGenerator.getTimestamp() + "', '" +
					TimestampGenerator.getTimestamp() + "', '" +
					TimestampGenerator.getTimestamp() + 
					"');";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
					
		}
		catch (Exception ex) {
			throw ex;
		}
		
	}
	
	public static boolean isUserExist(String username, Connection conn) throws Exception {
		// Checks if a username already exists within the database
		boolean result = false;
		
		String sql = "SELECT * FROM " + LoginModel.TABLENAME 
				+ " WHERE " + LoginModel.COLNAME_NAME + " = '" + username + "';";
		Statement st= conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			result = true;
		}
		return result;
	}
	
}
