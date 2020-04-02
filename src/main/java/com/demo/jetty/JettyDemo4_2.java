package com.demo.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

/**
 * jetty+resteasy提供restful服务
 * 相比JettyDemo4，这里使用了ServerConnector connector，暂时不知道具体作用
 */
public class JettyDemo4_2 {
    //private static String hostIp = "127.0.0.1";
    private static int port = 8080;

    public static void main(String[] args) throws Exception {
        Server server=new Server();
        ServerConnector connector=new ServerConnector(server);
        connector.setPort(port);
        server.addConnector(connector);

        ServletHolder servletHolder = new ServletHolder(HttpServletDispatcher.class);
        servletHolder.setInitParameter("resteasy.resources","com.demo.jetty.JettyController");//关联controller
        servletHolder.setInitParameter("resteasy.servlet.mapping.prefix", "/rest/v1/");//resteasy前缀   http://localhost:8080/base/rest/v1/xxx

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/base");//设置上下问路径 http://localhost:8080/base
        handler.addServlet(servletHolder, "/rest/*");//这里可以设置成/rest/*或者/rest/v1/*
        server.setHandler(handler);
        server.start();

        server.join();

    }
}
