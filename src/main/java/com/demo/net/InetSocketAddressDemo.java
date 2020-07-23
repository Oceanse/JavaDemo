package com.demo.net;

import org.eclipse.jetty.server.Server;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * InetSocketAddress类主要作用是封装端口 他是在在InetAddress基础上加端口
 * 此类实现 IP 套接字地址（IP 地址 + 端口号）。它还可以是一个对（主机名 + 端口号），
 * 在此情况下，将尝试解析主机名。如果解析失败，则该地址将被视为未解析 地址，
 * 但是其在某些情形下仍然可以使用，比如通过代理连接。
 */
public class InetSocketAddressDemo {

    /**
     * 开启ServerSocket(阻塞)用于test()方法连接测试
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("server将一直等待连接的到来");
        //等待客户端的连接请求，返回与该客户端进行通信用的Socket对象,The method blocks until a connection is made
        Socket socket = serverSocket.accept();  //当有客户端试图连接此socket时，就会解除阻塞行为，后面的代码就可以被执行
        System.out.println("当前有客户端试图连接此socket，现在我可以被执行");
    }


    /**
     * 连接serverSocket
     * @throws IOException
     */
    @Test
    public void test() throws IOException {

        // 封装IP/port, ip+port可以唯一标识主机中的应用程序（进程）
        InetSocketAddress add = new InetSocketAddress("localhost", 10086);

        //获取port
        System.out.println(add.getPort());

        //封装IP
        InetAddress addr = add.getAddress();
        System.out.println(addr.getHostAddress());//返回ip
        System.out.println(addr.getHostName());//返回域名
    }


    /**
     * jetty是非阻塞的
     * 连接成功
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Server server = new Server(10085);
        server.start(); //jetty server是非阻塞的
        InetSocketAddress add = new InetSocketAddress("localhost", 10085);
        Socket socket = new Socket();
        try {
            socket.connect(add, 10000);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("socket.isConnected(): " + socket.isConnected());
            socket.close();
            server.stop();
        }
    }



    /**
     * jetty是非阻塞的
     * 连接失败
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        Server server = new Server(10085);
        server.start(); //jetty server是非阻塞的
        InetSocketAddress add = new InetSocketAddress("localhost", 10086);
        //InetSocketAddress add=new InetSocketAddress("localhost",55533);
        Socket socket = new Socket();
        try {
            socket.connect(add, 10000);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("socket.isConnected(): " + socket.isConnected());
            socket.close();
            server.stop();
        }
    }

}
