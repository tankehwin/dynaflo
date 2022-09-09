<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="includes/header.jsp" %> 
<body>   
<%
	Connection conn = (Connection) session.getAttribute("conn");
	String action = request.getParameter("action");
	String error = "";
	String brand = "";
	
	brand = (request.getParameter("brand")!=null)?request.getParameter("brand"):"";
	BrandModel brandObj = new BrandModel();
	if(action != null && action.equals("selectBrand")) {
		brandObj = BrandManager.getObject(brand, conn);
	}
	if(action != null && action.equals("editBrand")) {
		try {
			String expiryDate = request.getParameter("expiryDate");
			String exchangeRate = request.getParameter("exchangeRate");
			String freightCharges = request.getParameter("freightCharges");
			String priceDate = request.getParameter("priceDate");
			String news = request.getParameter("news");
			BrandManager.updateObject(brand, exchangeRate, expiryDate, freightCharges, priceDate, news, conn);
			String success = "Update successful for " + brand;
%>
<script>
	$(function() {
		$( "#dialog-message" ).dialog({
			modal: true,
			buttons: {
				OK: function() {
					$( this ).dialog( "close" );
					window.location.replace("items_query.jsp");
					
				}
			}
		});
	});
</script>

<div id="dialog-message" title="Update Successful">
	<p>
		<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
		<%=success %>
	</p>
</div>
<%
		}
		catch (Exception ex) {
			error = ex.getMessage();
		}	
	} // end if
%>
<form action="brands.jsp" method="post" accept-charset="utf-8">
<input type="hidden" name="action" value="selectBrand">
<table class="gridtable">
	<tr>
		<th>Brand
		</th>
		<td>
			<select class="partNumber" name="brand">
<%
	ArrayList<BrandModel> brands = BrandManager.getAllObjects(conn);
	// trying out new style of for loop
	for(BrandModel brandList : brands){
%>
				<option value="<%=brandList.getName() %>" <%=(brand.trim().equals(brandList.getName()))?"selected":"" %>><%=brandList.getName() %></option>
<%
	}
%>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Select"/>
		</td>
	</tr>
</table>
</form>
<br />
<form action="brands.jsp" method="post" accept-charset=utf-8>
<input type="hidden" name="action" value="editBrand">
<input type="hidden" name="brand" value="<%=brand%>">
<table class="cleartable">
	<tr>
		<td>Exchange Rate
		</td>
		<td>:
		</td>
		<td><input name="exchangeRate" value="<%=brandObj.getExchangeRate() %>"/>
		</td>
	</tr>
	<tr>
		<td>Expiry Date
		</td>
		<td>:
		</td>
		<td><input name="expiryDate" value="<%=brandObj.getExpiryDate() %>"/>
		</td>
	</tr>
	<tr>
		<td>Freight (%)
		</td>
		<td>:
		</td>
		<td><input name="freightCharges" value="<%=brandObj.getFreightCharges() %>"/>
		</td>
	</tr>
	<tr>
		<td>Price Date
		</td>
		<td>:
		</td>
		<td><input name="priceDate" value="<%=brandObj.getPriceDate() %>"/>
		</td>
	</tr>
	<tr>
		<td>News
		</td>
		<td>:
		</td>
		<td><input name="news" value="<%=brandObj.getNews() %>"/>
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="Update"/>
		</td>
		<td>&nbsp;
		</td>
		<td>&nbsp;
		</td>
	</tr>
</table>
</form>
<br />
<%
	if(!error.equals("")) {
%>
<span class="ui-state-error-text ui-state-error" ><%=error %></span> 
<%
	}
%>
</body>
<%@include file="includes/footer.jsp" %> 
</html>