<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="includes/header.jsp" %> 
<body oncontextmenu="return false;"><!-- stop right-click action -->

<script language=JavaScript>
// highlight results table row when clicked with jquery

$(document).ready(function(){
    $("#results tr").click(function(){
    	var selected = $(this).hasClass("highlight");
        $("#results tr").removeClass("highlight");
        if(!selected){
        	$(this).addClass("highlight");
        }
    }); 
});
</script>

<%
	Connection conn = (Connection) session.getAttribute("conn");	
	String action = request.getParameter("action");
	String error = "";
	String importResults = "";
	String partNum = "";
	String brand = "";
	BrandModel pricingVariableObj = null;
	int colspan = 16;
	boolean ifIracExists = false;
	ArrayList<ItemModel> result = new ArrayList<ItemModel>();
	if(action != null && action.equals("searchPart")) {
		partNum = request.getParameter("partnum");	

		
		brand = request.getParameter("brand");	
		pricingVariableObj = BrandManager.getObject(brand, conn);
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
			try{
				int importCount = excelBook.ingestExcelFile(filePath, conn);
				if(importCount>0){
					importResults = new Integer(importCount).toString() + " items were imported.";
				}
			}
			catch(Exception ex){
				importResults = ex.getMessage();
			}			
		}	
	}
	
%>
<form action="items_query.jsp" method="post" accept-charset="utf-8">
<input type="hidden" name="action" value="searchPart">
<table class="gridtable" style="display:inline-block;table-layout:fixed;width:500px;">
	<col style="overflow:hidden;width:100px;" id="colSearchTitle"/>
	<col style="overflow:hidden;width:250px;" id="colSearchValue"/>
	<tr>
		<th colspan="2"><div class="criteria">SEARCH PARTS</div>
		</th>
	</tr>
	<tr>
		<th><div class="criteria">BRAND:</div>
		</th>
		<td><div class="criteria">
			<select style="width:165px;" name="brand">
<%
	ArrayList<BrandModel> brands = BrandManager.getAllObjects(conn);
	// trying out new style of for loop
	for(BrandModel brandObj : brands){
%>
				<option value="<%=brandObj.getName() %>" <%=(brand.trim().equals(brandObj.getName()))?"selected":"" %>><%=brandObj.getName() %></option>
<%
	}
%>
			</select></div>
		</td>
	</tr>
	<tr>
		<th><div class="criteria">PART NO.:</div>
		</th>
		<td><div class="criteria"><input type="text" class="partNumber" name="partnum" value="<%=partNum %>" /><input type="submit" value="Search" /></div>
		</td>
	</tr>
</table>
<table class="gridtable" style="display:inline-block;table-layout:fixed;width:500px;">
	<col style="overflow:hidden;width:120px;" id="colDoubleTitle"/>
	<col style="overflow:hidden;width:130px;" id="colDoubleValue"/>
	<col style="overflow:hidden;width:100px;" id="colFreightTitle"/>
	<col style="overflow:hidden;width:50px;" id="colFreightValue"/>
	<tr>
		<th colspan="4"><div class="criteria">PRICING VARIABLES</div>
		</th>
	</tr>
	<tr>
		<th><div class="criteria">EXCHANGE RATE:</div>
		</th>
		<td><div align="center" class="criteria"><%=(pricingVariableObj!=null)?pricingVariableObj.getExchangeRate():"" %></div>
		</td>
		<th rowspan="2"><div class="criteria">FREIGHT:</div>
		</th>
		<td rowspan="2"><div align="center" class="criteria"><%=(pricingVariableObj!=null)?pricingVariableObj.getFreightCharges():"" %></div>
		</td>
	</tr>
	<tr>
		<th><div class="criteria">EXR DATE:</div>
		</th>
		<td><div align="center" class="criteria"><%=(pricingVariableObj!=null)?pricingVariableObj.getExpiryDate():"" %></div>
		</td>
	</tr>
</table>
</form>
<br />

<table id="results" class="gridtable" style="table-layout:fixed;width:2265px;">
	<col style="overflow:hidden;width:170px;" id="colPartNo"/>
	<col style="overflow:hidden;width:375px;" id="colDesc"/>
	<col style="overflow:hidden;width:200px;" id="colAddInfo1"/>
	<col style="overflow:hidden;width:200px;" id="colAddInfo2"/>
	<col style="overflow:hidden;width:200px;" id="colAddInfo3"/>
	<col style="overflow:hidden;width:100px;" id="colSellPrice"/>
	<col style="overflow:hidden;width:50px;" id="colDynDisCode"/>
	<col style="overflow:hidden;width:55px;" id="colDuties"/>
	<col style="overflow:hidden;width:55px;" id="colGraFamType"/>
	<col style="overflow:hidden;width:55px;" id="colGraFamDis"/>
	<col style="overflow:hidden;width:55px;" id="colGraStdDis"/>
	<col style="overflow:hidden;width:50px;" id="colLeadARO"/>
	<col style="overflow:hidden;width:170px;" id="colOldPartNo"/>
	<col style="overflow:hidden;width:100px;" id="colLastDatePurc"/>
	<col style="overflow:hidden;width:200px;" id="colLastSupp"/>
	<col style="overflow:hidden;width:200px;" id="colSuppPartNo"/>
	<tr>
		<th colspan="<%=colspan%>">SEARCH RESULTS
		</th>
	</tr>
	<tr>
		<th rowspan="2" >PART NO.
		</th>
		<th rowspan="2" >DESCRIPTION
		</th>
		<th rowspan="2" >ADD. INFORMATION 1
		</th>
		<th rowspan="2" >ADD. INFORMATION 2
		</th>
		<th rowspan="2" >ADD. INFORMATION 3
		</th>		
		<th rowspan="2" >SELLING PRICE<br/>(RM)
		</th>
		<th rowspan="2" >DYN <br/>DISC. <br/>CODE
		</th>
		<th rowspan="2" >DUTIES 
		</th>
		<th colspan="3" >GRACO 
		</th>
		<th rowspan="2" >LEAD <br/>TIME <br/>(DAYS)
		</th>
		<th rowspan="2" >OLD PART <br/>NO.
		</th>
		<th rowspan="2" >LATEST DATE <br/>QUOTED/<br/>PURCHASED
		</th>
		<th rowspan="2" >LATEST SUPPLIER
		</th>
		<th rowspan="2" >SUPPLIER <br/>PART NO.
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
		<td style="overflow:hidden;width:200px;"><%=itmObj.getPartNumber() %>
		</td>
		<td style="overflow:hidden;width:200px;"><%=itmObj.getDescription() %>
		</td>
		<td style="overflow:hidden;width:200px;"><%=itmObj.getAddInfo1() %>
		</td>
		<td style="overflow:hidden;width:200px;"><%=itmObj.getAddInfo2() %>
		</td>
		<td style="overflow:hidden;width:200px;"><%=itmObj.getAddInfo3() %>
		</td>
		<td align="right" style="background-color: #ffff99;overflow:hidden;width:200px;"><%=itmObj.getSellingPrice() %>
		</td>
		<td align="center" style="overflow:hidden;width:200px;"><%=itmObj.getDynafloDiscountCode() %>
		</td>
		<td align="center" style="overflow:hidden;width:100px;"><%=itmObj.getDuties().toString()+"%" %>
		</td>	
		<td align="center" style="overflow:hidden;width:200px;"><%=itmObj.getGracoFamType() %>
		</td>
		<td align="center" style="overflow:hidden;width:200px;"><%=(itmObj.getGracoFamDiscount().longValue()==0)?"":itmObj.getGracoFamDiscount()+"%" %>
		</td>
		<td align="center" style="overflow:hidden;width:200px;"><%=(itmObj.getGracoStdDiscount().longValue()==0)?"":itmObj.getGracoStdDiscount()+"%" %>
		</td>	
		<td align="center" style="overflow:hidden;width:200px;"><%=(itmObj.getLeadTimeARO().intValue()==0)?"":((itmObj.getLeadTimeARO().intValue()==-1)?"N/A":itmObj.getLeadTimeARO())  %>
		</td>
		<td align="center" style="overflow:hidden;width:200px;"><%=itmObj.getOldPartNumber() %>
		</td>
		<td align="center" style="overflow:hidden;width:200px;"><%=TimestampGenerator.getTruncatedDate(itmObj.getLatestDatePurchased()) %>
		</td>
		<td align="center" style="overflow:hidden;width:200px;"><%=itmObj.getSupplier() %>
		</td>
		<td align="center" style="overflow:hidden;width:200px;"><%=itmObj.getSupplierCode() %>
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