<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libros grilla</title>
</head>
<body>

<script>

function limpiarbusqueda() {  
	  
	  
	 alert ("busqueda limpia");  
	 $('#txtNombre').val(""); 
	 $('#txtApellido').val(""); 
	 $('#txtDNI').val(""); 
 } 
</script>

<%@include file="Decoraciones/librerias.jsp" %>
<%@include file="Decoraciones/header.jsp" %>

	<div class="row justify-content-center">
		<div class="col-10 mt-2 rounded border bg-light">
			<div class="row">
				<div class="col-12 mt-2">
					<h2 class="font-weight-bold text-center text-info"> Libros </h2>
				</div>
				<div class="col-12 mt-2">
				</div>
				<div class="col-12 mt-2">
				
				 <div class="form-row">
		    
  <form  action="Libros_Grilla.html" method="get" class=" w-100" >	
  
   <div class="form-row">
     
    <div class="form-group col-md-2">
      <label for="txtNombre">ISBN</label>
      <input type="text" class="form-control" name="txtISBN" id="txtISBN" placeholder="ISBN" value="${txtISBN}">
    </div>
    <div class="form-group col-md-2">
      <label for="txtApellido">Titulo</label>
      <input type="text" class="form-control" name="txtTitulo" id="txtTitulo" placeholder="Titulo" value="${txtTitulo}">
    </div>
         
      <div class="form-group col-md-2 mt-4 pt-1">      
         
         <button type="submit" class="btn btn-success "> <i class="fas fa-search"></i> Buscar </button>
         <button type="button"  class="btn btn-success " id="Limpiar" onclick="limpiarbusqueda();" > <i class="fas clean"></i>  Limpiar </button>
    </div>
    </div>	
    </form>
    
  
    
  
				
					<div class="col-12 mt-2 mb-3">
						<div class="bg-white border table-responsive table-striped">
							<table class="table">
								<thead>
									<tr class="text-info">
										<th>ISBN</th>
										<th>Titulo</th>
										<th>Autor</th>
										<th>Idioma</th>
										<th>Fecha de lanzamiento</th>
										<th>Cantidad de paginas</th>
										<th>Generos</th>
									</tr>
								</thead>
								<tbody>
								
    
                <c:forEach var="dato" items="${lista}" >
                  <tr>
                    <td>${dato.getISBN()}</td>
                    <td>${dato.getTitulo()}</td>
                    <td>${dato.getAutor().nombre} ${dato.getAutor().apellido}</td>
                    <td>${dato.getIdioma()}</td>
                    <td>${dato.getFechaLanzamiento()}</td>
                    <td>${dato.getCantPaginas()}</td>
                    
                 <td>genero no anda</td>
                   
                    
                  </tr>
                </c:forEach>   

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<%@include file="Decoraciones/Footer.jsp" %>

</body>
</html>