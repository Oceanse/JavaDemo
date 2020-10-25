package com.demo.javaIO.resource_operation;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetResourcePath {


    /**
     * 获取classpath：target下的文件路径
     * @throws IOException
     */
    @Test
    public void getFromClassPath() throws IOException {

        //Resource是org.springframework.core.io.Resource
        Resource resource = new ClassPathResource("classpath/classpath.html");
        String  path = resource.getFile().getPath();
        System.out.println(path);

        String content = new String(Files.readAllBytes(Paths.get(path)));
        System.out.println(content);
    }


    /**
     * 获取classpath：target下的文件路径
     * @throws IOException
     */
    @Test
    public void getFromClassPath2() throws IOException {

        //Resource是org.springframework.core.io.Resource
        Resource resource = new ClassPathResource("com/demo/annotation/TestDemo.class");
        String  path = resource.getFile().getPath();
        System.out.println(path);

        String content = new String(Files.readAllBytes(Paths.get(path)));
        System.out.println(content);
    }

}
