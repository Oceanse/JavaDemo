package com.demo.exception;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*例如要打开一个不存在文件时，一个异常就发生了，这些异常在编译时不能被简单地忽略。*/
public class IoExceptionType {


    @Test//throws编译时异常
    public void test() throws IOException{
        Path path=Paths.get("noexsisting file");
        Files.readAllBytes(path);//编译时异常必须要处理，否则编译不通过
    }



    @Test//catch编译时异常
    public void test2() {
        Path path=Paths.get("noexsisting file");
        try {
            Files.readAllBytes(path);//编译时异常必须要处理，否则编译不通过
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @Test//catch编译时异常
    public void test3() {
        try {
            Class clazz =Class.forName("com.demo.exception.IoExceptionType");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    /*throws是方法可能抛出异常的声明。(用在声明方法时，表示该方法可能要抛出异常) */
    @Test
    public void test4() throws ClassNotFoundException {
        Class clazz =Class.forName("com.demo.exception.IoExceptionType");
    }
    public static void main(String[] args) {

    }
}