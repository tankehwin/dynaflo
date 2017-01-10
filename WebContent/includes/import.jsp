<%@ page import="utils.*"%>
<%@ page import="data.*"%>
<%@ page import="model.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.math.*"%>
<%@ page import="java.text.*"%>
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
		if(session.getAttribute("conn") == null){

			DBConn connObj = new DBConn();
			conn = DBConn.getConn(dbConnString, dbUser, dbPassword);
			session.setAttribute("conn", conn);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} 
%>