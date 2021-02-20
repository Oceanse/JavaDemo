package com.demo.javaIO.third_library;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


/**
 *  <artifactId>commons-io</artifactId>
 *  FileUtils支持很多文件操作，如
 *
 *   文件写入
 *   读取文件
 *   创建目录
 *   拷贝文件和目录
 *   删除文件和目录
 *   从URL转换
 *   基于统配和过滤查看文件和目录
 *   比较文件内容
 *  文件的更新时间
 *  检查校验码
 */
public class FileUtilsDemo {

    @Test
    public void test() throws IOException {

        System.out.println(FileUtils.getTempDirectory());//获取临时目录
        System.out.println(FileUtils.getUserDirectory());//获取用户主目录
        System.out.println(FileUtils.getFile(FileUtils.getUserDirectory(), "mylog"));//Construct a file from the set of name elements


        FileUtils.touch(new File("newfile.txt"));//创建文件，如果文件存在则更新时间；如果不存在，创建一个空文件

        //boolean isSame=FileUtils.contentEquals(new File("test.txt"),new File("test2.txt"));
        //System.out.println(isSame);

        //第一个参数是文件，第二个是参数目录，第三个参数是否更新时间,newdir不存在则会自动创建
        FileUtils.copyFileToDirectory(new File("newfile.txt"),new File("newdir"),true);

    }




    @Test
    public void test2() throws IOException {
        InputStream in = FileUtils.openInputStream(new File("pom.xml"));//获取文件输入流,stream从文件流向程序
        Files.copy(in, Paths.get("test2.txt"), StandardCopyOption.REPLACE_EXISTING  );///获取文件输入和输出的文件流拷贝到执行文件中


        //OutputStream out = FileUtils.openOutputStream(new File("out.txt"));//获取文件输出流,stream从程序流向文件
        //out.write("hello beijing".getBytes());//源文件中有内容会被覆盖


        OutputStream out2 = FileUtils.openOutputStream(new File("out.txt"),true);//获取文件输出流,stream从程序流向文件，追加的形式添加内容
        out2.write("ocean no.1".getBytes());//在源文件内容后面追加新内容

    }

    @Test
    public void test3() throws IOException {

        File file=new File("test.txt");
        String contents="good luck";

        System.out.println(Charset.defaultCharset());

        //String写入File对象中,覆盖源文件内容
        FileUtils.writeStringToFile(file,contents, Charset.defaultCharset());//file不存在则创建

    }

    @Test
    public void test3_2() throws IOException {

        File file=new File("test.txt");
        String contents="good luck";

        System.out.println(Charset.defaultCharset());

        //String写入File对象中,覆盖源文件内容
        FileUtils.write(file,contents, Charset.defaultCharset());//file不存在则创建

    }

    @Test
    public void test4() throws IOException {
        //结果只和文件内容有关，和文件名以及文件路径没有关系
        System.out.println(FileUtils.checksumCRC32(new File("out.txt")));
        System.out.println(FileUtils.checksumCRC32(new File("test.txt")));
        System.out.println(FileUtils.checksumCRC32(new File("C:\\Users\\epanhai\\Desktop\\aaa.txt")));
    }



}
