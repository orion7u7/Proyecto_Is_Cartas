<%-- 
    Document   : VistaCartasPokemon
    Created on : 20 mar. 2022, 17:55:33
    Author     : Laptop
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cartas Pokemon</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="boostrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="estilos/estilos.css">
        <script src="boostrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="usuario.jsp" style="font-weight: bolder; color: #63A4EC">PowerCards</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="Administrador.jsp">Administración</a>
                        </li>
                        
                    </ul>
                    <div class="dropdown text-end">
                        <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
                        </a>
                        <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1" style="">
                            <li><a class="dropdown-item" href="#">Usuario</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#">Cerrar Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        
        
        
        <div id="carouselMultiItemExample" class="carousel slide carousel-dark text-center" data-mdb-ride="carousel" >
            
            <!-- Inner -->
            <!--<div class="carousel-inner py-4">-->
                <!-- Single item -->
                <center>
                    <div style="width: 100%">
                        <form action="Controler" method="POST">
                            <input type="submit" name="accion" value="Listar">
                        </form>
                        <table>
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Descripción</th>
                                    <th>Ataque</th>
                                    <th>defensa</th>
                                    <th>Tipo</th>
                                    <th>Juego</th>
                                    <th>Atributo</th>
                                    <th>Valor</th>
                                    <th>Foto</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="dato" items="${lista}">
                                    <tr>
                                        <td>${dato.getIdCarta()}</td>
                                        <td>${dato.getNombre()}</td>
                                        <td>${dato.getDescripcion()}</td>
                                        <td>${dato.getAtaque()}</td>
                                        <td>${dato.getDefensa()}</td>
                                        <td>${dato.getTipo()}</td>
                                        <td>${dato.getJuego_nombre()}</td>
                                        <td>${dato.getAtributo()}</td>
                                        <td>${dato.getValor()}</td>
                                        <td><img src="ControlerIMG?id=${dato.getIdCarta()}" width="250px" height="230px"></td>
                                    </tr>
                                </c:forEach>
                                
                            </tbody>
                        </table>
                    </div>
                </center>

                
                
            <!--</div> -->
            <!-- Inner -->
        </div>
        
        
        
        
        
        <footer class="w-100 d-flex align-items justify-content-center flex-wrap">
            <p class="fs-5 px-3 pt-3">Design. &copy; Todos los derechos Reservados PowerCards Games- Unillanos</p>
        </footer>
    </body>
</html>
