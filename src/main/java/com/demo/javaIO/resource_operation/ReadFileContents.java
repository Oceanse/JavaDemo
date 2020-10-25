package com.demo.javaIO.resource_operation;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFileContents {
    @Test
    public void readFileContents() throws IOException {

        //Resource是org.springframework.core.io.Resource
        Resource resource = new ClassPathResource("com/demo/annotation/TestDemo.class");
        String  path = resource.getFile().getPath();
        System.out.println(path);

        String content = new String(Files.readAllBytes(Paths.get(path)));
        System.out.println(content);
    }
}
