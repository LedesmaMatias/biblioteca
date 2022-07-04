<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row justify-content-center   ">
 
   <div class="col-10 mt-2 rounded border bg-light ">
 
	 <div class="row">
	 
	 
	     <div class="col-12 mt-2">
	     
	     	<h2 class="font-weight-bold text-center text-info"> Agregar Prestamo </h2>
	     	
	     	
	     </div>
	 
	     
<form action="" method="get" >
  <div class="form-row justify-content-center">
    <div class="form-group col-md-4">
    	<label for="cboIDBiblioteca">Biblioteca</label>
        <select name="cboIDBiblioteca" class="form-control">
        	<option value="1">1</option>
        	<option value="2">2</option>
        	<option value="3">3</option>
		</select>
    </div>
    <div class="form-group col-md-4">
      <label for="dateFecha">Fecha de Prestamo</label>
      <input type="date" class="form-control" name="dateFecha">
    </div>
   </div>
   <div class="form-group col-md-4">
      <label for="cantDias">Cantidad de dias</label>
      <input type="text" class="form-control" name="txtLibro" placeholder="ISBN"/>
    </div>
    <div class="form-group col-md-4">
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
   
 
  
</form>

         
	     
	     </div>
	     
		 </div>
	</div>

 </div>

<%@include file="Decoraciones/Footer.jsp" %>
</body>
</html>