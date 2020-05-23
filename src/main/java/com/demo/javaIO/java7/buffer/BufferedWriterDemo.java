package com.demo.javaIO.java7.buffer;

import org.testng.annotations.Test;

import java.io.*;


/**
 * 带缓冲区的字符输出流：
 *
 * 构造函数：
 * BufferedWriter(Writer out)
 * 常见：BufferedWriter(FileWriter fileWriter)  BufferedWriter(OutputStreamWriter fileWriter)
 */
public class BufferedWriterDemo {

    @Test
    public static void test() throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("testResource\\out.txt"));
        bw.write("今天是2020.05.17");
        bw.newLine();//Writes a line separator
        bw.write("Come on!");

        bw.flush();
        bw.close();
    }



    @Test
    public static void test2() throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("testResource\\out.txt")));
        bw.write("今天是2020.05.17");
        bw.newLine();//Writes a line separator
        bw.write("Come on!");

        bw.flush();
        bw.close();
    }

}
