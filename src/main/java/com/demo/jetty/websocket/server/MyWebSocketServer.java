package com.demo.jetty.websocket.server;

import com.alibaba.fastjson.JSONObject;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 *当创建好一个（服务）端点之后，将它以一个指定的URI发布到应用当中，这样远程客户端就能连接上它了,这种写法貌似需要部署到Tomcat服务器上才能启动
 *
 * <dependency>
 * <groupId>javax.websocket</groupId>
 * <artifactId>javax.websocket-api</artifactId>
 * <version>1.1</version>
 * <scope>provided</scope>  指定依赖范围为provided，只在编译、测试阶段有效。发布的时候，不需要此包，否则和tomcat lib下自带的websocket包冲突了
 * </dependency>
 */
@ServerEndpoint(value = "/websocket")
public class MyWebSocketServer {
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        System.out.println(session);
    }

    @OnMessage
    public void onMessage(String params, Session session) throws Exception {
        //获取服务端到客户端的通道
        System.out.println(("收到来自" + session.getId() + "的消息" + params));
        String result = "收到来自" + session.getId() + "的消息" + params;
        //返回消息给Web Socket客户端（浏览器）
        this.session.getBasicRemote().sendText(result.toString());
    }

    public void sendMessage(int status, String message, Object datas) throws IOException {
        JSONObject result = new JSONObject();
        result.put("status", status);
        result.put("message", message);
        result.put("datas", datas);
        this.session.getBasicRemote().sendText(result.toString());
    }


    public static void main(String[] args) throws Exception {

    }
}
