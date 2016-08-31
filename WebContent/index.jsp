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
	String importResults = "";
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
		String redirectURL = "items_query_result.jsp?partnum1="+partNum1+"&qty1="+qty1
				+"partnum2="+partNum2+"&qty2="+qty2
				+"partnum3="+partNum3+"&qty3="+qty3
				+"partnum4="+partNum4+"&qty4="+qty4
				+"partnum5="+partNum5+"&qty5="+qty5;
		response.sendRedirect(redirectURL);
	}
	else if(action != null && action.equals("importData")) {
		String filePath = request.getParameter("filepath");	
		System.out.println("File path is: " + filePath);
		if(!filePath.trim().equals("")){
			ExcelReader excelBook = new ExcelReader();
			int importCount = excelBook.ingestExcelFile(filePath, conn);
			if(importCount>0){
				importResults = new Integer(importCount).toString() + " items were imported.";
			}
		}	
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
		<td><input type="text" name="qty1" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
		</td>
	</tr>
	<tr>
		<td><input type="text" name="partnum2" />
		</td>
		<td><input type="text" name="qty2" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
		</td>
	</tr>
	<tr>
		<td><input type="text" name="partnum3" />
		</td>
		<td><input type="text" name="qty3" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
		</td>
	</tr>
	<tr>
		<td><input type="text" name="partnum4" />
		</td>
		<td><input type="text" name="qty4" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
		</td>
	</tr>
	<tr>
		<td><input type="text" name="partnum5" />
		</td>
		<td><input type="text" name="qty5" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
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
<form action="index.jsp" method="post" accept-charset=utf-8>
<input type="hidden" name="action" value="importData">
<table class="formtable">
	<tr>
		<td>Import New Data File
		</td>
		<td>&nbsp;
		</td>
	</tr>
	<tr>
		<td>Select file to import: 
		</td>
		<td><input type='file' name="filepath"/>
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="Import" />
		</td>
		<td>&nbsp;
		</td>
	</tr>
	<tr>
		<td><%=importResults %>
		</td>
		<td>&nbsp;
		</td>
	</tr>
</table>
</form>
<footer>
FOOTER
</footer>
</body>
</html>