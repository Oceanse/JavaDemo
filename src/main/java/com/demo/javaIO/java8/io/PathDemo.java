package com.demo.javaIO.java8.io;


import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *  java.nio.file.Path接口和java.io.File有相似性,指向文件或文件夹,在很多情况下，可以用Path来代替File类。
 */
public class PathDemo {


    @Test
    public void test(){

        Path path= Paths.get("C:\\Users\\epanhai\\git\\practice\\jp\\test.txt");
        Path path2= Paths.get("C:\\Users\\epanhai\\git\\practice\\jp");

        //返回值还是Path
        Path fileName = path.getFileName();
        Path fileName2 = path2.getFileName();
        System.out.println("filename:"+fileName);
        System.out.println("filename:"+fileName2);

        //Path--->String
        String fileNameStr = fileName.toString();
        String fileNameStr2 = fileName2.toString();

    }

    @Test
    public void test2(){

        //文件存在于工程根目录下，相对路径才有效
        Path path= Paths.get("test.txt");
        Path path2= Paths.get("test.json");

        System.out.println(Files.exists(path));
        System.out.println(Files.exists(path2));

        System.out.println(path.isAbsolute());//判断是否为绝对路径

        System.out.println();
        System.out.println(path);//输出相对路径
        System.out.println(path.toAbsolutePath());//输出绝对路径,还是Path对象

        Path fileName = path.toAbsolutePath().getFileName();//获取文件名
        String s = fileName.toString();//Path--->字符串


        File file = path.toFile();//Path--->File


    }

    //路径拼接
    @Test
    public void test3(){
        Path testPath=Paths.get("C:\\Users");
        Path dir = testPath.resolve("mydir");
        System.out.println(dir);
    }


    @Test
    public void test4(){
        Path testPath=Paths.get("C:\\Users\\epanhai\\Desktop");
        System.out.println(testPath.getNameCount());//Returns the number of name elements in the path.
        System.out.println(testPath.getName(2));
        System.out.println(testPath.getName(1));
        System.out.println(testPath.getName(0));
    }

    @Test
    public void test5(){
        //获取当前项目的绝对路径
        System.out.println(Paths.get("").toAbsolutePath());
    }
}
