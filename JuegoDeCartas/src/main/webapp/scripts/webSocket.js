var username;
var area;
var nom;
var websocket = new WebSocket("ws://localhost:" + document.location.port + "/JuegoDeCartas/myWebSocketEndpoint");

var aux = 0;
var pausador = 1001;
function capturar_user() {
    username =document.getElementById("usuario").value;
    console.log(username);
}
function user(nom){
    nom = document.getElementById(nom);
    nom.innerHTML= username;
}

websocket.onmessage = function (evt) {
    if (evt.data == 1000) {
        pausador=1000;
    }
    if (evt.dat==1001) {
        pausador=1001
    }
    if (pausador==1001) {
        area = document.getElementById("area");
        area.innerHTML += evt.data + "\n";
        if (aux > 2) {
            centro_m = document.getElementById("centro_m");
            for (var i = 0; i < 2; i++) {
                centro_m.removeChild(centro_m.firstChild);
            }
            centro_m.innerHTML += '<img id="' + evt.data + '" src="imagenes/jojo/' + evt.data + '.jpg"/>';
        } else {

        }
        aux++;
    }else{
        alert("Juego pausado");
    }
};

function join(id) {
    var elemento = document.getElementById(id);
    elemento.style.display = "none";
    console.log(username + " entra");
    websocket.send("*** " + username + " se ha unido!!");
}
function pausa() {
    alert("has pausado el juego");
    pausador = 1000;
    websocket.send(pausador);
}
function reanudar() {
    alert("juego reanudado");
    pausador = 1001;
    websocket.send(pausador);
}

function send_message(cart) {
    websocket.send(username + ": " + cart);
}
function send_cart(cart) {
    arribarow = document.getElementById("arribarow");
    console.log(cart);
    websocket.send(cart);
    for (var i = 0; i < 2; i++) {
        arribarow.removeChild(arribarow.cart);
    }

}