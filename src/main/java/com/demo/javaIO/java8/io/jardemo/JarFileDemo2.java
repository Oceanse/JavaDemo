package com.demo.javaIO.java8.io.jardemo;

import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarFileDemo2 {


    /**
     * 递归遍历jar包内所有文件目录的名字和大小
     * 等价于@Test2()
     * @throws IOException
     */
    @Test
    public void test() throws IOException {

        //通过jar文件路径构造JarFile
        File file = new File("C:\\Users\\epanhai\\.m2\\repository\\se\\ericsson\\jcat\\jcat-demo\\R6A0178-SNAPSHOT\\jcat-demo-R6A0178-SNAPSHOT.jar");
        JarFile jarFile;
        if (file.exists()) {
            jarFile = new JarFile(file);
        }else {
            throw new IOException("The jar file is not avaliable");
        }

        Enumeration<JarEntry> entries = jarFile.entries();
        while(entries.hasMoreElements()){
            JarEntry jarEntry = entries.nextElement();
            String fileName = jarEntry.getName();
            long size = jarEntry.getSize();
            System.out.println(fileName+"\t"+size);
        }
        jarFile.close();
    }





    /**
     *递归遍历jar包内所有文件目录的名字和大小
     * 等价于@Test()
     * @throws IOException
     */
    @Test
    public void test2() throws IOException{
        //通过jar文件路径构造JarFile
        File file = new File("C:\\Users\\epanhai\\.m2\\repository\\se\\ericsson\\jcat\\jcat-demo\\R6A0178-SNAPSHOT\\jcat-demo-R6A0178-SNAPSHOT.jar");
        JarFile jarFile;
        if (file.exists()) {
            jarFile = new JarFile(file);
        }else {
            throw new IOException("The jar file is not avaliable");
        }
        jarFile.stream().forEach(jarEntry -> System.out.println(jarEntry.getName()+"\t"+jarEntry.getSize()));
    }





    /**
     * 筛选出jar文件路径,读取jar包内某个特定文件的内容
     * JarEntry只是包含该entry的有关信息，为了从JAR文件中真正读取一个指定的文件，你必须构造其entry的InputStream，这和File和FileInputStream的区别有点儿相似
     * InputStream input = jarFile.getInputStream(JarEntry);
     */
    @Test
    public void test3() {
        StringBuffer buffer = new StringBuffer();
        Path path = Paths.get("C:\\Users\\EPANHAI\\.m2\\repository\\junit\\junit\\3.8.1");

        try {

            //筛选出jar文件路径
            String testPath = Files.list(path)
                    .filter(p -> p.getFileName().toString().endsWith(".jar")).findAny().map(Object::toString).orElse("/var/jcat/test-resources.jar");

            //通过jar文件路径构造JarFile
            File file = new File(testPath);
            JarFile jarFile;
            if (file.exists()) {
                System.out.println("Jar is avaliable");
                jarFile = new JarFile(file);
            } else {
                throw new IOException("Jar file is not avaliable");
            }


            //读取jar包内某个特定文件的内容
            Enumeration<JarEntry> enu = jarFile.entries();
            while (enu.hasMoreElements()) {
                JarEntry element = enu.nextElement();
                if (element.getName().toString().equals("stylesheet.css")) {
                    //System.out.println(element.getName());
                    InputStream is = jarFile.getInputStream(element);
                    BufferedReader in = new BufferedReader(new InputStreamReader(is));

                    String line = "";
                    while ((line = in.readLine()) != null) {
                        buffer.append(line);
                    }
                    System.out.println(buffer.toString());
                    jarFile.close();
                    in.close();
                    is.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}


