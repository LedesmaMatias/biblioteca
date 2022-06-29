
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes Grilla</title>

</head>

<%@include file="Decoraciones/librerias.jsp" %>
<%@include file="Decoraciones/header.jsp" %>



 <div class="row justify-content-center   ">
 
   <div class="col-10 mt-2 rounded border bg-light ">
 
 <div class="row">
 
 
     <div class="col-12 mt-2">
     	<h2 class="font-weight-bold text-center text-info"> Clientes </h2>
     </div>
     
       <% 
       //No sirve no le den bola
	    String clase_estilo = "text-succses";
       	String Msj = "";
       	
	    if(request.getParameter("hdErrorCodigo")!=null) 
	    {
	    	 if(request.getParameter("hdErrorCodigo") != "0") 
	 	    {
	    		clase_estilo = "Danger";
	    		Msj = request.getParameter("hdErrorCodigo");
	 	    }
	    	 
	    }
	    
	    %>
	    
	    
     
   <div class="col-12 mt-2">
     	<label class="font-weight-bold text-center text-success  "> 
     	${ErroMsj}    
     	</label>
     </div>
     
     
     <div class="col-12 mt-2">
    
  <form  action="Clientes_Grilla.html" method="get" class=" w-100" >
  <div class="form-row">
    <div class="form-group col-md-2">
      <label for="txtNombre">Nombre</label>
      <input type="text" class="form-control" name="txtNombre" placeholder="Nombre" value=${txtNombre}>
    </div>
    <div class="form-group col-md-2">
      <label for="txtApellido">Apellido</label>
      <input type="text" class="form-control" name="txtApellido" placeholder="Apellido" value=${txtApellido}>
    </div>
    
     <div class="form-group col-md-2">
      <label for="txtDNI">DNI</label>
      <input type="text" class="form-control" name="txtDNI" placeholder="DNI" value="${txtDNI}" >
    </div>
    
      <div class="form-group col-md-2 mt-4 pt-1">      
         
         <button type="submit" class="btn btn-success "> <i class="fas fa-search"></i> Buscar </button>
    </div>
    
      <div class="form-group col-md-2 mt-4">   
      
    </div>
    <div class="form-group col-md-2 mt-4 text-right">
    
       <a href="Clientes_ABM.html"  class="btn btn-success" >Agregar <i class="fas fa-plus"></i></a>
           
    </div>
    
  </div>
  
</form>

  
  </div>
 
      <div class="col-12  mt-2">
      
<div class="bg-white border table-responsive table-striped"> 
        <table class="table">
            <thead>
                <tr class="text-info">
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>DNI</th>
                    <th>Nacionalidad</th>
                    <th>Email</th>
                    <th>Direccion</th>
                    <th>Localidad</th>
                    <th>Telefono</th>
                    <th>Fecha. Nac.</th>
                     <th></th>
                </tr>
            </thead>
            <tbody>
       
                
                <c:forEach var="dato" items="${lista}" >
                  <tr>
                    <td>${dato.ID_cliente}</td>
                    <td>${dato.nombre}</td>
                    <td>${dato.apellido}</td>
                    <td>${dato.DNI}</td>
                    <td>${dato.nacionalidad.descripcion}</td>
                    <td>${dato.email}</td>
                    <td>${dato.direccion}</td>
                    <td>${dato.localidad}</td>
                    <td>${dato.telefono}</td>
                    <td>${dato.fecha_nacimiento}</td>
                    
                        <td>
                    <a href="Clientes_Editar.html?IdCliente=${dato.ID_cliente}"  class="btn btn-success" ><i class="fas fa-edit"></i></a>
                     <button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
            
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

<%@include file="Decoraciones/Footer.jsp" %>


</body>
</html>