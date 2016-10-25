<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<head>
<link href="jquery/css/ui-lightness/jquery-ui-1.10.4.custom.css" rel="stylesheet">
<!-- the line below was commented because table css was not being applied -->
<!-- <link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet">  --> 
<script src="jquery/js/jquery-1.10.2.js"></script>
<script src="jquery/js/jquery-ui-1.10.4.custom.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dynaflo</title>
<header>
DYNAFLO PARTS SEARCH SYSTEM
</header>  
<!-- the line below is the workaround to the problem above -->
<%@include file="../css/style.css" %> 
<%@include file="import.jsp" %>   
<%@include file="authentication.jsp" %>   
</head>
