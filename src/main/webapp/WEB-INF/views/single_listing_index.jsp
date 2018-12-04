<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/listings_style.css">
<title>LISTING</title>
</head>
<body background="resources/pic1.jpg">
<div class="loginbox">

<br><h1 align="center">LISTING</h1>

<h2 align="right"><a href="/CS673/filter_search_index" style="color:red">GO BACK - LISTINGS</a></h2>
<h2 align="right"><a href="/CS673/profile" style="color:red">USER PROFILE</a></h2>
<h2 align="right"><a href="/CS673/logout" style="color:red">Sign Out</a></h2>

<c:if test="${not empty user}"> 
	<strong><h2>Fullname: </h2>${user.fullname}</strong> 
	
	<strong><h2>Email: </h2>${user.email}</strong> 

	<strong><h2>Gender: </h2>${user.gender}</strong> 
	
	<strong><h2>City, State: </h2>${user.city}</strong>
	
	<strong><h2>Age: </h2>${user.age}</strong>
	
	<strong><h2>Pets: </h2>${user.pets}</strong>
	
	<strong><h2>Drinks: </h2>${user.drinks}</strong>
	
	<strong><h2>Smokes: </h2>${user.smokes}</strong>
	
	<strong><h2>Ideal room price range: </h2>${user.roomprice}</strong>
	
	<strong><h2>Total number of roommates the person wish to live with: </h2>${user.roommates}</strong>
	
	<strong><h2>Ethnicity: </h2>${user.ethnicity}</strong>
	
	<strong><h2>Religion: </h2>${user.religion}</strong>
	  
	<strong><h2>Physical disabilities and allergies: </h2>${user.physical}</strong><br>
	
	<strong><h2>Description: </h2>${user.description}</strong><br>
	
	<strong><p>----------------------------------------------</p></strong>
	<strong><h3>Send a message:</h3></strong>
	<form:form action="${id}" method="post" modelAttribute="emailDto">
	Subject: <input type="text" name="object"><br><br>
	Message:<br> 
	<textarea rows="4" cols="50" name="message" maxlength="300"></textarea><br><br>
	<input type="submit" value="Send">
	</form:form>
</c:if>

<c:if test="${empty user}">
	<p align="center"> This user doesn't exist</p>
</c:if>
</div>
</body>
</html>