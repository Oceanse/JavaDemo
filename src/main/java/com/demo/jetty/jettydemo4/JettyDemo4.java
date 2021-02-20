package com.demo.jetty.jettydemo4;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

/**
 * jetty-server + jetty-servlet + resteasy提供restful服务，暴露为webservice接口供其他应用调用
 *
 * <dependency>
 *    <groupId>org.eclipse.jetty</groupId>
 *    <artifactId>jetty-server</artifactId>
 *    <version>9.4.19.v20190610</version>
 * </dependency>
 *
 * <dependency>
 *    <groupId>org.eclipse.jetty</groupId>
 *    <artifactId>jetty-servlet</artifactId>
 *    <version>9.4.19.v20190610</version>
 * </dependency>
 *
 * <dependency>
 *     <groupId>org.jboss.resteasy</groupId>
 *     <artifactId>resteasy-jaxrs</artifactId>
 *     <version>3.6.2.Final</version>
 * </dependency>
 *
 *
 */
public class JettyDemo4 {
    //private static String hostIp = "127.0.0.1";
    private static int port = 8080;

    public static void main(String[] args) throws Exception {


        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/base");//设置上下问路径 http://localhost:8080/base

        ServletHolder servletHolder = new ServletHolder(HttpServletDispatcher.class);
        servletHolder.setInitParameter("resteasy.resources", "com.demo.jetty.jettydemo4.RestEasyController");//关联controller，这里可以关联多个controller
        servletHolder.setInitParameter("resteasy.servlet.mapping.prefix", "/rest/v1/");//resteasy前缀   http://localhost:8080/base/rest/v1/xxx
        servletHolder.setInitParameter("param", "paramvalue");//设置参数


        // 这里/rest/v1/*,实际是HttpServletDispatcher对应的url-pattern， HttpServletDispatcher负责把请求分配给某个具体的Servlet或者handler
        // 这里设置成 /* 或者 /rest/* 或者 /rest/v1/*, prifix中 /rest/v1/ 都会符合该url-pattern，那么请求就会分配到prifix对应的url
        // 这里的设置像个大门或者过滤器，只有符合初步筛选条件的url才会进入到下一步的url<--->handler匹配，真正的匹配规则由resteasy.resources和resteasy.servlet.mapping.prefix决定
        handler.addServlet(servletHolder, "/rest/v1/*");
        Server server = new Server(port);
        server.setHandler(handler);
        System.out.println("param:====="+servletHolder.getInitParameter("param"));//取参数
        server.start();

        server.join();

    }
}
