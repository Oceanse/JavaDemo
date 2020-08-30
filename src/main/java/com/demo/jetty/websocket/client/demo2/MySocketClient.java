package com.demo.jetty.websocket.client.demo2;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.URI;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@WebSocket(maxTextMessageSize = 64 * 1024)
public class MySocketClient {

    private String id;

    public MySocketClient() {

    }

    public MySocketClient(String id) {
        this.id = id;
    }

    @OnWebSocketMessage
    public void onMessage(Session session, String message){
        System.out.println("MySocketClient receve message: "+message);
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.println("MySocketClient connected to the server");
        session.getRemote().sendStringByFuture("This msg comes from MySocketClient");
    }


    @OnWebSocketClose
    public void onClose(Session session, int i, String message) {
        System.out.println("client: connection closed");
    }

    public static void main(String[] args) throws Exception {
        WebSocketClient client = new WebSocketClient();
        client.start();

        MySocketClient mySocketClient=new MySocketClient();
        URI echoUri = new URI("ws://127.0.0.1:8080/base/path1/");
        ClientUpgradeRequest request = new ClientUpgradeRequest();

        //connect(客户端websocket对象，服务端websocketurl, 升级请求)
        Future<Session> session = client.connect(mySocketClient, echoUri, request);
        session.get(60, TimeUnit.SECONDS).setIdleTimeout(0);
    }
}
