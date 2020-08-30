package com.demo.jetty.websocket.server2.demo1;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import java.io.IOException;


/**
 * https://www.eclipse.org/jetty/documentation/current/jetty-websocket-api-annotations.html
 *
 * jetty server + @WebSocket + WebSocketServlet 使得 AnnotatedEchoSocket具有servlet性质的服务端websocket
 *
 * @WebSocket: Flags this POJO as being a WebSocket class.The class must be not abstract and public.
 * WebSocketServlet: Abstract Servlet used to bridge the Servlet API to the WebSocket API.
 * WebSocketServlet个人理解：
 *   1主要是继承他的configure方法来注册WebSocket class(实例化WebSocket class)
 *   2 标明子类本质上仍然是一个Servlet
 */
@WebSocket(maxTextMessageSize = 128 * 1024, maxBinaryMessageSize = 128 * 1024)
public class AnnotatedEchoSocket extends WebSocketServlet {
    Session session;


    /**
     * register your websockets with the  WebSocketServletFactory
     * 在WebSocket类中，对自己WebSocket类注册
     * @param factory
     */
    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(0);//测试发现，这里必须设置为0，否则连接时候会报TimeoutException: Idle timeout expired: xxx ms，不知为什么

       //Register a websocket class with the default WebSocketCreator.
        factory.register(AnnotatedEchoSocket.class);
    }

    /**
     * @param session
     * @OnWebSocketConnect An optional method level
     * <p>
     * Flags one method in the class as receiving the On Connect event.
     * <p>
     * Method must be public, not abstract, return void, and have a single Session parameter.
     */

    @OnWebSocketConnect
    public void onText(Session session) throws Exception {
        this.session=session;
        session.getRemote().sendString("这是来自服务端AnnotatedEchoSocket的onOpen方法的消息");

    }


    @OnWebSocketClose
    public void onClose(int i, String string) throws IOException {
        System.out.println("服务端onClose。。。。");
        //session.getRemote().sendString("这是来自服务端AnnotatedEchoSocket2的onClose方法的消息");
    }


    @OnWebSocketMessage
    public void onMessage(String msg) throws IOException {
        System.out.println("服务器收到消息 " + msg);
        session.getRemote().sendString("这是来自服务端AnnotatedEchoSocket的onMessage方法的消息");
    }


    /**
     * 方法必需是公共的、非抽象的、void返回值
     * 方法参数为：
     * Session (可选的)
     * Throwable cause (必需的)
     */
    @OnWebSocketError
    public void onError(Throwable e) {//测试发现参数必须是Throwable e，不能是Execption e,不知为什么
        System.out.println("服务端AnnotatedEchoSocket的异常" + e);
    }

}