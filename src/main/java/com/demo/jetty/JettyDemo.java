package com.demo.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author epanhai
 * Jetty是一个Java实现的开源的servlet容器，它既可以像Tomcat一样作为一个完整的Web服务器和Servlet容器,jetty更轻量一些，允许将jetty嵌入到程序中执行
 *
 * Jetty有一个标语：“不要在Jetty中部署你的应用，在你的应用中部署Jetty！”这个意思是与其打包你的应用作为一个标准WAR被部署在Jetty中，
 * Jetty更倾向于被作为一个软件组件像任何POJO一样被实例化并且用在Java程序中。换句话说，在嵌入模式中运行Jetty意味着放一个HTTP模块到你的应用中，
 * 而不是放你的应用到一个HTTP server中。
 *
 * 在Jetty里Context是包含了在某一特定URL或Virtual Host下的一组Handler的Handler。可以这样理解，Context本身也是一种Handler，
 * 它里面包含了许多的Handler，这些Handler都只能处理某个特定URL下的请求。Jetty里的Context有ContextHandler，ServletContext和WebAppContext
 */
public class JettyDemo {
    public static void main(String[] args) throws Exception {

        //一般情况下context收到http请求之后，这个请求最终都会直接交到servletHandler来处理，因此它也需要负责对http请求的path进行处理，从而才能将这个http请求交给正确的servlet。
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        //设置上下文路径(根url)：localhost:8080/base/
        context.setContextPath("/base");

        //设置处理rest请求的Servlet及子url,指定Servlet和Servlet匹配的url
        context.addServlet(new ServletHolder(new HelloServlet()), "/hello");//localhost:8080/base/hello
        context.addServlet(new ServletHolder(new HiServlet()), "/hi");//localhost:8080/base/hi

        // Starting up Jetty to serve the RESTful API
        // Create a basic jetty server object that will listen on port 8080.  Note that if you set this to port 0 then a randomly available port will be assigned
        Server server=new Server(8080);//监听8080端口
        server.setHandler(context);
        server.start();
        server.join();
    }

}


class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = -6154475799000019575L;

    private static final String greeting = "Hello World";

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {

        response.setContentType("text/html;charset=UTF-8");//设置响应的内容类型以及编码方式：
        request.setCharacterEncoding("UTF-8");//请求编码方式
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(greeting);
        System.out.println("I am called");
    }

}



class HiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {


        //request.setCharacterEncoding(“UTF-8”)的作用是设置客户端请求和数据库取值时的编码，不指定的话使用iso-8859-1；
        //此行代码必须写在最前面或者所有request.getParameter("");方法之前
        request.setCharacterEncoding("UTF-8");//请求编码方式


        //response.setCharacterEncoding():用于设置服务器响应给客户端的数据的编码,告诉浏览器采用指定编码方式来解码，一般不会用这个方法来设置响应编码,而是采用response.setContentType()
        //它会自动调用response.setCharacterEncoding()方法来通知浏览器以指定编码方式来解码，使用此方法要在response.getWriter()执行之前
        response.setContentType("text/html;charset=UTF-8");//指定服务器响应给浏览器的内容类型html以及编码方式：
        response.setStatus(HttpServletResponse.SC_OK);
        //有中文write给Client端，所以我设置了HttpServletResponse 中 CharacterEncod 为“UTF-8”
        //注意这个设置编码要再写给Client之前设置！

        String name = request.getParameter("name");
        String password = request.getParameter("passwd");
        if (name!=null) {
            response.getWriter().println("名字："+name);
        }

        if (password!=null) {
            response.getWriter().println("密码："+password);
        }

        String characterEncoding = request.getCharacterEncoding();
        if (characterEncoding!=null) {
            response.getWriter().println("characterEncoding："+characterEncoding);
        }

        String contextPath = request.getContextPath();
        response.getWriter().println("contextPath: "+contextPath);

        StringBuffer requestURL = request.getRequestURL();
        response.getWriter().println("requestURL: "+requestURL);


        String head = request.getHeader("head");
        if (head!=null) {
            response.getWriter().println("head："+head);
        }


        response.getWriter().println("hahahah");
        String characterEncoding1 = response.getCharacterEncoding();
        response.getWriter().println("characterEncoding1："+characterEncoding1);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {

        response.setContentType("text/html;charset=UTF-8");//设置响应的内容类型以及编码方式：
        request.setCharacterEncoding("UTF-8");//请求编码方式
        response.setStatus(HttpServletResponse.SC_OK);
        //有中文write给Client端，所以我设置了HttpServletResponse 中 CharacterEncod 为“UTF-8”
        //注意这个设置编码要再写给Client之前设置！

        String name = request.getParameter("name");
        String password = request.getParameter("passwd");
        if (name!=null) {
            response.getWriter().println("名字："+name);
        }

        if (password!=null) {
            response.getWriter().println("密码："+password);
        }

        String characterEncoding = request.getCharacterEncoding();
        if (characterEncoding!=null) {
            response.getWriter().println("characterEncoding："+characterEncoding);
        }

        String contextPath = request.getContextPath();
        response.getWriter().println("contextPath: "+contextPath);

        StringBuffer requestURL = request.getRequestURL();
        response.getWriter().println("requestURL: "+requestURL);


        String head = request.getHeader("head");
        if (head!=null) {
            response.getWriter().println("head："+head);
        }


        response.getWriter().println("hahahah");
    }

}

