<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>ROOMMATE FINDER-HOME</title>
    <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/login_style.css">
<body background="resources/pic1.jpg">
    <div class="loginbox">
    <img src="resources/avatar.png" class="avatar">
        <h1>ROOMMATE FINDER</h1>
        <form:form action="login" method="post" modelAttribute="userForm">
            <p>Email</p>
            <form:input type="text" name="" placeholder="Enter Email" path='email'/>
            <p>Password</p>
            <form:input type="password" name="" placeholder="Enter Password" path='password'/>
            <input type="submit" name="" value="Login"/>
            <a href="#">Lost your password?</a><br>
            <a href="register">Don't have an account?</a>
        </form:form>
    </div>

</body>
</head>
</html>
