<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
<title>ROOMMATE FINDER</title>
<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/filter_search_style.css">
<div id="background">
<h2>Look for a roommate</h2>
<p><strong>*Required fields</strong><p> 
<h2 align="right"><a href="profile" style="color:red">User Profile</a></h2>
<h2 align="right"><a href="logout" style="color:red">Sign Out</a></h2>
<div class="loginbox">
<img src="resources/avatar.png" class="avatar">
<form:form action="filter_search_index" method="post" modelAttribute="searchForm">
<p>*Gender</p>
<form:select path="gender">
    <option value="male">Male</option>
    <option value="female">Female</option>
    <option value="other">Other</option>
</form:select>

<br><br>
<p>*City, State</p>
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

<p>*The person's age range</p>
<form:select path="agerange">
    <option value="18-28">18-28</option>
    <option value="29-39">29-39</option>
    <option value="40-50">40-50</option>
    <option value="51-65">51-60</option>
    <option value="65+">60+</option>
</form:select>
<br><br>

<p>*Their Pets</p>
<form:select name="Pets" path="pets">
  <option value="cat">Cat</option>
  <option value="dog">Dog</option>
  <option value="none">None</option>
</form:select>
<br><br>

<p>*Their drinking habbit</p>
<form:select path="drinking">
    <option value="frequently">Frequently</option>
    <option value="occasionally">Occasionally</option>
    <option value="never">Never</option>
</form:select>
<br><br>

<p>*Their smoking habits</p>
<form:select path="smoking">
    <option value="frequently">Frequently</option>
    <option value="occasionally">Occasionally</option>
    <option value="never">Never</option>
</form:select>
<br><br>

<p>*Their ideal room price range</p>
<form:select path="idealroomprice">
    <option value="$800-$1200">$800-$1200</option>
    <option value="$1200-$1600">$1200-$1600</option>
    <option value="$1600-$2000">$1600-$2000</option>
	<option value="$2000-$2400">$2000-$2400</option>
</form:select>
<br><br>

<p>*Number of roommates they wish to live with</p>
<form:select path="numberofroommates">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
	<option value="4+">4+</option>
</form:select>
<br><br>
<input type="submit" name="" value="Search"><br>
<a href="logout">Sign Out</a>
</form:form>
</div>
</div>
</body>
</html>