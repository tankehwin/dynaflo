<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="includes/header.jsp" %> 
<body>  
<%
	Connection conn = (Connection) session.getAttribute("conn");	
	String action = request.getParameter("action");
	String error = "";
	String importResults = "";
	int colspan = 17;
	boolean ifIracExists = false;
	ArrayList<ItemModel> result = new ArrayList<ItemModel>();
	if(action != null && action.equals("searchPart")) {
		String partNum = request.getParameter("partnum");	

		
		String brand = request.getParameter("brand");	
		if(!partNum.trim().equals("")){		
			result = ItemManager.getObject(partNum.toUpperCase(), brand, conn);
		
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
		<th>Brand
		</th>

	</tr>
	<tr>
		<td>
			<select class="partNumber" name="brand">
<%
	ArrayList<BrandModel> brands = BrandManager.getAllObjects(conn);
	// trying out new style of for loop
	for(BrandModel brandObj : brands){
%>
				<option value="<%=brandObj.getName() %>"><%=brandObj.getName() %></option>
<%
	}
%>
			</select>
		</td>
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
	</tr>
</table>
</form>
<br />

<table class="gridtable">
	<tr>
		<th colspan="<%=colspan%>">Search Results
		</th>
	</tr>
	<tr>
		<th rowspan="2">PART NO.
		</th>
		<th rowspan="2">DESCRIPTION
		</th>
		<th rowspan="2">ADD. INFORMATION 1
		</th>
		<th rowspan="2">ADD. INFORMATION 2
		</th>
		<th rowspan="2">ADD. INFORMATION 3
		</th>
		<th rowspan="2">ITEM REF.
		</th>		
		<th rowspan="2">SELLING PRICE<br/>(RM)
		</th>
		<th rowspan="2">DYN <br/>DISC. <br/>CODE
		</th>
		<th rowspan="2">DUTIES (%)
		</th>
		<th colspan="3">GRACO 
		</th>
		<th rowspan="2">LEAD <br/>TIME <br/>(DAYS)
		</th>
		<th rowspan="2">OLD PART <br/>NUMBER
		</th>
		<th rowspan="2">LATEST DATE <br/>PURCHASED
		</th>
		<th rowspan="2">LATEST SUPPLIER
		</th>
		<th rowspan="2">SUPPLIER <br/>PART NO.
		</th>
	</tr>
	<tr>
		<th>FAMILY <br/>TYPE
		</th>
		<th>FAMILY <br/>DISC.
		</th>
		<th>STD DISC.
		</th>
	</tr>
<%
	for(int i=0; i<result.size(); i++){
		ItemModel itmObj = result.get(i);
		if(itmObj.getPartNumber().startsWith("IAV")){
			ifIracExists = true;
		}
%>
	<tr>
		<td><%=itmObj.getPartNumber() %>
		</td>
		<td><%=itmObj.getDescription() %>
		</td>
		<td><%=itmObj.getAddInfo1() %>
		</td>
		<td><%=itmObj.getAddInfo2() %>
		</td>
		<td><%=itmObj.getAddInfo3() %>
		</td>
		<td align="center"><%=itmObj.getItemReference() %>
		</td>
		<td align="right" style="background-color: #ffff99;"><%=itmObj.getSellingPrice() %>
		</td>
		<td align="center"><%=itmObj.getDynafloDiscountCode() %>
		</td>
		<td align="center"><%=itmObj.getDuties().toString()+"%" %>
		</td>	
		<td align="center"><%=itmObj.getGracoFamType() %>
		</td>
		<td align="center"><%=(itmObj.getGracoFamDiscount().longValue()==0)?"":itmObj.getGracoFamDiscount()+"%" %>
		</td>
		<td align="center"><%=(itmObj.getGracoStdDiscount().longValue()==0)?"":itmObj.getGracoStdDiscount()+"%" %>
		</td>	
		<td align="center"><%=(itmObj.getLeadTimeARO().intValue()==0)?"":itmObj.getLeadTimeARO()  %>
		</td>
		<td align="center"><%=itmObj.getOldPartNumber() %>
		</td>
		<td align="center"><%=TimestampGenerator.getTruncatedDate(itmObj.getLatestDatePurchased()) %>
		</td>
		<td align="center"><%=itmObj.getSupplier() %>
		</td>
		<td align="center"><%=itmObj.getSupplierCode() %>
		</td>
	</tr>
<%		
	}
%>
</table>

<%
	if(ifIracExists){
%>
<br/>
<table class="gridtable">
<tr>
<td>
<div>
NOTE : <br/>
- Eex models are equipped with electrical installation for potentially explosive atmospheres Group II, category 2G - suitable for Zone 1 <br/>
- Eex-d models are supplied with exploision proof electric system for fire and explosion dangerous areas Class 1 div 1 - suitable for Zone 1 <br/>
- ADT models are equipped with electrical installation for potentially explosive atmospheres Group II, Category 3G - suitable for Zone 2 <br/>
- All models come with SST (304) tanks <br/>
- All models come with diathermic oil  except AV150 XE & AV200 XE <br/>
- All models come with 1 x CLIPSAC bag clip and 3 x IRSAC thermoproof bags <br/>
- Thermoproof disposal bags are manufactured to withstand temperatures up to 200°C <br/>
</div>
</td>
</tr>
</table>
<%
	}
%>

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