package com.demo.javaIO.java7.stream_reader_writer.inandout;

import org.testng.annotations.Test;

import java.io.*;

/**
 * 通过输入流及其read(byte[] b)方法把1.jpg内容读到内存中（byte[] b）,
 * 然后通过输出流及其write(byte[] b)把内存中的内容写到指定文件2.jpg
 */
public class IoStream {

    @Test
    public void test() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            //读取文件的底层编码
            in = new FileInputStream("testResource/out.txt");

            //把文件的底层编码写入文件中，所以这里两个文件的encoding方式必须一致
            out = new FileOutputStream("test.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void main(String[] args) {

        FileInputStream fis=null;
        FileOutputStream fos=null;
        byte[] b=new byte[10];
        int len;

        try {
            fis=new FileInputStream("C:\\Users\\epanhai\\Desktop\\1.jpg");
            fos =new FileOutputStream("C:\\Users\\epanhai\\Desktop\\2.jpg");

            //边读边写
            while((len=fis.read(b))!=-1){
                //把byte数组内写到另一个文件
                fos.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
