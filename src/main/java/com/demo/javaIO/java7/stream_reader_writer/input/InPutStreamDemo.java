package com.demo.javaIO.java7.stream_reader_writer.input;

import org.testng.annotations.Test;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


/**
 *
 * 流就像是连接内存(程序)和其他文件或者网络的管道，程序和文件的数据交换都要通过流的输入输出来完成
 * 当你要从文件或者网络读取数据的时候，一根管道(流)插到文件里面去，然后文件里面的数据就顺着管道流出来，管道的另一头(内存)就可以读取到数据并进行处理
 * 当你要往文件写入数据时，也是通过一根管道接入进文件，然后来自于管道另一头内存程序的数据写入到文件中
 *
 * 按照流动的方向，以内存或者程序为基准，分为输入input 和输出output ，即流向内存是输入流，流出内存的输出流。
 * 输入流 InputStream/Reader：把数据从其他设备上读取到内存中的流。
 * 输出流 OutputStream/Writer：把数据从内存中写出到其他设备上的流。
 *
 * 内存--------------------->硬盘
 *          write
 *
 *        inputstream
 * 硬盘-------------------->内存
 *           read
 *
 * 凡是以InputStream结尾的管道，都是以字节的形式向我们的程序输入数据
 *
 *
 * 根据数据的类型分为：
 * 字节流 InputStream/OutputStream：以字节为单位，读写数据的流。
 * 字符流 Reader/Writer：以字符为单位，读写数据的流。
 *
 *节点流和处理流：
 * 节点流就是一根管道直接插到数据源上面，直接读数据源里面的数据，或者是直接往数据源里面写入数据
 * 典型的节点流是文件流：文件的字节输入流（FileInputStream），文件的字节输出流（FileOutputStream），文件的字符输入流（FileReader），文件的字符输出流（FileWriter）。
 * 处理流是包在别的流上面的流，相当于是包到别的管道上面的管道。
 *
 * InputStream:
 *
 *
 *
 * FileInputStream:看这个名字就知道用于从文件中读取信息到内存中。
 * FileInputStream的构造方法
 *   1、 FileInputStream(File file)： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。
 *   2、 FileInputStream(String name)： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名name命名。
 *  推荐使用第二种构造方法
 *  当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有该文件,会抛出FileNotFoundException
 *
 * 常用api:
 *  1、 public void close() ：关闭此输入流并释放与此流相关联的任何系统资源。
 *  2、 public abstract int read()： 从输入流读取数据的下一个字节，读取到文件末尾，返回-1
 *  3、 public int read(byte[] b)： 每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回-1
 *
 *  */
public class InPutStreamDemo {

    @Test
    public void test1() throws IOException {
        File file = new File("pom.xml");
        FileInputStream fis =new FileInputStream(file);
        int i;
        while((i=fis.read())!=-1){    //read()返回下一个数据字节；如果已到达文件末尾，则返回 -1。
            System.out.print((char)i);
        }
        fis.close();//关闭流，释放内存资源
    }


    /**
     * out.txt包含中文字符占2byte，若使用字节流read()一个一个字节读，也就是半个字符，那么会显示乱码
     * 所以文本文件优先考虑字符流
     * @throws IOException
     */
    @Test
    public void test1_2() throws IOException {
        File file = new File("testResource\\out.txt");
        FileInputStream fis =new FileInputStream(file);
        int i;
        while((i=fis.read())!=-1){    //read()返回下一个数据字节；如果已到达文件末尾，则返回 -1。
            System.out.print((char)i);//显示乱码
        }
        fis.close();//关闭流，释放内存资源
    }


    @Test
    public void test2() throws IOException {
        File file = new File("pom.xml");
        FileInputStream fis =new FileInputStream(file);

        byte[] b=new byte[4]; //输入流中将最多 b.length 个字节的数据读入一个 byte 数组中(缓冲区)
        int len;
        while((len=fis.read(b))!=-1){//len可以理解为数组当前的长度，返回实际读取的字节数，流位于文件末尾而没有可用的字节，则返回值 -1
            System.out.print(new String(b,0,len,"UTF-8"));//读取数组中的有效长度
        }
        fis.close();//关闭流，释放内存资源
    }


    /**
     * 字节流处理文本文件容易出现乱码，优先考虑字符流
     * @throws IOException
     */
    @Test
    public void test2_2() throws IOException {
        File file = new File("testResource\\out.txt");
        FileInputStream fis =new FileInputStream(file);

        byte[] b=new byte[4]; //输入流中将最多 b.length 个字节的数据读入一个 byte 数组中(缓冲区)
        int len;
        while((len=fis.read(b))!=-1){//len可以理解为数组当前的长度，返回实际读取的字节数，流位于文件末尾而没有可用的字节，则返回值 -1
            System.out.print(new String(b,0,len,"UTF-8"));//读取数组中的有效长度
        }
        fis.close();//关闭流，释放内存资源
    }


    @Test
    public void test3() throws IOException {
        File file = new File("pom.xml");
        FileInputStream fis =new FileInputStream(file);
        BufferedInputStream bis=new BufferedInputStream(fis);

        byte[] b=new byte[5]; //输入流中将最多 b.length 个字节的数据读入一个 byte 数组中(缓冲区)
        int len;
        while((len=bis.read(b))!=-1){//len可以理解为数组当前的长度，返回实际读取的字节数，流位于文件末尾而没有可用的字节，则返回值 -1
            System.out.print(new String(b,0,len,"UTF-8"));//读取数组中的有效长度
        }
        bis.close();//后打开的先关闭
        fis.close();//先打开的后关闭
    }


    @Test
    public void test4() throws IOException{
        URI uri=URI.create("http://wwww.baidu.com");
        URL url = uri.toURL();
        InputStream inputStream = url.openStream();
        Files.copy(inputStream, Paths.get("testResource\\out.txt"), StandardCopyOption.REPLACE_EXISTING);
    }

}
