package com.demo.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.testng.annotations.Test;

public class JettyDem3 {
    public static void main(String[] args) throws Exception {
    }


    /**
     * 运行Java程序，Jetty服务器启动。此时在浏览器中访问http://localhost:8081就可以浏览C:\Users\epanhai文件夹中的所有文件的列表
     * 但是只能访问静态页面，上面的程序无法支持Servlet/JSP。
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        Server server = new Server(8081);

        //This handle will serve static content
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("C:\\Users\\epanhai");

        //true if directories are listed.
        resourceHandler.setDirectoriesListed(true);
        server.setHandler(resourceHandler);

        server.start();//这里个人暂时把serverd的启动理解为一个新启动的线程

        server.join();//这里面join（）函数骑到的作用就是使主线程阻塞，只有当server线程执行完毕，主线程才重新进入运行状态，后面的代码才会被运行
        System.out.println("good luck");
    }


    /**
     * 设置一个Java Web应用程序的目录，访问http://localhost:8080，此时已经支持Servlet/JSP
     * 但是仍然无法访问
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Server server = new Server(8081);

        WebAppContext webapp = new WebAppContext();
        webapp.setResourceBase("C:\\Users\\epanhai");

        server.setHandler(webapp);

        server.start();
        server.join();
    }

}
