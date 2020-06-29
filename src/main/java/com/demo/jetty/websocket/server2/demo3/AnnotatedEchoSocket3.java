package com.demo.jetty.websocket.server2.demo3;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

import java.io.IOException;


/**
 * @WebSocket注解用在服务端的handler
 * @WebSocket A required class level com.demo.annotation.  一个必需的类级别注解
 * Flags this POJO as being a WebSocket.   标记当前类为WebSocket类
 * The class must be not abstract and public.  这个类必需是非抽象的公共类
 */
@WebSocket(maxTextMessageSize = 128 * 1024, maxBinaryMessageSize = 128 * 1024)
public class AnnotatedEchoSocket3 {
    Session session;

    /**
     * @param session
     * @OnWebSocketConnect An optional method level com.demo.annotation.
     * 客户端连接server成功时候，会触发@OnWebSocketConnect注解的方法，此方法可用来主动向客户端发送消息，但是不能接受消息
     * Flags one method in the class as receiving the On Connect event.
     * Method must be public, not abstract, return void, and have a single Session parameter.
     */
    @OnWebSocketConnect
    public void onOpen(Session session) throws Exception {
        this.session = session;
        session.getRemote().sendString("这是来自服务端AnnotatedEchoSocket3的onOpen方法的消息");
    }

    @OnWebSocketMessage
    public void onMessage(String msg) throws IOException {
        System.out.println("服务器3收到消息 " + msg);
        session.getRemote().sendString("这是来自服务端AnnotatedEchoSocket3的onMessage方法的消息");
    }

    @OnWebSocketClose
    public void onClose(int i, String string) {
        System.out.println("服务端3onClose。。。。");
        //session.getRemote().sendString("这是来自服务端onClose方法的消息");该方法是连接关闭时候触发，所以send消息没有意义
    }


    /**
     * 方法必需是公共的、非抽象的、void返回值
     * 方法参数为：
     * Session (可选的)
     * Throwable cause (必需的)
     */
    @OnWebSocketError
    public void onError(Throwable e) {
        System.out.println("服务端AnnotatedEchoSocket3的异常" + e);
    }


}