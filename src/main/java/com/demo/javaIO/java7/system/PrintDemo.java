package com.demo.javaIO.java7.system;

import org.testng.annotations.Test;

import java.io.*;

/**
 * 打印流主要包含两个： PrintStream和PrintWriter,分别对应字节流和字符流
 * System.out对应的就是PrintStream,默认输出到控制台，我们可以重定向他的输出到文件，也就是使得 System.out.println("hello")输出到文件而不是控制台
 */
public class PrintDemo {


    @Test
    public static void test() throws FileNotFoundException {

        //System中的print默认打印到控制台
        PrintStream out = System.out;
        out.println("java...");

        //打印"water"到文件out.txt
        PrintStream out2=new PrintStream(new FileOutputStream("testResource\\out.txt"));
        out2.print("water");
    }




    @Test
    public static void test1_2() throws FileNotFoundException {

        PrintStream out=new PrintStream(new FileOutputStream("testResource\\out.txt"));

        //void setOut(PrintStream out)
        System.setOut(out);//Reassigns the "standard" output stream, 修改System中PrintStream的输出方向，这是重定向到文件
        System.out.print("water");
    }



    @Test
    public static void test1_3() throws FileNotFoundException {

        PrintStream out=new PrintStream("testResource\\out.txt");

        //void setOut(PrintStream out)
        System.setOut(out);//Reassigns the "standard" output stream, 修改System中PrintStream的输出方向，这是重定向到文件
        System.out.print("watermelon");
    }


    @Test
    public static void test2() throws IOException {

        // PrintWriter(String s)传路径
        PrintWriter pw = new PrintWriter("testResource\\out.txt");

        pw.println("飞雪连天射白鹿");
        pw.println("金庸小说我都爱看");
        System.out.println("写出完毕！");
        pw.close();    }


    @Test
    public static void test2_2() throws IOException {

        // PrintWriter(File f)传文件名
        PrintWriter pw=new PrintWriter(new FileWriter("testResource\\out.txt"));

        pw.println("飞雪连天射白鹿");
        pw.println("金庸小说我都爱看");
        System.out.println("写出完毕！");
        pw.close();    }



    @Test
    public static void test2_3() throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("pom.xml"));
            outputStream = new PrintWriter(new FileWriter("testResource\\out.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }}
}



