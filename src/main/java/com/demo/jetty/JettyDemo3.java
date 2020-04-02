package com.demo.jetty;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JettyDemo3 {

     // url以及参数可以任意设置  http://localhost:8888/任意设置
    //http://localhost:8888/hello/world?q1=1&q2=2
    public static void main(String[] args) throws Exception {
        Server server = new Server(8888);
        server.setHandler(new HelloHandler());
        server.start();
        server.join();
    }
}


class HelloHandler extends AbstractHandler {

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");//用于设置服务器响应给客户端的数据的编码，告诉浏览器采用指定编码方式来解码

        long threadId = Thread.currentThread().getId();
        response.getWriter().println("target:" + target);
        response.getWriter().println("hello" + threadId);
        String name = request.getParameter("name");
        String password = request.getParameter("passwd");
        if (name!=null) {
            response.getWriter().println("名字："+name);
        }

        if (password!=null) {
            response.getWriter().println("密码："+password);
        }


        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
    }

}