<%-- 
    Document   : Juegoadmin
    Created on : 23 mar. 2022, 21:17:30
    Author     : Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Juego</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="boostrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="estilos/estilos.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#" style="font-weight: bolder; color: #63A4EC">Administrador</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="Administrador.jsp">Volver Panel Administración</a>
                        </li>
                    </ul>
                </div>
                <div class="dropdown text-end">
                    <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
                    </a>
                    <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1" style="">
                        <li><a class="dropdown-item" href="#">User</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="CerrarS">Cerrar Sesion</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
    <br>
    <div style="justify-content: center; display: flex;">
        <img src="imagenes/Crear.png" alt="Desarrollo" width="350" height="200">
    </div>
    <div class="container">
            <form class="row g-3 needs-validation" action="Controlerjuego" method="POST">
                <div class="col-md-6">
                    <label for="validationCustom01" class="form-label">Nombre Juego</label>
                    <input type="text" class="form-control" id="nombre" name="txtjuego" required>
                </div>
                <div class="col-md-3" style="padding-left: 8%">
                    <label for="validationCustom02" class="form-label">Cantidad cartas</label>
                    <input type="number" class="form-control" id="total_cartas" name="txtcantidad" required>
                </div>
                <div class="col-md-6">
                    <label for="validationCustom03" class="form-label">Descripción</label>
                    <input type="text" class="form-control" id="descripcion" name="txtdescripcion" required>
                </div>
                <br>
                <div>
                    <label for="validationCustom03" class="form-label">Logo Juego</label>
                    <input type="file" class="form-control" aria-label="file example" name="filefotojuego" >
                    <div class="invalid-feedback">Example invalid form file feedback</div>
                </div>
                
                <div class="col-12">
                    <button class="btn btn-primary" type="submit" name="accion" value="Agregar">Agregar Juego</button>
                    
                </div>
            </form>
        </div>
</html>
