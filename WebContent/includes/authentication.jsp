<%
	LoginModel userLogin = (LoginModel) session.getAttribute("userLogin");
	if(userLogin == null) {
		String redirectURL = "index.jsp";
	    response.sendRedirect(redirectURL);
	}
	else{
%>
<table class="formtable">
	<tr>
		<td align="right" width="100%">Welcome, <%=userLogin.getName() %>.
		&nbsp;
		<a href="profile.jsp">Edit User Profile</a>
		&nbsp;
		<a href="index.jsp">Logout</a>
		</td>
	</tr>
</table>
<%		
	}
	
%>
