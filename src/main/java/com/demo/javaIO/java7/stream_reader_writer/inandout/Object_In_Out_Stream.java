package com.demo.javaIO.java7.stream_reader_writer.inandout;

import org.testng.annotations.Test;

import java.io.*;

/**
 * 序列化(serial):把对象转换为字节序列的过程称为对象的序列化。
 * 反序列化(deserial)把字节序列恢复为对象的过程称为对象的反序列化。
 *
 * 对象的序列化主要有两种用途：
 * 1） 把对象的字节序列永久地保存到硬盘上，通常存放在一个文件中；
 * 2） 在网络上传送对象的字节序列。
 *
 *
 * ObjectOutputStream：序列化java对象到硬盘
 * ObjectInputStream： 将硬盘中的数据反序列化到内存
 */
public class Object_In_Out_Stream {

    /**
     * 完成对象序列化，使其可以存储到硬盘
     * @throws IOException
     */
    @Test
    public static void test() throws IOException {

        //创建输出流(序列化流)
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("testResource\\out.txt"));

        //创建java对象
        Flower flower=new Flower("rose");

        //这里将java对象写入到序列化流，从而存储到硬盘文件中
        oos.writeObject(flower);

        oos.flush();
        oos.close();

    }


    /**
     * 反序列化，将文件中的字节码还原成对象
     * @throws IOException
     */
    @Test
    public static void test2() throws IOException, ClassNotFoundException {

        //创建输入流(序列化流)
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("testResource\\out.txt"));

        //Read an object from the ObjectInputStream
        Object o = ois.readObject();
        System.out.println(o.toString());
        ois.close();

    }
}


/**
 * Serializability of a class is enabled by the class implementing the java.io.Serializable interface
 */
class Flower implements Serializable {
    String name;

    public Flower(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                '}';
    }
}