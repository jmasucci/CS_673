<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ROOMMATE FINDER</title>
</head>
<body>
	<div align="center">
		<form:form action="register" method="post" modelAttribute="userForm">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>ROOMMATE FINDER</h2></td>
				</tr>
				<tr>
					<td><form:label path='firstName'>First Name:</form:label></td>
					<td><form:input path='firstName'/></td>
				</tr>
				<tr>
					<td><form:label path='lastName'>Last Name:</form:label></td>
					<td><form:input path='lastName'/></td>
				</tr>
				<tr>
					<td><form:label path='email'>Email:</form:label></td>
					<td><form:input type="email" path='email'/></td>
				</tr>
				<tr>
					<td><form:label path='age'>Age:</form:label></td>
					<td><form:input path='age'/></td>
				</tr>
				<tr>
					<td><form:label path='password'>Password:</form:label></td>
					<td><form:input type="password" path='password'/></td>
				</tr>
				<tr>
					<td><form:label path='confirmpw'>Confirm Password:</form:label></td>
					<td><form:input type="password" path='confirmpw'/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register" /></td>
				</tr>
			</table>
			<br>
			<table border="0">
				<tr><td colspan="2" align="center"><a href="#">Lost your password?</a></td></tr>
				<tr><td colspan="2" align="center"><a href="#">Don't have an account?</a></td></tr>
			</table>
		</form:form>
	</div>
</body>
</html>