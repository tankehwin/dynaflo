<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="includes/import.jsp" %>
<%@include file="includes/authentication.jsp" %>  
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
	String password = "";
	if(action != null && action.equals("editUser")) {
		password = request.getParameter("password");
		try {
			LoginManager.update(userLogin.getName(), password, conn);
			String success = "Update successful for " + userLogin.getName() + ".";
			System.out.println(success);
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
<script>
	$(function() {
		$( "#dob" ).datepicker();
	});
</script>
<form action="profile.jsp" method="post" accept-charset=utf-8>
<input type="hidden" name="action" value="editUser">
<table class="formtable">
	<tr>
		<td>Username
		</td>
		<td>:
		</td>
		<td><%=userLogin.getName() %>
		</td>
	</tr>
	<tr>
		<td>Password
		</td>
		<td>:
		</td>
		<td><input type="password" name="password" />
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
<footer>
FOOTER
</footer>
</body>
</html>