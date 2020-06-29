package com.demo.jetty.websocket.server2.demo2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;


/**    WebSocketServletFactory来自于<artifactId>websocket-servlet</artifactId，
 *     Basic WebSocketServletFactory for working with Jetty-based WebSocketServlets
 *        <dependency>
 *             <groupId>org.eclipse.jetty.websocket</groupId>
 *             <artifactId>websocket-servlet</artifactId>
 *             <version>9.4.19.v20190610</version>
 *         </dependency>
 *
 *
 *
 */
public class StartServer2 {
    public static void main(String args[]) {
        WebSocketHandler handler = new WebSocketHandler() {
            @Override
            public void configure(WebSocketServletFactory webSocketServletFactory) {
                webSocketServletFactory.getPolicy().setIdleTimeout(10L * 60L * 1000L);
                webSocketServletFactory.getPolicy().setAsyncWriteTimeout(10L * 1000L);

                //Register a websocket class  with the default WebSocketCreator.
                webSocketServletFactory.register(AnnotatedEchoSocket2.class);
            }
        };


        ContextHandler context = new ContextHandler();
        context.setContextPath("/test2/");   //ws://127.0.0.1:7778/test/
        context.setHandler(handler);

        Server server = new Server(7778);
        server.setHandler(context);
        try
        {
            /* 启动服务端 */
            server.start();
            server.join();
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }

    }
}
