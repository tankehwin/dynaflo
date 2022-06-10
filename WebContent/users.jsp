<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="includes/header.jsp" %> 
<body oncontextmenu="return false;"><!-- stop right-click action -->

<%
	Connection conn = (Connection) session.getAttribute("conn");	
	String action = request.getParameter("action");
	ArrayList<LoginModel> result = new ArrayList<LoginModel>();	
	if(action != null && action.equals("delete")) {
		String id = request.getParameter("id");
		LoginManager.delete(id, conn);
	}
	result = LoginManager.getAllObjects(conn);

%>
<form action="users.jsp" method="post" accept-charset="utf-8">
<input type="hidden" name="action" value="delete">
<table id="results" class="gridtable" style="table-layout:fixed;width:2020px;">
	<col style="overflow:hidden;width:170px;" id="colName"/>
	<col style="overflow:hidden;width:170px;" id="colAccType"/>
	<col style="overflow:hidden;width:170px;" id="colDateCreated"/>
	<col style="overflow:hidden;width:170px;" id="colDateUpdated"/>
	<col style="overflow:hidden;width:170px;" id="colAction"/>
	<tr>
		<th>NAME
		</th>
		<th>TYPE
		</th>
		<th>DATE CREATED
		</th>
		<th>DATE UPDATED
		</th>
		<th>ACTION
		</th>
	</tr>
<%
	for(int i=0; i<result.size(); i++){
		LoginModel lgnObj = result.get(i);
%>
	<tr>
		<td><%=lgnObj.getName() %>
		</td>
		<td><%=lgnObj.getAccType() %>
		</td>
		<td><%=TimestampGenerator.getTruncatedDate(lgnObj.getDateCreated()) %>
		</td>
		<td><%=TimestampGenerator.getTruncatedDate(lgnObj.getDateCreated()) %>
		</td>
		<td>
			<a href="users.jsp?action=delete&id=<%=lgnObj.getId()%>">Delete</a>
		</td>
	</tr>
<%
	}
%>
</table>


</body>
<%@include file="includes/footer.jsp" %>   
</html>