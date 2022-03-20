<%-- 
    Document   : Administrador
    Created on : 16/03/2022, 02:08:20 PM
    Author     : HOMEPCTK
--%>
<%@page import="java.util.Collection"%>
<%@page import="com.is.modelo.Juegos"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.is.database.MisConsultas"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Administrador</title>
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
                            <a class="nav-link active" aria-current="page" href="#">Agregar Cartas</a>
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
                        <li><a class="dropdown-item" href="index.jsp">Cerrar Sesion</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <form class="row g-3 needs-validation" novalidate action="ConsultaAdmin?menu=carta" method="post">
                <div class="col-md-6">
                    <label for="validationCustom01" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>
                <div class="col-md-3">
                    <label for="validationCustom02" class="form-label">Ataque</label>
                    <input type="number" class="form-control" id="ataque" name="ataque" required>
                </div>
                <div class="col-md-3">
                    <label for="validationCustom02" class="form-label">Defensa</label>
                    <input type="number" class="form-control" id="defensa" name="defensa" required>
                </div>
                <div class="col-md-6">
                    <label for="validationCustom03" class="form-label">Descripción</label>
                    <input type="text" class="form-control" id="descripcion" name="descripcion" required>
                </div>
                <div class="col-md-3">
                    <label for="validationCustom04" class="form-label">Juego</label>
                    <select class="form-select" id="juego" name="juego" required>
                        <option selected disabled value="">Choose...</option>
                        <%
                            MisConsultas consul = new MisConsultas();

                            Collection<Juegos> lista = consul.consulta_juego();
                            for (Juegos juego : lista) {
                                out.println("<option>" + juego.getNombre() + "</option>");
                            }
                        %>
                    </select>
                </div>
                <div class="col-md-3">
                    <label for="validationCustom04" class="form-label">Tipo de Carta</label>
                    <select class="form-select" id="tipo" name="tipo" required>
                        <option selected disabled value="">Choose...</option>
                        <option>Especial</option>
                        <option>Duelo</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label for="validationCustom03" class="form-label">Logo</label>
                    <input type="file" class="form-control" aria-label="file example" >
                    <div class="invalid-feedback">Example invalid form file feedback</div>
                </div>
                <div class="col-md-2">
                    <label for="validationCustom03" class="form-label" >Atributo</label>
                    <input type="text" class="form-control" id="atributo1" name="atributo1" required>
                    <label for="validationCustom03" class="form-label" >Valor</label>
                    <input type="number" class="form-control" id="valoratri1" name="valor1" required>
                </div>
                <div class="col-md-2">
                    <label for="validationCustom03" class="form-label">Atributo</label>
                    <input type="text" class="form-control" id="atributo2">
                    <label for="validationCustom03" class="form-label">Valor</label>
                    <input type="text" class="form-control" id="valoratri2" >
                </div>
                <div class="col-md-2">
                    <label for="validationCustom03" class="form-label">Atributo</label>
                    <input type="text" class="form-control" id="atributo3">
                    <label for="validationCustom03" class="form-label">Valor</label>
                    <input type="text" class="form-control" id="valoratri3">
                </div>
                <div class="col-12">
                    <button class="btn btn-primary" type="submit">Agregar Carta</button>
                </div>
            </form>
        </div>

        <div class="container">

            <label>Crear Sala</label>
            <form class="row g-3 needs-validation" novalidate>
                <div class="col-md-3">
                    <label for="validationCustom04" class="form-label">Juego</label>
                    <select class="form-select" id="juego" required>
                        <option selected disabled value="">Choose...</option>
                        <%
                            for (Juegos juego : lista) {
                                out.println("<option>" + juego.getNombre() + "</option>");
                            }
                        %>
                    </select>
                </div>
                <div class="col-12">
                    <button class="btn btn-primary" type="submit">Crear</button>
                </div>
            </form>
        </div>

        <script src="boostrap/js/bootstrap.min.js"></script>
        <script>
            // Example starter JavaScript for disabling form submissions if there are invalid fields
            (function () {
                'use strict'

                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.querySelectorAll('.needs-validation')

                // Loop over them and prevent submission
                Array.prototype.slice.call(forms)
                        .forEach(function (form) {
                            form.addEventListener('submit', function (event) {
                                if (!form.checkValidity()) {
                                    event.preventDefault()
                                    event.stopPropagation()
                                }

                                form.classList.add('was-validated')
                            }, false)
                        })
            })()
        </script>
    </body>
</html>

