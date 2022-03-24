var username;
var area;
var websocket = new WebSocket("ws://localhost:" + document.location.port + "/JuegoDeCartas/myWebSocketEndpoint");

websocket.onmessage = function (evt) {
    area = document.getElementById("area");
    area.innerHTML += evt.data + "\n";
    //var el = document.getElementById("centro_m");
    //el.innerHTML = "<img src='imagenes/jojo/"+evt+".jpg'>";
};

function join(id) {
    var elemento = document.getElementById(id);
    elemento.style.display = "none";
    username = document.getElementById("usuario").value;
    console.log(username + " entra");
    websocket.send("*** " + username + " se ha unido!!");
}

function send_message(cart) {
    websocket.send(username + ": " + cart);
}
function send_cart(cart) {
    websocket.send(cart);
}