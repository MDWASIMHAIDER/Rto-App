<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
<script>
$(function() {
		$('form[id="vform"]').validate({
			rules : {
				firstName : 'required',
				lastName : 'required',
				email : {
					required : true,
					email : true,
					maxlength : 20
				},
				gender : 'required',
				phone: 'required',
				dob: 'required'
			},
			messages : {
				firstName : 'Please enter FirstName',
				lastName : 'please enter LastName',
				email : 'Please enter valid email',
				phone : 'please enter phone number',
				gender: 'please enter gender',
				dob: 'please enter date of birth'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  } );
  </script>
<style type="text/css">
	/* table:{
		border: none;
	}
	tr:nth-child(even) {
  background-color: cyan;
}
tr:nth-child(odd) {
  background-color: pink;
  div {
  width: 70px;
  height: 300px;
  border: 1px solid #c3c3c3;
  display: -webkit-flex;
  display: flex;
  -webkit-flex-wrap: wrap;
  flex-wrap: wrap;
  -webkit-align-content: center;
  align-content: center;
} */
   tr > input:{
  	border-radius: 20px;
  }
}
</style>
</head>
<body style="background-color:#DAF7A6;">
	<div style="background-color:#DAF7A6;
	color: black;height:400px;
	width:470px;border-bottom-left-radius: 20px;
	border-radius:20px;margin-left:400px;">
	<h1 style="text-align: center;background-color:black;color:white;">Vechile Owner Detail</h1>
	
	<form:form modelAttribute="ownercmd" action="ownerInfo" method="POST" id="vform">
		<table style="border:1;align-items: center;">
			<tr>
				
				<td><form:hidden path="vechile_Owner_Id"/></td>
			</tr>
			
			<tr>
				<td>First-Name</td>
				<td><form:input path="firstName"/></td>
			</tr><br>
			<tr>
				<td>Last-Name</td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:input path="gender"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><form:input path="phone"/></td>
			</tr>
			<tr>
				<td>Dob</td>
				<td><form:input path="dob" id="datepicker" placeholder="MM/dd/yyy"/></td>
			</tr>
		
			<tr style="column-span:2;">
				<td></td>
				<td><input type="submit"  name="_target1"  value="next"/>
				<input type="submit"  name="_cancel"  value="cancel"/></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>