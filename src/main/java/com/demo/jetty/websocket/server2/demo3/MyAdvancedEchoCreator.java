package com.demo.jetty.websocket.server2.demo3;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;

public class MyAdvancedEchoCreator implements WebSocketCreator {


    AnnotatedEchoSocket3 annotatedEchoSocket3;

    public MyAdvancedEchoCreator() {
        annotatedEchoSocket3 = new AnnotatedEchoSocket3();

    }

    @Override
    public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp) {
        for (String sub : req.getSubProtocols())
        {
             //官方的Demo，这里可以根据相应的参数做判断，使用什么样的websocket
        }

        // 没有有效的请求，忽略它
        return annotatedEchoSocket3;

    }
}