package com.demo.jetty.websocket.server2.demo2;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

import java.io.IOException;


/**
 * @WebSocket: Flags this POJO as being a WebSocket class.
 * The class must be not abstract and public.
 *
 * 这里AnnotatedEchoSocket2只是一个websocket class
 */
@WebSocket(maxTextMessageSize = 128 * 1024, maxBinaryMessageSize = 128 * 1024)
public class AnnotatedEchoSocket2 {
    Session session;


    /**
     * @param session
     * @OnWebSocketConnect An optional method level com.demo.annotation.
     * <p>
     * Flags one method in the class as receiving the On Connect event.
     * <p>
     * Method must be public, not abstract, return void, and have a single Session parameter.
     */

    @OnWebSocketConnect
    public void onText(Session session) throws Exception {
        this.session=session;
        session.getRemote().sendString("这是来自服务端AnnotatedEchoSocket2的onOpen方法的消息");
    }


    @OnWebSocketClose
    public void onClose(int i, String string) throws IOException {
        System.out.println("服务端2onClose。。。。");
        //session.getRemote().sendString("这是来自服务端onClose方法的消息");
    }


    @OnWebSocketMessage
    public void onMessage(String msg) throws IOException {
        System.out.println("服务器收到消息 " + msg);
        session.getRemote().sendString("这是来自服务端AnnotatedEchoSocket2的onMessage方法的消息");
    }


    /**
     * 方法必需是公共的、非抽象的、void返回值
     * 方法参数为：
     * Session (可选的)
     * Throwable cause (必需的)
     */
    @OnWebSocketError
    public void onError(Throwable e) {//测试发现参数必须是Throwable e，不能是Execption e,不知为什么
        System.out.println("服务端AnnotatedEchoSocket2的异常" + e);
    }

}