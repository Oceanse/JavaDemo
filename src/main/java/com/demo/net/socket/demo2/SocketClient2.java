package com.demo.net.socket.demo2;

import org.eclipse.jetty.server.Server;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient2 {
    public static void main(String[] args) throws IOException {

        //要连接的服务端IP地址和端口,与服务端建立连接
        Socket socket=new Socket("127.0.0.1",55533);

        // 建立连接后获得输出流,向server端发送消息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("This message comes from client".getBytes("UTF-8"));

        //通过shutdownOutput告诉服务器已经发送完数据，后续只能接受数据
         socket.shutdownOutput();

        //获得输入流,从server端接受消息
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        while((len=inputStream.read(bytes))!=-1){
            System.out.print(new String(bytes,0,len,"UTF-8"));
        }

        //后打开先关闭
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
