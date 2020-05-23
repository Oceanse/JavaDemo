package com.demo.javaIO.java7.system;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * System.in其实是System类的一个静态成员public final static InputStream in；
 * The "standard" input stream. This stream is already open and ready to supply input data
 * Typically this stream corresponds to keyboard input or another input source specified by the host environment or user.
 */
public class SystemInDemo {
    public static void main(String[] args) throws IOException {
        //test();
        test4();
    }


    public static void test() {
        //public Scanner(InputStream source)
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the data: ");
        String content = scanner.nextLine();
        System.out.println(content);
    }


/*    public static void test2() throws IOException {
       //BufferedInputStream(InputStream in)
        BufferedInputStream br=new BufferedInputStream(System.in);
        System.out.println("please input the data: ");
        byte[] b=new byte[10];
        int len;
        while((len=br.read(b))!=-1){
            System.out.print(new String(b,0,len));
        }
        br.close();
    }*/

    public static void test2() throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);//将字节输入流转换成字符输入流
        BufferedReader br = new BufferedReader(isr); //构建缓冲字符输入流BufferedReader(Reader in)
        System.out.println("please input the data: ");
        String content = br.readLine();
        System.out.print(content);
        br.close();
    }

    @Test
    public static void test3() throws IOException {
        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("pom.xml")));

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }


    @Test
    public static void test4() throws IOException {
        int i=System.in.read();//returns ASCII code of 1st character
        System.out.println((char)i);//will print the character
        }



}
