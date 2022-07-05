<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prestamos Alta</title>
</head>
<body>
<%@include file="Decoraciones/librerias.jsp" %>
<%@include file="Decoraciones/header.jsp" %>
	<div class="row justify-content-center   ">
 
   <div class="col-10 mt-2 rounded border bg-light ">
 
	 <div class="">
	 
	 
	     <div class="col-12 mt-2">
	     
	     	<h2 class="font-weight-bold text-center text-info"> Agregar Prestamo </h2>
	     	
	     	
	     </div>
	 <div class="justify-content-center">
	 <form class="row g-3" action="">
	 	<div class="form-group col-md-6 pt-2">
	 		<label for="cboIDBiblioteca">Biblioteca</label>
        <select name="cboIDBiblioteca" class="form-control">
        	<option value="1">1</option>
        	<option value="2">2</option>
        	<option value="3">3</option>
		</select>
	 	</div>
	 	<div class="form-group col-md-6 pt-2">
	 		<label for="dateFecha">Fecha de Prestamo</label>
      <input type="date" class="form-control" name="dateFecha">
    
	 	</div>
	 	<div class="form-group col-md-2">
	 		<label for="cantDias">Cantidad de dias</label>
      <input type="text" class="form-control" name="txtLibro"/>
   
	 	</div>
	 	<div class="form-group col-md-4">
	 		<label for="cboIDCliente">Cliente</label>
        <select name="cboIDCliente" class="form-control">
        	<option value="1">1</option>
        	<option value="2">2</option>
        	<option value="3">3</option>
		</select>
	 	</div>
	 	<div class="col-md-6">
	 	</div>
	 	
     <div class="form-group col-md-2">
     <button type="submit" class="btn btn-danger ">Cancelar</button>
  </div>
   <div class="form-group col-md-2">
    <button type="submit" class="btn btn-primary">Aceptar</button>
  </div>

	 
	 </form>
	 	</div>
	 
	    <!--   
<form action="" method="get" >
  <div class="justify-content-center">
    <div class="form-group col-9">
    	<label for="cboIDBiblioteca">Biblioteca</label>
        <select name="cboIDBiblioteca" class="form-control">
        	<option value="1">1</option>
        	<option value="2">2</option>
        	<option value="3">3</option>
		</select>
    </div>
    <div class="form-group col-9">
      <label for="dateFecha">Fecha de Prestamo</label>
      <input type="date" class="form-control" name="dateFecha">
    </div>
   </div>
   <div class="form-group col-9">
      <label for="cantDias">Cantidad de dias</label>
      <input type="text" class="form-control" name="txtLibro"/>
    </div>
    <div class="form-group col-9">
    	<label for="cboIDCliente">Cliente</label>
        <select name="cboIDCliente" class="form-control">
        	<option value="1">1</option>
        	<option value="2">2</option>
        	<option value="3">3</option>
		</select>
    </div>
   
   
    <div class="form-row justify-content-center">

     <div class="form-group col-md-4">
     <button type="submit" class="btn btn-danger ">Cancelar</button>
  </div>
   <div class="form-group col-md-4">
    <button type="submit" class="btn btn-primary">Aceptar</button>
  </div>

   </div>
   
 
  
</form> -->

         
	     
	     </div>
	     
		 </div>
	</div>



<%@include file="Decoraciones/Footer.jsp" %>
</body>
</html>