package com.demo.javaIO.java7.file;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileDemo2 {

    @Test
    public void test1() {
        //创建文件
        File f = new File("testResource\\out.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件已存在");
            f.delete();
        }
    }
    @Test
    public void test1_1() {
        //创建文件
        File f = new File("JavaDemo\\newdir\\newfile");
        if (!f.exists()) {
            try {
                f.createNewFile();//这里createNewFile不能递归创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件已存在");
            f.delete();
        }
    }


    @Test
    public void test2() {

        File f = new File("C:\\Users\\epanhai\\Desktop\\ocean\\ocean2");
        if (!f.exists()) {
            f.mkdir();  //不能递归创建
        } else {
            System.out.println("dir已存在");
            f.delete();
        }
    }

    @Test
    public void test3() {

        File f = new File("C:\\Users\\epanhai\\Desktop\\ocean\\ocean2");
        if (!f.exists()) {
            f.mkdirs();  //递归创建
        } else {
            System.out.println("dir已存在");
            //f2.delete();
        }
        f.mkdirs();  //若file已经存在，再次mkdirs什么也不会做
    }



    @Test
    public void test4() {
        File f = new File("C:\\Users\\epanhai\\Desktop");

        //数组中存放着C:\Users\epanhai\Desktop当前目录下所有文件名和目录名，不包含子目录下的文件和目录
        String[] list = f.list();
        for (String s : list) {
            System.out.println(s);
        }
    }



    @Test
    public void test5() {
        File f = new File("C:\\Users\\epanhai\\Desktop");
        File[] files = f.listFiles();//返回File对象数组
        for (File file : files) {
            System.out.println(file.getName());
        }
    }



    @Test
    public void test6() {
        File[] files = File.listRoots();// List the available filesystem roots.
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }

    @Test
    public void test7 () {
        File f = new File("C:\\Users\\EPANHAI\\Documents\\git\\JavaDemo");
        File f2=new File("C:\\Users\\epanhai\\git\\myproject\\JavaDemo\\src\\main\\java\\io\\javaIO\\file\\FileTest.java");
        myListFile(f);

    }
    public void myListFile(File file){
        if(file.isFile()){
            System.out.println(file.getName());
            return;
        }
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()){
                myListFile(f);
            }else{
                System.out.println(f.getName());
            }
        }
    }


    @Test
    public void test8 () {
        Scanner scanner =new Scanner(System.in);
        System.out.println("请您输入合法路径：");
        while(true){
            String path = scanner.nextLine();
            File f=new File(path);
            if(!f.exists()){
                System.out.println("您输入的路径不存在，请重新输入");
            }else{
                System.out.println("路径正确");
                return;
            }
        }
    }
}
