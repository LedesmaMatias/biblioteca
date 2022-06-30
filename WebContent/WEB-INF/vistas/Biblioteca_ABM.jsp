<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca ABM</title>
</head>
<%@include file="Decoraciones/librerias.jsp" %>
<%@include file="Decoraciones/header.jsp" %>
<body>
	<div class="row justify-content-center   ">
 
   <div class="col-10 mt-2 rounded border bg-light ">
 
	 <div class="row">
	 
	 
	     <div class="col-12 mt-2">
	     
	     	<h2 class="font-weight-bold text-center text-info"> Libros en biblioteca </h2>
	     	
	     	
	     </div>
	 
	     <div class="col-12 mt-2">
	     
	      <div class="col-12 mt-2">
     	<label class="font-weight-bold text-center text-danger  "> 
     	${ErroMsj}    
     	</label>
     </div>
	     
<form action="" method="get" >
  <div class="form-row justify-content-center">
    <div class="form-group col-md-4">
      <label for="txtLibro">ISBN Libro</label>
      <input type="text" class="form-control" name="txtLibro" placeholder="ISBN">
    </div>
    <div class="form-group col-md-4">
      <label for="dateFecha">Fecha de alta</label>
      <input type="date" class="form-control" name="dateFecha">
    </div>
   </div>
   
    <div class="form-row justify-content-center">

     <div class="form-group col-md-4">
     <button type="submit" class="btn btn-danger ">Cancelar</button>
  </div>
   <div class="form-group col-md-4">
    <button type="submit" class="btn btn-primary">Aceptar</button>
  </div>

   </div>
   
 
  
</form>

         
	     
	     </div>
	     
		 </div>
	</div>

 </div>

<%@include file="Decoraciones/Footer.jsp" %>
</body>
</html>