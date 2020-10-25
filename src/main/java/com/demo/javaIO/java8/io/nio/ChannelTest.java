package com.demo.javaIO.java8.io.nio;

import org.testng.annotations.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * 通道主要用于传输数据，从缓冲区的一侧传到另一侧的实体（如文件、套接字...），反之亦然；
 *
 * 通道主要分为两大类，文件（File）通道和套接字（socket）通道；
 *
 * file通道：FileChannel
 * socket通道类：SocketChannel、ServerSocketChannel和DatagramChannel；
 */
public class ChannelTest {
    public static void main(String[] args) throws IOException {

    }


    /**
     * 从url下载文件
     * @throws IOException
     */
    @Test
    public void test() throws IOException {

        //从该url下载文件
        String urlStr="https://arm1s10-eiffel160.eiffel.gic.ericsson.se:8443/nexus/content/groups/public/com/ericsson/radio/test/ctr-with-dependencies/2.0.55/ctr-with-dependencies-2.0.55.jar";
        URL url = new URL(urlStr);

        //通道指向要下载的url, 在stream包一层channel
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());

        //通道指向目的文件
        FileOutputStream fos = new FileOutputStream("testResource\\resources.jar");
        FileChannel channel = fos.getChannel();

        //把字节流从源channel传输到目的channel
        channel.transferFrom(rbc, 0, Long.MAX_VALUE);

    }



    /**
     * 从url下载文件
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        String urlStr="https://arm1s10-eiffel160.eiffel.gic.ericsson.se:8443/nexus/content/groups/public/com/ericsson/radio/test/ctr-with-dependencies/2.0.55/ctr-with-dependencies-2.0.55.jar";
        URL url = new URL(urlStr);

        //此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类
        URLConnection rulConnection = url.openConnection();

        //HttpURLConnection有更多的API.
        HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;

        //从urlConnection获取inputStream
        InputStream inputStream = httpUrlConnection.getInputStream();

        //通道指向要下载的url, 在stream包一层channel
        ReadableByteChannel rbc = Channels.newChannel(inputStream);

        //通道指向目的文件,在stream包一层channel
        FileOutputStream fos = new FileOutputStream("testResource\\resources.jar");
        FileChannel channel = fos.getChannel();

        //把字节流从源channel传输到目的channel
        channel.transferFrom(rbc, 0, Long.MAX_VALUE);
    }


    /**
     * HttpURLconnection处理get请求
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        URL url = new URL("https://www.baidu.com/");
        //得到connection对象。
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //设置请求方式
        connection.setRequestMethod("GET");
        //连接
        connection.connect();
        //得到响应码
        int responseCode = connection.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK){
            //得到响应流
            InputStream inputStream = connection.getInputStream();

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
    }



}
