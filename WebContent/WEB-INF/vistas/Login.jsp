<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<%@include file="Decoraciones/librerias.jsp" %>


 <nav class="bg-info navbar navbar-dark navbar-expand-lg">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto text-white text-center m-auto">
    <div class="text-center "> <label>  Sistema Biblioteca Grupo 5 </label></div>
    
    </ul>
    
    
    
   
  </div>
</nav>


<body>
	<div class="row justify-content-center">
	
	
	
	
		<div class="col-6 mt-4 rounded border bg-light">
			<div class="row">
			<div class="col-12 mt-2">
			<h2 class=" font-weight-bold text-center text-info"> Iniciar Sesion</h2>
		<div class="col-6 mt-2">
     	<label class="font-weight-bold text-center text-danger  "> 
     	${ErrorMsj}    
     	</label>
     </div>
     
		<form  action="ValidarLogin.html" method="get">
			<div class="text-center">
				<input type="text" name="txtUser" class="mb-3 form-control" placeholder="Ingrese su usuario" required>
			</div>
			<div style="text-align: center;">
				<input type="password" name="txtPass" class="mb-3 form-control" placeholder="Ingrese su contraseña" required>
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