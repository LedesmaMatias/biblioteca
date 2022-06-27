<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>

<%@include file="Decoraciones/librerias.jsp" %>
<%@include file="Decoraciones/header.jsp" %>


<div class="row justify-content-center ">
      <div class="bg-light col-10 rounded border mt-2">
      
      
            <div class="row justify-content-center ">
                <div class="col-auto ">

                    <a class="btn btn-lg btn-primary m-2" href="Clientes_Grilla.html">Clientes </a>
   
                      </div>
                    
                 <div class="col-auto ">
                 	 <a class="btn btn-lg btn-primary m-2" href="Biblioteca_Grilla.html">Biblioteca </a>
                      </div>
                <div class="col-auto ">
                   <button type="button" class="btn btn-lg btn-primary m-2">Libros</button>

                </div>
                
            </div>
            
            <div class="row justify-content-center ">
               


                <div class="col-auto ">
                    <button type="button" class="btn btn-lg btn-primary m-2">Prestamos</button>
                </div>
                      
                <div class="col-auto ">
                   <button type="button" class="btn btn-lg btn-secondary m-2">Parametros</button>

                </div>
                   

              
            </div>
            
            
              <div class="justify-content-end row ">
                <div class="col-auto  ">

                    <button type="button" class="btn btn-danger  m-2">Salir</button>

                </div>
            </div>
            
  
      </div>
  </div>

<%@include file="Decoraciones/Footer.jsp" %>


</body>
</html>