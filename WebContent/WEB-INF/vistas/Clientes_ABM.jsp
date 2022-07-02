<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes ABM</title>

</head>

<%@include file="Decoraciones/librerias.jsp" %>
<%@include file="Decoraciones/header.jsp" %>




  
  <div class="row justify-content-center   ">
 
   <div class="col-10 mt-2 rounded border bg-light ">
 
	 <div class="row">
	 
	 
	     <div class="col-12 mt-2">
	     
	    <% 
	    String titulo = "Editar";
	    String Action = "Clientes_Editar.html";
	    if(request.getParameter("btnAgregar")!=null) 
	    {
	    	titulo= "Alta";
	    	Action ="Clientes_Alta.html";
	    }
	    %>
	     	<h2 class="font-weight-bold text-center text-info"> Clientes <%=titulo %> </h2>
	     	
	     	
	     </div>
	 
	     <div class="col-12 mt-2">
	     
	      <div class="col-12 mt-2">
     	<label class="font-weight-bold text-center text-danger  "> 
     	${ErroMsj}    
     	</label>
     </div>
	     
	     
<form action="<%=Action %>" method="get" >
   <input type="hidden" name="txtIdCliente" value="${cliente.getId()}">
  <div class="form-row justify-content-center">
    <div class="form-group col-md-4">
      <label for="txtNombre">Nombre</label>
      <input type="text" class="form-control" name="txtNombre" placeholder="Nombre" value="${cliente.getNombre()}">
    </div>
    
     <div class="form-group col-md-4">
      <label for="txtNombre">Nomsdfbre</label>
      <input type="text" class="form-control" name="txtNombreas" placeholder="Nombreasd" value="${cliente.getId()}">
    </div>
    
    <div class="form-group col-md-4">
      <label for="txtApellido">Apellido</label>
      <input type="text" class="form-control" name="txtApellido" placeholder="Apellido" value="${cliente.getApellido()}">
    </div>
   </div>
   
    <div class="form-row justify-content-center">
 
      <div class="form-group col-md-4">
      <label for="txtDNI">DNI</label>
      <input type="text" class="form-control" name="txtDNI" placeholder="DNI" value="${cliente.getDNI()}" >
    </div>
    <div class="form-group col-md-4">
      <label for="cboNacio">Nacionalidad</label>
      
    
     <select name="cboNacio" class="form-control">
<c:forEach var="dato" items="${NacioLista}"  varStatus="itemLoop">

 

  <option value="${dato.getId()}" >${dato.getDescripcion()}  </option>


</c:forEach>

</select> 

      
    </div>
 
    </div>
  
    <div class="form-row justify-content-center">

   
  
  <div class="form-group col-md-4">
    <label for="txtDireccion">Direccion</label>
    <input type="text" class="form-control" name="txtDireccion" placeholder="Direccion"  value="${cliente.getDireccion()}">
  </div>
  
   <div class="form-group col-md-4">
    <label for="txtLocalidad">Localidad</label>
    <input type="text" class="form-control" name="txtLocalidad" placeholder="Localidad"  value="${cliente.getLocalidad()}">
  </div>
   </div>

  
    <div class="form-row justify-content-center">

     <div class="form-group col-md-4">
    <label for="txtTelefono">Telefono</label>
    <input type="text" class="form-control" name="txtTelefono" placeholder="Telefono" value="${cliente.getTelefono()}">
  </div>
  
  <div class="form-group col-md-4">
    <label for="txteMail">Email</label>
    <input type="text" class="form-control" name="txteMail" placeholder="email@emil.com" value="${cliente.getEmail()}">
  </div>
   
   </div>
   
      <div class="form-row justify-content-center">

    
   <div class="form-group col-md-4">
    <label for="txtNac">Fecha de nacimiento</label>
    <input type="text" class="form-control" name="txtNac" placeholder="Fecha. Nac." value="${cliente.getFechaNacimiento()}">
  </div>
<div class="form-group col-md-4">
    </div>

   </div>
   
    <div class="form-row justify-content-center">

     <div class="form-group col-md-4">
     
      <a href="Clientes_Grilla.html" class="btn btn-danger " >Cancelar</a>
     
  </div>
   <div class="form-group col-md-4">
   
      
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
