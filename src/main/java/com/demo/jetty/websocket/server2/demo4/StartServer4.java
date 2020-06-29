package com.demo.jetty.websocket.server2.demo4;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;


//有问题
public class StartServer4 {
    public static void main(String[] args) throws Exception {
        Server server=new Server(8080);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/base");//设置上下问路径 http://localhost:8080/base



        /*WebSocketHandler handler = new MyEchoServlet4() {
            @Override
            public void configure(WebSocketServletFactory webSocketServletFactory) {
                webSocketServletFactory.getPolicy().setIdleTimeout(10L * 60L * 1000L);
                webSocketServletFactory.getPolicy().setAsyncWriteTimeout(10L * 1000L);

                //Register a websocket class  with the default WebSocketCreator.
                webSocketServletFactory.register(AnnotatedEchoSocket2.class);
            }
        };*/



       /* //两个servlet和两个path匹配，注意path后面的/要和client端请求url中的/同有同无，保持一致
        handler.addServlet(new ServletHolder(MyEchoServlet4.class), "/path4/");*/


        server.setHandler(handler);
        server.start();

        server.join();
    }
}
