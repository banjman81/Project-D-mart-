<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Eczar:wght@500&family=Fira+Sans&family=Pirata+One&display=swap" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="mainBg">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="text-danger text-center rounded">
		  		<a class="text-light btn" href="/"><h1 class="text-danger titleFont m-0">D-Mart</h1></a>
		  	</div>
		</nav>
		<h1 class="container titleFont text-light text-center my-5">Login</h1>
		<div class="container">
			<form method="POST" action="/loguser">
				<table class="mx-auto my-3 tablebg">
					<tbody><tr>
						<td class="p-3 pt-4"><label for="email"><h5>Email:</h5></label></td>
						<td class="p-3"><input type="text" id="email" name="email">
					</td></tr>
					<tr>
						<td colspan="2" class="text-center text-danger"><h5></h5></td>
					</tr>
					<tr>
						<td class="p-3 pt-4"><label for="password"><h5>Password:</h5></label></td>
						<td class="p-3"><input type="password" id="password" name="password">
					</td></tr>
					<tr class="text-center">
						<td colspan="2" class="p-n3"><h6 class="text-center text-danger">${login_error} ${no_email}</h6></td>
					</tr>
					<tr class="text-center">
						<td colspan="2" class="p-3"><input class="col-8 btn btn-primary" type="submit" value="Login"></td>
					</tr>
				</tbody></table>
			</form>
			<h5 class="text-center text-danger"></h5>
		</div>
	</div>
</body>
</html>