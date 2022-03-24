
<%@page import="com.is.modelo.Persona"%>
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

    </head>
    <body onload="user('nom');">
        <%!
            private int accesos = 0;
            private String usuario = "user";
        %>
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

                    <input id="entrarW" class="btn btn-success" onclick="join('entrarW');" value="Entrar" type="button">
                    <a href="#" class="btn btn-warning">Pausar</a>
                    <a href="salas.jsp" class="btn btn-danger">Abandonar partida</a> 
                    <div class="dropdown text-end">
                        <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
                        </a>
                        <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1" style="">
                                    <li><a id="njom" class="dropdown-item" value=""><%Persona per = new Persona();
                                        per.getNickname();%></a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="CerrarS">Cerrar Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <% int aux;
            int[] a = new int[14];
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < a.length;) {
                int n = (int) (Math.random() * 36);
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
            if (accesos <= 4) {
                ++accesos;
            } else {

            }
        %>
        <div class="fondo">
            <div class="arriba">
                <div class="arribarow">
                    <%
                        System.out.println(accesos);
                        if (accesos == 1) {

                            for (int i = 1; i < 4; i++) {
                    %>

                    <img id="<%=a[i]%>" value="<%=a[i]%>" src="imagenes/jojo/<%=a[i]%>.jpg" onclick="send_cart(<%=a[i]%>);"/>
                    <%
                        }
                    } else {
                    %>
                    <img id="puesta1" src="imagenes/Reverso.jpg"/>
                    <img id="puesta2" src="imagenes/Reverso.jpg"/>
                    <img id="puesta3" src="imagenes/Reverso.jpg"/>
                    <img id="puesta4" src="imagenes/Reverso.jpg"/>
                    <%
                        }
                    %>
                </div>
            </div>
            <div id="carata1" class="izquierda">
                <div class="izquierdarow">
                    <%  if (accesos == 2) {
                            for (int i = 4; i < 7; i++) {
                    %>

                    <img id="<%=a[i]%>" value="<%=a[i]%>" src="imagenes/jojo/<%=a[i]%>.jpg" onclick="send_cart(<%=a[i]%>);"/>
                    <%
                        }
                    } else {
                    %>
                    <img id="puesta1" src="imagenes/Reverso.jpg"/>
                    <img id="puesta2" src="imagenes/Reverso.jpg"/>
                    <img id="puesta3" src="imagenes/Reverso.jpg"/>
                    <img id="puesta4" src="imagenes/Reverso.jpg"/>
                    <%
                        }
                    %>
                </div>
            </div>
            <div id="carata2" class="derecha">
                <div class="derecharow">
                    <%  if (accesos == 3) {
                            for (int i = 7; i < 10; i++) {
                    %>

                    <img id="<%=a[i]%>" value="<%=a[i]%>" src="imagenes/jojo/<%=a[i]%>.jpg" onclick="send_cart(<%=a[i]%>);"/>
                    <%

                        }

                    } else {
                    %>
                    <img id="puesta1" src="imagenes/Reverso.jpg"/>
                    <img id="puesta2" src="imagenes/Reverso.jpg"/>
                    <img id="puesta3" src="imagenes/Reverso.jpg"/>
                    <img id="puesta4" src="imagenes/Reverso.jpg"/>
                    <%
                        }
                    %>
                </div>
            </div>
            <div id="carata3" class="centro">
                <div id="centro_m" class="centrorow">
                    <img id="puesta1" src="imagenes/Reverso.jpg"/>
                    <img id="puesta2" src="imagenes/Reverso.jpg"/>
                    <img id="puesta3" src="imagenes/Reverso.jpg"/>
                    <img id="puesta4" src="imagenes/Reverso.jpg"/>
                </div>
            </div>
            <div id="carata5" class="abajo">
                <div class="abajorow">
                    <%  if (accesos == 4) {
                            for (int i = 10; i < 13; i++) {
                    %>

                    <img id="<%=a[i]%>" value="<%=a[i]%>" src="imagenes/jojo/<%=a[i]%>.jpg" onclick="send_cart(<%=a[i]%>);"/>
                    <%
                        }
                    } else {
                    %>
                    <img id="puesta1" src="imagenes/Reverso.jpg"/>
                    <img id="puesta2" src="imagenes/Reverso.jpg"/>
                    <img id="puesta3" src="imagenes/Reverso.jpg"/>
                    <img id="puesta4" src="imagenes/Reverso.jpg"/>
                    <%
                        }
                    %>
                </div>

            </div>
            <div id="carata4" class="textoa">
                <div class="textorow">
                    <textarea id="area" name="area" placeholder="juegos" readonly></textarea>
                </div>
            </div>
        </div>
        <script src="scripts/webSocket.js"></script>
    </body>
</html>
