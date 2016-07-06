package utils;

import java.sql.*;

public class DBConn {
	
	public static Connection getConn(String conn, String usr, String pwd) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(conn, usr, pwd);
		return con;
	}
}
