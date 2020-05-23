package com.demo.javaIO.java7.buffer;

import org.testng.annotations.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {
    /**
     * BufferedOutputStream(OutputStream out)： 创建一个新的缓冲输出流
     */
    @Test
    public void test() {
        File f = new File("testResource\\out.txt"); //文件不存在会在工程根目录下被创建,如果有这个文件，会清空这个文件的数据
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream(f, true);//fos指向被写文件,如果有这个文件，在这个文件后面追加数据.
            bos = new BufferedOutputStream(fos);
            bos.write("asdfghj".getBytes(), 0, 4);//从指定的字节数组写入此输出流，然后输出流流向文件

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {//关闭流，释放内存资源
                bos.close();//后打开的先关闭
                fos.close();//先打开的后关闭
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * public FileOutputStream(File file, boolean append)；如果没有这个文件，会创建该文件;如果有这个文件，在这个文件后面追加数据.
     * BufferedOutputStream(OutputStream out)： 创建一个新的缓冲输出流
     */
    @Test
    public void test4() {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream("testResource\\out.txt", true);//fos指向被写文件,如果有这个文件，在这个文件后面追加数据.
            bos = new BufferedOutputStream(fos);
            bos.write("012345".getBytes(), 0, 4);//从指定的字节数组写入此输出流，然后输出流流向文件

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();//后打开的先关闭
                fos.close();//先打开的后关闭
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
