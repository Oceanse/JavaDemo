package com.demo.net.socket.demo1;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    /**
     * socket.accept()导致阻塞发生,也就是只有客户端的socket和server端的socket链接成功后才会解除block
     * @throws Exception
     */
    public static void main(String[] args) throws IOException {

        //启动server sockets, 监听10086
        ServerSocket socket=new ServerSocket(10085);
        System.out.println("server将一直等待连接的到来");

        //The method blocks until a connection is made
        Socket serverSocket = socket.accept();

        System.out.println("The connection between server and client is set up");
    }

}
