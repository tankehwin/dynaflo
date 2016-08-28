<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="includes/import.jsp" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dynaflow</title>
</head>
<body>
<header>
HEADER
</header>
<%
	Connection conn = (Connection) session.getAttribute("conn");	
	String partNum1 = request.getParameter("partnum1");	
	String qty1 = request.getParameter("qty1");	
	String partNum2 = request.getParameter("partnum2");	
	String qty2 = request.getParameter("qty2");	
	String partNum3 = request.getParameter("partnum3");	
	String qty3 = request.getParameter("qty3");	
	String partNum4 = request.getParameter("partnum4");	
	String qty4 = request.getParameter("qty4");	
	String partNum5 = request.getParameter("partnum5");	
	String qty5 = request.getParameter("qty5");	
	
	String sql = "SELECT * FROM items_master WHERE part_id = '" +
			partNum1 + "'";
	Statement st= conn.createStatement();
	System.out.println(sql);
	ResultSet rs = st.executeQuery(sql);
	Double price1 = null;
	Double duty1 = null;
	Double discount1 = null;
	/*
	while(rs.next()) {
		partNum1 = rs.getString("part_id");
		price1 = rs.getDouble("price");
		duty1 = rs.getDouble("duty");
		discount1 = rs.getDouble("discount");
	}
	*/
	ExcelReader excelBook = new ExcelReader();
	excelBook.ingestExcelFile("");
	
%>
<table class="formtable">
	<tr>
		<td>Part Number
		</td>
		<td>Qty
		</td>
		<td>Duty Percentage
		</td>
		<td>Discount
		</td>
		<td>Price
		</td>
	</tr>
	<tr>
		<td><%=partNum1 %>
		</td>
		<td><%=qty1 %>
		</td>
		<td><%=duty1 %>
		</td>
		<td><%=discount1 %>
		</td>
		<td><%=price1 %>
		</td>
	</tr>
</table>
<br />
<footer>
FOOTER
</footer>
</body>
</html>