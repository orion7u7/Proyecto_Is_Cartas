
<html>
    <head>
        <title>Salas</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="boostrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="estilos/estilos.css">
        <script src="boostrap/js/bootstrap.min.js"></script>

    </head>
    <body onload="user('nom');">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="usuario.jsp" style="font-weight: bolder; color: #63A4EC">PowerCards</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="usuario.jsp">Inicio</a>
                        </li>

                    </ul>
                    <div class="dropdown text-end">
                        <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
                        </a>
                        <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1" style="">
                            <li><a id="nom" class="dropdown-item" value=""><%=request.getAttribute("jugadorS")%></a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="CerrarS">Cerrar Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>

        <div id="carouselMultiItemExample" class="carousel slide carousel-dark text-center" data-mdb-ride="carousel" >

            <div class="carousel-inner py-4">
                <div class="carousel-item active">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="card">
                                    <img
                                        src="imagenes/jojologo.jpg"
                                        class="card-img-top"
                                        alt="Waterfall"
                                        />
                                    <div class="card-body">
                                        <h5 class="card-title">Jojo Bizzare Adventure</h5>
                                        <p class="card-text">
                                            Son videojuegos de rol desarrollados por Game Freak y publicados para videoconsolas portátiles de Nintendo.
                                        </p>
                                        Jugadores activos: <label for="inputEmail4">4/4</label>
                                        <br>
                                        <br>
                                        
                                        <a href="juego.jsp" class="btn btn-primary"><button class="btn btn-primary" onclick="join();">Ingresar</button></a>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 d-none d-lg-block">
                                <div class="card">
                                    <img
                                        src="imagenes/dragonball.jpg"
                                        class="card-img-top"
                                        alt="Sunset Over the Sea"
                                        />
                                    <div class="card-body">
                                        <h5 class="card-title">Dragon Ball</h5>
                                        <p class="card-text">
                                            Dragon Ball es un manga escrito e ilustrado por Akira Toriyama
                                        </p>
                                        Jugadores activos: <label for="inputEmail4">1/4</label>
                                        <br>
                                        <br>
                                        <a href="juego.jsp" class="btn btn-primary">Ingresar</a>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 d-none d-lg-block">
                                <div class="card">
                                    <img
                                        src="imagenes/yugioh.jpg"
                                        class="card-img-top"
                                        alt="Sunset over the Sea"
                                        />
                                    <div class="card-body">
                                        <h5 class="card-title">JoJo's Bizarre</h5>
                                        <p class="card-text">
                                            Es un juego de cartas coleccionables de origen japonés desarrollado y publicado por Konami.
                                        </p>
                                        Jugadores activos: <label for="inputEmail4">2/4</label>
                                        <br>
                                        <br>
                                        <a href="juego.jsp" class="btn btn-primary">Ingresar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="w-100 d-flex align-items justify-content-center flex-wrap">
            <p class="fs-5 px-3 pt-3">Design. &copy; Todos los derechos Reservados PowerCards Games- Unillanos</p>
        </footer>
        <script src="scripts/webSocket.js"></script>
    </body>
</html>
