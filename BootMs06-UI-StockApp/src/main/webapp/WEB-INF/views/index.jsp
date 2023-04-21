<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Application</title>
</head>
<body>
	<h3 style="text-align: center; color: red">Stock Application</h3>
	<form  style="justify-content: center;display: flex;" action="getTotalPrice">
		<table>
			<tr>
			<td>Companay Name ::  </td>
			<td><input type="text" name="companyName"/> </td>
			</tr>
			<tr>
			<td>Stock Quantity ::  </td>
			<td><input type="text" name="quantity"/> </td>
			</tr>
				<tr>
			<td><input type="submit" name="Get Total"/> </td>
			</tr>
		</table>
	</form>
	
	<h3 style="text-align: center;color:cyan; ">${msg }</h3>
</body>
</html>