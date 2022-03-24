var username;
var area;
var nom;
var websocket = new WebSocket("ws://localhost:" + document.location.port + "/JuegoDeCartas/myWebSocketEndpoint");
var aux = 0;
function capturar_user() {
    username = document.getElementById("usuario").value;
    console.log(username);
}
function user(nom) {
    nom = document.getElementById(nom);
    nom.innerHTML = username;
}

websocket.onmessage = function (evt) {
    area = document.getElementById("area");
    area.innerHTML += evt.data + "\n";
    if (aux != 0) {
        centro_m = document.getElementById("centro_m");
        centro_m.innerHTML += '<img id="' + evt.data + '" src="imagenes/jojo/' + evt.data + '.jpg"/>';
    }
    aux++;
    //var el = document.getElementById("centro_m");
    //el.innerHTML = "<img src='imagenes/jojo/"+evt+".jpg'>";
};

function join(id) {
    var elemento = document.getElementById(id);
    elemento.style.display = "none";
    console.log(username + " entra");
    websocket.send("*** " + username + " se ha unido!!");
}

function send_message(cart) {
    websocket.send(username + ": " + cart);
}
function send_cart(cart) {
    console.log(cart);
    websocket.send(cart);

}