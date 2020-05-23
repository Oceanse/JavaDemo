package com.demo.javaIO.java7.buffer;

import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/*
 *  节点流和处理流：
 *  节点流:  就是一根管道直接插到数据源上面，直接读数据源里面的数据，或者是直接往数据源里面写入数据
 *          典型的节点流是文件流：文件的字节输入流（FileInputStream），文件的字节输出流（FileOutputStream），文件的字符输入流（FileReader），文件的字符输出流（FileWriter）。
 *  处理流(缓冲流): 是包在别的流上面的流，相当于是包到别的管道上面的管道。带有缓冲区，缓冲区(Buffer)就是内存里面的一小块区域，先把数据放置到缓冲区上，等到缓冲区满了以后，
 *          再一次把缓冲区里面的数据写入到硬盘上或者读取出来，这样可以有效地减少对硬盘的访问次数，有利于保护我们的硬盘。
 *
 *  本质：在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少系统IO次数，从而提高读写的效率。
 *
 * 构造方法:
 * public BufferedInputStream(InputStream in) ：创建一个新的缓冲输入流，注意参数类型为InputStream。
 * 典型代表
 * public BufferedInputStream(FileInputStream in)
 * public BufferedInputStream(System.in)
 */
public class BufferedInputStreamDemo {

    /**
     * 通过缓冲字节流读文本文件有乱码的风险
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        File file = new File("pom.xml");
        FileInputStream fis =new FileInputStream(file);
        BufferedInputStream bis=new BufferedInputStream(fis);

        byte[] b=new byte[5];
        int len;
        //这里是通过缓冲区读写
        while((len=bis.read(b))!=-1){//len可以理解为数组当前的长度，返回实际读取的字节数，流位于文件末尾而没有可用的字节，则返回值 -1
            System.out.print(new String(b,0,len,"UTF-8"));//读取数组中的有效长度
        }
        bis.close();//后打开的先关闭
        fis.close();//先打开的后关闭
    }

    @Test
    public void test2() throws IOException, URISyntaxException {
        URI uri =new URI("http://www.baidu.com");
        URL url = uri.toURL();
        BufferedInputStream bis=new BufferedInputStream(url.openStream());
        byte[] b=new byte[1024];
        int len;
        //这里是通过缓冲区读写
        while((len=bis.read(b))!=-1){//len可以理解为数组当前的长度，返回实际读取的字节数，流位于文件末尾而没有可用的字节，则返回值 -1
            System.out.print(new String(b,0,len,"UTF-8"));//读取数组中的有效长度
        }
        bis.close();//后打开的先关闭
    }

}
