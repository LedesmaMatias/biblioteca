<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes ABM</title>

</head>
<body>


<%@include file="Decoraciones/librerias.jsp" %>
<%@include file="Decoraciones/header.jsp" %>

<script>

	function Validar() {
	

		if ($('#txtNombre').val() == "" ) {
			alert("Debe completar el campo Nombre.");
			$('#txtNombre').focus();
			return false;
		}

		
		if ($('#txtApellido').val() == "" ) {
			alert("Debe completar el campo Apellido.");
			$('#txtApellido').focus();
			return false;
		}
		
		
		if ($('#txtDNI').val() == "" ) {
			alert("Debe completar el campo DNI.");
			$('#txtDNI').focus();
			return false;
		}else 
			if($('#txtDNI').val().length != 10){
				alert("El campo DNI debe tener 10 digitos.");
				$('#txtDNI').focus();
				return false;
			}
		
		if ($('#txtDireccion').val() == "" ) {
			alert("Debe completar el campo Direccion.");
			$('#txtDireccion').focus();
			return false;
		}
		
		if ($('#txtTelefono').val() == "") {
			alert("Debe completar el campo Telefono.");
			$('#txtTelefono').focus();
			return false;
		}else 
			if($('#txtTelefono').val().length < 10 || $('#txtTelefono').val().length > 15){
			alert("El campo telefono debe tener minimo 10 numeros, maximo 15.");
			$('#txtTelefono').focus();
			return false;
		}
		
		if ($('#txtLocalidad').val() == "") {
			alert("Debe completar el campo Localidad.");
			$('#txtLocalidad').focus();
			return false;
		}
		if ($('#txteMail').val() == "") {
			alert("Debe completar el campo E-Mail.");
			$('#txteMail').focus();
			return false;
		}
		
		
		
		return true;
	}

	function limpiarbusqueda() {

		alert("busqueda limpia");
		$('#txtNombre').val("");
		$('#txtApellido').val("");
		$('#txtDNI').val("");
	}
	
	

	  $(function() {
          $('#txtNac').datetimepicker({           
              viewMode: 'days',
              format: 'DD/MM/YYYY'
          });
      });
	
	  //Funcion solo numeros
	  function validate(evt) {
		  var theEvent = evt || window.event;

		  // Handle paste
		  if (theEvent.type === 'paste') {
		      key = event.clipboardData.getData('text/plain');
		  } else {
		  // Handle key press
		      var key = theEvent.keyCode || theEvent.which;
		      key = String.fromCharCode(key);
		  }
		  var regex = /[0-9]|\./;
		  if( !regex.test(key) ) {
		    theEvent.returnValue = false;
		    if(theEvent.preventDefault) theEvent.preventDefault();
		  }
		}
	  
</script>




  
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
   <input type="hidden" name="txtIdCliente"  id="txtIdCliente" value="${cliente.getId()}">
  <div class="form-row justify-content-center">
    <div class="form-group col-md-4">
      <label for="txtNombre">Nombre</label>
      <input type="text" class="form-control" name="txtNombre" id="txtNombre" placeholder="Nombre" value="${cliente.getNombre()}">
    </div>
    
    <div class="form-group col-md-4">
      <label for="txtApellido">Apellido</label>
      <input type="text" class="form-control" name="txtApellido" id="txtApellido" placeholder="Apellido" value="${cliente.getApellido()}">
    </div>
   </div>
   
    <div class="form-row justify-content-center">
 
      <div class="form-group col-md-4">
      <label for="txtDNI">DNI</label>
      <input type="text" class="form-control" name="txtDNI" id="txtDNI" placeholder="DNI"  onkeypress='validate(event)' value="${cliente.getDNI()}" >
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
    <input type="text" class="form-control" name="txtDireccion" id="txtDireccion"  placeholder="Direccion"  value="${cliente.getDireccion()}">
  </div>
  
   <div class="form-group col-md-4">
    <label for="txtLocalidad">Localidad</label>
    <input type="text" class="form-control" name="txtLocalidad" id="txtLocalidad" placeholder="Localidad"  value="${cliente.getLocalidad()}">
  </div>
   </div>

  
    <div class="form-row justify-content-center">

     <div class="form-group col-md-4">
    <label for="txtTelefono">Telefono</label>
    <input type="text" class="form-control" name="txtTelefono"  id="txtTelefono" type="number" placeholder="Telefono" onkeypress='validate(event)' value="${cliente.getTelefono()}">
  </div>
  
  <div class="form-group col-md-4">
    <label for="txteMail">Email</label>
    <input type="text" class="form-control"  type="email" name="txteMail"  id="txteMail" placeholder="email@emil.com" value="${cliente.getEmail()}">
  </div>
   
   </div>
   
      <div class="form-row justify-content-center">

    
   <div class="form-group col-md-4">
    <label for="txtNac">Fecha de nacimiento</label>
    <input id='txtNac'  type="date" class=" form-control" name="txtNac" id="txtNac" placeholder="Fecha. Nac." value="${cliente.getFechaNacimiento()}" required>
    
 
    
     
  </div>
<div class="form-group col-md-4">
    </div>

   </div>
   
    <div class="form-row justify-content-center">

     <div class="form-group col-md-4">
     
      <a href="Clientes_Grilla.html" class="btn btn-danger " >Cancelar</a>
     
  </div>
   <div class="form-group col-md-4">
   
      
    <button type="submit" class="btn btn-primary" onclick="return Validar();">Aceptar</button>
    
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
