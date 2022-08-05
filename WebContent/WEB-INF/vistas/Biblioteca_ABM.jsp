<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca ABM</title>
</head>
<%@include file="Decoraciones/librerias.jsp" %>
<%@include file="Decoraciones/header.jsp" %>


<body>


<script>



$( document ).ready(function() {
	
	
	if(!$("#formBiblioteca").attr('action').includes("Biblioteca_Modificar"))
		{
			var ISBN = $( "#cboLibros" ).val();
			$( "#txtLibro" ).val(ISBN);
			
			var today = new Date();
			var dd = String(today.getDate()).padStart(2, '0');
			var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
			var yyyy = today.getFullYear();

			today = dd  + '-' + mm + '-' + yyyy;
					
		
			
			$("#dateFecha").val(today);
		}
	
});

function CambiarValor()
{
	
	var ISBN = $( "#cboLibros" ).val();
	$( "#txtLibro" ).val(ISBN);
	
}



</script>

	<div class="row justify-content-center   ">
 
   <div class="col-10 mt-2 rounded border bg-light ">
 
	 <div class="row">
	 
	 
	     <div class="col-12 mt-2">
	     
	     <% 
	  	
	    String titulo= "Agregar";
	    String Action ="Biblioteca_Alta.html";
	    if(request.getParameter("btnAgregar")==null) 
	    {
	    	Integer idBiblioteca = (Integer) request.getAttribute("idBiblioteca");
	    	titulo = "Editar";
		    Action = "Biblioteca_Modificar.html?idBiblioteca=" + idBiblioteca;
	    	
	    }
	    %>
	     
	     	<h2 class="font-weight-bold text-center text-info"> <%=titulo %> Libro en biblioteca ${idBiblioteca} </h2>
	     	
	     	
	     </div>
	 
	     <div class="col-12 mt-2">
	     
	      <div class="col-12 mt-2">
     	<label class="font-weight-bold text-center text-danger  "> 
     	${ErrorMsj}    
     	</label>
     </div>

<form id="formBiblioteca" action="<%=Action %>" method="post" >
  <div class="form-row justify-content-center">
    <div class="form-group col-md-2">
      <label class="form-label" for="txtLibro">ISBN Libro</label>
      <input type="text" class="form-control" name="txtLibro" id="txtLibro" placeholder="ISBN" value=${ISBN} required readOnly>
    </div>
    
     <div class="form-group col-md-4">
    
      <label for="cboLibros">Libro</label>
      
    
     <select name="cboLibros" id="cboLibros" class="form-control" onchange="CambiarValor()">
     
<c:forEach var="dato" items="${LibrosLista}"  varStatus="itemLoop">

 
<c:choose>
	<c:when test="${empty ISBN }">
		<option value="${dato.getISBN()}" > ${dato.getTitulo()}  </option>
	 </c:when>
  	<c:otherwise>

			
 		<c:choose>
 			
		<c:when test="${ISBN eq dato.getISBN() }">
			<option value="${dato.getISBN()}" selected> ${dato.getTitulo()}  </option>
		 </c:when>
	  	<c:otherwise>
					<option value="${dato.getISBN()}" > ${dato.getTitulo()}  </option>
		</c:otherwise> 
		</c:choose>

	</c:otherwise> 
</c:choose>


</c:forEach>

</select> 

      
    </div>
    
    <div class="form-group col-md-2">
      <label class="form-label" for="dateFecha">Fecha de alta</label>
      <input type="date" class="form-control" name="dateFecha" id="dateFecha" value="${fecha}" required>
    </div>
   </div>
   
    <div class="form-row justify-content-center  ">

     <div class="form-group col-md-4 text-right">
     <a href="Biblioteca_Grilla.html" class="btn btn-danger">Cancelar</a>
  </div>
   <div class="form-group col-md-4  ">
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