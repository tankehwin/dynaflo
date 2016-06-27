package utils;

import java.sql.*;

public class DBConn {
	
	public static Connection getConn(String conn, String usr, String pwd) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lifeboat_test","root","root");
		return con;
	}
}
