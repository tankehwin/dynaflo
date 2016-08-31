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
HEADER
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

	if(action != null && action.equals("backToIndex")) {
		String redirectURL = "index.jsp";
		response.sendRedirect(redirectURL);
	}
	
	ItemModel itmObj1 = new ItemModel();
	ItemModel itmObj2 = new ItemModel();
	ItemModel itmObj3 = new ItemModel();
	ItemModel itmObj4 = new ItemModel();
	ItemModel itmObj5 = new ItemModel();
	int iQty1 = 1;
	int iQty2 = 1;
	int iQty3 = 1;
	int iQty4 = 1;
	int iQty5 = 1;
	if(!partNum1.trim().equals("")){		
		if(!qty1.trim().equals("")){
			iQty1 = new Integer(qty1).intValue();
		}
		itmObj1 = ItemManager.getObject(partNum1, iQty1, conn);
	}
	if(!partNum2.trim().equals("")){		
		if(!qty2.trim().equals("")){
			iQty2 = new Integer(qty2).intValue();
		}
		itmObj2 = ItemManager.getObject(partNum2, iQty2, conn);
	}
	if(!partNum3.trim().equals("")){		
		if(!qty3.trim().equals("")){
			iQty3 = new Integer(qty3).intValue();
		}
		itmObj3 = ItemManager.getObject(partNum3, iQty3, conn);
	}
	if(!partNum4.trim().equals("")){		
		if(!qty4.trim().equals("")){
			iQty4 = new Integer(qty4).intValue();
		}
		itmObj4 = ItemManager.getObject(partNum4, iQty4, conn);
	}
	if(!partNum5.trim().equals("")){		
		if(!qty5.trim().equals("")){
			iQty5 = new Integer(qty5).intValue();
		}
		itmObj5 = ItemManager.getObject(partNum5, iQty5, conn);
	}
	
	
	
%>
<table class="formtable">
<tr>
<td>
<table class="gridtable">
	<tr>
		<td colspan="6">Search Results
		</td>
	</tr>
	<tr>
		<td>Part Number
		</td>
		<td>Qty
		</td>
		<td>Duties (%)
		</td>
		<td>Dynaflo Discount Code
		</td>
		<td>Selling Price
		</td>
		<td>Total Price
		</td>
	</tr>
<%
	if(!itmObj1.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj1.getPartNumber() %>
		</td>
		<td align="right"><%=iQty1 %>
		</td>
		<td align="right"><%=itmObj1.getDuties()*100 %>
		</td>
		<td><%=itmObj1.getDynafloDiscountCode() %>
		</td>
		<td align="right"><%=itmObj1.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj1.getSellingPrice()*iQty1 %>
		</td>
	</tr>
<%
	}
	else if(!partNum1.trim().equals("")){
%>
	<tr>
		<td colspan="6"><%=partNum1 %> does not exist.
		</td>
	</tr>
<%
	}
	if(!itmObj2.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj2.getPartNumber() %>
		</td>
		<td align="right"><%=iQty2 %>
		</td>
		<td align="right"><%=itmObj2.getDuties()*100 %>
		</td>
		<td><%=itmObj2.getDynafloDiscountCode() %>
		</td>
		<td align="right"><%=itmObj2.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj2.getSellingPrice()*iQty2 %>
		</td>
	</tr>
<%
	}
	else if(!partNum2.trim().equals("")){
%>
	<tr>
		<td colspan="6"><%=partNum2 %> does not exist.
		</td>
	</tr>
<%
	}
	if(!itmObj3.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj3.getPartNumber() %>
		</td>
		<td align="right"><%=iQty3 %>
		</td>
		<td align="right"><%=itmObj3.getDuties()*100 %>
		</td>
		<td><%=itmObj3.getDynafloDiscountCode() %>
		</td>
		<td align="right"><%=itmObj3.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj3.getSellingPrice()*iQty3 %>
		</td>
	</tr>
<%
	}
	else if(!partNum3.trim().equals("")){
%>
	<tr>
		<td colspan="6"><%=partNum3 %> does not exist.
		</td>
	</tr>
<%
	}
	if(!itmObj4.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj4.getPartNumber() %>
		</td>
		<td align="right"><%=iQty4 %>
		</td>
		<td align="right"><%=itmObj4.getDuties()*100 %>
		</td>
		<td><%=itmObj4.getDynafloDiscountCode() %>
		</td>
		<td align="right"><%=itmObj4.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj4.getSellingPrice()*iQty4 %>
		</td>
	</tr>
<%
	}
	else if(!partNum4.trim().equals("")){
%>
	<tr>
		<td colspan="6"><%=partNum4 %> does not exist.
		</td>
	</tr>
<%
	}
	if(!itmObj5.getPartNumber().trim().equals("")){
%>
	<tr>
		<td><%=itmObj5.getPartNumber() %>
		</td>
		<td align="right"><%=iQty5 %>
		</td>
		<td align="right"><%=itmObj5.getDuties()*100 %>
		</td>
		<td><%=itmObj5.getDynafloDiscountCode() %>
		</td>
		<td align="right"><%=itmObj5.getSellingPrice() %>
		</td>
		<td align="right"><%=itmObj5.getSellingPrice()*iQty5 %>
		</td>
	</tr>
<%
	}
	else if(!partNum5.trim().equals("")){
%>
	<tr>
		<td colspan="6"><%=partNum5 %> does not exist.
		</td>
	</tr>
<%
	}
%>
<form action="index.jsp" method="post" accept-charset=utf-8>
<input type="hidden" name="action" value="backToIndex">
	<tr>
		<td colspan="6"><input type="submit" value="Search Again" />
		</td>
	</tr>
</form>
</table>
<br />
</td>
</tr>
</table>
<footer>
FOOTER
</footer>
</body>
</html>