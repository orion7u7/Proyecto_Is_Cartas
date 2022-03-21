<%-- 
    Document   : VistaSalasCartas
    Created on : 20 mar. 2022, 17:36:20
    Author     : Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Visualizar Cartas</title>
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
        
        <!-- Carousel wrapper -->
        <div id="carouselMultiItemExample" class="carousel slide carousel-dark text-center" data-mdb-ride="carousel" >
            
            <!-- Inner -->
            <div class="carousel-inner py-4">
                <!-- Single item -->
                <div class="carousel-item active">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="card">
                                    <img
                                        src="imagenes/pokemon.jpg"
                                        class="card-img-top"
                                        alt="Waterfall"
                                        />
                                    <div class="card-body">
                                        <h5 class="card-title">Pokemon</h5>
                                        <p class="card-text">
                                            Visualizar set de Cartas del Juego Pokemon.
                                        </p>
                                        <br>
                                        <a href="#" class="btn btn-primary">Visualizar Cartas</a>
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
                                            Visualizar set de cartas del juego Dragon Ball.
                                        </p>
                                        <br>
                                        <a href="#" class="btn btn-primary">Visualizar Cartas</a>
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
                                        <h5 class="card-title">Yu-Gi-Oh!</h5>
                                        <p class="card-text">
                                            Visualizar set de Cartas del Juego Yu-Gi-Oh!.
                                        </p>
                                        <br>
                                        <br>
                                        <a href="juego.jsp" class="btn btn-primary">Visualizar Cartas</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single item -->
                <div class="carousel-item">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 col-md-12">
                                <div class="card">
                                    <img
                                        src="https://mdbcdn.b-cdn.net/img/new/standard/nature/184.webp"
                                        class="card-img-top"
                                        alt="Fissure in Sandstone"
                                        />
                                    <div class="card-body">
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">
                                            Some quick example text to build on the card title and make up the bulk
                                            of the card's content.
                                        </p>
                                        <a href="#!" class="btn btn-primary">Button</a>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 d-none d-lg-block">
                                <div class="card">
                                    <img
                                        src="https://mdbcdn.b-cdn.net/img/new/standard/nature/185.webp"
                                        class="card-img-top"
                                        alt="Storm Clouds"
                                        />
                                    <div class="card-body">
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">
                                            Some quick example text to build on the card title and make up the bulk
                                            of the card's content.
                                        </p>
                                        <a href="#!" class="btn btn-primary">Button</a>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 d-none d-lg-block">
                                <div class="card">
                                    <img
                                        src="https://mdbcdn.b-cdn.net/img/new/standard/nature/186.webp"
                                        class="card-img-top"
                                        alt="Hot Air Balloons"
                                        />
                                    <div class="card-body">
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">
                                            Some quick example text to build on the card title and make up the bulk
                                            of the card's content.
                                        </p>
                                        <a href="#!" class="btn btn-primary">Button</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single item -->
                <div class="carousel-item">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                                <div class="card">
                                    <img
                                        src="https://mdbcdn.b-cdn.net/img/new/standard/nature/187.webp"
                                        class="card-img-top"
                                        alt="Peaks Against the Starry Sky"
                                        />
                                    <div class="card-body">
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">
                                            Some quick example text to build on the card title and make up the bulk
                                            of the card's content.
                                        </p>
                                        <a href="#!" class="btn btn-primary">Button</a>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 mb-4 mb-lg-0 d-none d-lg-block">
                                <div class="card">
                                    <img
                                        src="https://mdbcdn.b-cdn.net/img/new/standard/nature/188.webp"
                                        class="card-img-top"
                                        alt="Bridge Over Water"
                                        />
                                    <div class="card-body">
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">
                                            Some quick example text to build on the card title and make up the bulk
                                            of the card's content.
                                        </p>
                                        <a href="#!" class="btn btn-primary">Button</a>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 mb-4 mb-lg-0 d-none d-lg-block">
                                <div class="card">
                                    <img
                                        src="https://mdbcdn.b-cdn.net/img/new/standard/nature/189.webp"
                                        class="card-img-top"
                                        alt="Purbeck Heritage Coast"
                                        />
                                    <div class="card-body">
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">
                                            Some quick example text to build on the card title and make up the bulk
                                            of the card's content.
                                        </p>
                                        <a href="#!" class="btn btn-primary">Button</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Inner -->
        </div>
        
        <footer class="w-100 d-flex align-items justify-content-center flex-wrap">
            <p class="fs-5 px-3 pt-3">Design. &copy; Todos los derechos Reservados PowerCards Games- Unillanos</p>
        </footer>
        
    </body>
</html>
