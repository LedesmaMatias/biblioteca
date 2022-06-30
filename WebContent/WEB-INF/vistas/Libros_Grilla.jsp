<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libros grilla</title>
</head>
<body>

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
									<tr>
										<td>1</td>
										<td>Instinto animal</td>
										<td>Rojo, Alfonso</td>
										<td>Español</td>
										<td>26/10/1998</td>
										<td>345</td>
										<td>policial</td>
										
									</tr>
									<tr>
										<td>2</td>
										<td>Estudio en escarlata</td>
										<td>Conan Doyle, Arthur</td>
										<td>Español</td>
										<td>26/11/1887</td>
										<td>185</td>
										<td>policial</td>
										
									</tr>
									<tr>
										<td>3</td>
										<td>El ultimo deseo</td>
										<td>sapkowski, Andrzej</td>
										<td>Español</td>
										<td>26/4/2002</td>
										<td>286</td>
										<td>fantasia</td>
										
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