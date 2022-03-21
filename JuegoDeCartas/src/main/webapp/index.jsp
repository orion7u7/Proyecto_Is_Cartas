
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Login Page</title>
        <link href="boostrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="estilos/estilos.css">
        <script src="boostrap/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

        <link rel="stylesheet" href="estilos/style.css"/>
    </head>
    <body>
        <div class="container">
            <div class="d-flex justify-content-center h-100">
                <div class="card">
                    <div class="card-header">
                        <h3>Iniciar</h3>
                    </div>
                    <div class="card-body">
                        <form class="admin oculto" method="post" action="Consulta1?menu=admin">
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control" name="user" placeholder="username" required>
                            </div>
                            <br>
                            <br>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="password" class="form-control" name="pass" placeholder="password" required>
                            </div>
                            <c:if test="${succes==0}">
                                <br>
                                <div class="alert alert-danger" role="alert">
                                    Usuario o contraseña incorrectos
                                </div>
                            </c:if>
                            <br>
                            <br>
                            <br>
                            <div class="form-group">
                                <input type="submit" value="Login" name="btn-admin" class="btn float-right login_btn">
                            </div>
                        </form>
                        <form class="user" method="post" action="Consulta1?menu=user">
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control" name="playeruser" placeholder="username" required>
                            </div>
                            <c:if test="${succes==2}">
                                <br>
                                <div class="alert alert-danger" role="alert">
                                    Jugador ya existe
                                </div>
                            </c:if>
                            <br>
                            <br>
                            <div class="form-group">
                                <input type="submit" value="Login" class="btn float-right login_btn">
                            </div>
                        </form>
                        <input type="button" value="User" class="btn float-right login_btn usuario oculto" />
                        <input type="button" value="Admin" class="btn float-right login_btn administrador admin" />
                    </div>

                </div>
            </div>
        </div>
        <script src="scripts/index.js"></script>

        <footer class="w-100 d-flex align-items justify-content-center flex-wrap">
            <p class="fs-5 px-3 pt-3">PowerCards Games-Unillanos</p>
        </footer>
    </body>
</html>