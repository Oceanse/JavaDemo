package com.demo.javaIO.java8.io.filesdemo;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesDemo2 {


    /**
     * Files.readAllBytes读取文件内容
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        Path path = Paths.get("pom.xml");
        byte[] bytes = Files.readAllBytes(path);
        String content = new String(bytes);
        System.out.println(content);
    }



    @Test
    public void test2() throws Exception{

        Path path= Paths.get("pom.xml");
        BufferedReader br = Files.newBufferedReader(path);
        String content=null;
        while((content=br.readLine())!=null){  //readLine()，使用起来特别方便，每次读回来的都是一行
            System.out.println(content);
        }
        br.close();
    }



    /**Files.newBufferedWriter 远比原来的FileOutputStream，
     * 然后BufferedWriter包装，等操作简单的多了*/
    @Test
    public void test3() throws Exception{

        Path path= Paths.get("out.txt");
        if(!Files.exists(path)){
            Files.createFile(path);
        }
        BufferedWriter bw = Files.newBufferedWriter(path);
        bw.write("hsdudfvdfb;dfkkfkkkkdfklkl4238989734788");
        bw.close();
    }


    /**
     * Files.newDirectoryStream
     * 遍历一个文件夹
     * @throws Exception
     */
    @Test
    public void test4() throws Exception{
        Path path= Paths.get("C:\\Users\\epanhai\\Desktop");
        DirectoryStream<Path> paths = Files.newDirectoryStream(path);
        for (Path path1 : paths) {
            System.out.println(path1.getFileName());
        }
    }


    /**
     *Files.readAllLines
     * @throws Exception
     */
    @Test
    public void test5() throws Exception{
        Path path= Paths.get("out.txt");
        List<String> contents = Files.readAllLines(path);
        System.out.println(contents.size());
        contents.forEach(System.out::println);
    }


    /**
     *  Files.list 对一个目录进行遍历处理
     * @throws Exception
     */
    @Test
    public void test6() throws Exception{
        Path path= Paths.get("C:\\Users\\epanhai\\Desktop");

        //转成Stream<Path>
        Stream<Path> list = Files.list(path);

        //filter之后还是stream<Path>,里面可能还是一堆path,尚硅谷开头的path可能不止一个
        Stream<Path> stream = list.filter(paths -> paths.getFileName().toString().startsWith("a"));

        //将上面fileter后的一堆path返回其中任意一个
        Optional<Path> any = stream.findAny();

        //转成String  等价于String startwithspring = any.toString();
        String startwitha = any.map(Objects::toString).orElse("com/demo/others");

        //打印全路径名
        System.out.println(startwitha);

        //返回Stream<Path>中元素的个数
        Stream<Path> list2 = Files.list(path);
        long count = list2.count();
        System.out.println(count);

    }



    @Test
    public void test6_2() throws IOException {

        //path是一个目录
        System.out.println("5==========================");
        Path path3=Paths.get("C:\\Users\\epanhai\\Desktop");
        Stream<Path> paths = Files.list(path3);
        //paths.forEach(filepath-> System.out.println(filepath));//全路径
        // paths.forEach(filepath-> System.out.println(filepath.getFileName()));//文件名
        List<Path> ls1 = paths.filter(p -> p.getFileName().toString().startsWith("J")).collect(Collectors.toList());
        System.out.println(ls1);

        //过滤完之后还是Stream<Path>,Stream类似于一个集合
        Stream<Path> stream = paths.filter(p -> p.getFileName().toString().startsWith("J"));

        //返回符合过滤条件的任意一个,类型是Optional<Path>
        Optional<Path> j = paths.filter(p -> p.getFileName().toString().startsWith("J")).findAny();

        //类型是Optional<String>
        Optional<String> j1 = paths.filter(p -> p.getFileName().toString().startsWith("J")).findAny().map(Objects::toString);

        //结果数据类型是orElse接受的参数类型，这里是orElse(Path path)
        Path path = paths.filter(p -> p.getFileName().toString().startsWith("J")).findAny().orElse(Paths.get("pom.xml"));

        //结果数据类型是orElse接受的参数类型，这里是orElse(String path)
        String s = paths.filter(p -> p.getFileName().toString().startsWith("J")).findAny().map(Objects::toString).orElse("com/demo/others");

    }


    /**
     *  Files.lines 处理文件内容
     * @throws IOException
     */
    @Test
    public void test7() throws IOException {
        Path path= Paths.get("out.txt");

        Stream<String> lines = Files.lines(path);
        List<String> out = lines.map(str -> str.toUpperCase()).collect(Collectors.toList());
        System.out.println(out);
    }


}
