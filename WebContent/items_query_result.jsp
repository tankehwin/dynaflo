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
<script language=JavaScript>
function disableselect(e) {
    return false;
}

function reEnable() {
    return true;
}

document.onselectstart = new Function("return false");

if (window.sidebar) {
    document.onmousedown = disableselect;
    document.onclick = reEnable;
}
</script>
</head>
<body>
<header>
DYNAFLO PARTS SEARCH SYSTEM
</header>
<script language=JavaScript>
//Disable right mouse click Script
//By Maximus (maximus@nsimail.com) w/ mods by DynamicDrive
//For full source code, visit http://www.dynamicdrive.com
var message="Function Disabled!";

///////////////////////////////////
function clickIE4(){
if (event.button==2){
//alert(message);
return false;
}
}

function clickNS4(e){
if (document.layers||document.getElementById&&!document.all){
if (e.which==2||e.which==3){
//alert(message);
return false;
}
}
}

if (document.layers){
document.captureEvents(Event.MOUSEDOWN);
document.onmousedown=clickNS4;
}
else if (document.all&&!document.getElementById){
document.onmousedown=clickIE4;
}

//document.oncontextmenu=new Function("alert(message);return false")
document.oncontextmenu=new Function("return false")
</script>
<%
	Connection conn = (Connection) session.getAttribute("conn");	
	String action = request.getParameter("action");
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

	if(action != null && action.equals("backToIndex")) {
		String redirectURL = "index.jsp";
		response.sendRedirect(redirectURL);
	}
	
	ItemModel itmObj1 = new ItemModel();
	ItemModel itmObj2 = new ItemModel();
	ItemModel itmObj3 = new ItemModel();
	ItemModel itmObj4 = new ItemModel();
	ItemModel itmObj5 = new ItemModel();
	ItemModel itmObj6 = new ItemModel();
	ItemModel itmObj7 = new ItemModel();
	ItemModel itmObj8 = new ItemModel();
	ItemModel itmObj9 = new ItemModel();
	ItemModel itmObj10 = new ItemModel();
	int iQty1 = 1;
	int iQty2 = 1;
	int iQty3 = 1;
	int iQty4 = 1;
	int iQty5 = 1;
	int iQty6 = 1;
	int iQty7 = 1;
	int iQty8 = 1;
	int iQty9 = 1;
	int iQty10 = 1;
	boolean ifIracExists = false;
	if(!partNum1.trim().equals("")){		
		if(!qty1.trim().equals("")){
			iQty1 = new Integer(qty1).intValue();
		}
		itmObj1 = ItemManager.getObject(partNum1, iQty1, conn);
		if(itmObj1.getPartNumber().startsWith("IAV")){
			ifIracExists = true;
		}
	}
	if(!partNum2.trim().equals("")){		
		if(!qty2.trim().equals("")){
			iQty2 = new Integer(qty2).intValue();
		}
		itmObj2 = ItemManager.getObject(partNum2, iQty2, conn);
		if(itmObj2.getPartNumber().startsWith("IAV")){
			ifIracExists = true;
		}
	}
	if(!partNum3.trim().equals("")){		
		if(!qty3.trim().equals("")){
			iQty3 = new Integer(qty3).intValue();
		}
		itmObj3 = ItemManager.getObject(partNum3, iQty3, conn);
		if(itmObj3.getPartNumber().startsWith("IAV")){
			ifIracExists = true;
		}
	}
	if(!partNum4.trim().equals("")){		
		if(!qty4.trim().equals("")){
			iQty4 = new Integer(qty4).intValue();
		}
		itmObj4 = ItemManager.getObject(partNum4, iQty4, conn);
		if(itmObj4.getPartNumber().startsWith("IAV")){
			ifIracExists = true;
		}
	}
	if(!partNum5.trim().equals("")){		
		if(!qty5.trim().equals("")){
			iQty5 = new Integer(qty5).intValue();
		}
		itmObj5 = ItemManager.getObject(partNum5, iQty5, conn);
		if(itmObj5.getPartNumber().startsWith("IAV")){
			ifIracExists = true;
		}
	}
	if(!partNum6.trim().equals("")){		
		if(!qty6.trim().equals("")){
			iQty6 = new Integer(qty6).intValue();
		}
		itmObj6 = ItemManager.getObject(partNum6, iQty6, conn);
		if(itmObj6.getPartNumber().startsWith("IAV")){
			ifIracExists = true;
		}
	}
	if(!partNum7.trim().equals("")){		
		if(!qty7.trim().equals("")){
			iQty7 = new Integer(qty7).intValue();
		}
		itmObj7 = ItemManager.getObject(partNum7, iQty7, conn);
		if(itmObj7.getPartNumber().startsWith("IAV")){
			ifIracExists = true;
		}
	}
	if(!partNum8.trim().equals("")){		
		if(!qty8.trim().equals("")){
			iQty8 = new Integer(qty8).intValue();
		}
		itmObj8 = ItemManager.getObject(partNum8, iQty8, conn);
		if(itmObj8.getPartNumber().startsWith("IAV")){
			ifIracExists = true;
		}
	}
	if(!partNum9.trim().equals("")){		
		if(!qty9.trim().equals("")){
			iQty9 = new Integer(qty9).intValue();
		}
		itmObj9 = ItemManager.getObject(partNum9, iQty9, conn);
		if(itmObj9.getPartNumber().startsWith("IAV")){
			ifIracExists = true;
		}
	}
	if(!partNum10.trim().equals("")){		
		if(!qty10.trim().equals("")){
			iQty10 = new Integer(qty10).intValue();
		}
		itmObj10 = ItemManager.getObject(partNum10, iQty10, conn);
		if(itmObj10.getPartNumber().startsWith("IAV")){
			ifIracExists = true;
		}
	}
	BigDecimal grandTotal = itmObj1.getSellingPrice().multiply(new BigDecimal(iQty1));
	grandTotal = grandTotal.add(itmObj2.getSellingPrice().multiply(new BigDecimal(iQty2)));
	grandTotal = grandTotal.add(itmObj3.getSellingPrice().multiply(new BigDecimal(iQty3)));
	grandTotal = grandTotal.add(itmObj4.getSellingPrice().multiply(new BigDecimal(iQty4)));
	grandTotal = grandTotal.add(itmObj5.getSellingPrice().multiply(new BigDecimal(iQty5)));
	grandTotal = grandTotal.add(itmObj6.getSellingPrice().multiply(new BigDecimal(iQty6)));
	grandTotal = grandTotal.add(itmObj7.getSellingPrice().multiply(new BigDecimal(iQty7)));
	grandTotal = grandTotal.add(itmObj8.getSellingPrice().multiply(new BigDecimal(iQty8)));
	grandTotal = grandTotal.add(itmObj9.getSellingPrice().multiply(new BigDecimal(iQty9)));
	grandTotal = grandTotal.add(itmObj10.getSellingPrice().multiply(new BigDecimal(iQty10)));

	grandTotal = grandTotal.setScale(2, BigDecimal.ROUND_HALF_UP);

	
	
%>
<table class="formtable">
<tr>
<td>
<table class="gridtable">
	<tr>
		<th colspan="16">Search Results
		</th>
	</tr>
	<tr>
		<th>Part Number
		</th>
		<th>Qty
		</th>
		<th>Description
		</th>
		<th>Additional <br/>Information 1
		</th>
		<th>Additional <br/>Information 2
		</th>
		<th>Additional <br/>Information 3
		</th>
		<th>Equipment/ <br/>Package Ref
		</th>
		<th>GRACO Ref
		</th>
		<th>GRACO <br/>Family Type
		</th>
		<th>GRACO <br/>Family Disc. (%)
		</th>
		<th>GRACO <br/>Std Disc. Code
		</th>
		<th>GRACO <br/>Std Disc. (%)
		</th>
		<th>Duties (%)
		</th>
		<th>Selling Price
		</th>
		<th>Total Price
		</th>
		<th>Dynaflo <br/>Disc. Code
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
		<td><%=itmObj1.getEquipmentPackageReference()%>
		</td>
		<td><%=itmObj1.getGracoReference() %>
		</td>
		<td align="center"><%=itmObj1.getGracoFamType() %>
		</td>
		<td align="center"><%=itmObj1.getGracoFamDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj1.getGracoStdDiscountCode() %>
		</td>
		<td align="center"><%=itmObj1.getGracoStdDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj1.getDuties() %>
		</td>	
		<td align="right"><%=itmObj1.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj1.getSellingPrice().multiply(new BigDecimal(iQty1)) %>
		</td>
		<td align="center"><%=itmObj1.getDynafloDiscountCode() %>
		</td>
	</tr>
<%
	}
	else if(!partNum1.trim().equals("")){
%>
	<tr>
		<td colspan="16"><%=partNum1 %> does not exist.
		</td>
	</tr>
<%
	}
	if(!itmObj2.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj2.getPartNumber() %>
		</td>
		<td align="center"><%=iQty2 %>
		</td>
		<td><%=itmObj2.getDescription() %>
		</td>
		<td><%=itmObj2.getAddInfo1() %>
		</td>
		<td><%=itmObj2.getAddInfo2() %>
		</td>
		<td><%=itmObj2.getAddInfo3() %>
		</td>
		<td><%=itmObj2.getEquipmentPackageReference()%>
		</td>
		<td align="center"><%=itmObj2.getGracoReference() %>
		</td>
		<td align="center"><%=itmObj2.getGracoFamType() %>
		</td>
		<td align="center"><%=itmObj2.getGracoFamDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj2.getGracoStdDiscountCode() %>
		</td>
		<td align="center"><%=itmObj2.getGracoStdDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj2.getDuties() %>
		</td>	
		<td align="right"><%=itmObj2.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj2.getSellingPrice().multiply(new BigDecimal(iQty2)) %>
		</td>
		<td align="center"><%=itmObj2.getDynafloDiscountCode() %>
		</td>
	</tr>
<%
	}
	else if(!partNum2.trim().equals("")){
%>
	<tr>
		<td colspan="16"><%=partNum2 %> does not exist.
		</td>
	</tr>
<%
	}
	if(!itmObj3.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj3.getPartNumber() %>
		</td>
		<td align="center"><%=iQty3 %>
		</td>
		<td><%=itmObj3.getDescription() %>
		</td>
		<td><%=itmObj3.getAddInfo1() %>
		</td>
		<td><%=itmObj3.getAddInfo2() %>
		</td>
		<td><%=itmObj3.getAddInfo3() %>
		</td>
		<td><%=itmObj3.getEquipmentPackageReference()%>
		</td>
		<td><%=itmObj3.getGracoReference() %>
		</td>
		<td align="center"><%=itmObj3.getGracoFamType() %>
		</td>
		<td align="center"><%=itmObj3.getGracoFamDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj3.getGracoStdDiscountCode() %>
		</td>
		<td align="center"><%=itmObj3.getGracoStdDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj3.getDuties() %>
		</td>
		<td align="right"><%=itmObj3.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj3.getSellingPrice().multiply(new BigDecimal(iQty3)) %>
		</td>
		<td align="center"><%=itmObj3.getDynafloDiscountCode() %>
		</td>
	</tr>
<%
	}
	else if(!partNum3.trim().equals("")){
%>
	<tr>
		<td colspan="16"><%=partNum3 %> does not exist.
		</td>
	</tr>
<%
	}
	if(!itmObj4.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj4.getPartNumber() %>
		</td>
		<td align="center"><%=iQty4 %>
		</td>
		<td><%=itmObj4.getDescription() %>
		</td>
		<td><%=itmObj4.getAddInfo1() %>
		</td>
		<td><%=itmObj4.getAddInfo2() %>
		</td>
		<td><%=itmObj4.getAddInfo3() %>
		</td>
		<td><%=itmObj4.getEquipmentPackageReference()%>
		</td>
		<td align="center"><%=itmObj4.getGracoReference() %>
		</td>
		<td align="center"><%=itmObj4.getGracoFamType() %>
		</td>
		<td align="center"><%=itmObj4.getGracoFamDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj4.getGracoStdDiscountCode() %>
		</td>
		<td align="center"><%=itmObj4.getGracoStdDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj4.getDuties() %>
		</td>
		<td align="right"><%=itmObj4.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj4.getSellingPrice().multiply(new BigDecimal(iQty4)) %>
		</td>
		<td align="center"><%=itmObj4.getDynafloDiscountCode() %>
		</td>
	</tr>
<%
	}
	else if(!partNum4.trim().equals("")){
%>
	<tr>
		<td colspan="16"><%=partNum4 %> does not exist.
		</td>
	</tr>
<%
	}
	if(!itmObj5.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj5.getPartNumber() %>
		</td>
		<td align="center"><%=iQty5 %>
		</td>
		<td><%=itmObj5.getDescription() %>
		</td>
		<td><%=itmObj5.getAddInfo1() %>
		</td>
		<td><%=itmObj5.getAddInfo2() %>
		</td>
		<td><%=itmObj5.getAddInfo3() %>
		</td>
		<td><%=itmObj5.getEquipmentPackageReference()%>
		</td>
		<td align="center"><%=itmObj5.getGracoReference() %>
		</td>
		<td align="center"><%=itmObj5.getGracoFamType() %>
		</td>
		<td align="center"><%=itmObj5.getGracoFamDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj5.getGracoStdDiscountCode() %>
		</td>
		<td align="center"><%=itmObj5.getGracoStdDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj5.getDuties() %>
		</td>	
		<td align="right"><%=itmObj5.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj5.getSellingPrice().multiply(new BigDecimal(iQty5)) %>
		</td>
		<td align="center"><%=itmObj5.getDynafloDiscountCode() %>
		</td>
	</tr>
<%
	}
	else if(!partNum5.trim().equals("")){
%>
	<tr>
		<td colspan="16"><%=partNum5 %> does not exist.
		</td>
	</tr>
<%
	}
	if(!itmObj6.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj6.getPartNumber() %>
		</td>
		<td align="center"><%=iQty6 %>
		</td>
		<td><%=itmObj6.getDescription() %>
		</td>
		<td><%=itmObj6.getAddInfo1() %>
		</td>
		<td><%=itmObj6.getAddInfo2() %>
		</td>
		<td><%=itmObj6.getAddInfo3() %>
		</td>
		<td><%=itmObj6.getEquipmentPackageReference()%>
		</td>
		<td align="center"><%=itmObj6.getGracoReference() %>
		</td>
		<td align="center"><%=itmObj6.getGracoFamType() %>
		</td>
		<td align="center"><%=itmObj6.getGracoFamDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj6.getGracoStdDiscountCode() %>
		</td>
		<td align="center"><%=itmObj6.getGracoStdDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj6.getDuties() %>
		</td>	
		<td align="right"><%=itmObj6.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj6.getSellingPrice().multiply(new BigDecimal(iQty6)) %>
		</td>
		<td align="center"><%=itmObj6.getDynafloDiscountCode() %>
		</td>
	</tr>
<%
	}
	else if(!partNum6.trim().equals("")){
%>
	<tr>
		<td colspan="16"><%=partNum6 %> does not exist.
		</td>
	</tr>
<%
	}
	if(!itmObj7.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj7.getPartNumber() %>
		</td>
		<td align="center"><%=iQty7 %>
		</td>
		<td><%=itmObj7.getDescription() %>
		</td>
		<td><%=itmObj7.getAddInfo1() %>
		</td>
		<td><%=itmObj7.getAddInfo2() %>
		</td>
		<td><%=itmObj7.getAddInfo3() %>
		</td>
		<td><%=itmObj7.getEquipmentPackageReference()%>
		</td>
		<td align="center"><%=itmObj7.getGracoReference() %>
		</td>
		<td align="center"><%=itmObj7.getGracoFamType() %>
		</td>
		<td align="center"><%=itmObj7.getGracoFamDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj7.getGracoStdDiscountCode() %>
		</td>
		<td align="center"><%=itmObj7.getGracoStdDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj7.getDuties() %>
		</td>
		<td align="right"><%=itmObj7.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj7.getSellingPrice().multiply(new BigDecimal(iQty7)) %>
		</td>
		<td align="center"><%=itmObj7.getDynafloDiscountCode() %>
		</td>
	</tr>
<%
	}
	else if(!partNum7.trim().equals("")){
%>
	<tr>
		<td colspan="16"><%=partNum7 %> does not exist.
		</td>
	</tr>
<%
	}
	if(!itmObj8.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj8.getPartNumber() %>
		</td>
		<td align="center"><%=iQty8 %>
		</td>
		<td><%=itmObj8.getDescription() %>
		</td>
		<td><%=itmObj8.getAddInfo1() %>
		</td>
		<td><%=itmObj8.getAddInfo2() %>
		</td>
		<td><%=itmObj8.getAddInfo3() %>
		</td>
		<td><%=itmObj8.getEquipmentPackageReference()%>
		</td>
		<td align="center"><%=itmObj8.getGracoReference() %>
		</td>
		<td align="center"><%=itmObj8.getGracoFamType() %>
		</td>
		<td align="center"><%=itmObj8.getGracoFamDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj8.getGracoStdDiscountCode() %>
		</td>
		<td align="center"><%=itmObj8.getGracoStdDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj8.getDuties() %>
		</td>		
		<td align="right"><%=itmObj8.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj8.getSellingPrice().multiply(new BigDecimal(iQty8)) %>
		</td>
		<td align="center"><%=itmObj8.getDynafloDiscountCode() %>
		</td>
	</tr>
<%
	}
	else if(!partNum8.trim().equals("")){
%>
	<tr>
		<td colspan="16"><%=partNum8 %> does not exist.
		</td>
	</tr>
<%
	}
	if(!itmObj9.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj9.getPartNumber() %>
		</td>
		<td align="center"><%=iQty9 %>
		</td>
		<td><%=itmObj9.getDescription() %>
		</td>
		<td><%=itmObj9.getAddInfo1() %>
		</td>
		<td><%=itmObj9.getAddInfo2() %>
		</td>
		<td><%=itmObj9.getAddInfo3() %>
		</td>
		<td><%=itmObj9.getEquipmentPackageReference()%>
		</td>
		<td align="center"><%=itmObj9.getGracoReference() %>
		</td>
		<td align="center"><%=itmObj9.getGracoFamType() %>
		</td>
		<td align="center"><%=itmObj9.getGracoFamDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj9.getGracoStdDiscountCode() %>
		</td>
		<td align="center"><%=itmObj9.getGracoStdDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj9.getDuties() %>
		</td>
		<td align="right"><%=itmObj9.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj9.getSellingPrice().multiply(new BigDecimal(iQty9)) %>
		</td>
		<td align="center"><%=itmObj9.getDynafloDiscountCode() %>
		</td>
	</tr>
<%
	}
	else if(!partNum9.trim().equals("")){
%>
	<tr>
		<td colspan="16"><%=partNum9 %> does not exist.
		</td>
	</tr>
<%
	}
	if(!itmObj10.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj10.getPartNumber() %>
		</td>
		<td align="center"><%=iQty10 %>
		</td>
		<td><%=itmObj10.getDescription() %>
		</td>
		<td><%=itmObj10.getAddInfo1() %>
		</td>
		<td><%=itmObj10.getAddInfo2() %>
		</td>
		<td><%=itmObj10.getAddInfo3() %>
		</td>
		<td><%=itmObj10.getEquipmentPackageReference()%>
		</td>
		<td align="center"><%=itmObj10.getGracoReference() %>
		</td>
		<td align="center"><%=itmObj10.getGracoFamType() %>
		</td>
		<td align="center"><%=itmObj10.getGracoFamDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj10.getGracoStdDiscountCode() %>
		</td>
		<td align="center"><%=itmObj10.getGracoStdDiscount().multiply(new BigDecimal(100)) %>
		</td>
		<td align="center"><%=itmObj10.getDuties() %>
		</td>
		<td align="right"><%=itmObj10.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj10.getSellingPrice().multiply(new BigDecimal(iQty10)) %>
		</td>
		<td align="center"><%=itmObj10.getDynafloDiscountCode() %>
		</td>
	</tr>
<%
	}
	else if(!partNum10.trim().equals("")){
%>
	<tr>
		<td colspan="16"><%=partNum10 %> does not exist.
		</td>
	</tr>
<%
	}
%>
	<tr>
		<th colspan="14" align="right">GRAND TOTAL
		</th>
		<th align="right"><%=grandTotal %>
		</th>
		<th>&nbsp;
		</th>
	</tr>
<form action="index.jsp" method="post" accept-charset=utf-8>
<input type="hidden" name="action" value="backToIndex">
	<tr>
		<td colspan="16"><input type="submit" value="Search Again" />
		</td>
	</tr>
</form>
</table>
<br />
</td>
</tr>
<%
	if(ifIracExists){
%>
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
<%
	}
%>
</table>
<footer>
FOOTER
</footer>
</body>
</html>