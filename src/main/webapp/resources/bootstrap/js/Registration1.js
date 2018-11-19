$(document).ready(function() {
	$('#validate').click(function(e) {
		var fullmame = document.forms["myForm"]["fullname"].value;
		if (fullname == null || fullname =="") {
		  alert("Full name must be filled out");
		  e.preventDefault;
		  return false;
		  } 
	
		var email = document.forms["myForm"]["email"].value;
		if (email == null || email == "")
		  {
		  alert("Email must be filled out");
		  e.preventDefault;
		  return false;
		  }
		
		var reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	    if (!reg.test(String(email).toLowerCase()))
	    	{
	    	alert("Email not valid");
			  e.preventDefault;
			  return false;
	    	}
	
		var pword = document.getElementById("pword").value;;
		if (pword == null || pword =="") {
		  alert("Password name must be filled out");
		  e.preventDefault;
		  return false;
		}
		
		var confirm = document.forms["myForm"]["confirm_pword"].value;
		if (confirm == null || confirm =="") {
		  alert("Password confirmation must be filled out");
		  e.preventDefault;
		  return false;
		}
		
		if (pword != confirm) {
			alert("Passwords don't correspond");
			e.preventDefault;
			return false;
		}
		
		var age = document.forms["myForm"]["age"].value;
		console.log(age);
		if (age == null || age == "") {
		  alert("age must be filled out");
		  e.preventDefault;
		  return false;
		}
	});
});