<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				</div>
				<div class="col-12 mt-2">
					<div class="col-12 mt-2 mb-3">
						<div class="bg-white border table-responsive table-striped">
							<table class="table">
								<thead>
									<tr class="text-info">
										<th>ID</th>
										<th>Biblioteca</th>
										<th>Fecha del prestamo</th>
										<th>Cantidad de dias</th>
										<th>Cliente</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>2</td>
										<td>27/06/2022</td>
										<td>10</td>
										<td>3</td>
										<td>
											<button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
                    						<button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
										</td>
									</tr>
									<tr>
										<td>2</td>
										<td>3</td>
										<td>03/07/2022</td>
										<td>15</td>
										<td>1</td>
										<td>
											<button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
                    						<button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
										</td>
									</tr>
									<tr>
										<td>3</td>
										<td>2</td>
										<td>01/07/2022</td>
										<td>20</td>
										<td>2</td>
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