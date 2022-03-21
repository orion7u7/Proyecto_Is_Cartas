var username;
var area;
var websocket = new WebSocket("ws://localhost:8090/JuegoDeCartas/myWebSocketEndpoint");

websocket.onmessage = function (evt) {
    area = document.getElementById("area");
    area.innerHTML += evt.data + "\n";
};

function join() {
    console.log("entro");
    username = document.getElementById("username").value;
    websocket.send("*** " + username + " se ha unido!!");
}

function send_message() {
    websocket.send(username + ": ");
}
