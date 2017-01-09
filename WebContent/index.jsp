<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="includes/import.jsp" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="jquery/css/ui-lightness/jquery-ui-1.10.4.custom.css" rel="stylesheet">
<%@include file="css/style.css" %> 
<script src="jquery/js/jquery-1.10.2.js"></script>
<script src="jquery/js/jquery-ui-1.10.4.custom.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dynaflo</title>
<header>
DYNAFLO PARTS SEARCH SYSTEM
</header>
</head>
<body>
<%
	Connection conn = (Connection) session.getAttribute("conn");	
	session.setAttribute("userLogin", null);
	String username = request.getParameter("username");	
	String error = "";
	if(username != null) {
		String password = request.getParameter("password");
		LoginModel userLogin = LoginManager.login(username, password, conn);
		if(userLogin != null) {
			session.setAttribute("userLogin", userLogin);
			// set auto-logout - function accepts parameter in seconds
			int minutes = 480;
			session.setMaxInactiveInterval(minutes*60); 
			String redirectURL = "items_query.jsp";
		    response.sendRedirect(redirectURL);
		    return;
		}
		else {
			error = "Username or password is invalid.";
			System.out.println(error);			
		}
	}
	else 
%>
<form action="index.jsp" method="post" accept-charset=utf-8>
<table class="cleartable">
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
		<td><input type="submit" value="Login" />
		</td>
		<td>&nbsp;
		</td>
		<td>&nbsp;
		</td>
	</tr>
</table>
</form>
<%
	if(!error.equals("")) {
%>
<br />
<%=error %>
<%
	}
%>
</body>
<%@include file="includes/footer.jsp" %>
</html>