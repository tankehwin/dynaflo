<%@ page import="utils.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%
	try {
		// load global.properties
		Properties prop = new Properties();
		ServletContext servletContext = session.getServletContext();
		prop.load(new FileInputStream(servletContext.getRealPath("/global.properties")));
		
		// create connection object
		String dbConnString = prop.getProperty("dbConnStr");
		String dbUser = prop.getProperty("dbUsr");
		String dbPassword = prop.getProperty("dbPwd");
		
		Connection conn;
		if(session.getAttribute("conn") == null) {

			DBConn connObj = new DBConn();
			conn = DBConn.getConn(dbConnString, dbUser, dbPassword);
			session.setAttribute("conn", conn);
		}
		
		
// 		// sample looping of properties file entries
// 		System.out.println("PROP SIZE: " + prop.size());
// 		for (String key : prop.stringPropertyNames()) {
// 			String value = prop.getProperty(key);
// 			System.out.println(key + " => " + value);
// 		}
	} catch (Exception e) {
		e.printStackTrace();
	} 
%>