<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body background="resources/pic1.jpg">
<title>ROOMMATE FINDER-STEP 3</title>
<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/profile_step3_style.css">
<h2>Profile Creation - Step 3</h2>
<p>*This part is<strong> OPTIONAL</strong><p> 
<div class="loginbox">
<img src="resources/avatar.png" class="avatar">

<form:form name="myForm" action="${flowExecutionUrl}" modelAttribute="userDto">

<p>Ethnicity</p>
<form:select name="Ethnicity" path="ethnicity">
  <option value="black"> Black</option>
  <option value="asian"> Asian</option>
  <option value="hispanic"> Hispanic</option>
  <option value="nativeamerican"> Native American</option>
  <option value="white"> White</option>
  <option value="pacificislander"> Pacific Islander</option>
  <option value="middleeastern"> Middle Eastern</option>
  <option value="indian"> Indian</option>
  <option value="other"> Other</option>
</form:select>
<br><br>

<p>Religion</p>
<form:select path="religion">
    <option value="agnostic">Agnostic</option>
    <option value="atheist">Atheist</option>
    <option value="christian">Christian</option>
    <option value="jewish">Jewish</option>
    <option value="catholic">Catholic</option>
    <option value="muslim">Muslim</option>
    <option value="hindu">Hindu</option>
    <option value="buddhist">Buddhist</option>
    <option value="sikh">Sikh</option>
    <option value="other">Other</option>
</form:select>
<br><br>
  
<p>Physical disabilities and allergies</p>
<form:textarea rows="4" cols="50" name="comment" maxlength="100" path="physical" placeholder="Enter text here..."/>
<br><br>

<p>Tell us more about yourself</p>
<p>(hobbies,activities,food,interests,books,movies,etc...)</p>
<form:textarea rows="4" cols="50" name="comment" maxlength="300" path="description" placeholder="Enter text here..."/>
<br><br>
<br><br>
<input type="submit" name="_eventId_cancel" value="Cancel">
<input type="submit" name="_eventId_previous" value="Prev">
<input type="submit" name="_eventId_submit" value="Register">
</form:form>
</body>
</html>