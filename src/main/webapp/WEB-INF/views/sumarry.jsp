<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <style type="text/css">
	table:{
		border: none;
	}
	tr:nth-child(even) {
  background-color: cyan;
}
tr:nth-child(odd) {
  background-color: pink;
}
</style> -->
</head>
<body style="background-color:#DAF7A6;">
	<h1 style="text-align: center;background-color:black;color:white;">Summary Details</h1>
	<form:form modelAttribute="ownercmd" action="resultpage" method="POST" id="vform">
		<table>
		
			<tr>
				<td colspan="2"><h1>Owner Details</h1></td>
				
			</tr>
		
			<tr>
				<td>First-Name</td>
				<td>${owner.firstName}</td>
			</tr>
			<tr>
				<td>Last-Name</td>
				<td>${owner.lastName}</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>${owner.gender}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${owner.email}</td>
			</tr>
			<tr>
				<td>Phone</td>
				<td>${owner.phone}</td>
			</tr>
			<tr>
				<td>Dob</td>
				<td>${owner.dob}</td>
			</tr>
			<tr>
				<td>Create Date</td>
				<td>${owner.create_Date}</td>
			</tr>
			<tr>
				<td>Update Date</td>
				<td>${owner.update_Date}</td>
			</tr>
	
	
			<tr>
				<td colspan="2"><h1>Address Details</h1></td>
				
			</tr>
	
			<tr>
				<td>Home No</td>
				<td>${address.homeno}</td>
			</tr>
			<tr>
				<td>Street-Name</td>
				<td>${address.streetName}</td>
			</tr>
			<tr>
				<td>city</td>
				<td>${address.city}</td>
			</tr>
			<tr>
				<td>Zip-Code</td>
				<td>${address.zipCode}</td>
			</tr>
			<tr>
				<td>Create Date</td>
				<td>${address.create_Date}</td>
			</tr>
			<tr>
				<td>Update Date</td>
				<td>${address.update_Date}</td>
			</tr>
			
	
	
	
	
			<tr>
				<td colspan="2"><h1>Vechile Details</h1></td>
				
			</tr>
	
			<tr>
				<td>Vechile-Type</td>
				<td>${vechile.vechileType}</td>
			</tr>
			<tr>
				<td>Manufacturing Year</td>
				<td>${vechile.mfgYear}</td>
			</tr>
			<tr>
				<td>Vechile-Brand</td>
				<td>${vechile.vechileBrand}</td>
			</tr>
			<tr>
				<td>Create Date</td>
				<td>${vechile.create_Date}</td>
			</tr>
			<tr>
				<td>Update Date</td>
				<td>${vechile.update_Date}</td>
			</tr>
			
	
	
	
			<tr>
				<td colspan="2"><h1>Registration Details</h1></td>
				
			</tr>

			<tr>
				<td>Registration Center</td>
				<td>${registration.reg_center}</td>
			</tr>
			<tr>
				<td>Registration Id</td>
				<td>${registration.vechile_Reg_Id}</td>
			</tr>
			<tr>
				<td>Registration Date</td>
				<td>${registration.reg_Date}</td>
			</tr>
			
			<tr>
				<td> Create Date</td>
				<td>${registration.create_Date}</td>
			</tr>
			
			<tr>
				<td> Update Date</td>
				<td>${registration.update_Date}</td>
			</tr>
			<tr>
				<td> Registration Number</td>
				<td>${registration.vechile_Reg_Num}</td>
			</tr>
			<tr>
				<td><input type="submit"  value="Submit"></td>
				
           	 </tr>
		</table>
	</form:form>
</body>
</html>