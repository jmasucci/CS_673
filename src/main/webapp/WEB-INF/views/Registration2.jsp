<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body background="resources/pic1.jpg">
<title>ROOMMATE FINDER-STEP 2</title>
<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/profile_step2_style.css">
<h2>Profile Creation - Step 2</h2>
<p>*Please fill out <strong>ALL</strong> the details below<p> 
<div class="loginbox">
<img src="resources/avatar.png" class="avatar">

<form:form name="myForm" action="${flowExecutionUrl}" modelAttribute="userDto">
  
<p>*Pets</p>
<form:select path="pets">
  <option value="cat">Cat</option>
  <option value="dog">Dog</option>
  <option value="none">None</option>
</form:select>
<br><br>

<p>*Drinks</p>
<form:select path="drinks">
    <option value="frequently">Frequently</option>
    <option value="occasionally">Occasionally</option>
    <option value="never">Never</option>
</form:select>
<br><br>

<p>*Smokes</p>
<form:select path="smokes">
    <option value="frequently">Frequently</option>
    <option value="occasionally">Occasionally</option>
    <option value="never">Never</option>
</form:select>
<br><br>

<p>*Your ideal room price range</p>
<form:select path="roomprice">
    <option value="$800-$1200">$800-$1200</option>
    <option value="$1200-$1600">$1200-$1600</option>
    <option value="$1600-$2000">$1600-$2000</option>
	<option value="$2000-$2400">$2000-$2400</option>
</form:select>
<br><br>

<p>*Total number of roommates you wish to live with</p>
<form:select path="roommates">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
	<option value="4+">4+</option>
</form:select>
<br><br>

<input type="submit" name="_eventId_cancel" value="Cancel">
<input type="submit" name="_eventId_previous" value="Prev">
<input type="submit" name="_eventId_submit" value="Next">
<br>
</form:form>
</body>
</html>