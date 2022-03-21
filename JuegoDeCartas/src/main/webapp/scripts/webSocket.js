var username;
var area;
var websocket = new WebSocket("ws://localhost:8080/JuegoDeCartas/myWebSocketEndpoint");

websocket.onmessage = function (evt) {
    area = document.getElementById("area");
    area.innerHTML += evt.data + "\n";
};

function join() {
    
    username = document.getElementById("usuario").value;
    console.log(username+" entra");
    websocket.send("*** " + username + " se ha unido!!");
}

function send_message(cart) {
    websocket.send(username + ": " +cart);
}
