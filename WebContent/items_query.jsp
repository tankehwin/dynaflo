<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="includes/header.jsp" %> 
<body>  
<%
	Connection conn = (Connection) session.getAttribute("conn");	
	String action = request.getParameter("action");
	String error = "";
	String importResults = "";
	int colspan = 20;
	if(action != null && action.equals("searchPart")) {
		String partNum1 = request.getParameter("partnum");	

		
		
		ItemModel itmObj1 = new ItemModel();
		boolean ifIracExists = false;
		if(!partNum1.trim().equals("")){		
			itmObj1 = ItemManager.getObject(partNum1, conn);
			if(itmObj1.getPartNumber().startsWith("IAV")){
				ifIracExists = true;
			}
		}
	}
	else if(action != null && action.equals("importData")) {
		Properties prop = new Properties();
		ServletContext servletContext = session.getServletContext();
		prop.load(new FileInputStream(servletContext.getRealPath("/global.properties")));	

		String tomcatLocation = prop.getProperty("tomcatLocation");
	   
	   	String filePath = tomcatLocation + "webapps/data/import.xls";
		if(!filePath.trim().equals("")){
			ExcelReader excelBook = new ExcelReader();
			int importCount = excelBook.ingestExcelFile(filePath, conn);
			if(importCount>0){
				importResults = new Integer(importCount).toString() + " items were imported.";
			}
		}	
	}
	
%>
<form action="items_query.jsp" method="post" accept-charset="utf-8">
<input type="hidden" name="action" value="searchPart">
<table class="gridtable">
	<tr>
		<th>Search Parts
		</th>
	</tr>
	<tr>
		<th>Part Number
		</th>

	</tr>
	<tr>
		<td><input type="text" class="partNumber" name="partnum" />
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="Search" />
		</td>
		<td>&nbsp;
		</td>
	</tr>
</table>
</form>


<table class="gridtable">
	<tr>
		<th colspan="<%=colspan%>">Search Results
		</th>
	</tr>
	<tr>
		<th rowspan="2">PART NO.
		</th>
		<th rowspan="2">QTY
		</th>
		<th rowspan="2">DESCRIPTION
		</th>
		<th rowspan="2">ADDITIONAL <br/>INFORMATION 1
		</th>
		<th rowspan="2">ADDITIONAL <br/>INFORMATION 2
		</th>
		<th rowspan="2">ADDITIONAL <br/>INFORMATION 3
		</th>
		<th rowspan="2">ITEM REF.
		</th>
		<th colspan="4">GRACO 
		</th>
		<th rowspan="2">DUTIES (%)
		</th>
		<th rowspan="2">SELLING PRICE
		</th>
		<th rowspan="2">TOTAL PRICE
		</th>
		<th rowspan="2">DYN <br/>DISC. CODE
		</th>
		<th rowspan="2">LEAD TIME <br/>(DAYS)
		</th>
		<th rowspan="2">OLD PART NUMBER
		</th>
		<th rowspan="2">LATEST DATE PURCHASED
		</th>
		<th rowspan="2">LATEST SUPPLIER
		</th>
		<th rowspan="2">SUPPLIER <br/>PART NO.
		</th>
	</tr>
	<tr>
		<th>FAMILY TYPE
		</th>
		<th>FAMILY DISC. (%)
		</th>
		<th>STD DISC. CODE
		</th>
		<th>STD DISC. (%)
		</th>
	</tr>
<%
	if(!itmObj1.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj1.getPartNumber() %>
		</td>
		<td align="center"><%=iQty1 %>
		</td>
		<td><%=itmObj1.getDescription() %>
		</td>
		<td><%=itmObj1.getAddInfo1() %>
		</td>
		<td><%=itmObj1.getAddInfo2() %>
		</td>
		<td><%=itmObj1.getAddInfo3() %>
		</td>
		<td align="center"><%=itmObj1.getEquipmentPackageReference()+itmObj1.getItemReference() %>
		</td>
		<td align="center"><%=itmObj1.getGracoFamType() %>
		</td>
		<td align="center"><%=NumberFormatter.getRoundedDiscount(itmObj1.getGracoFamDiscount()) %>
		</td>
		<td align="center"><%=itmObj1.getGracoStdDiscountCode() %>
		</td>
		<td align="center"><%=NumberFormatter.getRoundedDiscount(itmObj1.getGracoStdDiscount()) %>
		</td>
		<td align="center"><%=itmObj1.getDuties() %>
		</td>	
		<td align="right"><%=itmObj1.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj1.getSellingPrice().multiply(new BigDecimal(iQty1)) %>
		</td>
		<td align="center"><%=itmObj1.getDynafloDiscountCode() %>
		</td>
		<td align="center"><%=(itmObj1.getLeadTimeARO().intValue()==0)?"":itmObj1.getLeadTimeARO()  %>
		</td>
		<td align="center"><%=itmObj1.getOldPartNumber() %>
		</td>
		<td align="center"><%=TimestampGenerator.getTruncatedDate(itmObj1.getLatestDatePurchased()) %>
		</td>
		<td align="center"><%=itmObj1.getSupplier() %>
		</td>
		<td align="center"><%=itmObj1.getSupplierCode() %>
		</td>
	</tr>
<%
	}
%>
</table>

<%
	if(userLogin!=null && userLogin.getAccType().equals(LoginModel.CONST_ACC_TYPE_ADMIN)){
%>
<br />

<form action="file_upload.jsp" method="post" accept-charset="utf-8" enctype="multipart/form-data">
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
<%
	} // if(userLogin.getAccType().equals(LoginModel.CONST_ACC_TYPE_ADMIN)){
%>
</body>
<%@include file="includes/footer.jsp" %>   
</html>