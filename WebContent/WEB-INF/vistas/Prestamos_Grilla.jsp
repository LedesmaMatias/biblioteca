<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prestamos Grilla</title>
</head>
<body>

<%@include file="Decoraciones/librerias.jsp" %>
<%@include file="Decoraciones/header.jsp" %>

	<div class="row justify-content-center">
		<div class="col-10 mt-2 rounded border bg-light">
			<div class="row">
				<div class="col-12 mt-2">
					<h2 class="font-weight-bold text-center text-info"> Prestamos </h2>
				</div>
				<div class="col-12 mt-2">
				<label class="font-weight-bold text-center text-success  "> 
			    	${ErrorMsj}    
			    	</label>
				</div>
				<div class="col-12 mt-2">
					<div class="col-12 mt-2 mb-3">
					<div class="form-group col-md-2 mt-4 text-right">
						<a href="Prestamos_ABM.html?btnAgregar=true"  class="btn btn-success" >Agregar nuevo prestamo</a>
						</div>
						<div class="bg-white border table-responsive table-striped">
							<table class="table">
								<thead>
									<tr class="text-info">
										<th>ID Prestamo</th>
										<th>ID Cliente</th>
										<th>Libro en Biblioteca</th>
										<th>Fecha del prestamo</th>
										<th>Cantidad de dias</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
								
								<c:forEach var="dato" items="${lista}">
								
								<tr>
									<td>${dato.getId()}</td>
									<td>${dato.getCliente().getId()}
									<td>${dato.getBiblioteca().getId()}</td>
									<td>${dato.getFechaPrestamo()}</td>
									<td>${dato.getCantDias()}</td>
									<td>
										<a href="Prestamos_ABM_Modificar.html?idPrestamo=${dato.getId()}" class="btn btn-success"><i class="fas fa-edit"></i></a>
                   						<a href="Prestamos_Baja.html?idPrestamo=${dato.getId()}" class="btn btn-danger"><i class="far fa-trash-alt"></i></a>
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