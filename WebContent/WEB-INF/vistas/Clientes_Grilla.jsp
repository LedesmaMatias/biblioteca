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
 
     <div class="col-12 mt-2">
    
  <form class=" w-100">
  <div class="form-row">
    <div class="form-group col-md-2">
      <label for="txtNombre">Nombre</label>
      <input type="text" class="form-control" id="txtNombre" placeholder="Nombre">
    </div>
    <div class="form-group col-md-2">
      <label for="txtApellido">Apellido</label>
      <input type="text" class="form-control" id="txtApellido" placeholder="Apellido">
    </div>
    
     <div class="form-group col-md-2">
      <label for="txtDNI">DNI</label>
      <input type="text" class="form-control" id="txtDNI" placeholder="DNI">
    </div>
    
      <div class="form-group col-md-2 mt-4">
         <button type="submit" class="btn btn-success ">Buscar</button>
    </div>
    
    <div class="form-group col-md-2 mt-4">
         <a type="submit" class="btn btn-success " href="Clientes_ABM.html" >Agregar Cliente</a>
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
                <tr>
                    <td>1</td>
                    <td>Axl</td>
                    <td>Rose</td>
                    <td>666</td>
                    <td>Argentina</td>
                    <td>Guns@mail.com</td>
                    <td>Buenos Aires</td>
                     <td>Localidad</td>
                    <td>666</td>
                    <td>05/05/2002</td>
                    
                    <td>
                    
                      <button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
            <button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
            
                    </td>
                    
                </tr>
                <tr>
                    <td>1</td>
                    <td>Rodri</td>
                    <td>Santamaria</td>
                    <td>131313</td>
                    <td>Argentina</td>
                    <td>RSantamaria@mail.com</td>
                    <td>Buenos Aires</td>
                         <td>Localidad</td>
                    <td>1428</td>
                    <td>05/05/1999</td>
                    
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

<%@include file="Decoraciones/Footer.jsp" %>


</body>
</html>