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
	String action = request.getParameter("action");
	String error = "";
	if(action != null && action.equals("calculateItemPrice")) {
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
		String redirectURL = "items_query_result.jsp?partnum1="+partNum1+"&qty1="+qty1;
		response.sendRedirect(redirectURL);
	}	
%>
<form action="index.jsp" method="post" accept-charset=utf-8>
<input type="hidden" name="action" value="calculateItemPrice">
<table class="formtable">
	<tr>
		<td>Part Number
		</td>
		<td>Qty
		</td>
	</tr>
	<tr>
		<td><input type="text" name="partnum1" />
		</td>
		<td><input type="text" name="qty1" />
		</td>
	</tr>
	<tr>
		<td><input type="text" name="partnum2" />
		</td>
		<td><input type="text" name="qty2" />
		</td>
	</tr>
	<tr>
		<td><input type="text" name="partnum3" />
		</td>
		<td><input type="text" name="qty3" />
		</td>
	</tr>
	<tr>
		<td><input type="text" name="partnum4" />
		</td>
		<td><input type="text" name="qty4" />
		</td>
	</tr>
	<tr>
		<td><input type="text" name="partnum5" />
		</td>
		<td><input type="text" name="qty5" />
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="Calculate" />
		</td>
		<td>&nbsp;
		</td>
	</tr>
</table>
</form>
<br />
<footer>
FOOTER
</footer>
</body>
</html>