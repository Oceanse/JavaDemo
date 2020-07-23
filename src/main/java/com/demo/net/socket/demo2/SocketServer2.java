package com.demo.net.socket.demo2;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer2 {
    public static void main(String[] args) throws IOException {
        //创建一个ServerSocket, 在端口55533监听客户请求
        ServerSocket serverSocket=new ServerSocket(55533);
        System.out.println("server将一直等待连接的到来");
        //等待客户端的连接请求，返回与该客户端进行通信用的Socket对象,The method blocks until a connection is made
        Socket socket = serverSocket.accept();

        //建立好连接后，从socket中获取输入流,输入流
        InputStream inputStream = socket.getInputStream();
        //从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中，然后打印数组内容
        byte[] bytes = new byte[1024];
        int len;
        while((len=inputStream.read(bytes))!=-1){
            System.out.print(new String(bytes,0,len,"UTF-8"));
        }

        //通过outputStream向客户端
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello Client,I get the message.".getBytes("UTF-8"));
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
