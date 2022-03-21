
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<html>
    <head>
        <title>Juego Online</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="boostrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="estilos/estilos.css">
        <script src="boostrap/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="estilos/estilos_juego.css"/>
        <script src="scripts/webSocket.js"></script>
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
                            <a class="nav-link" href="juego.jsp">Juego</a>
                        </li>

                    </ul>
                    <a href="#" class="btn btn-warning">Pausar</a>
                    <a href="salas.jsp" class="btn btn-danger">Abandonar partida</a> 
                    <div class="dropdown text-end">
                        <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
                        </a>
                        <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1" style="">
                            <li><a class="dropdown-item" >User</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="CerrarS">Cerrar Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <% int aux;
            int[] a = new int[4];
            Set<Integer> set = new HashSet<>();

//
// Agregar n�meros sin repetir
//
            for (int i = 0; i < a.length;) {
                int n = (int) (Math.random() * 7);
                if (set.contains(n)) {
                    continue;
                }
                a[i++] = n;
                set.add(n);
            }
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] > a[j]) {
                        aux = a[i];
                        a[i] = a[j];
                        a[j] = aux;
                    }
                }
            }
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
        %>
        <div class="fondo">
            <div class="arriba">
                <div class="arribarow">
                    <%
                        for (int i = 1; i < a.length; i++) {
                    %>

                    <img id="<%=a[i]%>" src="imagenes/dragonball/carta<%=a[i]%>.jpg" onclick="send_message();"/>
                    <%
                        }
                    %>
                </div>
            </div>
            <div class="izquierda">
                <div class="izquierdarow">
                    <img src="imagenes/carta1.jpeg"/>
                    <img src="imagenes/carta4.jpeg"/>
                    <img src="imagenes/carta5.jpeg"/>
                </div>
            </div>
            <div class="derecha">
                <div class="derecharow">
                    <img src="imagenes/carta2.jpeg"/>
                    <img src="imagenes/carta3.jpeg"/>
                    <img src="imagenes/carta4.jpeg"/>
                </div>
            </div>
            <div class="centro">
                <div class="centrorow">
                    <img id="puesta1" src="imagenes/carta1.jpeg"/>
                    <img id="puesta2" src="imagenes/carta4.jpeg"/>
                    <img id="puesta3" src="imagenes/carta5.jpeg"/>
                    <img id="puesta4" src="imagenes/carta5.jpeg"/>
                </div>
            </div>
            <div class="textoa">
                <div class="textorow">
                    <input id="area" type="textarea" class="form-control" name="resumen" placeholder="juegos" readonly>
                </div>
            </div>
            <div class="abajo">
                <div class="abajorow">
                    <img src="imagenes/carta1.jpeg"/>
                    <img src="imagenes/carta1.jpeg"/>
                    <img src="imagenes/carta1.jpeg"/>
                </div>
            </div>

        </div>

    </body>
</html>
