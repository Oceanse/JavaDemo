package com.demo.javaIO.third_library;

import org.springframework.util.FileSystemUtils;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
public class FileSystemUtilsDemo {


    @Test
    public void test(){
    Path path= Paths.get("C:\\Users\\epanhai\\Desktop\\aa");

    //会递归删除这个目录下的所有内容，最后把当前目录也删除掉
        FileSystemUtils.deleteRecursively(path.toFile());
}

}
