package com.demo.javaIO.java7.buffer;

import org.testng.annotations.Test;

import java.io.*;

/**
 * java.io.BufferedReader--->java.io.Reader--->java.lang.Object
 * BufferedReader(成带有缓冲区的字符输入流): Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
 *
 * 构造函数：
 * public BufferedReader(Reader in) 参数通常是FileReader和InputStreamReader(字节->字符转换流)
 * 常用方法：
 * public String readLine() throws IOException：Reads a line of text
 */
public class BufferedReaderDemo {

    /**
     * 这里文件编码方式是utf-8, jvm默认字符集是utf-8,所以会出现乱码
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {

        //三行内容： abc 中国人 你最牛
        FileReader fr = new FileReader("testResource\\out.txt");//节点流

        //将字符输入流包装成带有缓冲区的字符输入流
        BufferedReader br = new BufferedReader(fr);//缓冲流

        //推测：br读取每一行的底层编码，然后按照系统的默认encoding解码
        //这里文件编码方式是utf-8, jvm默认字符集是utf-8
        System.out.println(br.readLine());//abc
        System.out.println(br.readLine());//中国人
        System.out.println(br.readLine());//你最牛

        //关闭时候只需要关闭最外层的包装流(装饰者模式)
        br.close();//关闭流，释放内存资源
    }


    /**
     * 这里文件编码方式是GB2312, jvm默认字符集是utf-8,所以会出现乱码
     * @throws IOException
     */
    @Test
    public void test1_2() throws IOException {

        //三行内容： abc 中国人 你最牛
        FileReader fr = new FileReader("testResource\\out.txt");//节点流

        //将字符输入流包装成带有缓冲区的字符输入流
        BufferedReader br = new BufferedReader(fr);//缓冲流

        //推测：br读取每一行的底层编码，然后按照系统的默认encoding解码
        //这里文件编码方式是utf-8, jvm默认字符集是utf-8
        System.out.println(br.readLine());//abc
        System.out.println(br.readLine());//中国人
        System.out.println(br.readLine());//你最牛

        //关闭时候只需要关闭最外层的包装流(装饰者模式)
        br.close();//关闭流，释放内存资源
    }


    @Test
    public void tests3() throws IOException {

        //三行内容： abc 中国人 你最牛
        FileReader fr = new FileReader("testResource\\out.txt");//节点流

        //将字符输入流包装成带有缓冲区的字符输入流
        BufferedReader br = new BufferedReader(fr);//缓冲流

        String readContent = null;
        while ((readContent = br.readLine()) != null) { //Reads a line of text
            System.out.println(readContent);
        }
        //关闭时候只需要关闭最外层的包装流(装饰者模式)
        br.close();//关闭流，释放内存资源
    }



    @Test
    public void test2() throws IOException {

        //将字符输入流包装成带有缓冲区的字符输入流
        FileInputStream fis = new FileInputStream("pom.xml");//字节输入流
        InputStreamReader isr = new InputStreamReader(fis);

        BufferedReader br = new BufferedReader(isr);//缓冲流

        String readContent = null;
        while ((readContent = br.readLine()) != null) {//Reads a line of text
            System.out.println(readContent);
        }
        //关闭时候只需要关闭最外层的包装流(装饰者模式)
        br.close();//关闭流，释放内存资源
    }

}
