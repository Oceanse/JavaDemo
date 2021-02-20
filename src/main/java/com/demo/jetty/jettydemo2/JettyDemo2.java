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

/**
 *  Jetty-server + jetty-Servlet提供RESTful API
 *
 * <dependency>
 *     <groupId>org.eclipse.jetty</groupId>
 *     <artifactId>jetty-servlet</artifactId>
 *     <version>9.4.19.v20190610</version>
 * </dependency>
 *
 * <dependency>
 *     <groupId>org.eclipse.jetty</groupId>
 *     <artifactId>jetty-server</artifactId>
 *     <version>${jetty.version}</version>
 * </dependency>
 */
public class JettyDemo2 {
    private static final int IDLE_TIMEOUT = 30;

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
        waitForIdleTimeout2();//开启定时器和计时器锁，不断轮询服务器启动时间，若启动时间大于某个值，就取消定时轮询
        server.stop();//关闭服务器
    }

    private static void waitForIdleTimeout() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Timer timer = new Timer();
        long init = System.currentTimeMillis();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (System.currentTimeMillis() - init > 5000) {//server启动时间大于5s时候
                    System.out.println("server当前运行了: "+(System.currentTimeMillis() - init)/1000+" s");//打印server启动时间
                    latch.countDown();//计时器锁初始值为1，减1变成0，
                }
            }
        }, 0, 1000);
        latch.await();//阻塞后面线程
        timer.cancel();//取消定时执行任务
    }


    private static void waitForIdleTimeout2() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);//Latch是门闩的意思
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("server will be shutdown after "+latch.getCount()+" s");
                latch.countDown();//计时器锁初始值为5，countDown()后减1
            }
        }, 0, 1000);//每1s执行一次任务
        latch.await();//latch门闩阻塞后面线程，直到latch变为0, 阻塞就会接触，然后继续执行(门闩一开始是关着的，直到变成0，门闩才会打开)
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