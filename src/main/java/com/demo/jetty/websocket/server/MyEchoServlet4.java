package com.demo.jetty.websocket.server;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "MyEchoServlet4 Servlet", urlPatterns = {"/echo"})
public class MyEchoServlet4 extends WebSocketServlet {
    Session session;

    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(0);//测试发现，这里必须设置为0，否则连接时候会报TimeoutException: Idle timeout expired: xxx ms，不知为什么
        factory.register(AnnotatedEchoSocket4.class);
    }
}
