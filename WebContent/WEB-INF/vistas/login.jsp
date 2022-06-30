<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<%@include file="Decoraciones/librerias.jsp" %>
<%@include file="Decoraciones/header.jsp" %>
<body>
	<div class="row justify-content-center">
		<div class="col-6 mt-4 rounded border bg-light">
			<div class="row">
			<div class="col-12 mt-2">
			<h2 class=" font-weight-bold text-center text-info"> Iniciar Sesion</h2>
		<form  action="" method="get">
			<div class="text-center">
				<input type="text" name="txtUser" class="mb-3 form-control" placeholder="Ingrese su usuario">
			</div>
			<div style="text-align: center;">
				<input type="password" name="txtUser" class="mb-3 form-control" placeholder="Ingrese su contraseña">
			</div>
			<div class="text-center">
				<button type="submit" class="mb-3 btn btn-success">Aceptar</button>
			</div>
		</form>
		
			</div>
			</div>
		</div>
	</div>

<%@include file="Decoraciones/Footer.jsp" %>
</body>
</html>