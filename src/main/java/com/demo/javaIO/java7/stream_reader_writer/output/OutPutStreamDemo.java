package com.demo.javaIO.java7.stream_reader_writer.output;

import org.testng.annotations.Test;

import java.io.*;


/*

 * 流就像是连接内存(程序)和其他文件或者网络的管道，程序和文件的数据交换都要通过流的输入输出来完成
 * 当你要从文件或者网络读取数据的时候，一根管道(流)插到文件里面去，然后文件里面的数据就顺着管道流出来，管道的另一头(内存)就可以读取到数据并进行处理
 * 当你要往文件写入数据时，也是通过一根管道接入进文件，然后来自于管道另一头内存程序的数据写入到文件中
 *
 *
 * 按照流动的方向，以内存或者程序为基准，分为输入input 和输出output ，即流向内存是输入流，流出内存的输出流。
 * 输入流 InputStream/Reader：把数据从其他设备上读取到内存中的流。
 * 输出流 OutputStream/Writer：把数据从内存中写出到其他设备上的流。
 *
 *
 *        outputstream
 * 内存--------------------->硬盘
 *          write
 *
 *       inputstream
 * 硬盘-------------------->内存
 *          read
 *
 * 根据数据的类型分为：
 * 字节流 InputStream/OutputStream：以字节为单位，读写数据的流。
 * 字符流 Reader/Writer：以字符为单位，读写数据的流。
 *
 *
 * FileOutputStream:文件输出流，用于将数据写出到文件
 * FileOutputStream构造方法，当你创建一个流对象时，必须直接或者间接传入一个文件路径：
 * 1、 public FileOutputStream(File file)：根据File对象为参数创建对象；如果没有这个文件，会创建该文件;如果有这个文件，会清空这个文件的数据.
 * 2、 public FileOutputStream(String name)： 根据名称字符串为参数创建对象；如果没有这个文件，会创建该文件;如果有这个文件，会清空这个文件的数据.
 * 3、public FileOutputStream(File file, boolean append)；如果没有这个文件，会创建该文件;如果有这个文件，在这个文件后面追加数据.
 * 4、public FileOutputStream(String name, boolean append) ；如果没有这个文件，会创建该文件;如果有这个文件，在这个文件后面追加数据.
 * 推荐使用第2、4种构造方法：
 *
 *
 * OutputStream:
 * 1、 public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
 * 2、 public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。
 * 3、 public void write(byte[] b)：将 b.length个字节从指定的字节数组写入此输出流。
 * 4、 public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。 也就是说从off个字节数开始读取一直到len个字节结束
 * 5、 public abstract void write(int b) ：将指定的字节输出流。
 */
public class OutPutStreamDemo {
    public static void main(String[] args) {
    }


    /**
     * public FileOutputStream(File file)：根据File对象为参数创建对象；如果没有这个文件，会创建该文件;如果有这个文件，会清空这个文件的数据.
     * public void write(byte[] b)：将 b.length个字节从指定的字节数组写入此输出流。
     */
    @Test
    public void test() {
        File f = new File("testResource\\out.txt"); //文件不存在会在工程根目录下被创建,如果有这个文件，会清空这个文件的数据
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);//fos指向被写文件
            fos.write("this will be shown in out.txt".getBytes());//从指定的字节数组写入此输出流，然后输出流流向文件

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();//关闭流，释放内存资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * public FileOutputStream(File file, boolean append)；如果没有这个文件，会创建该文件;如果有这个文件，在这个文件后面追加数据.
     * public void write(byte[] b, int off, int len) ：从偏移量 off开始输出到此输出流,也就是说从off个字节数开始读取一直到len个字节结束
     */
    @Test
    public void test2() {
        File f = new File("testResource\\out.txt"); //文件不存在会在工程根目录下被创建,如果有这个文件，会清空这个文件的数据
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f, true);//fos指向被写文件,如果有这个文件，在这个文件后面追加数据.
            fos.write("012345".getBytes(), 0, 4);//从指定的字节数组写入此输出流，然后输出流流向文件

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();//关闭流，释放内存资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * public FileOutputStream(String path, boolean append)；如果没有这个文件，会创建该文件;如果有这个文件，在这个文件后面追加数据.
     * BufferedOutputStream(OutputStream out)： 创建一个新的缓冲输出流
     */
    @Test
    public void test3() {
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
