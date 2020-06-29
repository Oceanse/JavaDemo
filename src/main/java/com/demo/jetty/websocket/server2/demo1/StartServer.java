package com.demo.jetty.websocket.server2.demo1;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class StartServer {
    public static void main(String[] args) throws Exception {
        Server server=new Server(8080);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/base");//设置上下问路径 http://localhost:8080/base

        //两个servlet和两个path匹配，注意path后面的/要和client端请求url中的/同有同无，保持一致
        handler.addServlet(new ServletHolder(AnnotatedEchoSocket.class), "/path2/");
        handler.addServlet(new ServletHolder(AnnotatedEchoSocket2.class), "/path2_2/");
        server.setHandler(handler);
        server.start();

        server.join();
    }
}
