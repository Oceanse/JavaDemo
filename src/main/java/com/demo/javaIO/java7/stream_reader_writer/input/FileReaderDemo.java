package com.demo.javaIO.java7.stream_reader_writer.input;

import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 *FileReader(字符输入流)： 读取存储在用户计算机上的文本文件（或原始数据缓冲区）的内容到内存中
 *
 * 继承关系： FileReader----->InputStreamReader(字节->字符转换流)------->Reader
 *
 *          FileReader
 * 内存<-------------------文件
 *
 * 构造函数：
 * FileReader(File file): Creates a new FileReader, given the File to read from.
 * FileReader(String fileName): Creates a new FileReader, given the name of the file to read from.
 *
 * 常用方法：
 * public int read() throws IOException ： 读取单个字符，返回一个int型变量代表读取到的字符
 * public int read(char [] c)： 读取字符到c数组，返回读取到字符的个数
 *
 *
 *
 *
 */
public class FileReaderDemo {


    /**
     * 内容是abc
     * @throws IOException
     */
    @Test
    public void test() throws IOException {

        System.out.println(Charset.defaultCharset().name());

        File file = new File("testResource\\out.txt");

        //通过FileReader发现，这里实际上将文件关联的FileInputStream按照默认的encoding转换成InputStreamReader(可理解成字符流)，包含着解码的过程，默认使用utf-8解码
        //然后通过InputStreamReader中的read()读取单个字符
        FileReader fr=new FileReader(file);


        //read(): Reads a single character. 本质是通过InputStreamReader中的read()读取单个字符
        //返回字符对应的编码，这里的单个字符采用utf-8编码(包含着编码的过程)
        System.out.println(fr.read());
        System.out.println(fr.read());
        System.out.println(fr.read());
        System.out.println(fr.read());
    }


    @Test
    public void test2() throws IOException {
        File file = new File("testResource\\out.txt");
        FileReader fr=new FileReader(file);

        //返回字符编码对应的字符,相当于用utf-8解码
        System.out.println((char)fr.read());
        System.out.println((char)fr.read());
        System.out.println((char)fr.read());
        System.out.println((char)fr.read());

    }


    @Test
    public void test3() throws IOException {
        FileReader fr=null;
        try {
            //通过FileReader发现，这里实际上将文件关联的FileInputStream按照默认的encoding转换成InputStreamReader(可理解成字符流)，包含着解码的过程，默认使用utf-8解码
            fr=new FileReader("testResource\\out.txt");

            //Reads characters into an array
            char[] b=new char[9];
            fr.read(b);
            System.out.println(Arrays.toString(b));
                System.out.print(new String(b));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println();
                System.out.println("closing....");
                fr.close();//关闭流，释放内存资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void test4() throws IOException {
        File file = new File("testResource\\out.txt");
        FileReader fr=null;

        int num=0;//统计字符个数；
        int i;
        fr=new FileReader(file);
        while((i=fr.read())!=-1){    //read()返回下一个字符的整数；如果已到达文件末尾，则返回 -1；Reader流里面的read()方法是一个字符一个字符地读取的
            System.out.print((char)i);
            num++;
        }
        System.out.println("\n"+"字符个数: "+num);
        fr.close();//关闭流，释放内存资源
    }


    @Test
    public void test5() throws IOException {
        FileReader fr=null;
        try {
            fr=new FileReader("testResource\\out.txt");
            char[] b=new char[10];
            int len;
            while((len=fr.read(b))!=-1){
                System.out.print(new String(b,0,len));//读取数组中的有效长度
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println();
                System.out.println("closing....");
                fr.close();//关闭流，释放内存资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
