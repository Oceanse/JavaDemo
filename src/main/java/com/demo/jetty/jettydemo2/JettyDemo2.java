package com.demo.jetty.jettydemo2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class JettyDemo2 {
    private static final int IDLE_TIMEOUT = 30;
    private static CountDownLatch latch = new CountDownLatch(1);
    static int i = 30;

    public static void main(String[] args) throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        //设置根url localhost:8080/hello
        context.setContextPath("/base");

        //只能访问localhost:8080/hello/a 来访问HelloServlet2
        context.addServlet(new ServletHolder(new HelloServlet2()), "/hello");
        Server server = new Server(8080);
        server.setHandler(context);

        //context.addServlet(new ServletHolder(new HelloServlet2()), "/*"); 访问localhost:8080/hello/a, localhost:8080/hello/a都行(通配符)
        server.start();//启动服务器
        waitForIdleTimeout();//开启定时器和计时器锁，不断轮询服务器启动时间，若启动时间大于某个值，就取消定时轮询
        server.stop();//关闭服务器
    }

    private static void waitForIdleTimeout() throws InterruptedException {
        Timer timer = new Timer();
        long init = System.currentTimeMillis();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("当前i值是： "+i--);
                if (System.currentTimeMillis() - init > 30000) {//server启动时间大于30s时候
                    System.out.println((System.currentTimeMillis() - init)/1000);//打印server启动时间
                    latch.countDown();//计时器锁初始值为1，减1变成0，
                }
            }
        }, 0, 1000);
        latch.await();//阻塞后面线程
        timer.cancel();//取消定时执行任务

    }


}


class HelloServlet2 extends HttpServlet {

    private static final long serialVersionUID = -6154475799000019575L;

    private static final String greeting = "Hello HelloServlet2";

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(greeting);
        System.out.println("I am called");
    }

}