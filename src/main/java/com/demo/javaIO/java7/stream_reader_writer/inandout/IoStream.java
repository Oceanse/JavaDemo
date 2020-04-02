package com.demo.javaIO.java7.stream_reader_writer.inandout;

import java.io.*;

public class IoStream {
    public static void main(String[] args) {
        File f3=new File("C:\\Users\\epanhai\\Desktop\\1.jpg");
        File f4=new File("C:\\Users\\epanhai\\Desktop\\2.jpg");

        FileInputStream fis=null;
        FileOutputStream fos=null;
        byte[] b=new byte[10];
        int len;

        try {
            fis=new FileInputStream(f3);
            fos =new FileOutputStream(f4);
            while((len=fis.read(b))!=-1){
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
