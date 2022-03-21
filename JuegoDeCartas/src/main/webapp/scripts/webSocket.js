var webSocket;
var messages = document.getElementById("messages");


function openSocket() {
    // Crear una nueva instancia de la WebSocket
    webSocket = new WebSocket("ws://localhost:8080/JuegoDeCartas/myWebSocketEndpoint");
}
websocket.onmessage = function processMessage(message) {
    var jsonData = JSON.parse(message.data);
    if (jsonData.message !== null){
        //recepcion mesaje poner en div (luego)
        //messageTextArea.value += jsonData.message + "\n";
    }
        
}

function send() {
    var text = document.getElementById("id").value;
    webSocket.send(text);
}

function closeSocket() {
    webSocket.close();
}

function writeResponse(text) {
    messages.innerHTML += "<br/>" + text;
}

