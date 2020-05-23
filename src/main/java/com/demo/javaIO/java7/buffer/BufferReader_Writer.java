package com.demo.javaIO.java7.buffer;

import org.testng.annotations.Test;

import java.io.*;

public class BufferReader_Writer {


    @Test
    public void test() throws IOException {
        File sourc = new File("pom.xml");
        File dest = new File("testResource\\out.txt");

        FileReader fr = new FileReader(sourc);
        FileWriter fw = new FileWriter(dest, true);//fos指向被写文件,如果有这个文件，在这个文件后面追加数据.

        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);

        char[] b = new char[10];
        int len;
        while ((len = br.read(b)) != -1) {
            bw.write(b, 0, len);
        }

        //后打开先关闭,先打开后关闭
        bw.close();
        br.close();
        fw.close();
        fr.close();
    }


    @Test
    public void test2() throws IOException {
        File sourc = new File("pom.xml");
        File dest = new File("testResource\\out.txt");

        FileReader fr = new FileReader(sourc);
        FileWriter fw = new FileWriter(dest, true);//fos指向被写文件,如果有这个文件，在这个文件后面追加数据.

        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);

        String content;
        while ((content = br.readLine()) != null) {
            bw.write(content);
            bw.newLine();
        }

        //后打开先关闭,先打开后关闭
        bw.close();
        br.close();
        fw.close();
        fr.close();
    }
}
