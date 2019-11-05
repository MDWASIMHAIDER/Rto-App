<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
		$('form[id="addressId"]').validate({
			rules : {
				homeno : 'required',
				streetName : 'required',
				city : 'required',
				zipCode: 'required'
			},
			messages : {
				homeno : 'Please enter home number',
				streetName : 'please enter street Number',
				city : 'Please enter city name',
				zipCode : 'please enter zip code',
		},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
				
</head>

<body style="background-color:#DAF7A6;">

<div style="background-color:#DAF7A6;
	color: black;height:400px;
	width:450px;border-bottom-left-radius: 20px;
	border-radius:20px;margin-left:400px;">
	<h1 style="text-align: center;background-color:black;color:white;">Vechile Owner Address Detail</h1>
	
	<form:form  modelAttribute="addresscmd" method="POST" action="ownerdetail" id="addressId">
		<table style="border:1">
			
			<tr>
				<td><form:hidden path="address_id"/></td>
				<td><form:hidden path="vechile_Owner_Id"/></td>
			</tr>
			<tr>
				<td>Home No</td>
				<td><form:input path="homeno"/></td>
			</tr>
			<tr>
				<td>Street-Name</td>
				<td><form:input path="streetName"/></td>
			</tr>
			<tr>
				<td>city</td>
				<td><form:input path="city"/></td>
			</tr>
			<tr>
				<td>Zip-Code</td>
				<td><form:input path="zipCode"/></td>
			</tr>
			<tr >
				<td></td>
				<td colspan="2" align="left">
					<a href="/owneres/ownerForm1?oid=${oid}">privious</a>
					<input type="submit" name="nextSubmit" value="Next"/>
					<%-- <input type="submit"  formaction="/owneres/ownerForm?oid=${oid}" value="previous"/> --%>
			
				</td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>