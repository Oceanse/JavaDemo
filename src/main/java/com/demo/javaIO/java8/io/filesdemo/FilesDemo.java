package com.demo.javaIO.java8.io.filesdemo;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesDemo {


    /**
     * Files.exists
     */
    @Test
    public void test() {
        //java.nio.file.Path接口和java.io.File有相似性,指向文件或文件夹,在很多情况下，可以用Path来代替File类。
        Path path = Paths.get("pom.xml");
        System.out.println(Files.exists(path));//判断文件是否存在
    }


    /**
     * Files.createDirectory
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        Path path = Paths.get("newdir");
        System.out.println(Files.createDirectory(path));//若newdir存在则会报FileAlreadyExistsException

        Path path2 = Paths.get("newdir2/subdir");
        System.out.println(Files.createDirectory(path2));//不能递归创建
    }



    /**
     * Files.createDirectories
     * Creates a directory by creating all nonexistent parent directories first.
     * Unlike the {createDirectory createDirectory} method, an com.demo.exception
     * is not thrown if the directory could not be created because it already exists.
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        Path path = Paths.get("newdir");
        System.out.println(Files.createDirectories(path));//即使newdir存在也会报FileAlreadyExistsException

        Path path2 = Paths.get("newdir2/subdir");
        System.out.println(Files.createDirectories(path2));//可以递归创建
    }


    /**
     * Files.createFile
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        Path path = Paths.get("newdir/newfile.txt");//若目录newdir不存在，则会报NoSuchFileException
        Files.createFile(path);
    }



    /**
     * Files.createFile
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {
        Path newdir = Files.createDirectories(Paths.get("newdir"));
        Path newfile = newdir.resolve(Paths.get("newfile"));
        Files.createFile(newfile);
    }





    /**
     * return true if the file was deleted by this method; {@code
     * return false if the file could not be deleted because it did not exist
     * @throws IOException
     */
    @Test
    public void test6() throws IOException {
        Path path = Paths.get("test.txt");
        System.out.println(Files.deleteIfExists(path));
    }



    /**
     * Files.deleteIfExists(dir/file)只会删除file，不会删除dir
     * return true if the file was deleted by this method; {@code
     * return false if the file could not be deleted because it did not exist
     * @throws IOException
     */
    @Test
    public void test7() throws IOException {
        Path path = Paths.get("newdir/newfile");
        System.out.println(Files.deleteIfExists(path));
    }


    /**
     * Files.delete 只能用来删除文件，不能删除目录，若文件不存在则会报NoSuchFileException
     * @throws IOException
     */
    @Test
    public void test8() throws IOException {
        Path path = Paths.get("newdir/newfile");
        Files.delete(path);
    }


    /**
     * Files.walk在 Java 中遍历文件。
     * @throws IOException
     */
    @Test
    public void test9() throws IOException {
        Path path = Paths.get("C:\\Users\\epanhai\\git\\myproject\\JavaDemo");
        Stream<Path> walk = Files.walk(path);//不指明深度，会遍历所有层次(目录级别数)的文件目录,包括path对应的根目录
        List<Path> collect = walk.collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


    /**
     * Files.walk在 Java 中遍历文件。
     * @throws IOException
     */
    @Test
    public void test9_2() throws IOException {
        Path path = Paths.get("C:\\Users\\epanhai\\git\\myproject\\JavaDemo");
        Stream<Path> walk = Files.walk(path,1);//指明深度1，只会遍历当前根目录下(目录级别数)的文件目录,包括path对应的根目录
        List<Path> collect = walk.collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


}
