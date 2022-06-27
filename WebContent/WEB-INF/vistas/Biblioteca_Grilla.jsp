<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				</div>
				<div class="col-12 mt-2">
					<form action="Biblioteca_ABM.html" method="get" class="w-100">
						<div class="form-row">
							<div class="form-group col-md-2">
								<label for="ddlLibro">Estado de libro </label>
								<select class="form-control" id="ddlLibro">
								    <option>Seleccionar estado</option> 
								    <option>En biblioteca</option> 
								    <option>Prestado</option> 
								</select>
							</div>
							<div class="form-group col-md-2 mt-4">
								<button type="submit" class="btn btn-success">Mostrar</button>
							</div>
							<div class="form-group col-md-2 mt-4">
								<button type="submit" name="btnAgregar" class="btn btn-success">Agregar libro en biblioteca</button>
							</div>
						</div>
					</form>
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
									<tr>
										<td>1</td>
										<td>Instinto animal</td>
										<td>26/06/2022</td>
										<td>En biblioteca</td>
										<td>
											<button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
                    						<button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
										</td>
									</tr>
									<tr>
										<td>2</td>
										<td>Instinto animal</td>
										<td>23/06/2022</td>
										<td>En biblioteca</td>
										<td>
											<button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
                    						<button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
										</td>
									</tr>
									<tr>
										<td>3</td>
										<td>Instinto animal</td>
										<td>26/06/2022</td>
										<td>Prestado</td>
										<td>
											<button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
                    						<button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
										</td>
									</tr>
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