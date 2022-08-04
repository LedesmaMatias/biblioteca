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
	     
	     <% 
	  	
	    String titulo= "Agregar";
	    String Action ="Prestamos_Alta.html";
	    if(request.getParameter("btnAgregar")==null) 
	    {
	    	Integer idPrestamo = (Integer) request.getAttribute("idPrestamo");
	    	titulo = "Editar";
		    Action = "Prestamos_Modificar.html?idPrestamo=" + idPrestamo;
	    	
	    }
	    %>
	     
	     	<h2 class="font-weight-bold text-center text-info"> Agregar Prestamo </h2>
	     	<label class="font-weight-bold text-center text-danger  "> 
     	${ErrorMsj}    
     	</label>
	     	
	     </div>
	 <div class="justify-content-center">
	 <form class="row g-3" action="<%=Action%>">
	 	<div class="form-group col-md-6 pt-2">
	 		<label for="txtBiblioteca">ID libro en biblioteca</label>
        <input type="text" class="form-control" name="txtBiblioteca" placeholder="ID Biblioteca" value="${idBiblioteca}" required>
	 	</div>
	 	<div class="form-group col-md-6 pt-2">
	 		<label for="dateFecha">Fecha de Prestamo</label>
      <input type="date" class="form-control" name="dateFecha" required>
    
	 	</div>
	 	<div class="form-group col-md-2">
	 		<label for="txtDias">Cantidad de dias</label>
      <input type="text" class="form-control" name="txtDias" value="${cantDias}" required/>
   
	 	</div>
	 	<div class="form-group col-md-4">
	 		<label for="txtCliente">Cliente</label>
        <input type="text" class="form-control" name="txtCliente" placeholder="ID Cliente" value="${idCliente}" required>
	 	</div>
	 	<div class="col-md-6">
	 	</div>
	 	
     <div class="form-group col-md-2">
     <a href="Prestamos_Grilla.html" class="btn btn-danger">Cancelar</a>
  </div>
   <div class="form-group col-md-2">
    <button type="submit" class="btn btn-primary">Aceptar</button>
  </div>

	 
	 </form>
	 	</div>
	 
	    

         
	     
	     </div>
	     
		 </div>
	</div>



<%@include file="Decoraciones/Footer.jsp" %>
</body>
</html>