package com.demo.javaIO.java7.stream_reader_writer.inandout;

import org.testng.annotations.Test;

import java.io.*;

public class Io_Reader_Writer {

    @Test
    public void test() throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }



    public static void main(String[] args) throws IOException {

        File sourc = new File("testResource\\test.txt");
        File dest = new File("testResource\\out.txt");

        FileReader fr = new FileReader(sourc);
        FileWriter fw = new FileWriter(dest, true);//fos指向被写文件,如果有这个文件，在这个文件后面追加数据.

        char[] b = new char[10];
        int len;
        while ((len = fr.read(b)) != -1) {
            fw.write(b, 0, len);
        }

        fw.close();//后打开先关闭
        fr.close();//先打开后关闭

    }


}
