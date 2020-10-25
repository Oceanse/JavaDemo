package com.demo.javaIO.java8.io.filesdemo;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesCopy {


    public static void main(String[] args) throws IOException {


    }

    @Test
    public void test() throws IOException {

        URI uri = URI.create("http://www.baidu.com/");
        URL url = uri.toURL();
        InputStream in = url.openStream();

        Path target=Paths.get("output.txt");//相对路径在工程的根目录下才有效

        //赋值前要确保target指向的文件不存在
        if (Files.exists(target)) {
            Files.delete(target);
        }

        Files.copy(in,target);//复制的过程会产生target对应的文件output.txt

    }


    @Test
    public void test2() throws IOException {

        URI u = URI.create("http://www.baidu.com/");
        InputStream in = u.toURL().openStream();

        //相对路径在工程的根目录下才有效
        //testdir目录存在，但是output.txt文件不存在
        Path target=Paths.get("testdir/output.txt");

        //赋值前要确保target指向的文件不存在
        if (Files.exists(target)) {
            Files.delete(target);
        }

        Files.copy(in,target);//复制的过程会产生target对应的文件output.txt
    }



    @Test
    public void test3() throws IOException {

        URI u = URI.create("http://www.baidu.com/");
        InputStream in = u.toURL().openStream();

        //相对路径在工程的根目录下才有效
        //nonedir目录不存在，output.txt文件不存在
        //NoSuchFileException
        Path target=Paths.get("nonedir/output.txt");


        //复制的过程会产生target对应的文件output.txt,但是不会createdir，所有路径中的dir一定要存在
        Files.copy(in,target);
    }

    @Test
    public void test4() throws IOException {

        URI u = URI.create("http://www.baidu.com/");
        InputStream in = u.toURL().openStream();

        Path target=Paths.get("test.txt");//FileAlreadyExistsException

        //不带StandardCopyOption.REPLACE_EXISTING，若target存在的话拷贝会报FileAlreadyExistsException
        Files.copy(in,target);//如果没有设置 REPLACE_EXISTING，而target又存在，那么拷贝操作会失败
    }


    @Test
    public void test5() throws IOException {

        URI u = URI.create("http://www.baidu.com/");
        InputStream in = u.toURL().openStream();

        Path target=Paths.get("test.txt");//FileAlreadyExistsException

        //如果设置了REPLACE_EXISTING，则会覆盖已有的文件
        Files.copy(in,target, StandardCopyOption.REPLACE_EXISTING);
    }


    /**
     * 类似于linux mv： Move or rename a file to a target file.
     * @throws IOException
     */
    @Test
    public void test6() throws IOException {

       Path path=Paths.get("C:\\Users\\epanhai\\git\\myproject\\JavaDemo\\testResource\\suite.json");
        Path path2=Paths.get("C:\\Users\\epanhai\\git\\myproject\\JavaDemo\\testResource\\suite2.json");

        //如果设置了REPLACE_EXISTING，则会覆盖已有的文件
        Files.move(path,path2, StandardCopyOption.REPLACE_EXISTING);
    }







}
