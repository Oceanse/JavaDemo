package com.demo.javaIO.java7.buffer;

import java.io.*;


/**
 * 节点流(字节流或者字符流)外面再包一层就是缓冲流,也叫处理流，高效流
 * 带有缓冲区的，缓冲区(Buffer)就是内存里面的一小块区域，先把数据放置到缓冲区上，等到缓冲区满了以后，
 * 再一次把缓冲区里面的数据写入到硬盘上或者读取出来，这样可以有效地减少对硬盘的访问次数，有利于保护我们的硬盘。
 *
 * 缓冲流的基本原理：
 * 1、使用了底层流对象从具体设备上获取数据，并将数据存储到缓冲区的数组内。
 * 2、通过缓冲区的read()方法从缓冲区获取具体的字符数据，这样就提高了效率。
 * 3、如果用read方法读取字符数据，并存储到另一个容器中，直到读取到了换行符时，将另一个容器临时存储的数据转成字符串返回，就形成了readLine()功能。
 * 也就是说在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少系统IO次数，从而提高读写的效率。
 *
 * 构造方法:
 * public BufferedInputStream(InputStream in) ：创建一个新的缓冲输入流，注意参数类型为InputStream。
 * public BufferedOutputStream(OutputStream out)： 创建一个新的缓冲输出流，注意参数类型为OutputStream。
 */
public class BufferedStream {

    public void copy(String source,String dest)throws IOException {
        File fsource=new File(source);
        File fdest=new File(dest);

        FileInputStream fis=new FileInputStream(fsource);
        FileOutputStream fos = new FileOutputStream(fdest);

        //在节点流的外面套接一层处理流
        BufferedInputStream bis=new BufferedInputStream(fis);
        BufferedOutputStream bos =new BufferedOutputStream(fos);

        byte[] b=new byte[1024];
        int len;
        while((len=bis.read(b))!=-1){
            bos.write(b,0,len);
        }
        bos.close();
        bis.close();
    }

    public static void main(String[] args) {
        String source="C:\\Users\\epanhai\\Desktop\\1.wmv";
        String dest="C:\\Users\\epanhai\\Desktop\\1_copy.wmv";
        try {
            long start = System.currentTimeMillis();
            new BufferedStream().copy(source,dest);
            long end=System.currentTimeMillis();
            System.out.println(end-start);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
