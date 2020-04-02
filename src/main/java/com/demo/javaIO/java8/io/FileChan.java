package com.demo.javaIO.java8.io;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChan {
    public static void main(String[] args)  {


    }
    public void test()throws Exception{
        RandomAccessFile ra=new RandomAccessFile ("out.txt","rw");
        FileChannel channel = ra.getChannel();

        ByteBuffer buf=ByteBuffer.allocate(1024);
        int bytesRead = channel.read(buf);
        System.out.println(bytesRead);
    }


    public void test2()throws Exception{

    }
}
