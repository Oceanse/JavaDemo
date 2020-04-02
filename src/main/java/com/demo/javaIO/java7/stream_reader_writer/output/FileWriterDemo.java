package com.demo.javaIO.java7.stream_reader_writer.output;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/*
* java.io.FileWriter类是写出字符到文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区。
*
* 构造方法
1、 FileWriter(File file)： 创建一个新的 FileWriter，给定要读取的File对象。如果没有这个文件，会创建该文件;如果有这个文件，会清空这个文件的数据.
2、FileWriter(String fileName)： 创建一个新的 FileWriter，给定要读取的文件的名称。如果没有这个文件，会创建该文件;如果有这个文件，会清空这个文件的数据.
3、FileWriter(File file)：创建一个新的 FileWriter，给定要读取的File对象。如果没有这个文件，会创建该文件;如果有这个文件，在这个文件后面追加数据.
4、FileWriter(String fileName, boolean appender)创建一个新的 FileWriter，给定要读取的文件的名称. 如果没有这个文件，会创建该文件;如果有这个文件，在这个文件后面追加数据.
*
* write(int b) 方法，每次可以写出一个字符数据
* write(String string)
*
*
* */
public class FileWriterDemo {

    @Test
    public void test(){
        File f=new File("testResource\\test.txt");
        FileWriter fw=null;
        try {
            try {
                fw=new FileWriter(f);//如果没有这个文件，会创建该文件;如果有这个文件，会清空这个文件的数据.
                fw.write("i love china !");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fw.close();//关闭流，释放内存资源
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void test2(){
        File f=new File("testResource\\test.txt");
        FileWriter fw=null;
        try {
            try {
                fw=new FileWriter("testResource\\test.txt",true);//如果没有这个文件，会创建该文件;如果有这个文件，在这个文件后面追加数据.
                fw.write("i love china !");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fw.close();//关闭流，释放内存资源
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
