
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca Grilla</title>
</head>
<body>

<%@include file="Decoraciones/librerias.jsp" %>
<%@include file="Decoraciones/header.jsp" %>

	<div class="row justify-content-center">
		<div class="col-10 mt-2 rounded border bg-light">
			<div class="row">
				<div class="col-12 mt-2">
					<h2 class="font-weight-bold text-center text-info"> Libros en biblioteca </h2>
				</div>
				<div class="col-12 mt-2">
			    	<label class="font-weight-bold text-center text-success  "> 
			    	${ErrorMsj}    
			    	</label>
			    </div>
				
				<div class="col-12 mt-2">
					<div>
						<form action="Biblioteca_Obtener_Grilla.html" method="get" class="w-100">
						<div class="form-row">
							<div class="form-group col-md-2 ml-4">
								<label for="ddlLibro">Estado de libro </label>
								<select class="form-control" id="ddlLibro">
								    <option>Seleccionar estado</option>
								    <option>Todos</option>
								    <option>En biblioteca</option> 
								    <option>Prestados</option> 
								</select>
							</div>
							<div class="form-group mt-4">
								<button type="submit" class="btn btn-success">Mostrar</button>
							</div>
							<div class="form-group col-md-4 mt-4">
								<a href="Biblioteca_ABM.html?btnAgregar=true" class="btn btn-success">Agregar libro en biblioteca</a>
							</div>
						</div>
					</form>
					</div>
					<div class="col-12 mt-2 mb-3">
						<div class="bg-white border table-responsive table-striped">
							<table class="table">
								<thead>
									<tr class="text-info">
										<th>ID</th>
										<th>Libro</th>
										<th>Fecha de alta</th>
										<th>Estado</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									
									<c:forEach var="dato" items="${lista}" >
									<tr>
										<td>${dato.getId()}</td>
										<td>${dato.getLibro().getTitulo()}</td>
										<td>${dato.getFechaAlta()}</td>
										<td>
										<c:choose>
											<c:when test="${dato.getEstado()==1}">
												En biblioteca
											</c:when>
											<c:otherwise>
												Prestado
											</c:otherwise>
										</c:choose>
										</td>
										<td>
											<a href="Biblioteca_ABM_Modificar.html?idBiblioteca=${dato.getId()}" class="btn btn-success"><i class="fas fa-edit"></i></a>
                    						<a href="Biblioteca_Baja.html?idBiblioteca=${dato.getId()}" class="btn btn-danger"><i class="far fa-trash-alt"></i></a>
                   						</td>
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