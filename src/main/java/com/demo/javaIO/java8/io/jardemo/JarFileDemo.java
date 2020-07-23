package com.demo.javaIO.java8.io.jardemo;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * JAR文件是打包基于JAVA技术的解决方案的标准方法。它允许开发者将所有相关内容（.class、图片、声音、及所有支持的文件）打包到一个文件中。
 * JAR格式支持压缩、认证、版本号及其他很多特性。
 * 如果你需要在程序中代码读写JAR文件，你不用担心解压的事，因为java类库将帮助你完成这些
 * <p>
 * 当你想指定目标JAR文件时, 可通过JarFile读取jar文件内容
 */
public class JarFileDemo {

    File file = new File("C:\\Users\\epanhai\\.m2\\repository\\se\\ericsson\\jcat\\jcat-demo\\R6C0022\\jcat-demo-R6C0022-jar-with-dependencies.jar");


    /**
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        JarFile jarFile;

        if (file.exists()) {
            jarFile = new JarFile(file);//通过把将JAR文件位置传给构造函数，创建一个JarFile的实例, 把JarFile想象成类似List的集合
        } else {
            throw new IOException("Jar file is not avaliable");
        }


        Stream<JarEntry> stream = jarFile.stream();
        Stream<String> stringStream = stream.map(jarEntry -> jarEntry.toString());
    }


    /**
     * 递归打印jar内所有的文件和目录的全路径
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        JarFile jarFile;

        if (file.exists()) {
            jarFile = new JarFile(file);//通过把将JAR文件位置传给构造函数，创建一个JarFile的实例, 把JarFile想象成类似List的集合
        } else {
            throw new IOException("Jar file is not avaliable");
        }

        System.out.println("Total count: " + jarFile.stream().count());
        jarFile.stream().forEach(jarEntry -> System.out.println(jarEntry));
    }


    @Test
    public void test3() throws IOException {

        JarFile jarFile;

        if (file.exists()) {
            jarFile = new JarFile(file);////通过把将JAR文件位置传给构造函数，创建一个JarFile的实例, 把JarFile想象成类似List的集合
        } else {
            throw new IOException("Jar file is not avaliable");
        }


        //打印jar包内所有文件和文件夹的总数量
        System.out.println("Total count in jar is: " + jarFile.stream().count());

        //帅选class文件
        List<String> classFile = jarFile.stream().
                filter(item -> !item.isDirectory()).
                filter(item -> item.toString().endsWith(".class")).
                map(item -> item.toString().replace(".class", "").replace("/",".")).
                filter(item->item.contains("ericsson")).
                collect(Collectors.toList());

        //打印jar包中一.class结尾的文件
        classFile.forEach(System.out::println);// classFile.forEach(item->System.out.println(item));

        //打印jar包中一.class结尾的文件的数量
        long count = jarFile.stream().filter(item -> !item.isDirectory() &&
                item.toString().endsWith(".class")).count();
        System.out.println("The count of file ends with .class: " + count);//classFile.size()

        jarFile.close();


    }
}
