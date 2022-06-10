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
		try {		
			String sql = "SELECT * FROM " + LoginModel.TABLENAME + " WHERE " + LoginModel.COLNAME_NAME + " = '" +
					username + "' AND " + LoginModel.COLNAME_PASSWORD + " = '" + password + "'";
			Statement st= conn.createStatement();
	
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
		}
		catch (Exception ex) {
			throw ex;
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
					LoginModel.CONST_ACC_TYPE_NORMAL + "', '" +
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
	
	public static void update(String username, String password, Connection conn) throws Exception {

		try {
			// TODO: Need to insert transaction lock
			// Check if user exists
			if (!isUserExist(username, conn)) {
				throw new Exception("This user is does not exist.");
			}
			// Create user
			String sql = "UPDATE " + LoginModel.TABLENAME + " SET " + 
					LoginModel.COLNAME_PASSWORD + " = '" + password + "', " +
					LoginModel.COLNAME_DATE_CREATED + " = '" + TimestampGenerator.getTimestamp() + "', " +
					LoginModel.COLNAME_DATE_UPDATED + " = '" + TimestampGenerator.getTimestamp() + 
					"' WHERE " + LoginModel.COLNAME_NAME + " = '" + username + "';";

			Statement st = conn.createStatement();
			st.executeUpdate(sql);
					
		}
		catch (Exception ex) {
			throw ex;
		}
		
	}
	
	public static void delete(String id, Connection conn) throws Exception {

		try {
			// TODO: Need to insert transaction lock
			// Create user
			String sql = "DELETE FROM " + LoginModel.TABLENAME +
					" WHERE " + LoginModel.COLNAME_ID + " = '" + id + "';";

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

	public static ArrayList<LoginModel> getAllObjects(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM " + LoginModel.TABLENAME + " ORDER BY " + LoginModel.COLNAME_NAME + ";";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ArrayList<LoginModel> result = new ArrayList<LoginModel>();
		LoginModel lgnObj = null;
		while(rs.next()) {
			lgnObj = new LoginModel();
			lgnObj.setId(new Integer(rs.getInt(LoginModel.COLNAME_ID)));
			lgnObj.setName(rs.getString(LoginModel.COLNAME_NAME));
			lgnObj.setPassword(rs.getString(LoginModel.COLNAME_PASSWORD));
			lgnObj.setAccType(rs.getString(LoginModel.COLNAME_ACC_TYPE));
			lgnObj.setDateCreated(rs.getTimestamp(LoginModel.COLNAME_DATE_CREATED));
			lgnObj.setDateUpdated(rs.getTimestamp(LoginModel.COLNAME_DATE_UPDATED));
			result.add(lgnObj);
		}	
		return result;
	}
	
}
