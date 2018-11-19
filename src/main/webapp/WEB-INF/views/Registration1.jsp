<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="resources/bootstrap/js/Registration1.js"></script>
</head>

<body background="resources/pic1.jpg">
<title>ROOMMATE FINDER</title>
<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/profile_step1_style.css">
<h2>Profile Creation - Step 1</h2>
<p>*Please fill out <strong>ALL</strong> the details below<p>


<div class="loginbox">
<img src="resources/avatar.png" class="avatar">
<form:form name="myForm" action="${flowExecutionUrl}" modelAttribute="userDto">

<p>*Full name</p><br>
    <form:input type="text" name="fullname" placeholder="Enter Full Name" path="fullname"/>
<br><br>

<p>*Email Address</p><br>
    <form:input path="email" type="text" name="email" placeholder="Enter Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"/>
<br>

<p>*Password</p><br>
    <form:input id="pword" type="password" name="pword" placeholder="Enter Password" path="password"/>
<br>

<br>
<p>*Confirm Password</p>
    <form:input path="confirmpw" type="password" id="confirm_pword" name="confirm_pword" placeholder="Confirm Password"/>

<p>*Gender</p><br>
<form:select path="gender">
    <option value="male">Male</option>
    <option value="female">Female</option>
    <option value="other">Other</option>
</form:select>

<br><br>
<p>*City, State</p><br>
<form:select path="city">
    <option value="princeton">Princeton, NJ</option>
    <option value="cambridge">Cambridge, MA</option>
    <option value="nyc">New York City, NY</option>
    <option value="chicago">Chicago, IL</option>
    <option value="newhaven">New Haven, CT</option>
    <option value="stanford">Stanford, CA</option>
    <option value="durham">Durham, NC</option>
    <option value="chicago">Chicago, IL</option>
    <option value="philadelphia">Philadelphia, PA</option>
    <option value="baltimore">Baltimore, MD</option>
    <option value="evanston">Evanston, IL</option>
    <option value="pasadena">Pasadena, CA</option>
    <option value="hanover">Hanover, NH</option>
    <option value="providence">Providence, RI</option>
    <option value="nashville">Nashville, TN</option>
    <option value="ithaca">Ithaca, NY</option>
    <option value="houston">Houston, TX</option>
    <option value="notredame">Notre Dame, IN</option>
    <option value="la">Los Angeles, CA</option>
    <option value="stlouis">St. Louis, MO</option>
    <option value="atlanta">Atlanta, GA</option>
    <option value="dc">Washington, DC</option>
    <option value="berkeley">Berkeley, CA</option>
    <option value="pittsburgh">Pittsburgh, PA</option>
    <option value="charlottesville">Charlottesville, VA</option>
    <option value="medford">Medford, MA</option>
    <option value="annarbor">Ann Arbor, MI</option>
    <option value="winston-salem">Winston-Salem, NC</option>
    <option value="santabarbara">Santa Barbara, CA</option>
    <option value="chapelhill">Chapel Hill, NC</option>
    <option value="irvine">Irvine, CA</option>
    <option value="rochester">Rochester, NY</option>
    <option value="waltham">Waltham, MA</option>
    <option value="gainesville">Gainesville, FL</option>
    <option value="chestnuthill">Chestnut Hill, MA</option>
    <option value="williamsburg">Williamsburg, VA</option>
    <option value="davis">Davis, CA</option>
    <option value="lajolla">La Jolla, CA</option>
    <option value="boston">Boston, MA</option>
    <option value="cleveland">Cleveland, OH</option>
    <option value="neworleans">New Orleans, LA</option>
    <option value="malibu">Malibu, CA</option>
    <option value="athens">Athens, GA</option>
    <option value="champaign">Champaign, IL</option>
    <option value="troy">Troy, NY</option>
    <option value="austin">Austin, TX</option>
    <option value="madison">Madison, WI</option>
    <option value="villanova">Villanova, PA</option>
    <option value="bethlehem">Bethlehem, PA</option>
    <option value="syracuse">Syracuse, NY</option>
    <option value="coralgables">Coral Gables, FL</option>
    <option value="columbus">Columbus, OH</option>
    <option value="westlafayette">West Lafayette, IN</option>
    <option value="piscataway">Piscataway, NJ</option>
    <option value="universitypark">University Park, PA</option>
    <option value="dallas">Dallas, TX</option>
    <option value="seattle">Seattle, WA</option>
    <option value="worcester">Worcester, MA</option>
    <option value="storrs">Storrs, CT</option>
    <option value="collegepark">College Park, MD</option>
    <option value="provo">Provo, UT</option>
    <option value="clemson">Clemson, SC</option>
    <option value="collegestation">College Station, TX</option>
    <option value="tallahassee">Tallahassee, FL</option>
    <option value="hoboken">Hoboken, NJ</option>
    <option value="santacruz">Santa Cruz, CA</option>
    <option value="amherst">Amherst, MA</option>
    <option value="minneapolis">Minneapolis, MN</option>
    <option value="blacksburg">Blacksburg, VA</option>
    <option value="champaign">Champaign, CA</option>
    <option value="waco">Waco, TX</option>
    <option value="binghamton">Binghamton, NY</option>
    <option value="golden">Golden, CO</option>
    <option value="raleigh">Raleigh, NC</option>
    <option value="stonybrook">Stony Brook, NY</option>
    <option value="fortworth">Fort Worth, TX</option>
    <option value="eastlansing">East Lansing, MI</option>
    <option value="riverside">Riverside, CA</option>
    <option value="sandiego">San Diego, CA</option>
    <option value="bloomington">Bloomington, IN</option>
    <option value="milwaukee">Milwaukee, WI</option>
    <option value="buffalo">Buffalo, NY</option>
    <option value="newarkde">Newark, DE</option>
    <option value="iowacity">Iowa City, IA</option>
    <option value="oxford">Oxford, OH</option>
    <option value="boulder">Boulder, CO</option>
    <option value="denver">Denver, CO</option>
    <option value="sanfrancisco">San Francisco, CA</option>
    <option value="burlington">Burlington, VT</option>
    <option value="potsdam">Potsdam, NY</option>
    <option value="eugene">Eugene, OR</option>
    <option value="newarknj">Newark, NJ</option>
    <option value="tucson">Tucson, AZ</option>
    <option value="columbia">Columbia, SC</option>
    <option value="stockton">Stockton, CA</option>
    <option value="tulsa">Tulsa, OK</option>
    <option value="tempe">Temp, AZ</option>
    <option value="auburn">Auburn, AL</option>
    <option value="knoxville">Knoxville, TN</option>
    <option value="ames">Ames, OH</option>
    <option value="saltlakecity">Salt Lake City, UT</option>
</form:select>
<br><br>
<p>*Your age</p>
<form:input path="age" type="number" name="age" placeholder="Enter age"></form:input>
<br><br>
<input type="submit" name="_eventId_cancel" value="Cancel">
<input type="submit" name="_eventId_submit" id="validate" value="Next">

</form:form>
</div>
</body>
</html>