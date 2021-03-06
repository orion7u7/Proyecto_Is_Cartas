
<html>
    <head>
        <title>Usuario</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="boostrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="estilos/estilos.css">
        <script src="boostrap/js/bootstrap.min.js"></script>
    </head>


    <body onload="capturar_user()">
        
        <script src="scripts/webSocket.js"></script>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
            	<
                <a class="navbar-brand" href="usuario.jsp" style="font-weight: bolder; color: #63A4EC">PowerCards</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page"  href="salas.jsp">Salas</a>
                        </li>

                    </ul>
                    <input id="usuario" type="hidden" value="<%= request.getAttribute("jugadorS")%>">
                    <div class="dropdown text-end">
                        <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
                        </a>
                        <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1" style="">
                            
                            <li><a class="dropdown-item" ><%=request.getAttribute("jugadorS")%></a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="CerrarS">Cerrar Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="imagenes/slider/Slide_1.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="imagenes/slider/Slide_2.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="imagenes/slider/Slide_3.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="imagenes/slider/Slide_4.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="imagenes/slider/Slide_5.jpg" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
        

        <section>
            <div class="w-50 mx-auto text-center" style="margin-top: 20px;">
                <h1 class="p-3 fs-2 border-top border-4"><span class="text-primary">Bienvenido!</span>, aqu? te garantizamos la experiencia de disfrutar</h1>
                <p class="p-3 fs-4"><span class="text-primary">Comienza ya</span>, que tus amigos te esperan para iniciar una nueva partida. JoJo's Bizarre, Dragon Ball, Pokemon.</p>
            </div>
        </section>

        <section class="container-fluid" style="padding: 15px;">
            <div class="row w-75 mx-auto">
                <div class="col-lg-6 col-md-12 col-sm-12 d-flex justify-content-start">
                    <img src="imagenes/Intro/Intro_1.png" alt="Desarrollo" width="180" height="160">
                    <div>
                        <h3 class="fs-5 mt-4 px-4 pb-1">Desarrollo</h3>
                        <p class="px-4">Desarrollo de experiencias Gamer en aplicaciones Web.</p>
                    </div>
                </div>
                <div class="col-lg-6 col-md-12 col-sm-12 d-flex justify-content-start">
                    <img src="imagenes/Intro/Intro_2.png" alt="Desarrollo" width="180" height="160">
                    <div>
                        <h3 class="fs-5 mt-4 px-4 pb-1">Compatibilidad</h3>
                        <p class="px-4">Te garantizamos el funcionamiento de cualquier juego en nuestra plataforma.</p>
                    </div>
                </div>
            </div>

            <div class="row w-75 mx-auto">
                <div class="col-lg-6 col-md-12 col-sm-12 d-flex justify-content-start">
                    <img src="imagenes/Intro/Intro_3.png" alt="Desarrollo" width="180" height="160">
                    <div>
                        <h3 class="fs-5 mt-4 px-4 pb-1">Comodidad</h3>
                        <p class="px-4">Nada mejor que jugar con una interfaz amigable..</p>
                    </div>
                </div>
                <div class="col-lg-6 col-md-12 col-sm-12 d-flex justify-content-start">
                    <img src="imagenes/Intro/Intro_4.png" alt="Desarrollo" width="180" height="160">
                    <div>
                        <h3 class="fs-5 mt-4 px-4 pb-1">Eficiencia</h3>
                        <p class="px-4">Los juegos lanzados en nuestra Web est?n creados para soportar multijugador.</p>
                    </div>
                </div>
            </div>
        </section>


        <section>
            <div class="w-50 mx-auto text-center" style="padding: 20px;">
                <h1 class="p-3 fs-2 border-top border-4 border-bottom"><span class="text-primary">Juega!</span>, disfruta al m?ximo</h1>
                <p class="p-3 fs-4"><span class="text-primary">Comienza ya</span>, Solo escoje una tem?tica de juego.</p>
            </div>

            <div class="mt-5 text-center" style="padding: 0px 0 30px 0; margin-top: -30px !important;">
                <img style="border-radius: 50px;" src="imagenes/Intro/post-intro.jpg">
            </div>


        </section>

        <footer class="w-100 d-flex align-items justify-content-center flex-wrap">
            <p class="fs-5 px-3 pt-3">Design. &copy; Todos los derechos Reservados PowerCards Games- Unillanos</p>
        </footer>

    </body>
</html>
