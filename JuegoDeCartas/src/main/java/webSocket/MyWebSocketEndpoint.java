package webSocket;

import java.io.IOException;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/myWebSocketEndpoint")
public class MyWebSocketEndpoint {

    @OnMessage
    public void message(String message, Session client) throws IOException, EncodeException {
        for (Session openSession : client.getOpenSessions()) {
            openSession.getBasicRemote().sendText(message);
        }
    }
}
