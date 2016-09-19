<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="includes/import.jsp" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="jquery/css/ui-lightness/jquery-ui-1.10.4.custom.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="jquery/js/jquery-1.10.2.js"></script>
<script src="jquery/js/jquery-ui-1.10.4.custom.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dynaflo</title>
</head>
<body>
<header>
DYNAFLO PARTS SEARCH SYSTEM
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
		String partNum6 = request.getParameter("partnum6");	
		String qty6 = request.getParameter("qty6");	
		String partNum7 = request.getParameter("partnum7");	
		String qty7 = request.getParameter("qty7");	
		String partNum8 = request.getParameter("partnum8");	
		String qty8 = request.getParameter("qty8");	
		String partNum9 = request.getParameter("partnum9");	
		String qty9 = request.getParameter("qty9");	
		String partNum10 = request.getParameter("partnum10");	
		String qty10 = request.getParameter("qty10");	
		String redirectURL = "items_query_result.jsp?partnum1="+partNum1+"&qty1="+qty1
				+"&partnum2="+partNum2+"&qty2="+qty2
				+"&partnum3="+partNum3+"&qty3="+qty3
				+"&partnum4="+partNum4+"&qty4="+qty4
				+"&partnum5="+partNum5+"&qty5="+qty5
				+"&partnum6="+partNum6+"&qty6="+qty6
				+"&partnum7="+partNum7+"&qty7="+qty7
				+"&partnum8="+partNum8+"&qty8="+qty8
				+"&partnum9="+partNum9+"&qty9="+qty9
				+"&partnum10="+partNum10+"&qty10="+qty10;
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
<table class="formtable">
<tr>
<td>
<form action="index.jsp" method="post" accept-charset="utf-8">
<input type="hidden" name="action" value="calculateItemPrice">
<table class="gridtable">
	<tr>
		<th colspan="2">Search Parts
		</th>
	</tr>
	<tr>
		<th>Part Number
		</th>
		<th>Qty
		</th>
	</tr>
	<tr>
		<td><input type="text" class="partNumber" name="partnum1" />
		</td>
		<td><input type="text" class="qty" name="qty1" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
		</td>
	</tr>
	<tr>
		<td><input type="text" class="partNumber" name="partnum2" />
		</td>
		<td><input type="text" class="qty" name="qty2" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
		</td>
	</tr>
	<tr>
		<td><input type="text" class="partNumber" name="partnum3" />
		</td>
		<td><input type="text" class="qty" name="qty3" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
		</td>
	</tr>
	<tr>
		<td><input type="text" class="partNumber" name="partnum4" />
		</td>
		<td><input type="text" class="qty" name="qty4" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
		</td>
	</tr>
	<tr>
		<td><input type="text" class="partNumber" name="partnum5" />
		</td>
		<td><input type="text" class="qty" name="qty5" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
		</td>
	</tr>
	<tr>
		<td><input type="text" class="partNumber" name="partnum6" />
		</td>
		<td><input type="text" class="qty" name="qty6" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
		</td>
	</tr>
	<tr>
		<td><input type="text" class="partNumber" name="partnum7" />
		</td>
		<td><input type="text" class="qty" name="qty7" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
		</td>
	</tr>
	<tr>
		<td><input type="text" class="partNumber" name="partnum8" />
		</td>
		<td><input type="text" class="qty" name="qty8" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
		</td>
	</tr>
	<tr>
		<td><input type="text" class="partNumber" name="partnum9" />
		</td>
		<td><input type="text" class="qty" name="qty9" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
		</td>
	</tr>
	<tr>
		<td><input type="text" class="partNumber" name="partnum10" />
		</td>
		<td><input type="text" class="qty" name="qty10" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
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
<form action="index.jsp" method="post" accept-charset="utf-8" enctype="multipart/form-data">
<input type="hidden" name="action" value="importData">
<table class="gridtable">
	<tr>
		<td colspan="2">Import New Data File
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
<%
	if(!importResults.trim().equals("")){
%>
	<tr>
		<td colspan="2"><%=importResults %>
		</td>
	</tr>
<%
	}
%>
</table>
</form>
</td>	
</tr>	
</table>
<footer>
FOOTER
</footer>
</body>
</html>