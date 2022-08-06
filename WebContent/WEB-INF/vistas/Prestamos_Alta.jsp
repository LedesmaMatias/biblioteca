<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prestamos Alta</title>
</head>
<body>




<script>



$( document ).ready(function() {
	
	
	if(!$("#formPrestamo").attr('action').includes("Prestamos_Modificar"))
		{
			var Id = $( "#cboBiblioteca" ).val();
			$( "#txtBiblioteca" ).val(Id);
			
			var IdCliente = $( "#cboClientes" ).val();
			$( "#txtCliente" ).val(IdCliente);
			
			var today = new Date();
			var dd = String(today.getDate()).padStart(2, '0');
			var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
			var yyyy = today.getFullYear();

			today = dd  + '-' + mm + '-' + yyyy;
					
		
			
			$("#dateFecha").val(today);
		}
	
});

function CambiarValorCL()
{
	
	var Id = $( "#cboClientes" ).val();
	$( "#txtCliente" ).val(Id);
	
}

function CambiarValor()
{
	
	var Id = $( "#cboBiblioteca" ).val();
	$( "#txtBiblioteca" ).val(Id);
	
}

</script>

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
	 <form class="row g-3" action="<%=Action%>" id="formPrestamo">
	 	<div class="form-group col-md-2 pt-2">
	 		<label for="txtBiblioteca">ID libro en biblioteca</label>
        <input type="text" class="form-control" name="txtBiblioteca" id="txtBiblioteca" placeholder="ID Biblioteca" value="${idBiblioteca}" required readOnly>
	 	</div>
	 	
	 	<div class="form-group col-md-4 pt-2">
	 		<label for="txtBiblioteca">Libros en biblioteca</label>
      
	 	    
	 	    <select name="cboBiblioteca" id="cboBiblioteca" class="form-control" onchange="CambiarValor()">
     
<c:forEach var="dato" items="${LibrosLista}"  varStatus="itemLoop">

 
<c:choose>
	<c:when test="${empty idBiblioteca }">
		<option value="${dato.getId()}" > ${dato.getId()} - ${dato.getLibro().getTitulo()}  </option>
	 </c:when>
  	<c:otherwise>

			
 		<c:choose>
 			
		<c:when test="${idBiblioteca eq dato.getId() }">
			<option value="${dato.getId()}" selected> ${dato.getId()} - ${dato.getLibro().getTitulo()}  </option>
		 </c:when>
	  	<c:otherwise>
					<option value="${dato.getId()}" > ${dato.getId()} - ${dato.getLibro().getTitulo()}  </option>
		</c:otherwise> 
		</c:choose>

	</c:otherwise> 
</c:choose>


</c:forEach>

</select> 
	 	
	 	</div>
	 	
	 	<div class="form-group col-md-2 pt-2">
	 		<label for="dateFecha">Fecha de Prestamo</label>
      <input type="date" class="form-control" name="dateFecha" id="dateFecha" required>
    
	 	</div>
	 	<div class="form-group col-md-3 pt-2">
	 		<label for="txtDias">Cantidad de dias</label>
      <input type="text" class="form-control" name="txtDias" value="${cantDias}" required/>
   
	 	</div>
	 	<div class="form-group col-md-2 pt-2">
	 		<label for="txtCliente">Cliente</label>
        <input type="text" class="form-control" name="txtCliente" id="txtCliente"placeholder="ID Cliente" value="${idCliente}" required readOnly>
	 	</div>
	 	
	 	<div class="form-group col-md-4 pt-2">
	 		<label for="txtBiblioteca">Clientes</label>
      
	 	    
	 	    <select name="cboClientes" id="cboClientes" class="form-control" onchange="CambiarValorCL()">
     
<c:forEach var="dato" items="${listaClientes}"  varStatus="itemLoop">

 
<c:choose>
	<c:when test="${empty idCliente }">
		<option value="${dato.getId()}" > ${dato.getNombre()}, ${dato.getApellido()} - ${dato.getDNI() }</option>
	 </c:when>
  	<c:otherwise>

			
 		<c:choose>
 			
		<c:when test="${idCliente eq dato.getId() }">
			<option value="${dato.getId()}" selected> ${dato.getNombre()}, ${dato.getApellido()} -  ${dato.getDNI() }</option>
		 </c:when>
	  	<c:otherwise>
					<option value="${dato.getId()}" > ${dato.getNombre()}, ${dato.getApellido()} -  ${dato.getDNI()}</option>
		</c:otherwise> 
		</c:choose>

	</c:otherwise> 
</c:choose>


</c:forEach>

</select> 
	 	
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