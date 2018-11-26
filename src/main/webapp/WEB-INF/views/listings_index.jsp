<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<title>LISTINGS</title>
<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/listings_style.css">
<br><h2 align="center">ROOMMATE LISTINGS</h2>
<h2 align="right"><a href="filter_search_index" style="color:red">GO BACK - Search</a></h2>
<h2 align="right"><a href="profile" style="color:red">User Profile</a></h2>
<h2 align="right"><a href="logout" style="color:red">Sign Out</a></h2>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 25%;
	align: center;
}

td, th {
    border: 1px solid #000000;
    text-align: left;
    padding: 12px;
	}
}

</style>
</head>
<body>

<c:if test="${not empty users}">
    <table align="center">
        <c:forEach var="u" items="${users}">
            <tr>
                <td>${u.fullname}</td>
                <td>${u.age}</td>
                <td>${u.email}</td>   
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty users}">
	<p align="center">No roommates found</p>
</c:if>

</body>
</html>