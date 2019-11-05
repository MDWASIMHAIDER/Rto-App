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
		$('form[id="vechileId"]').validate({
			rules : {
				vechileType : 'required',
				mfgYear : 'required',
				vechileBrand : 'required'
			},
			messages : {
				vechileType : 'Please enter Vechile Type',
				mfgYear : 'please enter year',
				vechileBrand : 'Please enter brand'
				
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
<h1 style="text-align: center;background-color:black;color:white;">Vechile Details</h1>

	<form:form modelAttribute="vdcmd" method="POST" action="vechiledtl" id="vechileId">
		<table style="border:1">
			
			<tr>
				<td><form:hidden path="vechile_Id"/></td>
				<td><form:hidden path="vechile_Owner_Id"/></td>
			</tr>
			<tr>
				<td>Vechile-Type</td>
				<td><form:input path="vechileType"/></td>
			</tr>
			<tr>
				<td>Manufacturing Year</td>
				<td><form:input path="mfgYear"/></td>
			</tr>
			<tr>
				<td>Vechile-Brand</td>
				<td><form:input path="vechileBrand"/></td>
			</tr>
			<tr colspan="2">
				<td></td>
				<td>
				<a href="/addressss/loadAddress?addressId=${addressId}">previous</a>
				<%-- <input type="submit" name="altSubmit" formaction="/addressss/loadAddress?addressId=${addressId}" value="previous"/> --%>
				<input type="submit"  name="_target2"  value="next">
           	    </td>
           	 </tr>
		
		</table>
	</form:form>
	</div>
</body>
</html>