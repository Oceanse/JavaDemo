package com.demo.javaIO.java7.stream_reader_writer.input;

import org.testng.annotations.Test;

import java.io.*;

public class FileReaderDemo {

    @Test
    public void test1() throws IOException {
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
    public void test2() throws IOException {
        File f=new File("testResource\\out.txt");
        FileReader fr=null;
        try {
            fr=new FileReader(f);
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
