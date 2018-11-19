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
  <option value="Black"> Black</option>
  <option value="Asian"> Asian</option>
  <option value="Hispanic/Latin"> Hispanic</option>
  <option value="NativeAmerican"> Native American</option>
  <option value="White"> White</option>
  <option value="PacificIslander"> Pacific Islander</option>
  <option value="MiddleEastern"> Middle Eastern</option>
  <option value="Indian"> Indian</option>
  <option value="OtherEthnicity"> Other</option>
</form:select>
<br><br>

<p>Religion</p>
<form:select path="religion">
    <option value="Agnostic">Agnostic</option>
    <option value="Atheist">Atheist</option>
    <option value="Christian">Christian</option>
    <option value="Jewish">Jewish</option>
    <option value="Catholic">Catholic</option>
    <option value="Muslim">Muslim</option>
    <option value="Hindu">Hindu</option>
    <option value="Buddhist">Buddhist</option>
    <option value="Sikh">Sikh</option>
    <option value="OtherReligion">Other</option>
</form:select>
<br><br>
  
<p>Physical disabilities and allergies</p>
<form:textarea rows="4" cols="50" name="comment" maxlength="100" path="physical" placeholder="Enter text here..."/>
<br><br>

<p>Tell us more about yourself</p>
<p>(hobbies,activities,food,interests,books,movies,etc...)</p>
<form:textarea rows="4" cols="50" name="comment" maxlength="300" path="description" placeholder="Enter text here..."/>

<input type="submit" name="_eventId_cancel" value="Cancel">
<input type="submit" name="_eventId_previous" value="Prev">
<input type="submit" name="_eventId_submit" value="Register">
</form:form>
</body>
</html>