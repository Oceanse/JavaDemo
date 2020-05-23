package com.demo.javaIO.java7.stream_reader_writer.input;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


/*
 * In Java, a stream is composed of bytes
 *
 * 流就像是连接内存(程序)和其他文件或者网络的管道，程序和文件的数据交换都要通过流的输入输出来完成
 * 当你要从文件或者网络读取数据的时候，一根管道(流)插到文件里面去，然后文件里面的数据就顺着管道流出来，管道的另一头(内存)就可以读取到数据并进行处理
 * 当你要往文件写入数据时，也是通过一根管道接入进文件，然后来自于管道另一头内存程序的数据写入到文件中
 *
 *
 * 按照流动的方向,以内存或者程序为基准分为输入input和输出output
 * 输入流 InputStream/Reader：把数据从其他设备上读取到内存中的流。
 * 输出流 OutputStream/Writer：把数据从内存中写出到其他设备上的流。
 *
 *          outputstream
 * 内存--------------------->硬盘
 *          write
 *
 *        inputstream
 * 内存<--------------------硬盘
 *           read
 *
 *
 * 根据数据的类型分为：
 * 字节流 InputStream/OutputStream：以字节为单位，读写数据的流。
 * 字符流 Reader/Writer：以字符为单位，读写数据的流。
 *
 * 注意：
 *一切数据(文本、图片、音频、视频)底层都是以二进制数字存储，一个一个的字节，传输的时候也是如此。所以字节流可以传输任何数据。所以再操作流的时候要注意，
 * 无论使用什么样的流对象，底层传输始终是二进制数据。
 *
 *
 *
 *
 *
 *
 * FileInputStream:看这个名字就知道用于从文件中读取信息到内存中(obtains input bytes from a file in a file system)
 * FileInputStream的构造方法
 * 1、 public FileOutputStream(File file)：根据File对象为参数创建对象；如果没有这个文件，会创建该文件;如果有这个文件，会清空这个文件的数据.
 * 2、 public FileOutputStream(String name)： 根据名称字符串为参数创建对象；如果没有这个文件，会创建该文件;如果有这个文件，会清空这个文件的数据.
 * 3、public FileOutputStream(File file, boolean append)；如果没有这个文件，会创建该文件;如果有这个文件，在这个文件后面追加数据.
 * 4、public FileOutputStream(String name, boolean append) ；如果没有这个文件，会创建该文件;如果有这个文件，在这个文件后面追加数据.
 *  推荐使用第2、4种构造方法当你创建一个流对象时，必须传入一个文件路径。该路径下如果没有该文件会抛出FileNotFoundException
 *
 * 常用api:
 *  1、 public void close() ：关闭此输入流并释放与此流相关联的任何系统资源。
 *  2、 public abstract int read()： 从输入流读取数据的下一个字节，读取到文件末尾，返回-1
 *  3、 public int read(byte[] b)： 每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回-1
 *
 *
 *  */
public class FileInPutStreamDemo {

    @Test
    public void test1() throws IOException {
        //文件内容是"abc"， 文件采用utf-8编码，根据utf-8编码规则，这里一个字符占1个字节
        File file = new File("testResource\\out.txt");
        FileInputStream fis = new FileInputStream(file);
        int i1, i2, i3, i4;
        //read(): return the next byte of data, return -1 if the end of the file is reached.
        //read()从输入流读取完下一个byte, 指针会向后移动
        i1 = fis.read();
        i2 = fis.read();
        i3 = fis.read();
        i4 = fis.read();
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);

        //返回char
        System.out.println((char) i1);
        System.out.println((char) i2);
        System.out.println((char) i3);
        System.out.println((char) i4);
        fis.close();//关闭流，释放内存资源
    }


    /**
     * read()方法每次只读一个字节，如果文件里有非单节字符存在时候就会出现乱码
     * @throws IOException
     */
    @Test
    public void test1_2() throws IOException {
        //文件内容是"中", unicode编号是\u4e2d,文件采用utf-8编码， 根据utf-8编码规则，底层编码占3个字节
        FileInputStream fis = new FileInputStream("testResource\\out.txt");
        int i1, i2, i3, i4;
        //read(): return the next byte of data, return -1 if the end of the file is reached.
        //read()读取完下一个byte, 指针会向后移动
        i1 = fis.read();
        i2 = fis.read();
        i3 = fis.read();
        i4 = fis.read();
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);

        //返回char，返回乱码
        System.out.println((char) i1);
        System.out.println((char) i2);
        System.out.println((char) i3);
        System.out.println((char) i4);
        fis.close();//关闭流，释放内存资源
    }


    /**
     * out.txt采用utf-8编码，也就是底层采用三个字节存储"中"这个字符
     * 着三个字节通过字节输入流被读取到内存数组中， 然后转成String,就相当于把这三个字节按照utf-8解码
     * 编码解码都是utf-8,所以不会出现乱码
     *
     * @throws IOException
     */
    @Test
    public void test1_3() throws IOException {

        //文件内容是"中", unicode编号是\u4e2d, 根据utf-8编码规则，底层编码占3个字节
        FileInputStream fis = new FileInputStream("testResource\\out.txt");
        byte[] b = new byte[3]; //输入流中将最多 b.length 个字节的数据读入一个 byte 数组中(缓冲区)
        int len = fis.read(b);//这里相当于读取文件的底层编码到byte数组
        System.out.print(new String(b, 0, len, "utf-8"));//byte数组转成String相当于解码，源文件采用utf-8编码，这里JVM采用utf-8解码
        fis.close();//关闭流，释放内存资源
    }


    /**
     * 文件编码方式：utf-8
     * jvm默认编码/解码方式：utf-8
     *所以会出现乱码
     * @throws IOException
     */
    @Test
    public void test1_4() throws IOException {
        //jvm默认编码方式：utf-8
        String csn = Charset.defaultCharset().name();
        System.out.println(csn);


        //文件内容是"中", 文件采用GB2312编码， 底层编码占2个字节
        FileInputStream fis = new FileInputStream("testResource\\out.txt");
        byte[] b = new byte[3]; //输入流中将最多 b.length 个字节的数据读入一个 byte 数组中(缓冲区)
        int len = fis.read(b);//这里相当于读取文件的底层编码到byte数组
        System.out.print(new String(b, 0, len));//byte数组转成String相当于解码，没有指明编码方式时候默认采用jvm默认编码方式：utf-8
        fis.close();//关闭流，释放内存资源
    }



    /**
     * 文件编码方式：GB2312
     * jvm默认编码方式：utf-8
     *所以这里会出现乱码
     * @throws IOException
     */
    @Test
    public void test1_5() throws IOException {
        //jvm默认编码方式：utf-8
        String csn = Charset.defaultCharset().name();
        System.out.println(csn);


        //文件内容是"中", unicode编号是\u4e2d, 根据utf-8编码规则，底层编码占3个字节
        FileInputStream fis = new FileInputStream("testResource\\out.txt");
        byte[] b = new byte[3]; //输入流中将最多 b.length 个字节的数据读入一个 byte 数组中(缓冲区)
        int len = fis.read(b);//这里相当于读取文件的底层编码到byte数组
        System.out.print(new String(b, 0, len));//byte数组转成String相当于解码，没有指明编码方式时候默认采用jvm默认编码方式：utf-8
        fis.close();//关闭流，释放内存资源
    }

    /**
     * 文件编码方式：GB2312
     * 指定jvm编码方式：GB2312
     *所以这里会出现乱码
     * @throws IOException
     */
    @Test
    public void test1_6() throws IOException {

        //文件内容是"中", unicode编号是\u4e2d, 根据utf-8编码规则，底层编码占3个字节
        FileInputStream fis = new FileInputStream("testResource\\out.txt");
        byte[] b = new byte[3]; //输入流中将最多 b.length 个字节的数据读入一个 byte 数组中(缓冲区)
        int len = fis.read(b);//这里相当于读取文件的底层编码到byte数组，实际上只存储了2个字节，所以len=2
        System.out.print(new String(b, 0, len,"GB2312"));//byte数组转成String相当于解码，指定jvm编码方式：GB2312
        fis.close();//关闭流，释放内存资源
    }


    /**
     * out.txt采用utf-8编码，中文字符"中国"占用6个字节， 若使用字节流read()一个一个字节读，也就是半个字符，那么会显示乱码
     * read()方法每次只读一个字节，如果文件里有非单节字符存在时候就会出现乱码
     * 所以文本文件优先考虑字符流
     * @throws IOException
     */
    @Test
    public void test1_7() throws IOException {
        File file = new File("testResource\\out.txt");
        FileInputStream fis = new FileInputStream(file);
        int i;
        while ((i = fis.read()) != -1) {    //read()返回下一个数据字节；如果已到达文件末尾，则返回 -1。
            System.out.print((char) i);
        }
        fis.close();//关闭流，释放内存资源
    }


    /**
     * 采用字节输入流的read(byte[] b)方法读取文件的内容(底层编码)，如果数组的长度大于文件所有字符长度，那么只要文件编码和解码
     * (数组转String)一致不会出现乱码；
     * 如果数组的长度小于文件所有字符长度，即使编码和解码一致，也会有可能出现乱码
     * 字节流处理文本文件容易出现乱码，优先考虑字符流
     *
     * @throws IOException
     */
    @Test
    public void test1_8() throws IOException {
        File file = new File("testResource\\out.txt");//内容"中国"， utf-8编码，占用6字节
        FileInputStream fis = new FileInputStream(file);

        byte[] b = new byte[10]; //byte数组长度大于文件所有字符占用的字节数,编码/解码一致时不会出现乱码
        //byte[] b = new byte[2]; //byte数组长度小于文件所有字符占用的字节数,编码/解码一致也会出现乱码
        //byte[] b = new byte[3]; //byte数组长度小于文件所有字符占用的字节数,编码/解码一致不会出现乱码
        int len;
        while ((len = fis.read(b)) != -1) {//len可以理解为数组当前的长度，返回实际读取的字节数，流位于文件末尾而没有可用的字节，则返回值 -1
            System.out.print(new String(b, 0, len, "UTF-8"));//读取数组中的有效长度
        }
        fis.close();//关闭流，释放内存资源
    }


    /**
     * available(): eturns an estimate of the number of remaining bytes that can be read
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        //文件内容是"abc"
        FileInputStream fis = new FileInputStream("testResource\\out.txt");

        //Returns an estimate of the number of remaining bytes that can be read
        //返回inputstream(文件中)剩余的可读的字节数，文件未读取时是3
        int available = fis.available();
        System.out.println(available);//

        //读取第1个字节后，剩余的可读的字节数是2
        System.out.println();
        System.out.println(fis.read());
        System.out.println(fis.available());

        //读取第2个字节后，剩余的可读的字节数是1
        System.out.println();
        System.out.println(fis.read());
        System.out.println(fis.available());

        //读取第3个字节后，剩余的可读的字节数是0
        System.out.println();
        System.out.println(fis.read());
        System.out.println(fis.available());

        fis.close();//先打开的后关闭
    }


    /**
     * skip(int n): Skips over and discards n bytes of data from the input stream.
     *
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        //文件内容是"abc"
        FileInputStream fis = new FileInputStream("testResource\\out.txt");

        //Returns an estimate of the number of remaining bytes that can be read
        //返回inputstream(文件中)剩余的可读的字节数，文件未读取时是3
        int available = fis.available();
        System.out.println(available);//

        //读取第1个字节后，剩余的可读的字节数是2
        System.out.println();
        System.out.println(fis.read());
        System.out.println(fis.available());


        System.out.println();
        fis.skip(1);//跳过一个字节
        System.out.println(fis.available());
        System.out.println(fis.read());
        System.out.println(fis.available());


        fis.close();//先打开的后关闭
    }



    @Test
    public void test4x() throws IOException {
        URI uri = URI.create("http://wwww.baidu.com");
        URL url = uri.toURL();
        InputStream inputStream = url.openStream();
        Files.copy(inputStream, Paths.get("testResource\\out.txt"), StandardCopyOption.REPLACE_EXISTING);
    }

}
