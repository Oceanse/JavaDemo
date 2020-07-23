package com.demo.net.socket.demo1;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        //server socket, 该port处于监听状态
        InetSocketAddress add=new InetSocketAddress("localhost",10085);

        //client socket
        Socket socket=new Socket();
        try {
            socket.connect(add,10000);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("socket.isConnected(): "+socket.isConnected());
            socket.close();
        }
    }}

