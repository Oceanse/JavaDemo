package com.demo.jetty.jettydemo4;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

/**
 * jetty+resteasy提供restful服务，暴露为webservice接口供其他应用调用
 */
public class JettyDemo4 {
    //private static String hostIp = "127.0.0.1";
    private static int port = 8080;

    public static void main(String[] args) throws Exception {

        ServletHolder servletHolder = new ServletHolder(HttpServletDispatcher.class);
        servletHolder.setInitParameter("resteasy.resources","com.demo.jetty.jettydemo4.RestEasyController");//关联controller
        servletHolder.setInitParameter("resteasy.servlet.mapping.prefix", "/rest/v1/");//resteasy前缀   http://localhost:8080/base/rest/v1/xxx
        servletHolder.setInitParameter("param", "paramvalue");

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/base");//设置上下问路径 http://localhost:8080/base


        //这里/rest/v1/*,实际是HttpServletDispatcher对应的url-pattern， HttpServletDispatcher负责把请求分配给某个Servlet
        //这里设置成 /* 或者 /rest/* 或者 /rest/v1/*, prifix中 /rest/v1/ 都会符合该url-pattern，那么请求就会分配到prifix对应的url
        handler.addServlet(servletHolder, "/rest/v1/*");
        Server server=new Server(port);
        server.setHandler(handler);
        System.out.println(servletHolder.getInitParameter("param"));
        server.start();

        server.join();

    }
}
