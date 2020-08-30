package com.demo.jetty.jettydemo3;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JettyDemo3 {

    /**
     * http://localhost:8888/test3/hello/world?name=1&passwd=2
     */
    public static void main(String[] args) throws Exception {
        Server server = new Server(8888);
        ContextHandler context = new ContextHandler();
        context.setContextPath("/test3/"); // http://localhost:8888/test3/xxx,
        context.setHandler(new HelloHandler());//setHandler(Handler handler)   通过setHandler来设置处理器
        server.setHandler(context);
        server.start();
        server.join();
    }
}


/**
 * jetty自己提供的handler: AbstractHandler
 * 定制自己的处理器
 */
class HelloHandler extends AbstractHandler {

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        //用于设置服务器响应给客户端的数据的编码，告诉浏览器采用指定编码方式来解码
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("HelloHandler receive the request"+"<br>");

        // 获取请求参数
        String name = request.getParameter("name");
        String password = request.getParameter("passwd");
        if (name != null) {
            response.getWriter().println("name：" + name);
        }

        if (password != null) {
            response.getWriter().println("passwd：" + password);
        }

        // 表示请求处理完成
        baseRequest.setHandled(true);
    }

}