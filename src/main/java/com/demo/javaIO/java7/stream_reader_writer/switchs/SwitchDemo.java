package com.demo.javaIO.java7.stream_reader_writer.switchs;

import org.testng.annotations.Test;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;


/**
 *  An InputStreamReader is a bridge from byte streams to character streams
 *  It reads bytes and decodes them into characters using a specified charset.
 *  The charset that it uses may be specified by name or may be given explicitly,
 *  or the platform's default charset may be accepted.
 *
 * 1，源或者目的对应的设备是字节流，但是操作的却是文本数据，可以使用转换作为桥梁。提高对文本操作的便捷。
 * 2，一旦操作文本涉及到具体的指定编码表时，必须使用转换流 。
 *
 * InputStreamReader就是把InputStream转换成Reader
 *
 */
public class SwitchDemo {


    @Test
    public void test() throws IOException {

        InputStream inputStream = new FileInputStream("pom.xml");

        //字节流根据指定的编码方式转成字符流，Charset.defaultCharset()=utf-8,这里面包含了解码的过程
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.defaultCharset());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str=null;
        while((str=bufferedReader.readLine())!=null){//可以按行读取数据，推测理解为把上面的解码的数据按行读取
            System.out.println(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
    }


    @Test
    public void test2() throws IOException {
        URI uri=URI.create("http://wwww.baidu.com");
        URL url = uri.toURL();
        InputStream inputStream = url.openStream();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.defaultCharset());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str=null;
        while((str=bufferedReader.readLine())!=null){//可以按行读取数据
            System.out.println(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
    }

}
