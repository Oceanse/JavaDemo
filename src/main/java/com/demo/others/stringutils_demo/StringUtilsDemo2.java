package com.demo.others.stringutils_demo;

import org.springframework.util.StringUtils;
import org.testng.annotations.Test;

/**
 *
 * org.springframework.util.StringUtils;
 *
 */
public class StringUtilsDemo2 {

    /**
     * 判断某字符串是否为空，为空的标准是 str==null 或 str.length()==0
     */
    @Test
    public void test(){
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty("   "));
        System.out.println(StringUtils.isEmpty("\t"));
        System.out.println(StringUtils.isEmpty("\n"));


        String str="ocean";
        if(!StringUtils.isEmpty(str)){
            System.out.println("good");
        }
    }


    @Test
    public void test2(){
        String path="C:\\Users\\epanhai\\Documents\\git\\myproject\\JavaDemo\\pom.xml";
        System.out.println(StringUtils.getFilename(path));
        System.out.println(StringUtils.getFilenameExtension(path));
    }

    @Test
    public void test3(){
        System.out.println(StringUtils.quote("aa"));
    }



}
