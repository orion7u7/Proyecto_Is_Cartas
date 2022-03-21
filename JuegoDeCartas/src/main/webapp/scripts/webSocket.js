var username;
var websocket = new WebSocket("ws://http://localhost:8090/JuegoDeCartas/myWebSocketEndpoint");

websocket.onmessage = function(evt) { 
	area.innerHTML += evt.data + "\n";
};

function join() {
    username = usuario.value;
    websocket.send("*** " + username + " se ha unido!!");
}

function send_message() {
    websocket.send(username + ": " );
}
