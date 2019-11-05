<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IND-RTO</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
<script>
$(function() {
		$('form[id="regId"]').validate({
			rules : {
				reg_center : 'required'
			},
			messages : {
				reg_center : 'Please enter center'
				
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
	<!-- <h1><a href="user">Home</a></h1> -->
	<h1 style="text-align: center;background-color:black;color:white;">Vechile Center Detail</h1>
	<form:form modelAttribute="rgcmd" method="POST" action="register" id="regId">
		<table style="border:1">
			<tr>
				<td>Registration Center</td>
				<td><form:input path="reg_center"/></td>
			</tr>
			<tr>
			<td></td>
				<%-- <td><input type="submit" name="altSubmit" formaction="/vechiles/loadVechile?vechileId=${vechileId}" value="previous"/> --%>
				<td><a href="/vechiles/loadVechile1?vechileId=${vechileId}">previous</a>
				<input type="submit"  value="Submit"></td>
           	 </tr>
		</table>
	</form:form>
	</div>
</body>
</html>