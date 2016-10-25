<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="includes/header.jsp" %> 
<body> 
<%
	Connection conn = (Connection) session.getAttribute("conn");
	String action = request.getParameter("action");
	String error = "";
	if(action != null && action.equals("registerUser")) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			LoginManager.register(username, password, conn);
			String success = "Registration successful for " + username + ".";
			System.out.println(success);
%>
<script>
	$(function() {
		$( "#dialog-message" ).dialog({
			modal: true,
			buttons: {
				OK: function() {
					$( this ).dialog( "close" );
					window.location.replace("index.jsp");
					
				}
			}
		});
	});
</script>

<div id="dialog-message" title="Registration Successful">
	<p>
		<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
		<%=success %>
	</p>
</div>
<%
		}
		catch (Exception ex) {
			if(ex.getMessage().equals("This user is already registered.")) {
				error = ex.getMessage();
			}
			else {
				error = ex.getMessage() + ". This user could not be registered.";
			}
		}	
	} // end if
%>
<script>
	$(function() {
		$( "#dob" ).datepicker();
	});
</script>
<form action="register.jsp" method="post" accept-charset=utf-8>
<input type="hidden" name="action" value="registerUser">
<table class="gridtable">
	<tr>
		<td>Username
		</td>
		<td>:
		</td>
		<td><input type="text" name="username" />
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
		<td><input type="submit" value="Register"/>
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